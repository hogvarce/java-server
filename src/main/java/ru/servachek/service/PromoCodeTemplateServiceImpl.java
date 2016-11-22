package ru.servachek.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.*;
import ru.servachek.model.QPromoCodeTemplate;
import ru.servachek.model.QPromoSale;
import ru.servachek.repository.*;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
@Service
public class PromoCodeTemplateServiceImpl implements PromoCodeTemplateService {

    @Autowired
    private PromoCodeTemplateRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PromoCodeRepository promoCodeRepository;
    private Random random;
    @Autowired
    private PromoSaleRepository promoSaleRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepositiory taskRepositiory;
    private BooleanExpression result;

    @PostConstruct
    private void setUp() {
        taskRepositiory.deleteAll();
        promoSaleRepository.deleteAll();
        Calendar calendar = new GregorianCalendar();
        for (int i = 0; i < 200; i++) {
            random = new Random();
            calendar.set(2016, Calendar.NOVEMBER, random.nextInt((30 - 11) + 1) + 11);
            PromoSale promoSale = PromoSale.builder()
                    .title((random.nextInt((120 - 100) + 1) + 100) + " процентов гарантии цены - gn3")
                    .label("Промоакция#" + (i + 1))
                    .created_at(calendar.getTime())
                    .started_at(new Date())
                    .finished_at(calendar.getTime())
                    .start_time(new Date())
                    .end_time(calendar.getTime())
                    .disabled(false)
                    .priority(0)
                    .build();
            promoSaleRepository.save(promoSale);
        }
        userRepository.deleteAll();
        User admin = User.builder()
                .userName("admin")
                .password("admin")
                .token("111")
                .build();
        userRepository.save(admin);
        repository.deleteAll();
        List<PromoSale> promoSales = promoSaleRepository.findAll();
        for (int i = 0; i < 200; i++) {
            random = new Random();
            PromoCodeTemplate promoCodeTemplate = PromoCodeTemplate.builder()
                    .title("Шаблон-промокодов-" + (random.nextInt((120 - 100) + 1) + 100))
                    .promos(promoSales.toArray(new PromoSale[promoSales.size()]))
                    .created_at(new Date())
                    .mask("#####-####-#####")
                    .users(new User[]{admin})
                    .payer_type(0)
                    .landing_page(new LandingPage())
                    .build();
            save(promoCodeTemplate);
        }
    }


    @Override
    @SneakyThrows
    public Page<PromoCodeTemplate> getPage(Pageable pageable, Filters filters) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        QPromoCodeTemplate qPromoCodeTemplate = new QPromoCodeTemplate("promocodetemplate");
        List<BooleanExpression> predicateList = new ArrayList<>();
        Field[] filterFields = filters.getClass().getDeclaredFields();
        Date[] dates;
        for (Field field : filterFields) {
            field.setAccessible(true);
            if (field.get(filters) != null && !field.get(filters).equals("")) {
                switch (field.getName()) {
                    case "title":
                        predicateList.add(qPromoCodeTemplate.title.contains((String) field.get(filters)));
                        break;
                    case "mask":
                        predicateList.add(qPromoCodeTemplate.mask.contains((String) field.get(filters)));
                        break;
                    case "creationDates":
                        dates = (Date[]) field.get(filters);
                        predicateList.add(qPromoCodeTemplate.created_at.between(dates[0], dates[1]));
                        break;
                    case "updateDates":
                        dates = (Date[]) field.get(filters);
                        predicateList.add(qPromoCodeTemplate.updated_at.between(dates[0], dates[1]));
                        break;
                }
            }
        }
        if (predicateList.size() == 0) {
            return repository.findAll(pageable);
        }
        result = predicateList.get(0);
        for (int i = 1; i < predicateList.size(); i++) {
            result = result.and(predicateList.get(i));
        }

        return repository.findAll(result, pageable);
    }

    @Override
    public Page<PromoCodeTemplate> getPage(Pageable pageable) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return repository.findAll(pageable);
    }


    @Override
    public void save(PromoCodeTemplate promoCodeTemplate) {
        repository.save(promoCodeTemplate);
    }

    @Override
    public Task promoCodeGenerate(String id, int count) {

        PromoCodeTemplate promoCodeTemplate = repository.findOne(id);

        Task task = Task.builder()
                .title(promoCodeTemplate.getTitle())
                .created_at(new Date())
                .status("in_progress")
                .current_operation(0)
                .total_operation(count)
                .build();
        taskService.update(task);

        char[] options = {'F', 'Z', 'P', 'E', 'N', 'T', 'L', 'C', 'D', 'O'};
        for (int i = 0; i < count; i++) {

            task.setCurrent_operation(i + 1);
            taskService.update(task);

            random = new Random();

            String mask = "####-####-####-####";
            Random r = new Random();
            while (mask.contains("#")) {
                mask = mask.replaceFirst("#", String.valueOf(r.nextInt(9)));
            }

            PromoCode promoCode = PromoCode.builder()
                    .code(generateCodeWithMask(promoCodeTemplate.getMask()))
                    .promo_code_template(promoCodeTemplate)
                    .build();
            promoCodeRepository.save(promoCode);
        }
        task.setStatus("finished_success");
        taskService.update(task);
        return task;

    }

    @Override
    public PromoCodeTemplate getById(String id) {
        return repository.findOne(id);
    }

    private String generateCodeWithMask(String mask) {
        while ((mask = mask.replaceFirst("#", String.valueOf(random.nextInt(9)))).contains("#")) {
        }
        return mask;
    }
}
