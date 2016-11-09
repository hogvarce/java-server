package ru.servachek.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.TextScore;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import ru.servachek.model.Filters;
import ru.servachek.model.PromoSale;
import ru.servachek.model.PromoSales;

/**
 * Created by Ganzhenko on 12.10.2016.
 */
public interface PromoSaleRepository extends MongoRepository<PromoSale, String>, QueryDslPredicateExecutor<PromoSale> {

}
