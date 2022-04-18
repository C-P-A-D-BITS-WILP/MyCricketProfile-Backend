package com.bits.cpad.dto;

import java.util.List;

public class InningsDTO {
	private Integer id;
	private String battingTeamName;
	private String bowlingTeamName;
	private List<BattingScoreDTO> battingScores;
	private List<BowlingScoreDTO> bowlingScores;
	private Integer totalScore;
	private Float overs;
	private Integer wickets;
	private String extras;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBattingTeamName() {
		return battingTeamName;
	}

	public void setBattingTeamName(String battingTeamName) {
		this.battingTeamName = battingTeamName;
	}

	public String getBowlingTeamName() {
		return bowlingTeamName;
	}

	public void setBowlingTeamName(String bowlingTeamName) {
		this.bowlingTeamName = bowlingTeamName;
	}

	public List<BattingScoreDTO> getBattingScores() {
		return battingScores;
	}

	public void setBattingScores(List<BattingScoreDTO> battingScores) {
		this.battingScores = battingScores;
	}

	public List<BowlingScoreDTO> getBowlingScores() {
		return bowlingScores;
	}

	public void setBowlingScores(List<BowlingScoreDTO> bowlingScores) {
		this.bowlingScores = bowlingScores;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Float getOvers() {
		return overs;
	}

	public void setOvers(Float overs) {
		this.overs = overs;
	}

	public Integer getWickets() {
		return wickets;
	}

	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}
}
