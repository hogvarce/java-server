package ru.servachek.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.Filters;
import ru.servachek.model.PromoSale;
import ru.servachek.repository.PromoSaleRepository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Random;

@Service
@Log4j
public class PromoSaleServiceImpl implements PromoSaleService {

    @Autowired
    private PromoSaleRepository repository;
    private Random random;


    @PostConstruct
    private void setUp() {
        repository.deleteAll();
        for (int i = 0; i < 30; i++) {
            random = new Random();
            PromoSale promoSale = PromoSale.builder()
                    .title((random.nextInt((120 - 100) + 1) + 100) + " процентов гарантии цены - gn3")
                    .label("Промоакция#" +(i+1))
                    .build();
            save(promoSale);
            System.out.println("promoSale = " + promoSale);
        }
    }

    @Override
    public Page<PromoSale> getPage(Pageable pageable, Filters filters) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return repository.findByLabel(filters.getSelectedPromoActionsLabel(), pageable);
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
