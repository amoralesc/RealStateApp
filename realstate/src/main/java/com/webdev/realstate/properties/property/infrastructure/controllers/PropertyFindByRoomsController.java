package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.find.PropertyFindByBathsResponse;
import com.webdev.realstate.properties.property.domain.Property;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Property", description = "Property REST API")
@RequestMapping(value = "/property")
public class PropertyFindByRoomsController {

	private PropertyFindByRoomsController findByRooms;

	@Operation(summary = "Find properties by quantity of bathrooms", description = "Find all properties by the quantity of rooms", tags = {"Property", "Quantity", "Rooms"})
	@GetMapping(value = "/quantityRooms")
	public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "quantityRooms") String quantityRooms) {
		PropertyFindByBathsResponse response = new PropertyFindByBathsResponse((List<Property>) findByRooms.execute(quantityRooms));
		return ResponseEntity.status(HttpStatus.OK).body(response.response());

	}
}