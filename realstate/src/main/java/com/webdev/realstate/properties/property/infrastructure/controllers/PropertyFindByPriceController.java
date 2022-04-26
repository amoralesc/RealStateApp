package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.find.PropertyFindByPriceResponse;
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
public class PropertyFindByPriceController {

	//@Autowired
	private PropertyFindByPriceController findByPrice;

	@Operation(summary = "Find properties by price", description = "Find all properties by the price(1000000 in the system", tags = {"Property", "Price"})
	@GetMapping(value = "/price")
	public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "price") String price) {
		PropertyFindByPriceResponse response = new PropertyFindByPriceResponse((List<Property>) findByPrice.execute(price));
		return ResponseEntity.status(HttpStatus.OK).body(response.response());

	}

}
