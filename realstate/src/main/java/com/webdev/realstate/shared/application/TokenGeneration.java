package com.webdev.realstate.shared.application;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TokenGeneration {

	private final String PREFIX = "Bearer ";
	private final String SECRET = "real_state";
	private final String CLAIM = "authorities";
	private final String ID = "RealStateApp";
	private final int VALIDITY = 120000;

	public TokenGeneration() {
	}

	public TokenGenerationResponse execute(String username) {
		List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts.builder()
				.setId(ID)
				.setSubject(username)
				.claim(CLAIM, grantedAuthorityList.stream().map(
						GrantedAuthority::getAuthority
				).collect(Collectors.toList()))
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + VALIDITY))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
				.compact();
		return new TokenGenerationResponse(PREFIX + token);
	}
}
