package com.webdev.realstate.users.user.application.find;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserEmail;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;

import java.util.Optional;

public class UserFindByEmail {

    private final UserRepository repository;

    public UserFindByEmail(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(String email) {
        User user = null;
        Optional<User> optionalUser = repository.findByEmail(new UserEmail(email));
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }
}
