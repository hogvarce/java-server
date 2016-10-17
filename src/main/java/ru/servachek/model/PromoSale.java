package ru.servachek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PromoSale {

    @Id
    private String _id;

    private Integer code;
    private String title;
    private String description;
    private String region;
    private String date;
    private String time;
    private Date date_created;
    private Boolean active;
    private Integer priority;
    private Date date_sale;
    private String type_sale;
    private String type;
}
