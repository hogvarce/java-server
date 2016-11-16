package ru.servachek.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ganzhenko on 14.11.2016.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup {
    private User[] users;
}
