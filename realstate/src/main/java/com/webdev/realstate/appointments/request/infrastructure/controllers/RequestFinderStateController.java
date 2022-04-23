package com.webdev.realstate.appointments.request.infrastructure.controllers;

import com.webdev.realstate.appointments.request.application.find.RequestFindByState;
import com.webdev.realstate.appointments.request.application.find.RequestFindByStateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class RequestFinderStateController {
	@Autowired
	private RequestFindByState findByState;

	@Operation(summary = "Find request by state", description = "Find all request by the state (PENDING in the system", tags = {"Request", "State"})
	@GetMapping(value = "/state")
	public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "state") String requestState) {
		RequestFindByStateResponse response = new RequestFindByStateResponse(findByState.execute(requestState));
		return ResponseEntity.status(HttpStatus.OK).body(response.response());
	}
}
