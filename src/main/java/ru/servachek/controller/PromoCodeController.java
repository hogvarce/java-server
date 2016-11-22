package ru.servachek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.servachek.model.PageRequestWrapper;
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
    public Page<PromoCode> getPage(@RequestBody PageRequestWrapper requestWrapper) {
        if (requestWrapper.getFilters() == null) {
            return service.getPage(requestWrapper.getPageRequest());
        } else {
            return service.getPage(requestWrapper.getPageRequest(), requestWrapper.getFilters());
        }
    }
}
