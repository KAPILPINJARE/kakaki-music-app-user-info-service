package com.capgemini.userinfoservice.service;

import java.util.List;

import com.capgemini.userinfoservice.entity.Song;
import com.capgemini.userinfoservice.entity.User;

public interface UserService {

	public User addNewUser(User user);

	public User getUserDetailByMail(String userEmail);

	public User getUserDetailByName(String userName);

	public User updateUserDetail(User user);

}
