package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.find.PropertyFindById;
import com.webdev.realstate.properties.property.application.find.PropertyFindByIdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Tag(name = "Property", description = "Property REST API")
@RequestMapping(value = "/property")
public class PropertyFinderByIdController {

	@Autowired
	private PropertyFindById findById;

	@Operation(summary = "Find property by id", description = "Find a property given its id", tags = {"Property"})
	@GetMapping(value = "/{id}")
	public ResponseEntity<HashMap<String, Object>> execute(@PathVariable String id) {
		PropertyFindByIdResponse response
				= new PropertyFindByIdResponse(findById.execute(id));
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());

	}
}
