package ru.servachek.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.servachek.model.PromoSale;

/**
 * Created by Ganzhenko on 12.10.2016.
 */
public interface PromoSaleRepository extends MongoRepository<PromoSale, Long> {
}
