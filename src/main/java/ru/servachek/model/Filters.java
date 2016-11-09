package ru.servachek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Ganzhenko on 19.10.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filters {
    private List dataLabel;
    private String label;
    private List dataTitle;
    private String title;
    private List dataMechanics;
    private String mechanics;
    private List selectedActiveOptions;
    private List regions;
    private Integer[] priorityRange;
    private Integer startPriorityRange = 0;
    private Integer endPriorityRange = 100;
    private String actionDates;
    private String timeAction;
    private String creationDates;
    private Boolean showSelectTime;
}
