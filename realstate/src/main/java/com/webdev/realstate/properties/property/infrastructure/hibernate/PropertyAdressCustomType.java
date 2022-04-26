package com.webdev.realstate.properties.property.infrastructure.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.realstate.properties.property.domain.entities.PropertyAddress;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PropertyAdressCustomType implements UserType {

	@Override
	public int[] sqlTypes() {
		return new int[]{Types.LONGNVARCHAR};
	}

	@Override
	public Class returnedClass() {
		return PropertyAddress.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return Objects.equals(x, y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return Objects.hashCode(x);
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
		List<PropertyAddress> result = null;
		try {
			Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
			if (value.isPresent()) {
				List<HashMap<String, Object>> objects = new ObjectMapper().readValue(
						value.get(), List.class
				);
				result = objects.stream().map(
						element -> new PropertyAddress(
								(String) element.get("city"),
								(String) element.get("detail"),
								(String) element.get("info"),
								(String) element.get("neighborhood")
						)
				).collect(Collectors.toList());
			}
		} catch (Exception e) {
			throw new HibernateException("Error deserializing value of UserPhone", e);
		}
		return Optional.ofNullable(result);

	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
		Optional<List<PropertyAddress>> object = (value == null) ? Optional.empty() : (Optional<List<PropertyAddress>>) value;

		try {
			if (object.isEmpty()) {
				st.setNull(index, Types.LONGNVARCHAR);
			} else {
				ObjectMapper mapper = new ObjectMapper();
				List<HashMap<String, Object>> objects = object.get().stream().map(
						element -> element.data()
				).collect(Collectors.toList());
				String serializedObject = mapper.writeValueAsString(objects)
						.replace("\\", "");
				st.setString(index, serializedObject);
			}
		} catch (Exception e) {
			throw new HibernateException("Error serializing value of PropertyAddress", e);
		}
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return null;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return null;
	}
}
