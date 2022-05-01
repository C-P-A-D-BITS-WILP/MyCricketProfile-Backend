package com.bits.cpad.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.dto.TeamDTO;
import com.bits.cpad.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@GetMapping(path = "/teams")
	public List<TeamDTO> getTeams() {
		List<TeamDTO> list = teamService.getTeamList(0, 10);
		return list;
	}

	@GetMapping(path = "/my-teams/{userId}")
	public List<TeamDTO> getMyTeams(@PathVariable int userId) {
		List<TeamDTO> list = teamService.getMyTeamList(userId, 0, 10);
		return list;
	}

	@GetMapping(path = "/team-info/{teamId}")
	public TeamDTO getTeamDetails(@PathVariable int teamId) {
		TeamDTO team = teamService.getTeam(teamId);
		return team;
	}

	@PostMapping(path = "/create-team")
	public TeamDTO createTeam(@RequestBody Map<?,?> newTeam) {
		TeamDTO team = teamService.createTeam(newTeam);
		return team;
	}

	@PostMapping(path = "/remove-player")
	public TeamDTO removePlayer(@RequestBody Map<?,?> playerMap) {
		return teamService.removePlayer(playerMap);
	}

	@PostMapping(path = "/accept-player")
	public TeamDTO acceptPlayer(@RequestBody Map<?,?> playerMap) {
		return teamService.acceptPlayer(playerMap);
	}
	
	@PostMapping(path = "/request-join-team")
	public String requestToJoin(@RequestBody Map<?,?> map) {
		teamService.requestToJoin(map);
		return "Success";
	}
	
	@DeleteMapping(path = "/soft-delete-team/{teamId}")
	public void softDeleteTeam(@PathVariable int teamId) {
		System.out.println(teamId);
	}
}
