package com.bits.cpad.service;

import java.util.List;
import java.util.Map;

import com.bits.cpad.dto.TeamDTO;

public interface TeamService {

	public List<TeamDTO> getTeamList(int startIndx, int endIdx);
	
	public List<TeamDTO> getMyTeamList(int userId, int startIndx, int endIdx);

	public TeamDTO getTeam(int teamId);

	public TeamDTO createTeam(Map<?, ?> newTeam);

	public TeamDTO updateTeam(TeamDTO team);

	public TeamDTO removePlayer(Map<?, ?> playerMap);

	public TeamDTO acceptPlayer(Map<?, ?> playerMap);

	public void requestToJoin(Map<?, ?> map);
}
