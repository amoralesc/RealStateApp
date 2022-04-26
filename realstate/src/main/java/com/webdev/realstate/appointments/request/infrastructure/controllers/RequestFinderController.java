package com.webdev.realstate.appointments.request.infrastructure.controllers;

import com.webdev.realstate.appointments.request.application.find.RequestFindById;
import com.webdev.realstate.appointments.request.application.find.RequestFindByIdResponse;
import com.webdev.realstate.appointments.request.application.find.RequestFindByUser;
import com.webdev.realstate.appointments.request.application.find.RequestFindByUserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Request", description = "Request REST API")
@RequestMapping(value = "/request")
public class RequestFinderController {

	@Autowired
	private RequestFindById findById;
	@Autowired
	private RequestFindByUser findByUser;

	@Operation(summary = "Find request by id", description = "Find a request given its UUID", tags = {"Request"})
	@GetMapping(value = "/{id}")
	public ResponseEntity<HashMap<String, Object>> execute(
			@PathVariable String id
	) {
		RequestFindByIdResponse response =
				new RequestFindByIdResponse(
						findById.execute(id)
				);
		return ResponseEntity.
				status(HttpStatus.OK)
				.body(response.response());
	}

	@Operation(summary = "Find requests by user", description = "Find requests given its user id and user type", tags = {"Request", "User"})
	@GetMapping(value = "/find")
	public ResponseEntity<List<HashMap<String, Object>>> execute(
			@RequestParam(name = "userId") String userId,
			@RequestParam(name = "isAgent") boolean isAgent,
			@RequestParam(name = "state", required = false) String state
	) {
		RequestFindByUserResponse response =
				new RequestFindByUserResponse(
						findByUser.execute(userId, isAgent, Optional.ofNullable(state))
				);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());
	}
}
