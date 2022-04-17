package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.find.AppointmentFindByDate;
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
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentFinderUserIdController {

    //@Autowired
    private AppointmentFindByDate findByUserId;

    @Operation(summary = "Find appointments by user id", description = "Find all appointments by the user id (564af8a6-a7ea-4733-acff-d2e5aada4e5a in the system", tags = {"Appointment", "UserId"})
    @GetMapping(value = "/userid")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "userid") String userId) {
        /*AppointmentFindByUserIdResponse response = new AppointmentFindByUserIdResponse(findByUserId.execute(userId));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());*/
        return null;
    }

}
