package org.amarques.spring.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.amarques.spring.test.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private Map<String, User> users = new HashMap<>();
	
	
	public List<User> getUsers(){
		return new ArrayList<>(users.values());
	}
	
	public User getUser (String id) {
		return users.get(id);
	}
	
	public void createUser (User user) throws Exception {
		if (null != users.get(user.getId())) {
			throw new Exception("User with ID " + user.getId() + " already exists");
		}
		users.put(user.getId(), user);
	}
	
	public void createUsers (List<User> users) throws Exception {
		List<String> errorMessages = new ArrayList<>();
		for (User user : users) {
			try {
				createUser(user);
			}
			catch (Exception exception) {
				errorMessages.add(exception.getMessage());
			}
		}
		if (errorMessages.size() > 0) {
			throw new Exception("Error trying to add users: " + errorMessages.toString());
		}
	}
	
	public void updateUser (User user) throws Exception {
		if (null == users.get(user.getId())) {
			throw new Exception("There is no user with ID " + user.getId() + " to be updated");
		}
		users.put(user.getId(), user);
	}
}