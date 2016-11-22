package ru.servachek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.servachek.model.PageRequestWrapper;
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
    public Page<Task> getProgress(@RequestBody PageRequestWrapper requestWrapper){
        if (requestWrapper.getFilters() == null) {
            return service.getPage(requestWrapper.getPageRequest());
        } else {
            return service.getPage(requestWrapper.getPageRequest(), requestWrapper.getFilters());
        }
    }

    @RequestMapping("vms/task/{id}")
    public Task getStatus(@PathVariable("id") String id) {
        return service.getById(id);
    }
}
