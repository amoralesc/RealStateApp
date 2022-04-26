
package com.webdev.realstate.properties.property.application.update;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.entities.PropertyAddress;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;
import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.entities.UserPhone;
import com.webdev.realstate.users.user.domain.ports.UserRepository;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserName;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class propertyUpdate{

    private final PropertyRepository repository;

    public propertyUpdate(PropertyRepository repository) {
        this.repository = repository;
    }

    public void execute(String propertyId, List<HashMap<String, Object>> propertyAdressSerialized) {
        Optional<List<Property>> optionalProperty =  repository.findByPropertyId(new PropertyId(propertyId));

        if (optionalProperty.isPresent()) {
            Property property= (Property) optionalProperty.get();

            if (propertyAdressSerialized != null) {
                List<PropertyAddress> propertyAddresses =
                        propertyAdressSerialized.stream().map(
                                element -> new PropertyAddress(
                                        (String) element.get("city"),
                                        (String) element.get("detail"),
                                        (String) element.get("info"),
                                        (String) element.get("neighborhood")
                                )
                        ).collect(Collectors.toList());
                property.updateAddress(propertyAddresses);
            }

            repository.update(property);
        }
    }

}