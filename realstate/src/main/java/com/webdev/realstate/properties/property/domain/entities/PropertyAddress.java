package com.webdev.realstate.properties.property.domain.entities;

import java.util.HashMap;

public class PropertyAddress {
	private String city;
	private String detail;
	private String info;
	private String neighborhood;

	public PropertyAddress(String city, String detail, String info, String neighborhood) {
		this.city = city;
		this.detail = detail;
		this.info = info;
		this.neighborhood = neighborhood;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("city", city);
			put("detail", detail);
			put("info", info);
			put("neighborhood", neighborhood);
		}};
		return data;
	}
}
