package com.webdev.realstate.users.user.application.find;

import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserEmail;
import com.webdev.realstate.users.user.domain.valueobjects.UserName;

import java.util.Optional;

public class UserFindByUsername {
    private final UserRepository repository;

    public UserFindByUsername(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(String username) {
        User user = null;
        Optional<User> optionalUser = repository.findByUsername(new UserName(username));
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }
}
