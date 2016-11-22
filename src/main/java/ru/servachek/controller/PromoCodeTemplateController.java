package ru.servachek.controller;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.servachek.model.*;
import ru.servachek.service.PromoCodeTemplateService;
import ru.servachek.service.PromoSaleService;

import java.util.Date;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
@RestController
public class PromoCodeTemplateController {
    @Autowired
    private PromoCodeTemplateService promoCodeTemplateService;

    @RequestMapping(value = "vms/promo-code-template")
    public Page<PromoCodeTemplate> getPage(@RequestBody PageRequestWrapper requestWrapper) {
        if (requestWrapper.getFilters() == null) {
            return promoCodeTemplateService.getPage(requestWrapper.getPageRequest());
        } else {
            return promoCodeTemplateService.getPage(requestWrapper.getPageRequest(), requestWrapper.getFilters());
        }
    }

    @RequestMapping(value = "vms/promo-code-template/{id}", method = RequestMethod.GET)
    public PromoCodeTemplate getTemplate(@PathVariable("id") String id) {
        return promoCodeTemplateService.getById(id);
    }

    @RequestMapping(value = "vms/promo-code-template/save")
    public void savePromoCodeTemplate(@RequestBody PromoCodeTemplate promoCodeTemplate) {
        promoCodeTemplate.setUpdated_at(new Date());
        promoCodeTemplateService.save(promoCodeTemplate);
    }

    @RequestMapping(value = "vms/promo-code-template/{id}", method = RequestMethod.PUT)
    public void getTemplate(@RequestBody PromoCodeTemplate promoCodeTemplate) {
        promoCodeTemplate.setUpdated_at(new Date());
        promoCodeTemplateService.save(promoCodeTemplate);
    }

    @RequestMapping(value = "vms/promo-code-template/generate")
    @SneakyThrows
    public Task promoCodeTemplateGenerate(@RequestParam(name = "id") String id,
                                          @RequestParam(name = "count") int count){
        if (count < 1) {
            throw new Exception("count must be positive and greater than zero!");
        }
        return promoCodeTemplateService.promoCodeGenerate(id, count);
    }
}
