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
import org.springframework.data.mongodb.core.index.TextIndexed;
import ru.servachek.converter.DateStringSerializer;
import ru.servachek.converter.StringDateDeserializer;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@QueryEntity
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PromoSale {
    @JsonProperty("promo_id")
    private String id;
    @JsonSerialize(using = DateStringSerializer.class)
    @JsonDeserialize(using = StringDateDeserializer.class)
    private Date created_at = new Date(); // дата создание
    @JsonSerialize(using = DateStringSerializer.class)
    @JsonDeserialize(using = StringDateDeserializer.class)
    private Date updated_at; // Дата обновления
    private String start_time = "00:00:00"; // 00:00:00
    private String end_time = "23:59:59"; // 23:59:59,
    private Integer priority; // Приоритет
    private Integer min_price = 0; //  Минимальная суммарная стоимость акционных товаров(набора продуктов),по умолчанию 0,
    private Integer max_price = 0;  //  Максимальная суммарная  стоимость акционных товаров(набора продуктов),по умолчанию 0,
    private Boolean disabled = false; //  Признак того, что запись не активна(при значении отличном от нуля),по умолчанию 0,
    private Date started_at; //  Начальная дата  активности
    private Date finished_at; //  Конечная дата активности ,
    private String title; //  Название промо-акции ,
    private String sap_code; //SAPCODE ,
    private String guid; // GUID ,
    private String mechanics; // Промо-механика ,
    private List<Object> discounts; // Скидки ,
    private List<Object> product_sets; //    Наборы товаров,
    private List<Object> regions; // Регионы ,
    private Integer max_quantity_per_sku; //   Максимальное количество  одинаковых SKU,
    private Boolean current; //   Указание признака что акция находится в  истории ,
    private Integer semFilterId; //   Идентификатор фильтра из SEM,
    @TextIndexed
    private String label; //код промоакции
}
