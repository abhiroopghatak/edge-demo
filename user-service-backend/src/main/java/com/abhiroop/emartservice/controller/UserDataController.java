package com.abhiroop.emartservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhiroop.emartservice.pojo.User;
import com.abhiroop.emartservice.service.UserService;

@RestController
public class UserDataController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/" ,method = RequestMethod.GET,headers = "Accept=application/json")
	public String heartbeat(Model model) {

		return "UserData-service App is ready";
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUsers(Model model) {

		List<User> listOfUsers = new ArrayList<User>();
		if (userService != null) {
			try {
				listOfUsers = userService.getAll();
			} catch (Exception e) {
				System.out.println("Exception at getAllUsers service => " + e.getMessage());
			}
		}
		return listOfUsers;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable int id) {
		User c = null;
		if (userService != null && id > 0) {
			try {
				c = userService.getById(id);

			} catch (Exception e) {
				System.out.println("Exception at getUserById service => " + e.getMessage());
				c = new User("INVALID", "NO USER FOUND");
			}

		}
		return c;

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public User addUser(@RequestBody User c) {

		try {
			String opn="ADD";
			if (c.getId() < 1) {
				c.setStatus("NEW");
			} else {
				opn ="UPDATE";
				c.setStatus("EXISTING");
			}
			c=userService.addUser(c);
			System.out.println("User "+opn+" SUCCESS");
		} catch (Exception e) {
			System.out.println("Exception at addUser  service => " + e.getMessage());
			c.setStatus("INVALID");
		}
		return c;

	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("id") int id) {
		String result = "";
		try {
			userService.deleteById(id);
			result = "SUCCESS";
		} catch (Exception e) {
			System.out.println("Exception at delete user service =>" + e.getMessage());
			result = e.getMessage();
		}
		return result;
	}
}
