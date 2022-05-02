package com.bits.cpad.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "user_fname")
	private String userFName;

	@Column(name = "user_lname")
	private String userLName;

	@Column(name = "email_id")
	private String email;

	@Column(name = "login_id")
	private String loginId;

	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "batting_Style")
	private String battingStyle;

	@Column(name = "bowling_Style")
	private String bowlingStyle;

	private String role;

	@ManyToMany(mappedBy = "players", fetch = FetchType.LAZY)
	private List<Team> teams;

	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
	private List<BattingScore> battingScores;

	@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
	private List<BowlingScore> bowlingScores;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getBattingStyle() {
		return battingStyle;
	}

	public void setBattingStyle(String battingStyle) {
		this.battingStyle = battingStyle;
	}

	public String getBowlingStyle() {
		return bowlingStyle;
	}

	public void setBowlingStyle(String bowlingStyle) {
		this.bowlingStyle = bowlingStyle;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<BattingScore> getBattingScores() {
		return battingScores;
	}

	public void setBattingScores(List<BattingScore> battingScores) {
		this.battingScores = battingScores;
	}

	public List<BowlingScore> getBowlingScores() {
		return bowlingScores;
	}

	public void setBowlingScores(List<BowlingScore> bowlingScores) {
		this.bowlingScores = bowlingScores;
	}

	
}