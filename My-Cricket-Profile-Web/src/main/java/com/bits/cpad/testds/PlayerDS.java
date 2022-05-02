package com.bits.cpad.testds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bits.cpad.dto.PlayerDTO;
import com.bits.cpad.dto.PlayerScoreDTO;

public class PlayerDS {

	static Map<Integer, PlayerDTO> PLAYERS;

	static {
		PLAYERS = new HashMap<Integer, PlayerDTO>();
		PLAYERS.put(1, new PlayerDTO(1, "Sachin Tendulkar"));
		PLAYERS.put(2, new PlayerDTO(2, "Virat Kohli"));
		PLAYERS.put(3, new PlayerDTO(3, "Mahindra Singh Dhoni"));
		PLAYERS.put(4, new PlayerDTO(4, "Rohit Sharma"));
		PLAYERS.put(5, new PlayerDTO(5, "KL Rahul"));
		PLAYERS.put(6, new PlayerDTO(6, "Mayank Agarwal"));
		PLAYERS.put(7, new PlayerDTO(7, "Chris Gayle"));
		PLAYERS.put(8, new PlayerDTO(8, "A B De Villiars"));
		PLAYERS.put(9, new PlayerDTO(9, "Robin Uttappa"));
		PLAYERS.put(10, populateDhawan());
	}

	public static List<PlayerDTO> getPlayerList(int startIndex, int endIndex) {
		List<PlayerDTO> playerList = new ArrayList<PlayerDTO>(PLAYERS.values());
		return playerList.subList(startIndex, endIndex);
	}

	public static PlayerDTO getPlayer(int playerId) {
		return PLAYERS.get(playerId);
	}

	private static PlayerDTO populateDhawan() {
		PlayerDTO player = new PlayerDTO();
		player.setId(10);
		player.setName("Shikar Dhawan");
		player.setAge(35);
		player.setBattingStyle("Left Handed Bat");
		player.setBowlingStyle("Right-arm offbreak");
		player.setRole("Batsman");

		PlayerScoreDTO score = new PlayerScoreDTO();
		score.setMatches(34);

		score.setBattingInnings(58);
		score.setNotOut(1);
		score.setRunsScored(2315);
		score.setHighestScore(190);
		score.setStrikeRate(66.95);
		score.setBattingAvg(40.61);
		score.setFifties(5);
		score.setHundreds(7);

		score.setBowlingInnings(5);
		score.setBallsBowled(54);
		score.setRunsGiven(18);
		score.setWickets(0);
		score.setBowlingAvg(0.0);
		score.setEconomy(2.0);
		score.setFiver(0);

		player.setScore(score);

		return player;
	}

}
