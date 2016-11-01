package ru.servachek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.FiltersPromoCodeTemplate;
import ru.servachek.model.PromoCode;
import ru.servachek.model.PromoCodeTemplate;
import ru.servachek.repository.PromoCodeRepository;
import ru.servachek.repository.PromoCodeTemplateRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
@Service
public class PromoCodeTemplateServiceImpl implements PromoCodeTemplateService {

    @Autowired
    private PromoCodeTemplateRepository repository;
    @Autowired
    private PromoCodeRepository promoCodeRepository;
    private Random random;

    @PostConstruct
    private void setUp() {
        repository.deleteAll();
        for (int i = 0; i < 200; i++) {
            random = new Random();
            PromoCodeTemplate promoCodeTemplate = PromoCodeTemplate.builder()
                    .title("Шаблон-промокодов-" + (random.nextInt((120 - 100) + 1) + 100))
                    .build();
            save(promoCodeTemplate);
            System.out.println("promoCodeTemplate = " + promoCodeTemplate);
        }

    }

    @Override
    public Page<PromoCodeTemplate> getPage(Pageable pageable, FiltersPromoCodeTemplate filters) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return repository.findByTitle(filters.getSelectedPromoCodeTemplateLabel(), pageable);
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
    public PromoCodeTemplate getPromoCodeTemplate(String id) {
        return null;
    }

    @Override
    public void save(PromoCodeTemplate promoCodeTemplate) {
        repository.save(promoCodeTemplate);
    }

    @Override
    public List<PromoCodeTemplate> getAll() {
        return repository.findAll();
    }

    @Override
    public void promoCodeGenerate(String id, int count) {
        PromoCodeTemplate promoCodeTemplate = repository.findOne(id);
        char[] options = {'F','Z','P','E','N','T','L','C','D','O'};
        for (int i = 0; i < count; i++) {
            random = new Random();

            String mask = "####-####-####-####";
            Random r = new Random();
            while (mask.contains("#")){
                mask = mask.replaceFirst("#", String.valueOf(r.nextInt(9)));
            }

            PromoCode promoCode = PromoCode.builder()
                    .code(generateCodeWithMask(promoCodeTemplate.getMask()))
                    .build();
            promoCodeRepository.save(promoCode);
        }
    }

    private String generateCodeWithMask(String mask) {
        while ((mask = mask.replaceFirst("#", String.valueOf(random.nextInt(9)))).contains("#")) {}
        return mask;
    }
}
