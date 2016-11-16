package ru.servachek.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Ganzhenko on 15.11.2016.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @JsonProperty("task_id")
    private String id;
    private Date created_at;
    private Date updated_at;
    private String title;
    private String type;
    private String[] options;
    private Date started_at;
    private Date finished_at;
    private String status;
    private Integer total_operation;
    private Integer current_operation;
    private String error;
}
