package ru.servachek.controller;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.*;
import ru.servachek.model.Filters;
import ru.servachek.model.PageRequestWrapper;
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
    public Page<PromoSale> getPage(@RequestBody PageRequestWrapper requestWrapper) {
        if (requestWrapper.getFilters() == null) {
            return promoSaleService.getPage(requestWrapper.getPageRequest());
        } else {
             return promoSaleService.getPage(requestWrapper.getPageRequest(), requestWrapper.getFilters());
        }
    }

    @RequestMapping(value = "pms/list/promoaction")
    public PromoSale getPromoSale (@RequestParam(name = "id") String id) {
        return promoSaleService.getPromoSale(id);
    }

    @RequestMapping(value = "pms/save")
    public void savePromoSale (@RequestBody PromoSale promoSale) {
        promoSale.setUpdated_at(new Date());
        promoSaleService.save(promoSale);
    }
}
