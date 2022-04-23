package com.bits.cpad.testds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bits.cpad.dto.Player;
import com.bits.cpad.dto.Team;

public class TeamDS {

	static Map<Integer, Team> TEAMS;

	static {
		TEAMS = new HashMap<Integer, Team>();
		TEAMS.put(1, new Team(1, "RCB", "#xbyzj", new Player(1, "United Sprites"), new Player(100, "Faf Du Plessis"), "Bengaluru"));
		TEAMS.put(2, new Team(2, "MI", "#mbxsd", new Player(2, "Reliance"), new Player(100, "Rohit Sharma"), "Mumbai"));
		TEAMS.put(3, new Team(3, "DC", "#fasqw", new Player(3, "United Sprites"), new Player(100, "Rishab Pant"), "Delhi"));
		TEAMS.put(4, new Team(4, "KXIP", "#vsdqw", new Player(4, "United Sprites"), new Player(100, "Mayank Agarwal"), "Chandigarh"));
		TEAMS.put(5, new Team(5, "LSG", "#rhrsa", new Player(5, "United Sprites"), new Player(100, "K L Rahul"), "Lucknow"));
		TEAMS.put(6, new Team(6, "GT", "#jydfg", new Player(6, "United Sprites"), new Player(100, "Hardik Pandya"), "Ahmedabad"));
		TEAMS.put(7, new Team(7, "SRH", "#qwgbt", new Player(7, "United Sprites"), new Player(100, "Kane Williamson"), "Hyderabad"));
		TEAMS.put(8, new Team(8, "KKR", "#nyurs", new Player(8, "United Sprites"), new Player(100, "Shreyas Iyer"), "Kolkatta"));
		TEAMS.put(9, new Team(9, "CSK", "#njdaw", new Player(9, "Chennai Super Kings Cricket Ltd."), new Player(100, "Ravindra Jadeja"), "Chennai"));
		TEAMS.put(10, new Team(10, "RR", "#ysffe", new Player(10, "Manoj Badale"), new Player(100, "Sanju Samson"), "Jaipur"));
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
