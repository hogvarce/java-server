package ru.servachek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ganzhenko on 19.10.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filters {
    private String selectedPromoActionsLabel;
    private String selectedPromoActionsName;
    private String selectedPromoActionsType;
    private String actionDates;
    private String timeAction;
    private Integer[] selectedRegionListValue;
    private Integer[] activeValues;
    private Integer[] sliderValues;
    private String creationDates;
    private Integer[] promoTypeValues;


}
