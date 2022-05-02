package com.bits.cpad.dto;

import java.util.Date;

public class PlayerDTO {
	Integer id;
	String name;
	Integer age;
	Date dob;
	String role;
	String battingStyle;
	String bowlingStyle;
	PlayerScoreDTO score;
	String playerStatus;
	Integer teamMemberId;

	public String getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
	}

	public PlayerDTO() {
	}

	public PlayerDTO(int id, String name, String status) {
		this.id = id;
		this.name = name;
		this.playerStatus = status;
	}

	public PlayerDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public PlayerScoreDTO getScore() {
		return score;
	}

	public void setScore(PlayerScoreDTO score) {
		this.score = score;
	}

	public Integer getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(Integer teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
