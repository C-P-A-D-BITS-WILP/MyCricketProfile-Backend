package com.bits.cpad.dto;

import java.util.List;

public class MatchScoreCardDTO {
	
	private Integer id;
	private List<InningsDTO> innings;
	private String matchResult;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}

	public List<InningsDTO> getInnings() {
		return innings;
	}

	public void setInnings(List<InningsDTO> innings) {
		this.innings = innings;
	}
	
}
