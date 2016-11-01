package ru.servachek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.servachek.model.User;
import ru.servachek.service.UserService;

/**
 * Created by Ganzhenko on 24.10.2016.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public User getUser(@RequestBody User user) throws Exception {
        String token = user.getToken();
        String userName = user.getUserName();
        String password = user.getPassword();
        User userAuth;
        if (token != null) {
            userAuth = userService.getUserByToken(token);
        } else if (userName != null) {
            userAuth = userService.getuserByName(userName);
            if (userAuth != null && userAuth.getPassword().equals(password)) {
                return userAuth;
            }  else {
                throw new Exception("Ошибка авторизации");
            }
        } else {
            throw new Exception("Ошибка авторизации");
        }
        if (userAuth == null) {
            throw new Exception("Ошибка авторизации");
        }
        return userAuth;
    }
}
