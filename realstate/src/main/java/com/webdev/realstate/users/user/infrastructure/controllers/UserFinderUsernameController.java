package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.users.user.application.find.UserFindByEmail;
import com.webdev.realstate.users.user.application.find.UserFindByEmailResponse;
import com.webdev.realstate.users.user.application.find.UserFindByUsername;
import com.webdev.realstate.users.user.application.find.UserFindByUsernameResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/user")
public class UserFinderUsernameController {
    @Autowired
    private UserFindByUsername findByUsername;

    @Operation(summary = "Find user by username", description = "Find user given its username", tags = {"User"})
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping(value = "/findUsername/{username}")
    public ResponseEntity<HashMap<String, Object>> execute(@PathVariable String username) {
        UserFindByUsernameResponse response =
                new UserFindByUsernameResponse(
                        findByUsername.execute(username)
                );
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(response.response());
    }
}
