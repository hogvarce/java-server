package ru.servachek.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ganzhenko on 24.10.2016.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @JsonProperty("user_id")
    private String id;
    private String token;

    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
