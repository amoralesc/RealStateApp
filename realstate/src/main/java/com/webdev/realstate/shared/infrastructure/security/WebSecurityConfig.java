package com.webdev.realstate.shared.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = {
			"/v3/api-docs/**",
			"/v3/api-docs.yaml",
			"/swagger-ui/**"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user/login").permitAll()
				//.antMatchers(HttpMethod.GET, "/user/all").permitAll()
				.antMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated();*/
		//EL QUE ESTABAMOS USANDO
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user/login").permitAll()
				.antMatchers(HttpMethod.GET, "/user/all").permitAll()
				.antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
				.antMatchers(HttpMethod.GET, AUTH_WHITELIST)
				.authenticated().and().httpBasic().and().csrf().disable();
		/*http.csrf().disable()*//*
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)*//*
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user/login").permitAll()
				.antMatchers(HttpMethod.GET, "/user/all").permitAll()
				.antMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated();*/
	}

}
