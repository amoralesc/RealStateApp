package com.webdev.realstate.properties.address.infrastructure.adapters;

import com.webdev.realstate.properties.address.domain.Address;
import com.webdev.realstate.properties.address.domain.ports.AddressRepository;
import com.webdev.realstate.properties.address.domain.valueobjects.AddressId;
import com.webdev.realstate.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateAddressRepository extends HibernateRepository<Address> implements AddressRepository {

    public HibernateAddressRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Address.class);
    }

    @Override
    public void save(Address address) {
        persist(address);
    }

    @Override
    public void update(Address address) {
        updateEntity(address);
    }

    //REVISAR
    @Override
    public Optional<Address> find(AddressId addressId) {
        return getById(addressId);
    }

    @Override
    public Optional<List<Address>> all() {
        return getAll();
    }

    @Override
    public void delete(Address address) {
        deleteEntity(address);
    }
}
