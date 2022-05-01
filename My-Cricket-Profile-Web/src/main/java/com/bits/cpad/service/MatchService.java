package com.bits.cpad.service;

import java.util.List;

import com.bits.cpad.dto.DashboardScoreCardDTO;
import com.bits.cpad.dto.MatchScoreCardDTO;

public interface MatchService {

	public List<DashboardScoreCardDTO> getRecentMatchCards();

	public MatchScoreCardDTO getDetailedMatchScoreCard(Integer matchId);

}
