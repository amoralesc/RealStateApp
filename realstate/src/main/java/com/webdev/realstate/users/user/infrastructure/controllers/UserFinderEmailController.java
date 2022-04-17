package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.users.user.application.find.UserFindByEmail;
import com.webdev.realstate.users.user.application.find.UserFindByName;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/user")
public class UserFinderEmailController {

    //@Autowired
    private UserFindByEmail findByEmail;

    @Operation(summary = "Find user by email", description = "Find all users by the user email (a@gmail.com in the system", tags = {"User", "Email"})
    @GetMapping(value = "/email")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "email") String userEmail) {
        /*UserFindByEmailResponse response = new UserFindByEmailResponse(findByEmail.execute(userEmail));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());*/
        return null;
    }

}

