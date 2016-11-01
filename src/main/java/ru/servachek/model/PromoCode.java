package ru.servachek.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * Created by Ganzhenko on 01.11.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PromoCode {
    @JsonProperty("promo_code_id")
    private String id;
    private String created_at;
    private String updated_at;
    private Boolean disabled = false;
    private Integer number_of_uses = 0;
    private Integer max_number_of_uses = 0;
    private Integer max_number_of_uses_per_user = 0;
    private String code;
    private Date started_at;
    private Date finished_at;
    private PromoCodeTemplate promo_code_template;
    private Integer order_id;
    private Integer payer_type;
    private PromoSales promos;
    private List<User> users;
    private List<Object> user_groups;
    private Object landing_page;
}