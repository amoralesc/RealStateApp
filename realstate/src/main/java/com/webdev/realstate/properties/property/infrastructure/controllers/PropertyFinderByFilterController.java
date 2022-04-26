package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.find.PropertyFindByFilter;
import com.webdev.realstate.properties.property.application.find.PropertyFindByFilterResponse;
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
import java.util.Optional;

@RestController
@Tag(name = "Property", description = "Property REST API")
@RequestMapping(value = "/property")
public class PropertyFinderByFilterController {

	@Autowired
	private PropertyFindByFilter findByFilter;

	@Operation(summary = "Find property by filtering", description = "Find a property given some filters", tags = {"Property"})
	@GetMapping(value = "/filter")
	public ResponseEntity<List<HashMap<String, Object>>> execute(
			@RequestParam(name = "propertyType", required = false) String propertyType,
			@RequestParam(name = "offerType", required = false) Boolean offerType,
			@RequestParam(name = "quantityRooms", required = false) Integer quantityRooms,
			@RequestParam(name = "quantityBathrooms", required = false) Integer quantityBathrooms
	) {
		PropertyFindByFilterResponse response =
				new PropertyFindByFilterResponse(
						findByFilter.execute(
								Optional.ofNullable(propertyType),
								Optional.ofNullable(offerType),
								Optional.ofNullable(quantityRooms),
								Optional.ofNullable(quantityBathrooms)
						)
				);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());
	}
}
