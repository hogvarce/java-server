package ru.servachek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.PromoSale;
import ru.servachek.model.Task;
import ru.servachek.repository.TaskRepositiory;

import java.util.List;

/**
 * Created by Ganzhenko on 15.11.2016.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepositiory repositiory;

    @Override
    public Page<Task> getAll(Pageable pageable) {
        return repositiory.findAll(pageable);
    }

    @Override
    public Task getById(String id) {
        return repositiory.findOne(id);
    }

    @Override
    public void update(Task task) {
        repositiory.save(task);
    }


}
