package ru.servachek.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.servachek.model.Filters;
import ru.servachek.model.PromoSale;

import java.util.List;

/**
 * Created by Ganzhenko on 11.10.2016.
 */
public interface PromoSaleService {
    Page<PromoSale> getPage(Pageable pageable, Filters filters);
    Page<PromoSale> getPage(Pageable pageable);
    PromoSale getPromoSale(String id);
    void save(PromoSale promoSale);
}
