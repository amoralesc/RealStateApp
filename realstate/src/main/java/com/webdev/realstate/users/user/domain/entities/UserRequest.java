package com.webdev.realstate.users.user.domain.entities;

import java.util.Date;
import java.util.HashMap;

public class UserRequest {
	private String id;
	private Date date;
	private String state;
	private String propertyId;
	private String agentId;

	public UserRequest(String id, Date date, String state, String propertyId, String agentId) {
		this.id = id;
		this.date = date;
		this.state = state;
		this.propertyId = propertyId;
		this.agentId = agentId;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("id", id);
			put("date", date);
			put("state", state);
			put("propertyId", propertyId);
			put("agentId", agentId);
		}};
		return data;
	}
}
