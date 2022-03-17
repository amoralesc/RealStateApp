package com.webdev.realstate.users.user.domain.entities;

import java.util.HashMap;

public class UserPhone {
	private String countryCode;
	private String number;

	public UserPhone(String countryCode, String number) {
		this.countryCode = countryCode;
		this.number = number;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("countryCode", countryCode);
			put("number", number);
		}};
		return data;
	}
}
