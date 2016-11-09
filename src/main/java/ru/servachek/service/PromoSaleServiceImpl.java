package ru.servachek.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.BooleanTemplate;
import javafx.beans.binding.BooleanBinding;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.Filters;
import ru.servachek.model.PromoSale;
import ru.servachek.model.QPromoSale;
import ru.servachek.repository.PromoSaleRepository;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Log4j
public class PromoSaleServiceImpl implements PromoSaleService {

    @Autowired
    private PromoSaleRepository repository;
    private Random random;
    private BooleanExpression result;


    @PostConstruct
    private void setUp() {
        repository.deleteAll();
        for (int i = 0; i < 200; i++) {
            random = new Random();
            PromoSale promoSale = PromoSale.builder()
                    .title((random.nextInt((120 - 100) + 1) + 100) + " процентов гарантии цены - gn3")
                    .label("Промоакция#" + (i + 1))
                    .disabled(false)
                    .build();
            save(promoSale);
            System.out.println("promoSale = " + promoSale);
        }
    }

    @Override
    @SneakyThrows
    public Page<PromoSale> getPage(Pageable pageable, Filters filters) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        QPromoSale qPromoSale = new QPromoSale("promosale");
        List<BooleanExpression> predicateList = new ArrayList<>();
        Field[] filterFields = filters.getClass().getDeclaredFields();
        for (Field field : filterFields) {
            field.setAccessible(true);
            if (field.get(filters) != null && !field.get(filters).equals("")) {
                switch (field.getName()) {
                    case "label":
                        predicateList.add(qPromoSale.label.contains((String) field.get(filters)));
                        break;
                    case "title":
                        predicateList.add(qPromoSale.title.contains((String) field.get(filters)));
                        break;
                    case "mechanics":
                        predicateList.add(qPromoSale.mechanics.contains((String) field.get(filters)));
                        break;
                    case "selectedActiveOptions":
                        List<String> activeValues = (List<String>) field.get(filters);
                        if (activeValues.contains("Активный") && activeValues.contains("Неактивный")) {
                            predicateList.add(qPromoSale.disabled.isNotNull());
                        } else {
                            if (activeValues.contains("Активный")) {
                                predicateList.add(qPromoSale.disabled.isTrue());
                            }
                            if (activeValues.contains("Неактивный")) {
                                predicateList.add(qPromoSale.disabled.isFalse());
                            }
                        }
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
    public Page<PromoSale> getPage(Pageable pageable) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return repository.findAll(pageable);
    }

    public PromoSale getPromoSale(String id) {
        return repository.findOne(id);
    }

    @Override
    public void save(PromoSale promoSale) {
        repository.save(promoSale);
    }

}
