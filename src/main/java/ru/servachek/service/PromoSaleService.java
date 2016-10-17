package ru.servachek.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.servachek.model.PromoSale;

import java.util.List;

/**
 * Created by Ganzhenko on 11.10.2016.
 */
public interface PromoSaleService {
    List<PromoSale> getAll();
    Page<PromoSale> getPage(Pageable pageable);

    void save(PromoSale promoSale);
}
