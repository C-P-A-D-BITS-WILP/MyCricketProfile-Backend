package com.bits.cpad.testds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bits.cpad.dto.PlayerDTO;
import com.bits.cpad.dto.TeamDTO;
import com.bits.cpad.dto.UserDTO;

public class TeamDS {

	static Map<Integer, TeamDTO> TEAMS;

	static {
		TEAMS = new HashMap<Integer, TeamDTO>();
		TEAMS.put(1, new TeamDTO(1, "RCB", "#xbyzj", new UserDTO(1, "United", "Sprites"), new PlayerDTO(100, "Faf Du Plessis"),
				"Bengaluru", 16));
		TEAMS.put(2, populateMI());
		TEAMS.put(3, new TeamDTO(3, "DC", "#fasqw", new UserDTO(3, "United", "Sprites"), new PlayerDTO(100, "Rishab Pant"),
				"Delhi", 16));
		TEAMS.put(4, new TeamDTO(4, "KXIP", "#vsdqw", new UserDTO(4, "United", "Sprites"), new PlayerDTO(100, "Mayank Agarwal"),
				"Chandigarh", 16));
		TEAMS.put(5, new TeamDTO(5, "LSG", "#rhrsa", new UserDTO(5, "United", "Sprites"), new PlayerDTO(100, "K L Rahul"),
				"Lucknow", 16));
		TEAMS.put(6, new TeamDTO(6, "GT", "#jydfg", new UserDTO(6, "United", "Sprites"), new PlayerDTO(100, "Hardik Pandya"),
				"Ahmedabad", 16));
		TEAMS.put(7, new TeamDTO(7, "SRH", "#qwgbt", new UserDTO(7, "United", "Sprites"), new PlayerDTO(100, "Kane Williamson"),
				"Hyderabad", 16));
		TEAMS.put(8, new TeamDTO(8, "KKR", "#nyurs", new UserDTO(8, "United", "Sprites"), new PlayerDTO(100, "Shreyas Iyer"),
				"Kolkatta", 16));
		TEAMS.put(9, new TeamDTO(9, "CSK", "#njdaw", new UserDTO(9, "Chennai Super",   "Kings Cricket Ltd."),
				new PlayerDTO(100, "Ravindra Jadeja"), "Chennai", 16));
		TEAMS.put(10, new TeamDTO(10, "RR", "#ysffe", new UserDTO(10, "Manoj", "Badale"), new PlayerDTO(100, "Sanju Samson"),
				"Jaipur", 12));
	}

	public static List<TeamDTO> getTeamList(int startIndex, int endIndex) {
		List<TeamDTO> teamList = new ArrayList<TeamDTO>(TEAMS.values());
		return teamList.subList(startIndex, endIndex);
	}

	private static TeamDTO populateMI() {
		PlayerDTO captain = new PlayerDTO(100, "Rohit Sharma", "Confirmed");
		captain.setPlayerStatus("Confirmed");
		TeamDTO mi = new TeamDTO(2, "MI", "#mbxsd", new UserDTO(2, "Reliance", ""), captain, "Mumbai", 16);

		List<PlayerDTO> players = new ArrayList<PlayerDTO>();

		players.add(captain);
		players.add(new PlayerDTO(101, "Ishan Kishan", "Confirmed"));
		players.add(new PlayerDTO(102, "Kieron Pollard", "Confirmed"));
		players.add(new PlayerDTO(103, "Jasprit Bumrah", "Confirmed"));
		players.add(new PlayerDTO(104, "Surya Kumar Yadav", "Confirmed"));
		players.add(new PlayerDTO(105, "Tilak Verma", "Pending"));

		mi.setPlayers(players);

		return mi;
	}

	public static TeamDTO getTeam(int teamId) {
		return TEAMS.get(teamId);
	}

	public static List<TeamDTO> getMyTeamList(int startIndex, int endIndex) {
		List<TeamDTO> teamList = new ArrayList<TeamDTO>(TEAMS.values());
		List<TeamDTO> myList = teamList.parallelStream().filter(team -> team.getId() % 2 == 0)
				.collect(Collectors.toList());
		return myList;
	}

}
