package com.webdev.realstate.shared.infrastructure.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
public class RabbitMqEventBusConfiguration {

	@Autowired
	private Environment env;

	public RabbitMqEventBusConfiguration(Environment env) {
		this.env = env;
	}

	@Bean
	public CachingConnectionFactory connection() {
		CachingConnectionFactory factory = new CachingConnectionFactory();

		factory.setHost(Objects.requireNonNull(env.getProperty("rabbit.host")));
		factory.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("rabbit.port"))));
		factory.setUsername(Objects.requireNonNull(env.getProperty("rabbit.user")));
		factory.setPassword(Objects.requireNonNull(env.getProperty("rabbit.password")));

		return factory;
	}

}

