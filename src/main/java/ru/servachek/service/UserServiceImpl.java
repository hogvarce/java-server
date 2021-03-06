package ru.servachek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.servachek.model.User;
import ru.servachek.repository.UserRepository;

import javax.annotation.PostConstruct;

/**
 * Created by Ganzhenko on 24.10.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    private void setUp() {

    }


    @Override
    public User getUserByToken(String token) {
        return repository.findByToken(token);
    }

    @Override
    public User getUserByName(String userName) {
        return repository.findByUserName(userName);
    }

}
