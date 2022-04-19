package com.bits.cpad.testds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bits.cpad.dto.Team;

public class TeamDS {

	static Map<Integer, Team> TEAMS;

	static {
		TEAMS = new HashMap<Integer, Team>();
		TEAMS.put(1, new Team(1, "RCB"));
		TEAMS.put(2, new Team(2, "MI"));
		TEAMS.put(3, new Team(3, "DC"));
		TEAMS.put(4, new Team(4, "KXIP"));
		TEAMS.put(5, new Team(5, "LSG"));
		TEAMS.put(6, new Team(6, "GT"));
		TEAMS.put(7, new Team(7, "SRH"));
		TEAMS.put(8, new Team(8, "KKR"));
		TEAMS.put(9, new Team(9, "CSK"));
		TEAMS.put(10, new Team(10, "RR"));
	}

	public static List<Team> getTeamList(int startIndex, int endIndex) {
		List<Team> teamList = new ArrayList<Team>(TEAMS.values());
		return teamList.subList(startIndex, endIndex);
	}

	public static Team getTeam(int teamId) {
		return TEAMS.get(teamId);
	}

	public static List<Team> getMyTeamList(int startIndex, int endIndex) {
		List<Team> teamList = new ArrayList<Team>(TEAMS.values());
		List<Team> myList = teamList.parallelStream().filter(team -> team.getId() % 2 == 0)
				.collect(Collectors.toList());
		return myList;
	}

}
