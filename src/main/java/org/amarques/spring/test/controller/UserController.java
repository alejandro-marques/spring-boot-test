package org.amarques.spring.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.amarques.spring.test.model.User;
import org.amarques.spring.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/people")
public class UserController {
	
	// Logger
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/user"}, method=RequestMethod.GET, produces = "application/json")
	public List<User> listUsers (){
		logger.info("Received user list request");
		return userService.getUsers();
	}
	
	@RequestMapping(value={"/user/{id}"}, method=RequestMethod.GET, produces = "application/json")
	public User getUser (@PathVariable(required = true) String id){
		logger.info(String.format("Received user \"%s\" request", id));
		return userService.getUser(id);
	}
	
	@RequestMapping(value={"/user"}, method=RequestMethod.POST, produces = "application/json")
	public String addUsers (@Valid @RequestBody List<User> users) throws Exception{
		logger.info("Received user list creation request: " + users);
		userService.createUsers(users);
		return "{\"status\": \"OK\"}";
	}
	
	@RequestMapping(value={"/user/{id}"}, method=RequestMethod.POST, produces = "application/json")
	public String addUser (@PathVariable(required = true) String id, @Valid @RequestBody User user) throws Exception{
		logger.info("Received user creation request: " + user);
		userService.createUser(user);
		return "{\"status\": \"OK\"}";
	}
	
	@RequestMapping(value={"/user/{id}"}, method=RequestMethod.PUT, produces = "application/json")
	public String updateUser (@PathVariable(required = true) String id, @Valid @RequestBody User user) throws Exception{
		logger.info("Received user update request: " + user);
		userService.updateUser(user);
		return "{\"status\": \"OK\"}";
	}
}