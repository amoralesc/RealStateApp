package com.webdev.realstate.appointments.request.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.domain.exceptions.AppointmentAlreadyExist;
import com.webdev.realstate.appointments.request.application.create.RequestCreator;
import com.webdev.realstate.appointments.request.domain.exceptions.InvalidDate;
import com.webdev.realstate.appointments.request.domain.exceptions.RequestAlreadyExist;
import com.webdev.realstate.shared.domain.exceptions.InvalidCustomUUID;
import com.webdev.realstate.shared.infrastructure.schema.ErrorSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@Tag(name = "Request", description = "Request REST API")
@RequestMapping(value = "/request")
public class RequestCreateController {

    //@Autowired
    private RequestCreator creator;

    @Operation(summary = "Create a new Request", description = "Create a new Request in the system", tags = {"Request"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Request created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })
    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody RequestCreatorRequest request) {
        creator.execute(request.getId(), request.getDate(), request.getClientId(), request.getAgentId());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(value = {InvalidCustomUUID.class, InvalidDate.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RequestAlreadyExist.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedAppointment(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    static class RequestCreatorRequest {

        @Schema(description = "Request id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5e")
        private String id;

        @Schema(description = "Request date", example = "2022-04-15")
        private Date date;

        @Schema(description = "Request state", example = "1")
        private boolean state;

        @Schema(description = "Request agent id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
        private String agentId;

        @Schema(description = "Request client id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
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
