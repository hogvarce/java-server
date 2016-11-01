package ru.servachek.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.servachek.model.Filters;
import ru.servachek.model.PromoSale;
import ru.servachek.model.PromoSales;

/**
 * Created by Ganzhenko on 12.10.2016.
 */
public interface PromoSaleRepository extends MongoRepository<PromoSale, String> {
    Page<PromoSale> findByLabel(String code, Pageable pageable);
}
