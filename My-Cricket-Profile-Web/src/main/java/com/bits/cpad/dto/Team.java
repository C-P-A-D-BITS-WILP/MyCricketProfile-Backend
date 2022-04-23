package com.bits.cpad.dto;

import java.util.List;

public class Team {
	String name;
	Integer id;
	String identifier;
	Player owner;
	Player captain;
	String location;
	List<Player> teamMembers;

	public Team(int id, String teamName) {
		this.id = id;
		this.name = teamName;
	}

	public Team(int id, String teamName, String identifier, Player owner, Player captain, String location) {
		this.id = id;
		this.name = teamName;
		this.identifier = identifier;
		this.owner = owner;
		this.captain = captain;
		this.location = location;
	}

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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Player getCaptain() {
		return captain;
	}

	public void setCaptain(Player captain) {
		this.captain = captain;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Player> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<Player> teamMembers) {
		this.teamMembers = teamMembers;
	}
}
