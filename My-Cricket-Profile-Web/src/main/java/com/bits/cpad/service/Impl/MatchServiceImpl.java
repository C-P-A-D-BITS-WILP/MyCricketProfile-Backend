package com.bits.cpad.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.cpad.dto.DashboardScoreCardDTO;
import com.bits.cpad.dto.MatchScoreCardDTO;
import com.bits.cpad.entity.CricketMatch;
import com.bits.cpad.repository.MatchRepository;
import com.bits.cpad.service.MatchService;
import com.bits.cpad.utils.EntityToDTOMapper;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	MatchRepository matchRepo;
	
	@Override
	public List<DashboardScoreCardDTO> getRecentMatchCards() {
		Iterable<CricketMatch> tempList = matchRepo.findAll();
		List<CricketMatch> matchList =  StreamSupport.stream(tempList.spliterator(), false).collect(Collectors.toList());
		List<DashboardScoreCardDTO> dashboardScoreCardDTOs = EntityToDTOMapper.getDashboardScoreCard(matchList);
		return dashboardScoreCardDTOs;
	}

	@Override
	public MatchScoreCardDTO getDetailedMatchScoreCard(Integer matchId) {
		CricketMatch match = matchRepo.findById(matchId).get();
		
		MatchScoreCardDTO dto = EntityToDTOMapper.getMatchScoreCard(match);
		return dto;
	}
}
