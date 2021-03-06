package com.bits.cpad.dto;

import com.bits.cpad.utils.Utility;

public class BattingScoreDTO {
	private String batsmanName;
	private String caughtBy;
	private String bowledBy;
	private Integer runs;
	private Integer balls;
	private Integer fours;
	private Integer sixers;
	private Double strikeRate;
	private Boolean dismissed = false;

	public BattingScoreDTO(String string, String string2, String string3, int i, int j, int k, int l) {
		this.batsmanName = string;
		this.caughtBy = string2;
		this.bowledBy = string3;
		this.runs = i;
		this.balls = j;
		this.fours = k;
		this.sixers = l;
		this.setStrikeRate();
		this.setDismissed();
	}

	public BattingScoreDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getBatsmanName() {
		return batsmanName;
	}

	public void setBatsmanName(String batsmanName) {
		this.batsmanName = batsmanName;
	}

	public String getCaughtBy() {
		return caughtBy;
	}

	public void setCaughtBy(String caughtBy) {
		this.caughtBy = caughtBy;
	}

	public String getBowledBy() {
		return bowledBy;
	}

	public void setBowledBy(String bowledBy) {
		this.bowledBy = bowledBy;
		this.setDismissed();
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
		this.setStrikeRate();
	}

	public Integer getBalls() {
		return balls;
	}

	public void setBalls(Integer balls) {
		this.balls = balls;
		this.setStrikeRate();
	}

	public Integer getFours() {
		return fours;
	}

	public void setFours(Integer fours) {
		this.fours = fours;
	}

	public Integer getSixers() {
		return sixers;
	}

	public void setSixers(Integer sixers) {
		this.sixers = sixers;
	}

	public Double getStrikeRate() {
		return strikeRate;
	}

	private void setStrikeRate() {
		if (this.balls == null || this.balls == 0)
			this.strikeRate = 0.0;
		else {
			this.strikeRate = Utility.round(((double) this.runs / (double) this.balls) * 100, 2);
		}
	}

	public boolean isDismissed() {
		return dismissed;
	}

	private void setDismissed() {
		if(this.bowledBy.isEmpty())
			this.dismissed = false;
		else
			this.dismissed = true;
	}

}
