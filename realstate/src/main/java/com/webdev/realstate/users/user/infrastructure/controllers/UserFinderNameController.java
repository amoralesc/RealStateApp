package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.users.user.application.find.UserFindByName;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/user")
public class UserFinderNameController {

    //@Autowired
    private UserFindByName findByName;

    @Operation(summary = "Find user by name", description = "Find all users by the user name (?name and ?lastName in the system", tags = {"User", "Name"})
    @GetMapping(value = "/name")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "name") String userName) {
        /*UserFindByNameResponse response = new UserFindByNameResponse(findByName.execute(userName));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());*/
        return null;
    }
}

