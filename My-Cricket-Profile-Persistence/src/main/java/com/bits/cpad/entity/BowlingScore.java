package com.bits.cpad.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bowling_score")
public class BowlingScore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Double overs;

	private Integer maidens;

	@Column(name = "runs_given")
	private Integer runsGiven;

	private Integer wickets;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "player_fk")
	private User player;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "innings_fk")
	private InningsScore innings;

	@Column(name = "no_balls")
	private Integer noBalls;

	private Integer wides;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getOvers() {
		return overs;
	}

	public void setOvers(Double overs) {
		this.overs = overs;
	}

	public Integer getMaidens() {
		return maidens;
	}

	public void setMaidens(Integer maidens) {
		this.maidens = maidens;
	}

	public Integer getRunsGiven() {
		return runsGiven;
	}

	public void setRunsGiven(Integer runsGiven) {
		this.runsGiven = runsGiven;
	}

	public Integer getWickets() {
		return wickets;
	}

	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public InningsScore getInnings() {
		return innings;
	}

	public void setInnings(InningsScore innings) {
		this.innings = innings;
	}

	public Integer getNoBalls() {
		return noBalls;
	}

	public void setNoBalls(Integer noBalls) {
		this.noBalls = noBalls;
	}

	public Integer getWides() {
		return wides;
	}

	public void setWides(Integer wides) {
		this.wides = wides;
	}
	
}
