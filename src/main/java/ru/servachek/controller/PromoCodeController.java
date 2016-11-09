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
import ru.servachek.model.Filters;
import ru.servachek.model.PromoCode;
import ru.servachek.model.PromoSale;
import ru.servachek.service.PromoCodeService;

import java.util.Date;


/**
 * Created by Ganzhenko on 01.11.2016.
 */
@RestController
public class PromoCodeController {
    @Autowired
    private PromoCodeService promoCodeService;

    @RequestMapping(value = "vms/promo-code")
    public Page<PromoCode> getPage(@RequestParam(name = "offset", defaultValue = "0") Integer offset,
                                   @RequestParam(name = "size", defaultValue = "20") Integer size,
                                   @RequestParam(name = "sort", defaultValue = "asc") String sort,
                                   @RequestParam(name = "sortBy", defaultValue = "code") String sortBy,
                                   @RequestParam(name = "filters", required = false) String filters) {
        Gson gson = new Gson();
        Filters filterFields = gson.fromJson(filters, Filters.class);
        int page = (offset / size);
        Sort.Direction direction = sort.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = new PageRequest(page, size, direction, sortBy);

        if (filters == null) {
            return promoCodeService.getPage(pageRequest);
        }

        return promoCodeService.getPage(pageRequest, filterFields);
    }

    @RequestMapping(value = "pms/promo-code")
    public PromoCode getPromoCode(@RequestParam(name = "id") String id) {
        return promoCodeService.getPromoCode(id);
    }

    @RequestMapping(value = "pms/promo-code/save")
    public void savePromoCode(@RequestBody PromoCode promoCode) {
        promoCode.setCreated_at(new Date().toString());
        promoCodeService.save(promoCode);
    }

}
