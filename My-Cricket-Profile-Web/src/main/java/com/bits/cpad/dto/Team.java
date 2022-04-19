package com.bits.cpad.dto;

public class Team {
	String name;
	Integer id;

	public Team(int id, String teamName) {
		this.id = id;
		this.name = teamName;
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

}
