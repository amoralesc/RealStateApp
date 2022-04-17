package com.webdev.realstate.users.user.infrastructure.controllers;

import com.webdev.realstate.shared.infrastructure.schema.ErrorSchema;
import com.webdev.realstate.users.user.application.login.UserLogin;
import com.webdev.realstate.users.user.domain.exceptions.AuthenticateFailed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/user")
@Tag(name = "User", description = "User REST API")
public class UserLoginController {

    //@Autowired
    private UserLogin login;

    @Operation(summary = "Authenticated a User", description = "Authenticated a User in the system", tags = {"User"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authenticated in the system"),
            @ApiResponse(responseCode = "401", description = "Unauthorized user", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
    })
    @PostMapping(value = "/login")
    public ResponseEntity<HashMap<String, Object>> execute(@RequestBody UserLoginRequest request){
        //UserLoginResponse response = login.execute(request.getEmail(), request.getPassword());
        //return ResponseEntity.status(HttpStatus.OK).body(response.response());
        return null;
    }

    @ExceptionHandler(AuthenticateFailed.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseEntity<HashMap> handleFailedAuthenticated(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    static class UserLoginRequest {
        @Schema(description = "User email, contains @", example = "a@gmail.com")
        private String email;

        @Schema(description = "User password, contains $ and/or *", example = "Ajiacation123$*")
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
