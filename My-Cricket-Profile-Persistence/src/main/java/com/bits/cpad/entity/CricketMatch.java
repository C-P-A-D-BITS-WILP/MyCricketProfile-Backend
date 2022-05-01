package com.bits.cpad.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cricket_match")
public class CricketMatch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "match_type")
	private String matchType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mom_fk")
	private User mom;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team1_fk")
	private Team team1;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team2_fk")
	private Team team2;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tournament_fk")
	private Tournament tournament;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "winning_team_fk")
	private Team winningTeam;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "scorecard_fk")
	private ScoreCard scoreCard;

	@Column(name="match_date")
	@Temporal(TemporalType.DATE)
	private Date matchDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public User getMom() {
		return mom;
	}

	public void setMom(User mom) {
		this.mom = mom;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Team getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(Team winningTeam) {
		this.winningTeam = winningTeam;
	}

	public ScoreCard getScoreCard() {
		return scoreCard;
	}

	public void setScoreCard(ScoreCard scoreCard) {
		this.scoreCard = scoreCard;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	
}
