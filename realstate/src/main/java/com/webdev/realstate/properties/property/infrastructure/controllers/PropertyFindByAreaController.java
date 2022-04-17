package com.webdev.realstate.properties.property.infrastructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
public class PropertyFindByAreaController {

    //@Autowired
    private PropertyFindByAreaController findByArea;

    @Operation(summary = "Find properties by area", description = "Find all properties by the area(56 in the system", tags = {"Property", "Area"})
    @GetMapping(value = "/area")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "area") String area) {
        /*PropertyFindByAreaResponse response = new PropertyFindByAreaResponse(findByArea.execute(area));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());*/
        return null;
    }
}
