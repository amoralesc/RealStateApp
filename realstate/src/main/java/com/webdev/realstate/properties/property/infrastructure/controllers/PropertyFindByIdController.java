package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.find.PropertyFindByIdResponse;
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
public class PropertyFindByIdController {

    //@Autowired
    private PropertyFindByIdController findById;

    @Operation(summary = "Find properties by id", description = "Find all properties by the id(56 in the system", tags = {"Property", "id"})
    @GetMapping(value = "/id")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "Id") String id) {
        PropertyFindByIdResponse response = new PropertyFindByIdResponse((List<Property>) findById.execute(id));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());

    }
}
