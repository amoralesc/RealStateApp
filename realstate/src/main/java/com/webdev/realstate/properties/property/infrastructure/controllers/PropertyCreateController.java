package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.properties.property.application.create.PropertyCreator;
import com.webdev.realstate.properties.property.domain.exceptions.InvalidArea;
import com.webdev.realstate.properties.property.domain.exceptions.InvalidPrice;
import com.webdev.realstate.properties.property.domain.exceptions.InvalidQuantity;
import com.webdev.realstate.shared.infrastructure.schema.ErrorSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@Tag(name = "Property", description = "Property REST API")
@RequestMapping(value = "/property")
public class PropertyCreateController {

	//@Autowired
	private PropertyCreator creator;

	@Operation(summary = "Create a new Property", description = "Create a new Property in the system", tags = {"Property"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Property created"),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
	})
	@PostMapping(value = "/create")
	public ResponseEntity execute(@RequestBody PropertyCreateController.PropertyCreatorRequest request) {
        /*creator.execute(request.getId(), request.getAgentId(), request.getArea(), request.getDescription(), request.getPrice(),
                request.getQuantityBathroom(), request.getQuantityRoom());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);*/
		return null;
	}

	@ExceptionHandler(value = {InvalidArea.class, InvalidQuantity.class, InvalidPrice.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
		HashMap<String, String> response = new HashMap<>() {{
			put("error", exception.getMessage());
		}};
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	static class PropertyCreatorRequest {
		@Schema(description = "Property id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
		private String id;

		@Schema(description = "Property description", example = "It's a property...")
		private String description;

		@Schema(description = "Property type", example = "1")
		private boolean propertyType;

		@Schema(description = "Property offer type", example = "1")
		private boolean offerType;

		@Schema(description = "Property quantity room", example = "2")
		private int quantityRoom;

		@Schema(description = "Property quantity bathroom", example = "1")
		private int quantityBathroom;

		@Schema(description = "Property area", example = "50")
		private double area;

		@Schema(description = "Property price", example = "1000000")
		private double price;

		@Schema(description = "Property agent id", example = "564af8a6-a7ea-4733-acff-d2e5aada4e5a")
		private String agentId;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public boolean isPropertyType() {
			return propertyType;
		}

		public void setPropertyType(boolean propertyType) {
			this.propertyType = propertyType;
		}

		public boolean isOfferType() {
			return offerType;
		}

		public void setOfferType(boolean offerType) {
			this.offerType = offerType;
		}

		public int getQuantityRoom() {
			return quantityRoom;
		}

		public void setQuantityRoom(int quantityRoom) {
			this.quantityRoom = quantityRoom;
		}

		public int getQuantityBathroom() {
			return quantityBathroom;
		}

		public void setQuantityBathroom(int quantityBathroom) {
			this.quantityBathroom = quantityBathroom;
		}

		public double getArea() {
			return area;
		}

		public void setArea(double area) {
			this.area = area;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getAgentId() {
			return agentId;
		}

		public void setAgentId(String agentId) {
			this.agentId = agentId;
		}
	}
}

