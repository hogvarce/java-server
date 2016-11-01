package ru.servachek.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.servachek.model.PromoSale;
import ru.servachek.model.User;

/**
 * Created by Ganzhenko on 24.10.2016.
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByToken(String token);
    User findByUserName(String userName);
}
