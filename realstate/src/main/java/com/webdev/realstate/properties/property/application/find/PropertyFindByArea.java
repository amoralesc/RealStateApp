package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyArea;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyFindByArea {

    private PropertyRepository repository;

    public PropertyFindByArea(PropertyRepository repository){
        this.repository = repository;
    }

    public List<Property> execute(Double propertyArea){
        List<Property> properties = new ArrayList<>();
        Optional<List<Property>> optionalProperties = repository.findByArea(new PropertyArea(propertyArea));
        if (optionalProperties.isPresent()){
            properties = optionalProperties.get();
        }
        return properties;
    }

}
