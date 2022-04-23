package com.bits.cpad.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.dto.Team;
import com.bits.cpad.testds.TeamDS;

@RestController
public class TeamController {

	@GetMapping(path = "/teams")
	public List<Team> getTeams() {
		List<Team> list = TeamDS.getTeamList(0, 10);
		return list;
	}

	@GetMapping(path = "/my-teams/{userId}")
	public List<Team> getMyTeams(@PathVariable int userId) {
		System.out.println(userId);
		List<Team> list = TeamDS.getMyTeamList(0, 10);
		return list;
	}

	@GetMapping(path = "/team-info/{teamId}")
	public Team getTeamDetails(@PathVariable int teamId) {
		Team team = TeamDS.getTeam(teamId);
		return team;
	}

	@DeleteMapping(path = "/soft-delete-team/{teamId}")
	public void softDeleteTeam(@PathVariable int teamId) {
		System.out.println(teamId);
	}
}
