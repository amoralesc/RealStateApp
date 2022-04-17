package com.webdev.realstate.users.user.infrastructure.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdev.realstate.users.user.domain.entities.UserPhone;
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

public class UserPhoneCustomType implements UserType {
	@Override
	public int[] sqlTypes() {
		return new int[]{Types.LONGNVARCHAR};
	}

	@Override
	public Class returnedClass() {
		return List.class;
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
		List<UserPhone> result = null;
		try {
			Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
			if (value.isPresent()) {
				List<HashMap<String, Object>> objects = new ObjectMapper().readValue(
						value.get(), List.class
				);
				result = objects.stream().map(
						element -> new UserPhone(
								(String) element.get("countryCode"),
								(String) element.get("number")
						)
				).collect(Collectors.toList());
			}
		} catch (Exception e) {
			throw new HibernateException("Error deserializing value of UserPhone" + e.toString());
		}
		return Optional.ofNullable(result);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
		Optional<List<UserPhone>> object = (value == null) ? Optional.empty() : (Optional<List<UserPhone>>) value;

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
			throw new HibernateException("Error serializing value of UserPhone" + e.toString());
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