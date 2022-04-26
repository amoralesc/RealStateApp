package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.find.PropertyFindByUserId;
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
public class PropertyFindByUserIdController {

<<<<<<< HEAD
    //@Autowired
    private PropertyFindByUserId findByUserId;
=======
	//@Autowired
	private PropertyFinderByUserId findByUserId;
>>>>>>> origin/develop

	@Operation(summary = "Find properties by user id", description = "Find all properties by the user id (564af8a6-a7ea-4733-acff-d2e5aada4e5a in the system", tags = {"Property", "UserId"})
	@GetMapping(value = "/userid")
	public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestParam(name = "userid") String userId) {
        /*PropertyFindByUserIdResponse response = new PropertyFindByUserIdResponse(findByUserId.execute(userId));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());*/
		return null;
	}
}

