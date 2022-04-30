package com.bits.cpad.entity;

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
	private Integer fiver;
	private Integer maidens;

	@Column(name = "runs_given")
	private Integer runsGiven;

	private Integer wickets;

	@ManyToOne
	@JoinColumn(name = "player_fk")
	private User player;

	@ManyToOne
	@JoinColumn(name = "innings_fk")
	private InningsScore innings;

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

	public Integer getFiver() {
		return fiver;
	}

	public void setFiver(Integer fiver) {
		this.fiver = fiver;
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

	
}
