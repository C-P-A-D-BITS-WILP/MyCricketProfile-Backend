package com.bits.cpad.dto;

public class MatchScoreCardDTO {
	private Integer id;
	private InningsDTO innings1;
	private InningsDTO innings2;
	private InningsDTO innings3;
	private InningsDTO innings4;
	private String matchResult;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public InningsDTO getInnings1() {
		return innings1;
	}

	public void setInnings1(InningsDTO innings1) {
		this.innings1 = innings1;
	}

	public InningsDTO getInnings2() {
		return innings2;
	}

	public void setInnings2(InningsDTO innings2) {
		this.innings2 = innings2;
	}

	public InningsDTO getInnings3() {
		return innings3;
	}

	public void setInnings3(InningsDTO innings3) {
		this.innings3 = innings3;
	}

	public InningsDTO getInnings4() {
		return innings4;
	}

	public void setInnings4(InningsDTO innings4) {
		this.innings4 = innings4;
	}

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}

}
