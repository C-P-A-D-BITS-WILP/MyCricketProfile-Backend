package com.bits.cpad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.dto.MatchScoreCardDTO;
import com.bits.cpad.testds.ScoreCardDS;

@RestController
public class MatchController {

	@GetMapping(value = "/match-score/{matchId}")
	public MatchScoreCardDTO getDetailedMatchScoreCard(@PathVariable Integer matchId) {
		return ScoreCardDS.getDetailedMatchScoreCard(matchId);
	}
}
