package ru.servachek.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.servachek.model.PromoCodeTemplate;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
public interface PromoCodeTemplateRepository extends MongoRepository<PromoCodeTemplate, String> {
    Page<PromoCodeTemplate> findByTitle(String title, Pageable pageable);
}
