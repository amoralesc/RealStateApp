package com.webdev.realstate.appointments.appointment.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.create.AppointmentCreator;
import com.webdev.realstate.appointments.appointment.domain.exceptions.InvalidDate;
import com.webdev.realstate.shared.infrastructure.schema.ErrorSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@Tag(name = "Appointment", description = "Appointment REST API")
@RequestMapping(value = "/appointment")
public class AppointmentCreateController {

    //@Autowired
    private AppointmentCreator creator;

    @Operation(summary = "Create a new Appointment", description = "Create a new Appointment in the system", tags = {"Appointment"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Appointment created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })
    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody AppointmentCreatorRequest request) {
        /*creator.execute(request.getId(), request.getDate(), request.isState(), request.getAgentId(), request.getClientId(), request.getPropertyId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);*/
        return null;
    }

    @ExceptionHandler(value = {InvalidDate.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    static class AppointmentCreatorRequest {

        @Schema(description = "Appointment id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
        private String id;

        @Schema(description = "Appointment date", example = "2022-04-15")
        private Date date;

        @Schema(description = "Appointment state", example = "1")
        private boolean state;

        @Schema(description = "Appointment property id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
        private String propertyId;

        @Schema(description = "Appointment agent id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
        private String agentId;

        @Schema(description = "Appointment client id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
        private String clientId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public String getPropertyId() {
            return propertyId;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
        }

        public String getAgentId() {
            return agentId;
        }

        public void setAgentId(String agentId) {
            this.agentId = agentId;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }
    }
}
