package ru.servachek.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.servachek.model.Filters;
import ru.servachek.model.PromoCodeTemplate;
import ru.servachek.model.Task;

import java.util.List;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
public interface PromoCodeTemplateService {
    Page<PromoCodeTemplate> getPage(Pageable pageable, Filters filters);
    Page<PromoCodeTemplate> getPage(Pageable pageable);
    void save(PromoCodeTemplate promoCodeTemplate);
    Task promoCodeGenerate(String id, int count);
}
