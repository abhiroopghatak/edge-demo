package com.abhiroop.emartservice.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhiroop.emartservice.pojo.User;

@Service("userService")
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> getAll() {
		List<User> pList = new ArrayList<User>();
		if (repository != null) {
			pList = repository.findAll();
		}
		return pList;
	}

	public User getById(int id) throws Exception {
		User item = null;
		if (repository != null) {
			item = repository.getOne(id);
			if (item instanceof HibernateProxy) {
				item = (User) Hibernate.unproxy(item);
			}
		}

		return item;
	}

	public User addUser(User c) throws Exception {
		if (repository != null && c != null) {
			c.setStatus("ACTIVE");
			c = repository.save(c);
		}
		return c;
	}
	

	public void deleteById(int id) throws Exception {

		User user = null;
		if (repository != null) {
			user = getById(id);
			if (user != null) {
				repository.delete(user);
				System.out.println(user + " deleted in system");
			}
		}

	}

}
