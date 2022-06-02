package com.webdev.realstate.appointments.request.infrastructure.controllers;

import com.webdev.realstate.appointments.request.application.find_all.RequestFindAll;
import com.webdev.realstate.appointments.request.application.find_all.RequestFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Request", description = "Request REST API")
@RequestMapping(value = "/request")
public class RequestFinderAllController {

	@Autowired
	private RequestFindAll findAll;

	@Operation(summary = "Find all requests", description = "Find all requests in the system", tags = {"Request"})
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
	@GetMapping(value = "/all")
	public ResponseEntity<List<HashMap<String, Object>>> execute() {
		RequestFindAllResponse response =
				new RequestFindAllResponse(
						findAll.execute()
				);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());
	}
}
