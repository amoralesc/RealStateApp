package com.webdev.realstate.shared.application;

public class TokenGenerationResponse {
	private final String token;

	public TokenGenerationResponse(String token) {
		this.token = token;
	}

	public String token() {
		return token;
	}
}
