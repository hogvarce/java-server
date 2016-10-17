package ru.servachek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.PromoSale;
import ru.servachek.repository.PromoSaleRepository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class PromoSaleServiceImpl implements PromoSaleService {

    @Autowired
    private PromoSaleRepository repository;
    private Random random;


    @PostConstruct
    private void setUp() {
        repository.deleteAll();
            for (int i = 0; i < 200; i++) {
                random = new Random();
                PromoSale promoSale = PromoSale.builder()
                        .code(i)
                        .title((random.nextInt((120 - 100) + 1) + 100) + " процентов гарантии цены - gn3")
                        .date("30.06.2016 - 30.08.2016")
                        .date_created(new Date())
                        .time("09:00 -18:00")
                        .region("Москва и Подмосковье")
                        .description("Скидка на доставку")
                        .type("Скидка на доставку")
                        .build();
                save(promoSale);
            }

    }

    @Override
    public List<PromoSale> getAll() {
        return repository.findAll();
    }

    public Page<PromoSale> getPage(Pageable pageable) {
         return repository.findAll(pageable);
    }

    @Override
    public void save(PromoSale promoSale) {
        repository.save(promoSale);
    }
}
