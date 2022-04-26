package com.webdev.realstate.properties.property.application.find;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyArea;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyFindByPrice {

    private PropertyRepository repository;

    public PropertyFindByPrice(PropertyRepository repository){
        this.repository = repository;
    }

    public List<Property> execute(Double propertyPrice){
        List<Property> properties = new ArrayList<>();
        Optional<List<Property>> optionalProperties = repository.findByPrice(new PropertyPrice(propertyPrice));
        if (optionalProperties.isPresent()){
            properties = optionalProperties.get();
        }
        return properties;
    }
}
