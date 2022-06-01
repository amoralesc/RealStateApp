package com.webdev.realstate.appointments.appointment.domain.events;

import com.webdev.realstate.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class AppointmentUpdatedDomainEvent extends DomainEvent {

	private Date date;
	private String state;
	private String propertyId;
	private String userId;
	private String agentId;

	public AppointmentUpdatedDomainEvent() {
		super(null);
	}


	public AppointmentUpdatedDomainEvent(String aggregateId, Date date, String state, String propertyId, String userId, String agentId) {
		super(aggregateId);
		this.date = date;
		this.state = state;
		this.propertyId = propertyId;
		this.userId = userId;
		this.agentId = agentId;
	}

	public AppointmentUpdatedDomainEvent(String aggregateId, String eventId, String occurredOn, Date date, String state, String propertyId, String userId, String agentId) {
		super(aggregateId, eventId, occurredOn);
		this.date = date;
		this.state = state;
		this.propertyId = propertyId;
		this.userId = userId;
		this.agentId = agentId;
	}

	public Date getDate() {
		return date;
	}

	public String getState() {
		return state;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public String getUserId() {
		return userId;
	}

	public String getAgentId() {
		return agentId;
	}

	@Override
	public String eventName() {
		return "update.appointment";
	}

	@Override
	public HashMap<String, Serializable> toPrimitive() {
		return new HashMap<String, Serializable>() {{
			put("date", date);
			put("state", state);
			put("propertyId", propertyId);
			put("userId", userId);
			put("agentId", agentId);
		}};
	}

	@Override
	public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
		return new AppointmentUpdatedDomainEvent(
				aggregateId,
				eventId,
				occurredOn,
				new Date((Long) body.get("date")),
				(String) body.get("state"),
				(String) body.get("propertyId"),
				(String) body.get("userId"),
				(String) body.get("agentId")
		);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AppointmentUpdatedDomainEvent other = (AppointmentUpdatedDomainEvent) o;

		return date.equals(other.date) &&
				state.equals(other.state) &&
				propertyId.equals(other.propertyId) &&
				userId.equals(other.userId) &&
				agentId.equals(other.agentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(
				date,
				state,
				propertyId,
				userId,
				agentId
		);
	}
}
