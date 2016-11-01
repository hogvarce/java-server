package ru.servachek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Ganzhenko on 31.10.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoCodeTemplates {
    private List<PromoCodeTemplate> promoCodeTemplates;
}
