package ru.servachek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.servachek.model.PromoCode;
import ru.servachek.service.PromoCodeService;

/**
 * Created by Ganzhenko on 15.11.2016.
 */
@RestController
public class PromoCodeController {
    @Autowired
    private PromoCodeService service;

    @RequestMapping("/vms/promo-code")
    public Page<PromoCode> getPage(@RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                   @RequestParam(name = "size", defaultValue = "20") Integer size,
                                   @RequestParam(name = "sort", defaultValue = "asc") String sort,
                                   @RequestParam(name = "sortBy", defaultValue = "title") String sortBy,
                                   @RequestParam(name = "filters", required = false) String filters) {
        int page = (offset / size);
        Sort.Direction direction = sort.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = new PageRequest(page, size, direction, sortBy);
        return service.getPage(pageRequest);
    }
}
