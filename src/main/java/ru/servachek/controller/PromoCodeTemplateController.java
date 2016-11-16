package ru.servachek.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.servachek.model.*;
import ru.servachek.service.PromoCodeTemplateService;
import ru.servachek.service.PromoSaleService;

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

    @RequestMapping(value = "vms/promo-code-template/generate")
    public Task promoCodeTemplateGenerate(@RequestParam(name = "id") String id,
                                          @RequestParam(name = "count") int count){
        return promoCodeTemplateService.promoCodeGenerate(id, count);
    }
}
