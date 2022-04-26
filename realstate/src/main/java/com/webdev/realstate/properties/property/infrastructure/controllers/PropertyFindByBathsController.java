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
public class PropertyFindByBathsController {

    private PropertyFindByBathsController findByBaths;
    @Operation(summary = "Find properties by quantity of bathrooms", description = "Find all properties by the quantity of baths", tags = {"Property", "Quantity", "Bathrooms"})
    @GetMapping(value = "/quantityBathrooms")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "quantityBathrooms") String quantityBathrooms) {
        PropertyFindByBathsResponse response = new PropertyFindByBathsResponse((List<Property>) findByBaths.execute(quantityBathrooms));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());

    }

}
