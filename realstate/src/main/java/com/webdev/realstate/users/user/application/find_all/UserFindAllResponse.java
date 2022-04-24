package com.webdev.realstate.users.user.application.find_all;

import com.webdev.realstate.users.user.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserFindAllResponse {

	private List<User> users;

	public UserFindAllResponse(List<User> users) {
		this.users = users;
	}

	public List<HashMap<String, Object>> response() {
		return users.stream().map(
				user -> user.data()
		).collect(Collectors.toList());
	}
}
