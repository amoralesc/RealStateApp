package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyArea;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyFindById {

    private PropertyRepository repository;

    public PropertyFindById(PropertyRepository repository){
        this.repository = repository;
    }

    public List<Property> execute(String propertyId){
        List<Property> properties = new ArrayList<>();
        Optional<List<Property>> optionalProperties = repository.findByPropertyId(new PropertyId(propertyId));
        if (optionalProperties.isPresent()){
            properties = optionalProperties.get();
        }
        return properties;
    }
}
