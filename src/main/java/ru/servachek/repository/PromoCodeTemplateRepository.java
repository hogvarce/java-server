package ru.servachek.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import ru.servachek.model.PromoCodeTemplate;
import ru.servachek.model.PromoSale;

import java.util.Iterator;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
public interface PromoCodeTemplateRepository extends MongoRepository<PromoCodeTemplate, String>, QueryDslPredicateExecutor<PromoCodeTemplate> {
}
