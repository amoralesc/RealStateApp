package com.webdev.realstate.properties.property.infrastructure.adapters;


import com.webdev.realstate.properties.property.domain.Property;
import com.webdev.realstate.properties.property.domain.ports.PropertyRepository;
import com.webdev.realstate.properties.property.domain.valueobjects.*;
import com.webdev.realstate.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernatePropertyRepository extends HibernateRepository<Property> implements PropertyRepository {

    public HibernatePropertyRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Property.class);
    }

    @Override
    public void save(Property property) {
        persist(property);
    }

    @Override
    public void update(Property property) {
        updateEntity(property);
    }

    @Override
    public Optional<List<Property>> findByPropertyId(PropertyId PropertyId) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> root = cq.from(Property.class);
        cq.select(root).where(cb.equal(root.get("PropertyId"), PropertyId));
        List<Property> property = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(property);
    }

    @Override
    public Optional<List<Property>> findByType(PropertyType propertyType) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> root = cq.from(Property.class);
        cq.select(root).where(cb.equal(root.get("PropertyType"), propertyType));
        List<Property> property = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(property);
    }

    @Override
    public Optional<List<Property>> findByRooms(PropertyQuantityRooms propertyQuantityRooms) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> root = cq.from(Property.class);
        cq.select(root).where(cb.equal(root.get("propertyQuantityRooms"), propertyQuantityRooms));
        List<Property> property = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(property);
    }

    @Override
    public Optional<List<Property>> findByBaths(PropertyQuantityBathrooms propertyQuantityBathrooms) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> root = cq.from(Property.class);
        cq.select(root).where(cb.equal(root.get("propertyQuantityBathrooms"), propertyQuantityBathrooms));
        List<Property> property = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(property);
    }

    @Override
    public Optional<List<Property>> findByArea(PropertyArea propertyArea) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> root = cq.from(Property.class);
        cq.select(root).where(cb.equal(root.get("propertyArea"), propertyArea));
        List<Property> property = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(property);
    }

    @Override
    public Optional<List<Property>> findByPrice(PropertyPrice propertyPrice) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> root = cq.from(Property.class);
        cq.select(root).where(cb.equal(root.get("propertyPrice"), propertyPrice));
        List<Property> property = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return Optional.ofNullable(property);
    }

    @Override
    public Optional<List<Property>> findAll() {
        return getAll();
    }
}
