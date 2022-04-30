package com.bits.cpad.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "innings_score")
public class InningsScore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Double overs;

	@Column(name = "total_score")
	private Integer totalScore;

	@Column(name = "wickets")
	private Integer wickets;

	@ManyToOne
	@JoinColumn(name = "batting_team_fk")
	private Team battingTeam;

	@ManyToOne
	@JoinColumn(name = "bowling_team_fk")
	private Team bowlingTeam;

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

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getWickets() {
		return wickets;
	}

	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}

	public Team getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(Team battingTeam) {
		this.battingTeam = battingTeam;
	}

	public Team getBowlingTeam() {
		return bowlingTeam;
	}

	public void setBowlingTeam(Team bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}

}
