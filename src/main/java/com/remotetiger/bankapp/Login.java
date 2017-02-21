package com.remotetiger.bankapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@Column(name = "id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "security_question")
	private String securityQuestion;
	@Column(name = "security_question_answer")
	private String securityAnswer;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Login [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", securityQuestion=");
		builder.append(securityQuestion);
		builder.append(", securityAnswer=");
		builder.append(securityAnswer);
		builder.append("]");
		return builder.toString();
	}

	public Login() {

	}

	public Login(String username, String password, String securityQuestion, String securityAnswer) {
		super();
		this.username = username;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
