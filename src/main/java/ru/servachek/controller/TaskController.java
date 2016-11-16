package ru.servachek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.servachek.model.PromoCodeTemplate;
import ru.servachek.model.Task;
import ru.servachek.service.PromoCodeTemplateService;
import ru.servachek.service.TaskService;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService service;

    @RequestMapping("vms/task")
    public Page<Task> getProgress(){
        return service.getAll(new PageRequest(0, 20, Sort.Direction.DESC, "created_at"));
    }

    @RequestMapping("vms/task/{id}")
    public Task getStatus(@PathVariable("id") String id) {
        return service.getById(id);
    }
}
