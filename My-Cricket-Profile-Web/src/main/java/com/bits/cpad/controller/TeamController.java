package com.bits.cpad.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.dto.TeamDTO;
import com.bits.cpad.testds.TeamDS;

@RestController
public class TeamController {

	@GetMapping(path = "/teams")
	public List<TeamDTO> getTeams() {
		List<TeamDTO> list = TeamDS.getTeamList(0, 10);
		return list;
	}

	@GetMapping(path = "/my-teams/{userId}")
	public List<TeamDTO> getMyTeams(@PathVariable int userId) {
		List<TeamDTO> list = TeamDS.getMyTeamList(0, 10);
		return list;
	}

	@GetMapping(path = "/team-info/{teamId}")
	public TeamDTO getTeamDetails(@PathVariable int teamId) {
		TeamDTO team = TeamDS.getTeam(teamId);
		return team;
	}

	@DeleteMapping(path = "/soft-delete-team/{teamId}")
	public void softDeleteTeam(@PathVariable int teamId) {
		System.out.println(teamId);
	}
}
