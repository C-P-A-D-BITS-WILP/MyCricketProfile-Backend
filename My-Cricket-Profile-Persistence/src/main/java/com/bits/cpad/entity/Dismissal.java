package com.bits.cpad.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dismissal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bowler_fk")
	private User bowler;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fielder_fk")	
	private User fielder;
	
	@Column(name = "dismissial_type")
	private String dismissalType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getBowler() {
		return bowler;
	}

	public void setBowler(User bowler) {
		this.bowler = bowler;
	}

	public User getFielder() {
		return fielder;
	}

	public void setFielder(User fielder) {
		this.fielder = fielder;
	}

	public String getDismissalType() {
		return dismissalType;
	}

	public void setDismissalType(String dismissalType) {
		this.dismissalType = dismissalType;
	}
	
	
}
