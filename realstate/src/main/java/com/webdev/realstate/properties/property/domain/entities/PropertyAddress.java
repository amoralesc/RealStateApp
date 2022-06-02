package com.webdev.realstate.properties.property.domain.entities;

import java.util.HashMap;

public class PropertyAddress {
	private String id;
	private String city;
	private String postalCode;
	private String detail;
	private String info;

	public PropertyAddress(String id, String city, String postalCode, String detail, String info) {
		this.id = id;
		this.city = city;
		this.postalCode = postalCode;
		this.detail = detail;
		this.info = info;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("id", id);
			put("city", city);
			put("postalCode", postalCode);
			put("detail", detail);
			put("info", info);
		}};
		return data;
	}
}
