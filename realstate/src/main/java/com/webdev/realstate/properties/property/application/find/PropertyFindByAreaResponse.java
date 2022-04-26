package com.webdev.realstate.properties.property.application.find;



import com.webdev.realstate.properties.property.domain.Property;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyFindByAreaResponse {

    private List<Property> properties;

    public PropertyFindByAreaResponse(List<Property> properties) {
        this.properties = properties;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = properties.stream().map(property-> property.data()).collect(Collectors.toList());
        return response;
    }
}
