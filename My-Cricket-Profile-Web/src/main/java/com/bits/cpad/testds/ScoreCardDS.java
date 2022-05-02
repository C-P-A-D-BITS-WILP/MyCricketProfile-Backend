package com.bits.cpad.testds;

import java.util.ArrayList;
import java.util.List;

import com.bits.cpad.dto.BattingScoreDTO;
import com.bits.cpad.dto.BowlingScoreDTO;
import com.bits.cpad.dto.DashboardScoreCardDTO;
import com.bits.cpad.dto.InningsDTO;
import com.bits.cpad.dto.MatchScoreCardDTO;

public class ScoreCardDS {

	public static MatchScoreCardDTO getDetailedMatchScoreCard(Integer matchId) {
		MatchScoreCardDTO matchScoreCard = new MatchScoreCardDTO();
		matchScoreCard.setId(matchId);

		InningsDTO innings1 = new InningsDTO();
		innings1.setBattingTeamName("KXIP");
		innings1.setTotalScore(151);
		innings1.setOvers(20.0);
		innings1.setWickets(5);
		innings1.setBowlingTeamName("SRH");
		List<BattingScoreDTO> battingScores = new ArrayList<>();
		battingScores.add(new BattingScoreDTO("Dhawan (c)", "Marco Jansen", "Bhuvneshwar", 8, 11, 1, 0));
		battingScores.add(new BattingScoreDTO("Prabhsimran", "Pooran", "T Natarajan", 14, 11, 2, 0));
		battingScores.add(new BattingScoreDTO("Bairstow", "", "J Suchith", 12, 10, 2, 0));
		battingScores.add(new BattingScoreDTO("Livingstone", "Williamson ", "Bhuvneshwar", 60, 33, 5, 4));
		battingScores.add(new BattingScoreDTO("Jitesh Sharma (wk)", "Umran Malik", "Umran Malik", 11, 8, 2, 0));
		battingScores.add(new BattingScoreDTO("Rabada", "", "", 0, 0, 0, 0));

		List<BowlingScoreDTO> bowlingScores = new ArrayList<BowlingScoreDTO>();
		bowlingScores.add(new BowlingScoreDTO("Bhuvneshwar", 4.0f, 0, 22, 3, 0, 0));
		bowlingScores.add(new BowlingScoreDTO("Marco Jansen", 4.0f, 0, 35, 0, 0, 0));
		bowlingScores.add(new BowlingScoreDTO("T Natarajan", 4.0f, 0, 38, 1, 0, 0));
		bowlingScores.add(new BowlingScoreDTO("J Suchith", 4.0f, 0, 28, 1, 0, 0));
		bowlingScores.add(new BowlingScoreDTO("Umran Malik", 4.0f, 1, 28, 4, 0, 0));

		innings1.setBattingScores(battingScores);
		innings1.setBowlingScores(bowlingScores);
		innings1.setExtras("16 (b 3, lb 6, w 6, nb 1, p 0)");

		List<InningsDTO> inningsList = new ArrayList<InningsDTO>();
		inningsList.add(innings1);
		inningsList.add(innings1);
		matchScoreCard.setInnings(inningsList);

		return matchScoreCard;
	}

	public static List<DashboardScoreCardDTO> populateDummyData() {
		List<DashboardScoreCardDTO> dtos = new ArrayList<DashboardScoreCardDTO>();
		
		dtos.add(new DashboardScoreCardDTO(1, "IPLT20", "LSG", 130, 2, 20, "KXIP", 0, 0, 0, "KXIP need 131 in 20 Overs" ));
		dtos.add(new DashboardScoreCardDTO(2, "Pepsi Cup", "Ind", 130, 2, 30, "Eng", 0, 0, 0, "Ind won the toss and choose to bat"));
		dtos.add(new DashboardScoreCardDTO(3, "Bilateral Series","RSA", 220, 8,  50,  "WI",  214,  10, 46.3, "RSA won by 6 Runs"));
		dtos.add(new DashboardScoreCardDTO(4, "Bilateral Series", "Eng",  363, 5,  50,  "NZ",  290,  7, 50, "Eng won by 73 runs"));
		dtos.add(new DashboardScoreCardDTO(5, "Pak tour of SL", "SL",  285, 4,  50,  "Pak",  236, 10, 42, "SL won by 49 runs"));
		return dtos;
	}

}
