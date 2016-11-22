package ru.servachek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ganzhenko on 14.11.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LandingPage {
    private Integer landing_page_id = 0;
    private String name = "Cool landing";
    private String uri = "http://www.eldorado.ru";
}
