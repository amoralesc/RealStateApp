package com.webdev.realstate.appointments.request.infrastructure.controllers;

import com.webdev.realstate.appointments.request.application.find.RequestFindByDate;
import com.webdev.realstate.appointments.request.application.find.RequestFindByDateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Request", description = "Request REST API")
@RequestMapping(value = "/request")
public class RequestFinderDateController {
    @Autowired
    private RequestFindByDate findByDate;

    @Operation(summary = "Find request by date", description = "Find all request by the date (2022-04-15 in the system", tags = {"Request", "Date"})
    @GetMapping(value = "/date")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "date")Date requestDate) {
        RequestFindByDateResponse response = new RequestFindByDateResponse(findByDate.execute(requestDate));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
