package com.webdev.realstate.shared.domain.aggregate;

import com.webdev.realstate.shared.domain.exceptions.InvalidCustomUUID;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CustomUUID implements Serializable {
	private String value;

	public CustomUUID(String value) {
		validate(value);
		this.value = value;
	}

	public String value() {
		return value;
	}

	private void validate(String value) {
		validFormat(value);
	}

	private void validFormat(String value) {
		try {
			UUID.fromString(value);
		} catch (Exception ex) {
			throw new InvalidCustomUUID("El UUID no tiene un formato valido");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomUUID that = (CustomUUID) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
