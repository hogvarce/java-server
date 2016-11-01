package ru.servachek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FiltersPromoCodeTemplate {
    private String selectedPromoCodeTemplateLabel;
}
