package com.webdev.realstate.properties.property.infrastructure.controllers;

import com.webdev.realstate.appointments.appointment.application.update.AppointmentUpdate;
import com.webdev.realstate.appointments.appointment.domain.exceptions.InvalidAppointmentState;
import com.webdev.realstate.appointments.appointment.infrastructure.controllers.AppointmentUpdateController;
import com.webdev.realstate.properties.property.application.update.PropertyUpdate;
import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.shared.infrastructure.schema.ErrorSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RestController
@Tag(name = "Property", description = "Property REST API")
@RequestMapping(value = "/property")
public class PropertyUpdateController {
    @Autowired
    private PropertyUpdate update;

    @Operation(summary = "Update property", description = "Update a property", tags = {"Property"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })
    @PostMapping(value = "/update")
    public ResponseEntity execute(@RequestBody PropertyUpdateController.PropertyUpdateRequest request) {
        update.execute(
                request.getId(),
                request.getDescription(),
                request.getPropertyType(),
                request.offerType(),
                request.getQuantityRooms(),
                request.getQuantityBathrooms(),
                request.getArea(),
                request.getPrice()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

    @ExceptionHandler(value = {InvalidAppointmentState.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    static class PropertyUpdateRequest {
        @Schema(description = "Property id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
        private String id;

        @Schema(description = "Property description", example = "Casa en Rosales")
        private String description;

        @Schema(description = "Property type", example = "Flat")
        private String propertyType;

        @Schema(description = "Property offerType", example = "true")
        private boolean offerType;

        @Schema(description = "Property quantityRooms", example = "2")
        private int quantityRooms;

        @Schema(description = "Property quantityBathrooms", example = "2")
        private int quantityBathrooms;

        @Schema(description = "Property area", example = "50")
        private double area;

        @Schema(description = "Property price", example = "1200000")
        private double price;

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

        public String getPropertyType() {
            return propertyType;
        }

        public void setPropertyType(String propertyType) {
            this.propertyType = propertyType;
        }

        public boolean offerType() {
            return offerType;
        }

        public void setOfferType(boolean offerType) {
            this.offerType = offerType;
        }

        public int getQuantityRooms() {
            return quantityRooms;
        }

        public void setQuantityRooms(int quantityRooms) {
            this.quantityRooms = quantityRooms;
        }

        public int getQuantityBathrooms() {
            return quantityBathrooms;
        }

        public void setQuantityBathrooms(int quantityBathrooms) {
            this.quantityBathrooms = quantityBathrooms;
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
    }
}
