package ru.servachek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.servachek.model.PromoSale;
import ru.servachek.service.PromoSaleService;

@RestController
public class PromoSaleController {

    @Autowired
    private PromoSaleService promoSaleService;

    @RequestMapping(value = "pms/list")
    public Page<PromoSale> getPage(@RequestParam(name = "offset") Integer offset,
                                  @RequestParam(name = "size") Integer size,
                                  @RequestParam(name = "sort", defaultValue = "asc") String sort,
                                  @RequestParam(name = "sortBy", defaultValue = "code") String sortBy) {
        int page = (offset / size);
        Sort.Direction direction = sort.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = new PageRequest(page, size, direction, sortBy);
        return promoSaleService.getPage(pageRequest);
    }
}
