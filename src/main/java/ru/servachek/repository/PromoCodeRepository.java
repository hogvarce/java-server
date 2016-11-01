package ru.servachek.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.servachek.model.PromoCode;
import ru.servachek.model.PromoSale;

/**
 * Created by Ganzhenko on 01.11.2016.
 */
public interface PromoCodeRepository extends MongoRepository<PromoCode, String>{
    Page<PromoSale> findByCode(String code, Pageable pageable);
}
