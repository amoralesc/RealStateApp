package com.webdev.realstate.users.user.application.find;

import com.webdev.realstate.users.user.domain.User;

import java.util.HashMap;

public class UserFindByEmailResponse {

    private User user;

    public UserFindByEmailResponse(User user) {
        this.user = user;
    }

    public HashMap<String, Object> response() {
        if (user == null) {
            return new HashMap<>();
        }

        return user.data();
    }

}
