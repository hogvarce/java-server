package ru.servachek.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.servachek.model.Filters;
import ru.servachek.model.Task;

/**
 * Created by Ganzhenko on 15.11.2016.
 */
public interface TaskService {
    Page<Task> getPage(Pageable pageable);
    Page<Task> getPage(Pageable pageable, Filters filters);
    Task getById(String id);
    void update(Task task);
}

