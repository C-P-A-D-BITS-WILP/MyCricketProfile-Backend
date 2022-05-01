package com.bits.cpad.dto;

/**
 * @author Jayant
 *
 */
public class DashboardScoreCardDTO {

	private Integer id;

	private String tournamentName;

	private String team1;

	private Integer score1;

	private Integer wickets1;

	private Double overs1;

	private String team2;

	private Integer score2;

	private Integer wickets2;

	private Double overs2;

	private String summary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public Integer getScore1() {
		return score1;
	}

	public void setScore1(Integer score1) {
		this.score1 = score1;
	}

	public Integer getWickets1() {
		return wickets1;
	}

	public void setWickets1(Integer wickets1) {
		this.wickets1 = wickets1;
	}

	public Double getOvers1() {
		return overs1;
	}

	public void setOvers1(Double overs1) {
		this.overs1 = overs1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public Integer getScore2() {
		return score2;
	}

	public void setScore2(Integer score2) {
		this.score2 = score2;
	}

	public Integer getWickets2() {
		return wickets2;
	}

	public void setWickets2(Integer wickets2) {
		this.wickets2 = wickets2;
	}

	public Double getOvers2() {
		return overs2;
	}

	public void setOvers2(Double overs2) {
		this.overs2 = overs2;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
