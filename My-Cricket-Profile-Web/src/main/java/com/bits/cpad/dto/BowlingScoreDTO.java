package com.bits.cpad.dto;

public class BowlingScoreDTO {

	private String bowlerName;
	private Float overs;
	private Integer maidens;
	private Integer runsGiven;
	private Integer wickets;
	private Integer noBalls;
	private Integer wides;
	private Float economy;

	public BowlingScoreDTO(String bowlerName, float overs, int maidens, int runsGiven, int wickets, int noBalls, int wides) {
		this.bowlerName = bowlerName;
		this.overs = overs;
		this.maidens = maidens;
		this.runsGiven = runsGiven;
		this.wickets = wickets;
		this.noBalls = noBalls;
		this.wides = wides;
		this.setEconomy();
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	public Float getOvers() {
		return overs;
	}

	public void setOvers(Float overs) {
		this.overs = overs;
		this.setEconomy();
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
		this.setEconomy();
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

	public Float getEconomy() {
		return economy;
	}

	private void setEconomy() {
		if (this.overs == 0) {
			this.economy = 0.0f;
		} else {
			this.economy = this.runsGiven / this.overs;
		}
	}

	public Integer getWickets() {
		return wickets;
	}

	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}
}
