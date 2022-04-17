package com.webdev.realstate.appointments.request.infrastructure.controllers;

import com.webdev.realstate.appointments.request.application.find.RequestFindByUserId;
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
@Tag(name = "Request", description = "Request REST API")
@RequestMapping(value = "/request")
public class RequestFinderUserIdController {

    //@Autowired
    private RequestFindByUserId findByUserId;

    @Operation(summary = "Find request by user id", description = "Find all request by the user id (564af8a6-a7ea-4733-acff-d2e5aada4e5e in the system", tags = {"Request", "UserId"})
    @GetMapping(value = "/userid")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "userid") String userId) {
        /*RequestFindByUserIdResponse response = new RequestFindByUserIdResponse(findByUserId.execute(userId));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());*/
        return null;
    }

}