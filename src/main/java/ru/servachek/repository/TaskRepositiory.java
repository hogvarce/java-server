package ru.servachek.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import ru.servachek.model.Task;

/**
 * Created by Ganzhenko on 15.11.2016.
 */
public interface TaskRepositiory extends MongoRepository<Task, String>, QueryDslPredicateExecutor<Task> {
}
