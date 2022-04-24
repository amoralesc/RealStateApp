package com.webdev.realstate.users.user.domain.entities;

import java.util.Date;
import java.util.HashMap;

public class UserRequest {
	private String id;
	private Date date;
	private String state;
	private String propertyId;
	private String userId;
	private String agentId;

	public UserRequest(String id, Date date, String state, String propertyId, String userId, String agentId) {
		this.id = id;
		this.date = date;
		this.state = state;
		this.propertyId = propertyId;
		this.userId = userId;
		this.agentId = agentId;
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("id", id);
			put("date", date);
			put("state", state);
			put("propertyId", propertyId);
			put("userId", userId);
			put("agentId", agentId);
		}};
		return data;
	}
}
