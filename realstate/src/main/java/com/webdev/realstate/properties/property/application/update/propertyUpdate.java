package com.webdev.realstate.properties.property.application.update;

import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.entities.PropertyAddress;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.PropertyId;
import com.webdev.realstate.users.user.domain.User;
import com.webdev.realstate.users.user.domain.entities.UserPhone;
import com.webdev.realstate.users.user.domain.valueobjects.UserId;
import com.webdev.realstate.users.user.domain.valueobjects.UserName;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class propertyUpdate{

    private PropertyRepository repository;

    public propertyUpdate(PropertyRepository repository) {
        this.repository = repository;
    }

    public void execute( ){



    }
}
