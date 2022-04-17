package com.bits.cpad.testds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bits.cpad.dto.Player;
import com.bits.cpad.dto.PlayerScore;

public class PlayerDS {

	static Map<Integer, Player> PLAYERS;

	static {
		PLAYERS = new HashMap<Integer, Player>();
		PLAYERS.put(1, new Player(1, "Sachin Tendulkar"));
		PLAYERS.put(2, new Player(2, "Virat Kohli"));
		PLAYERS.put(3, new Player(3, "Mahindra Singh Dhoni"));
		PLAYERS.put(4, new Player(4, "Rohit Sharma"));
		PLAYERS.put(5, new Player(5, "KL Rahul"));
		PLAYERS.put(6, new Player(6, "Mayank Agarwal"));
		PLAYERS.put(7, new Player(7, "Chris Gayle"));
		PLAYERS.put(8, new Player(8, "A B De Villiars"));
		PLAYERS.put(9, new Player(9, "Robin Uttappa"));
		PLAYERS.put(10, populateDhawan());
	}

	public static List<Player> getPlayerList(int startIndex, int endIndex) {
		List<Player> playerList = new ArrayList<Player>(PLAYERS.values());
		return playerList.subList(startIndex, endIndex);
	}

	public static Player getPlayer(int playerId) {
		return PLAYERS.get(playerId);
	}

	private static Player populateDhawan() {
		Player player = new Player();
		player.setId(10);
		player.setName("Shikar Dhawan");
		player.setAge(35);
		player.setBattingStyle("Left Handed Bat");
		player.setBowlingStyle("Right-arm offbreak");
		player.setRole("Batsman");

		PlayerScore score = new PlayerScore();
		score.setMatches(34);

		score.setBattingInnings(58);
		score.setNotOut(1);
		score.setRunsScored(2315);
		score.setHighestScore(190);
		score.setStrikeRate(66.95F);
		score.setBattingAvg(40.61F);
		score.setFifties(5);
		score.setHundreds(7);

		score.setBowlingInnings(5);
		score.setBallsBowled(54);
		score.setRunsGiven(18);
		score.setWickets(0);
		score.setBowlingAvg(0.0F);
		score.setEconomy(2.0F);
		score.setFiver(0);

		player.setScore(score);

		return player;
	}

}
