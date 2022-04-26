package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.find.PropertyFindByType;
import com.webdev.realstate.properties.property.application.find.PropertyFindByTypeResponse;
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
public class PropertyFindByTypeController {
	//@Autowired
	private PropertyFindByType findByType;

	@Operation(summary = "Find properties by type", description = "Find all properties by type in the system", tags = {"Property"})
	@GetMapping(value = "/find")
	public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "type") String type) {
		PropertyFindByTypeResponse response
				= new PropertyFindByTypeResponse(findByType.execute(type));
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response.response());
	}
}
