package ru.servachek.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.Filters;
import ru.servachek.model.PromoCode;
import ru.servachek.model.PromoSale;

/**
 * Created by Ganzhenko on 01.11.2016.
 */
public interface PromoCodeService {
    Page<PromoCode> getPage(Pageable pageable, Filters filters);
    Page<PromoCode> getPage(Pageable pageable);
    PromoCode getPromoCode(String id);
    void save(PromoCode promoCode);
}
