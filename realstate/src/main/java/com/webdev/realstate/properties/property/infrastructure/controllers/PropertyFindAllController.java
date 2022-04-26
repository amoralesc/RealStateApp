package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.find_all.PropertyFindAll;
import com.webdev.realstate.properties.property.application.find_all.PropertyFindAllResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "User", description = "User REST API")
@RequestMapping(value = "/property")
public class PropertyFindAllController {

	private PropertyFindAll findAll;

	@Operation(summary = "Find all properties", description = "Find all properties in the system", tags = {"Property"})
	@GetMapping(value = "/all")
	public ResponseEntity<List<HashMap<String, Object>>> execute() {
		PropertyFindAllResponse response =
				new PropertyFindAllResponse(
						findAll.execute()
				);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());
	}

}
