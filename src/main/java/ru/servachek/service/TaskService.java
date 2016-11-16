package ru.servachek.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.servachek.model.PromoSale;
import ru.servachek.model.Task;

import java.util.List;

/**
 * Created by Ganzhenko on 15.11.2016.
 */
public interface TaskService {
    Page<Task> getAll(Pageable pageable);
    Task getById(String id);
    void update(Task task);
}

