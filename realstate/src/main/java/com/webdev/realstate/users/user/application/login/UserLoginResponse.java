package com.webdev.realstate.users.user.application.login;

import java.util.HashMap;

public class UserLoginResponse {

	private final String username;
	private final String token;

	public UserLoginResponse(String username, String token) {
		this.username = username;
		this.token = token;
	}

	public HashMap<String, Object> response() {
		return new HashMap<>() {{
			put("username", username);
			put("token", token);
		}};
	}
}
