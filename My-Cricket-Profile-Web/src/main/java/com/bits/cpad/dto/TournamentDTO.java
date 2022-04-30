package com.bits.cpad.dto;

import java.util.Date;


public class TournamentDTO {

	String name;

	Integer id;

	TeamDTO winner;

	TeamDTO runner;

	Integer fee;
	
	Date startDate;
	
	Date endDate;
	
	UserDTO oraganizer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TeamDTO getWinner() {
		return winner;
	}

	public void setWinner(TeamDTO winner) {
		this.winner = winner;
	}

	public TeamDTO getRunner() {
		return runner;
	}

	public void setRunner(TeamDTO runner) {
		this.runner = runner;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UserDTO getOraganizer() {
		return oraganizer;
	}

	public void setOraganizer(UserDTO oraganizer) {
		this.oraganizer = oraganizer;
	}
	
	
}
