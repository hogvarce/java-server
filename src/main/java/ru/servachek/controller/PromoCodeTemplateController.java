package ru.servachek.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.servachek.model.Filters;
import ru.servachek.model.FiltersPromoCodeTemplate;
import ru.servachek.model.PromoCodeTemplate;
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
    public Page<PromoCodeTemplate> getPage(@RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                           @RequestParam(name = "size", defaultValue = "20") Integer size,
                                           @RequestParam(name = "sort", defaultValue = "asc") String sort,
                                           @RequestParam(name = "sortBy", defaultValue = "title") String sortBy,
                                           @RequestParam(name = "filters", required = false) String filters) {
        Gson gson = new Gson();
        FiltersPromoCodeTemplate filterFields = gson.fromJson(filters, FiltersPromoCodeTemplate.class);
        int page = (offset / size);
        Sort.Direction direction = sort.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = new PageRequest(page, size, direction, sortBy);

        if (filters == null) {
            return promoCodeTemplateService.getPage(pageRequest);
        }
        return promoCodeTemplateService.getPage(pageRequest, filterFields);
    }

    @RequestMapping(value = "vms/promo-code-template/generate")
    public void promoCodeTemplateGenerate(@RequestParam(name = "id") String id,
                                          @RequestParam(name = "count") int count){
        promoCodeTemplateService.promoCodeGenerate(id, count);
    }
}
