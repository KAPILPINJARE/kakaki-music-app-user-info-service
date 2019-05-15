package com.capgemini.userinfoservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.userinfoservice.dao.UserDao;
import com.capgemini.userinfoservice.entity.Song;
import com.capgemini.userinfoservice.entity.User;
import com.capgemini.userinfoservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	private String baseUrl = "http://localhost:8082/song/";

	@Override
	public User addNewUser(User user) {
		User user1 = getUserDetailByMail(user.getUserEmail());
		if (user1 == null) {
			return dao.insert(user);
		} else {
			return null;
		}
	}

	@Override
	public User getUserDetailByMail(String userEmail) {
		return dao.findByuserEmail(userEmail);
	}

	@Override
	public User updateUserDetail(User user) {

		User user1 = getUserDetailByMail(user.getUserEmail());

		user1.setUserName(user.getUserName());
		user1.setUserFirstName(user.getUserFirstName());
		user1.setUserLastName(user.getUserLastName());
		user1.setUserEmail(user.getUserEmail());
		user1.setUserPassword(user.getUserPassword());
		user1.setUserContactNumber(user.getUserContactNumber());
		user1.setSecurityQuestion(user.getSecurityQuestion());
		user1.setSecurityAnswer(user.getSecurityAnswer());
		return dao.save(user1);
	}

	@Override
	public User getUserDetailByName(String userName) {
		return dao.findByuserName(userName);
	}



}
