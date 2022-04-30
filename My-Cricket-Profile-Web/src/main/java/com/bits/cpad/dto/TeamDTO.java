package com.bits.cpad.dto;

import java.util.List;

public class TeamDTO {
	String name;
	Integer id;
	String identifier;
	UserDTO owner;
	PlayerDTO captain;
	String location;
	List<PlayerDTO> players;
	Integer teamSize;

	public TeamDTO(int id, String teamName) {
		this.id = id;
		this.name = teamName;
	}

	public TeamDTO(int id, String teamName, String identifier, UserDTO owner, PlayerDTO captain, String location, int size) {
		this.id = id;
		this.name = teamName;
		this.identifier = identifier;
		this.owner = owner;
		this.captain = captain;
		this.location = location;
		this.teamSize = size;
	}

	public TeamDTO() {
		// TODO Auto-generated constructor stub
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

	public UserDTO getOwner() {
		return owner;
	}

	public void setOwner(UserDTO owner) {
		this.owner = owner;
	}

	public PlayerDTO getCaptain() {
		return captain;
	}

	public void setCaptain(PlayerDTO captain) {
		this.captain = captain;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> players) {
		this.players = players;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

}
