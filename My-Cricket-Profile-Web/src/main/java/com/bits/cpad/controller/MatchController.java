package com.bits.cpad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.dto.DashboardScoreCardDTO;
import com.bits.cpad.dto.MatchScoreCardDTO;
import com.bits.cpad.service.MatchService;
import com.bits.cpad.testds.ScoreCardDS;

@RestController
public class MatchController {

	@Autowired
	private MatchService matchService;

	@GetMapping(value = "/match-score/{matchId}")
	public MatchScoreCardDTO getDetailedMatchScoreCard(@PathVariable Integer matchId) {
//		return ScoreCardDS.getDetailedMatchScoreCard(matchId);
		return matchService.getDetailedMatchScoreCard(matchId);
	}

	@GetMapping(value = "/match-score/recent-matches")
	public List<DashboardScoreCardDTO> getRecentMatchCards() {
		return matchService.getRecentMatchCards();
	}
}
