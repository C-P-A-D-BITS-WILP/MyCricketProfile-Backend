package com.bits.cpad.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "scorecard")
public class ScoreCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "innings1_fk")
	private InningsScore innings1;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "innings2_fk")
	private InningsScore innings2;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "innings3_fk")
	private InningsScore innings3;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "innings4_fk")
	private InningsScore innings4;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public InningsScore getInnings1() {
		return innings1;
	}

	public void setInnings1(InningsScore innings1) {
		this.innings1 = innings1;
	}

	public InningsScore getInnings2() {
		return innings2;
	}

	public void setInnings2(InningsScore innings2) {
		this.innings2 = innings2;
	}

	public InningsScore getInnings3() {
		return innings3;
	}

	public void setInnings3(InningsScore innings3) {
		this.innings3 = innings3;
	}

	public InningsScore getInnings4() {
		return innings4;
	}

	public void setInnings4(InningsScore innings4) {
		this.innings4 = innings4;
	}

}
