package ru.servachek.service;

import ru.servachek.model.User;

/**
 * Created by Ganzhenko on 24.10.2016.
 */
public interface UserService {
    User getUserByToken(String token);
    User getUserByName(String userName);
}

