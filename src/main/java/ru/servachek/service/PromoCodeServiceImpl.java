package ru.servachek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.*;
import ru.servachek.repository.PromoCodeRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ganzhenko on 01.11.2016.
 */
@Service
public class PromoCodeServiceImpl implements PromoCodeService {

    @Autowired
    private PromoCodeRepository repository;
    private PromoCodeTemplateService promoCodeTemplateService;
    private Random random;

    @PostConstruct
    private void setUp() {
        repository.deleteAll();
    }

    @Override
    public Page<PromoCode> getPage(Pageable pageable, Filters filters) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return repository.findAll(pageable);
    }

    @Override
    public Page<PromoCode> getPage(Pageable pageable) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return repository.findAll(pageable);
    }

    @Override
    public PromoCode getPromoCode(String id) {
        return repository.findOne(id);
    }

    @Override
    public void save(PromoCode promoCode) {
        repository.save(promoCode);
    }
}
