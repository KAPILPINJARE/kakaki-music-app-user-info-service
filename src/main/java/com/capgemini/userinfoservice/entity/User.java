package com.capgemini.userinfoservice.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_details")
public class User {

	private String userName;
	private String userFirstName;
	private String userLastName;
	@Id
	private String userEmail;
	private String userPassword;
	private long userContactNumber;
	private String securityQuestion;
	private String securityAnswer;

	public User() {
		super();
	}

	public User(String userName, String userFirstName, String userLastName, String userEmail, String userPassword,
			long userContactNumber, String securityQuestion, String securityAnswer) {
		super();
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userContactNumber = userContactNumber;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getUserContactNumber() {
		return userContactNumber;
	}

	public void setUserContactNumber(long userContactNumber) {
		this.userContactNumber = userContactNumber;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

}
