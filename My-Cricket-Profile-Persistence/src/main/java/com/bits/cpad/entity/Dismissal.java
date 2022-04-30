package com.bits.cpad.entity;

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

	@ManyToOne
	@JoinColumn(name="bowler_fk")
	private User bowler;

	@ManyToOne
	@JoinColumn(name="fielder_fk")	
	private User fielder;
	
	@Column(name = "dismissial_type")
	private String dismissalType;
	
	
}
