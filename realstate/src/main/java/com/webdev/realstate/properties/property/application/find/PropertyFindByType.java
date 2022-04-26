package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyArea;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyFindByType {

    private PropertyRepository repository;

    public PropertyFindByType(PropertyRepository repository){
        this.repository = repository;
    }

    public List<Property> execute(String propertyType){
        List<Property> properties = new ArrayList<>();
        Optional<List<Property>> optionalProperties = repository.findByType(new PropertyType(propertyType));
        if (optionalProperties.isPresent()){
            properties = optionalProperties.get();
        }
        return properties;
    }
}
