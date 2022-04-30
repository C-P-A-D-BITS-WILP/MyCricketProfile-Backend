package com.bits.cpad.dto;

public class UserDTO {
	String fname;
	
	String lname;
	
	String email;
	
	Integer id;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(int id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
