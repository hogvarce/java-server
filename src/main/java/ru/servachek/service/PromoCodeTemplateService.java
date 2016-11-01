package ru.servachek.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.servachek.model.FiltersPromoCodeTemplate;
import ru.servachek.model.PromoCodeTemplate;

import java.util.List;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
public interface PromoCodeTemplateService {
    Page<PromoCodeTemplate> getPage(Pageable pageable, FiltersPromoCodeTemplate filters);
    Page<PromoCodeTemplate> getPage(Pageable pageable);
    PromoCodeTemplate getPromoCodeTemplate(String id);
    void save(PromoCodeTemplate promoCodeTemplate);
    List<PromoCodeTemplate> getAll();
    void promoCodeGenerate(String id, int count);
}
