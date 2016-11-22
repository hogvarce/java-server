package ru.servachek.service;

import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.servachek.model.Filters;
import ru.servachek.model.QTask;
import ru.servachek.model.Task;
import ru.servachek.repository.TaskRepositiory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ganzhenko on 15.11.2016.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepositiory repositiory;
    private BooleanExpression result;

    @Override
    @SneakyThrows
    public Page<Task> getPage(Pageable pageable, Filters filters) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        QTask qTask = new QTask("task");
        List<BooleanExpression> predicateList = new ArrayList<>();
        Field[] filterFields = filters.getClass().getDeclaredFields();
        for (Field field : filterFields) {
            field.setAccessible(true);
            if (field.get(filters) != null && !field.get(filters).equals("")) {
                switch (field.getName()) {
                    case "title":
                        predicateList.add(qTask.title.contains((String) field.get(filters)));
                        break;
                    case "status":
                        String[] status = (String[]) field.get(filters);
                        if (Arrays.asList(status).contains("finished_success")) {
                            predicateList.add(qTask.status.equalsIgnoreCase("finished_success"));
                        }
                        if (Arrays.asList(status).contains("in_progress")) {
                            predicateList.add(qTask.status.equalsIgnoreCase("in_progress"));
                        }
                        if (Arrays.asList(status).contains("error")) {
                            predicateList.add(qTask.status.equalsIgnoreCase("error"));
                        }
                        break;
                }
            }
        }
        if (predicateList.size() == 0) {
            return repositiory.findAll(pageable);
        }
        result = predicateList.get(0);
        for (int i = 1; i < predicateList.size(); i++) {
            result = result.or(predicateList.get(i));
        }
        return repositiory.findAll(result, pageable);
    }

    @Override
    public Page<Task> getPage(Pageable pageable) {
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
