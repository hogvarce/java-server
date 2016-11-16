package ru.servachek.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.servachek.converter.DateStringSerializer;
import ru.servachek.converter.StringDateDeserializer;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
@QueryEntity
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PromoCodeTemplate {
    @JsonProperty("promo_code_template_id")
    private String id;
    @JsonSerialize(using = DateStringSerializer.class)
    @JsonDeserialize(using = StringDateDeserializer.class)
    private Date created_at = new Date();
    @JsonSerialize(using = DateStringSerializer.class)
    @JsonDeserialize(using = StringDateDeserializer.class)
    private Date updated_at;
    private String mask = "#####-####-#####";
    private String title;
    private PromoSale[] promos;
    private User[] users;
    private UserGroup[] user_groups;
    private Integer payer_type = 0;
    private LandingPage landing_page;
}
