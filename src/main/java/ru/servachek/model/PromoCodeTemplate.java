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
 * Created by Ganzhenko on 31.10.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PromoCodeTemplate {
    @JsonProperty("promo_code_template_id")
    private String id;
    private String created_at = new Date().toString();
    private String updated_at;
    private String mask = "#####-####-#####";
    private String title;
    private List<Object> promos;
    private List<User> users;
    private List<Object> user_groups;
    private Integer payer_type = 0;
    private Object landing_page;
}
