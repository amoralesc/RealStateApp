package com.webdev.realstate.shared.infrastructure.rabbitmq;

import com.webdev.realstate.shared.domain.bus.event.DomainEvent;
import com.webdev.realstate.shared.domain.bus.event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

public class RabbitMqEventBus implements EventBus {

	private final RabbitMqPublisher publisher;
	private final String exchangeName;

	@Autowired
	private Environment env;

	public RabbitMqEventBus(RabbitMqPublisher publisher, Environment env) {
		this.publisher = publisher;
		this.env = env;
		this.exchangeName = this.env.getProperty("rabbit.exchange");
	}

	@Override
	public void publish(List<DomainEvent> events) {
		events.forEach(this::publish);
	}

	public void publish(DomainEvent domainEvent) {
		this.publisher.publish(domainEvent, this.exchangeName);
	}
}
