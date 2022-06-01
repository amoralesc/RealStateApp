package com.webdev.realstate.shared.infrastructure.rabbitmq;

import com.webdev.realstate.shared.domain.bus.event.DomainEvent;
import com.webdev.realstate.shared.infrastructure.rabbitmq.serializable.DomainEventJsonDeserializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class RabbitMqDomainEventsConsumer {

	private final DomainEventsInformation information;
	private final DomainEventJsonDeserializer deserializer;

	@Autowired
	private final ApplicationContext context;

	public RabbitMqDomainEventsConsumer(DomainEventsInformation information, DomainEventJsonDeserializer deserializer, ApplicationContext context) {
		this.information = information;
		this.deserializer = deserializer;
		this.context = context;
	}

	@RabbitListener(queues = "#{'${rabbit.queues}'.split(',')}")
	public void consume(Message message) throws Exception {
		String serializedMessage = new String(message.getBody());
		System.out.println("SERIALIZED-MESSAGE " + serializedMessage);
		DomainEvent domainEvent = deserializer.deserialize(serializedMessage);
		System.out.println("DOMAIN-EVENT " + domainEvent.toString());
		String queueName = message.getMessageProperties().getConsumerQueue();
		Object subscriber = this.subscriberFor(queueName);
		try {
			Method subscriberOnMethod = subscriber.getClass().getMethod("on", domainEvent.getClass());
			System.out.println("Metodo " + subscriberOnMethod.toString());
			subscriberOnMethod.invoke(subscriber, domainEvent);
		} catch (Exception error) {
			error.printStackTrace();
			throw new Exception("Error Listener: " + error.toString());
		}
	}

	private Object subscriberFor(String queueName) throws Exception {
		if (!this.information.validateEventSubscriber(queueName)) {
			throw new Exception("No hay listener asociado a la cola " + queueName);
		}
		String eventSubscriberName = this.information.getEventSubscriber(queueName);
		System.out.println("🌴" + eventSubscriberName);
		return context.getBean(eventSubscriberName);
	}
}

