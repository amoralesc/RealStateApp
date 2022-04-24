package com.webdev.realstate.users.user.domain;

import com.webdev.realstate.users.user.domain.entities.UserAppointment;
import com.webdev.realstate.users.user.domain.entities.UserPhone;
import com.webdev.realstate.users.user.domain.entities.UserRequest;
import com.webdev.realstate.users.user.domain.exceptions.AuthenticateFailed;
import com.webdev.realstate.users.user.domain.valueobjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
	private UserId userId;
	private UserName userName;
	private UserEmail userEmail;
	private UserIsAgent isAgent;
	private UserPassword password;
	private Optional<List<UserPhone>> phoneList;
	private Optional<List<UserRequest>> requestsList;
	private Optional<List<UserAppointment>> appointmentsList;

	public User(UserId userId, UserName userName, UserEmail userEmail, UserIsAgent isAgent, UserPassword password, Optional<List<UserPhone>> phoneList, Optional<List<UserRequest>> requestsList, Optional<List<UserAppointment>> appointmentsList) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.isAgent = isAgent;
		this.password = password;
		this.phoneList = phoneList;
		this.requestsList = requestsList;
		this.appointmentsList = appointmentsList;
	}

	public static User create(UserId userId, UserName userName, UserEmail userEmail, UserPassword password) {
		User user = new User(
				userId,
				userName,
				userEmail,
				new UserIsAgent(false),
				password,
				Optional.empty(),
				Optional.empty(),
				Optional.empty()
		);
		return user;
	}

	public void authenticateUser(UserEmail userEmail, UserPassword password) {
		if (!(this.password.equals(password) && this.userEmail.equals(userEmail))) {
			throw new AuthenticateFailed("Credenciales inválidas");
		}
	}

	public void addPhone(UserPhone userPhone) {
		List<UserPhone> phones = new ArrayList<>();
		if (phoneList.isPresent()) {
			phones = phoneList.get();
		}
		phones.add(userPhone);
		phoneList = Optional.of(phones);
	}

	public void addRequest(UserRequest userRequest) {
		List<UserRequest> requests = new ArrayList<>();
		if (requestsList.isPresent()) {
			requests = requestsList.get();
		}
		requests.add(userRequest);
		requestsList = Optional.of(requests);
	}

	public void addAppointment(UserAppointment userAppointment) {
		List<UserAppointment> appointments = new ArrayList<>();
		if (appointmentsList.isPresent()) {
			appointments = appointmentsList.get();
		}
		appointments.add(userAppointment);
		appointmentsList = Optional.of(appointments);
	}

	public HashMap<String, Object> data() {
		HashMap<String, Object> data = new HashMap<>() {{
			put("id", userId.value());
			put("name", userName.value());
			put("email", userEmail.value());
			put("isAgent", isAgent.value());
			put("phones", createPhones());
			put("requests", createRequests());
			put("appointments", createAppointments());
		}};
		return data;
	}

	private List<HashMap<String, Object>> createPhones() {
		List<HashMap<String, Object>> list = new ArrayList<>();
		if (!phoneList.isEmpty()) {
			list = phoneList.get().stream().map(
					phone -> phone.data()
			).collect(Collectors.toList());
		}
		return list;
	}

	private List<HashMap<String, Object>> createRequests() {
		List<HashMap<String, Object>> list = new ArrayList<>();
		if (!requestsList.isEmpty()) {
			list = requestsList.get().stream().map(
					request -> request.data()
			).collect(Collectors.toList());
		}
		return list;
	}

	private List<HashMap<String, Object>> createAppointments() {
		List<HashMap<String, Object>> list = new ArrayList<>();
		if (!appointmentsList.isEmpty()) {
			list = appointmentsList.get().stream().map(
					appointment -> appointment.data()
			).collect(Collectors.toList());
		}
		return list;
	}
}
