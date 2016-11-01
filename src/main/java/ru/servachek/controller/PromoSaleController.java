package ru.servachek.controller;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.servachek.model.Filters;
import ru.servachek.model.PromoSale;
import ru.servachek.service.PromoSaleService;

import java.util.ArrayList;
import java.util.Date;

@RestController
@Log4j
public class PromoSaleController {

    @Autowired
    private PromoSaleService promoSaleService;

    @RequestMapping(value = "pms/list")
    public Page<PromoSale> getPage(@RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                   @RequestParam(name = "size", defaultValue = "20") Integer size,
                                   @RequestParam(name = "sort", defaultValue = "asc") String sort,
                                   @RequestParam(name = "sortBy", defaultValue = "label") String sortBy,
                                   @RequestParam(name = "filters", required = false) String filters) {
        Gson gson = new Gson();
        Filters filterFields = gson.fromJson(filters, Filters.class);
        int page = (offset / size);
        Sort.Direction direction = sort.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = new PageRequest(page, size, direction, sortBy);

        if (filters == null) {
            return promoSaleService.getPage(pageRequest);
        }
        return promoSaleService.getPage(pageRequest, filterFields);
    }

    @RequestMapping(value = "pms/list/promoaction")
    public PromoSale getPromoSale (@RequestParam(name = "id") String id) {
        return promoSaleService.getPromoSale(id);
    }

    @RequestMapping(value = "pms/save")
    public void savePromoSale (@RequestBody PromoSale promoSale) {
        promoSale.setCreated_at(new Date().toString());
        promoSaleService.save(promoSale);
    }
}
