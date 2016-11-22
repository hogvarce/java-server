package ru.servachek.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.servachek.converter.StringArrayToDate;

import java.util.Date;
import java.util.List;

/**
 * Created by Ganzhenko on 19.10.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filters {
    private String label;
    private String title;
    private List dataMechanics;
    private String mechanics;
    private List selectedActiveOptions;
    private List regions;
    private Integer[] priorityRange;
    private Integer startPriorityRange = 0;
    private Integer endPriorityRange = 100;
    @JsonDeserialize(using = StringArrayToDate.class)
    private Date[] actionDates;
    private String timeAction;
    @JsonDeserialize(using = StringArrayToDate.class)
    private Date[] creationDates;
    @JsonDeserialize(using = StringArrayToDate.class)
    private Date[] updateDates;
    private Boolean showSelectTime;
    private String mask;
    private String[] status;
}
