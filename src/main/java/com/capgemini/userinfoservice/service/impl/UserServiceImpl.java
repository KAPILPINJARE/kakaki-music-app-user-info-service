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

		List<Integer> favList = user1.getUserFavourite();
		for (Integer list : user.getUserFavourite()) {
			favList.add(list);
		}

		user1.setUserName(user.getUserName());
		user1.setUserFirstName(user.getUserFirstName());
		user1.setUserLastName(user.getUserLastName());
		user1.setUserEmail(user.getUserEmail());
		user1.setUserPassword(user.getUserPassword());
		user1.setUserContactNumber(user.getUserContactNumber());
		user1.setSecurityQuestion(user.getSecurityQuestion());
		user1.setSecurityAnswer(user.getSecurityAnswer());
		user1.setUserFavourite(favList);
		return dao.save(user1);
	}

	@Override
	public User getUserDetailByName(String userName) {
		return dao.findByuserName(userName);
	}

	@Override
	public List<Song> getAllFavouriteSong(String userEmail) {

		RestTemplate restTemplate = new RestTemplate();

		User user = getUserDetailByMail(userEmail);
		List<Song> songs = new ArrayList<Song>();

		for (int songId : user.getUserFavourite()) {
			Song song = restTemplate.getForEntity(baseUrl + songId, Song.class).getBody();
			songs.add(song);
		}
		return songs;
	}

	@Override
	public User updateUserFavouriteSong(User user, int songId) {
		int variable = -1;
		for (int i = 0; i < user.getUserFavourite().size(); i++) {
			if (user.getUserFavourite().get(i) == songId) {
				variable = i;
				break;
			}
		}
		if (variable >= 0) {
			user.getUserFavourite().remove(variable);
		}
		return dao.save(user);
	}

}
