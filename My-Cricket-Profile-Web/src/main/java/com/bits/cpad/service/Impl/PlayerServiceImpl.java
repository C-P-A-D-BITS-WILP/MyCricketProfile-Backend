package com.bits.cpad.service.Impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.cpad.dto.PlayerDTO;
import com.bits.cpad.dto.PlayerScoreDTO;
import com.bits.cpad.entity.BattingScore;
import com.bits.cpad.entity.BowlingScore;
import com.bits.cpad.entity.User;
import com.bits.cpad.repository.UserRepository;
import com.bits.cpad.service.PlayerService;
import com.bits.cpad.utils.EntityToDTOMapper;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	UserRepository userRepo;

	@Override
	public List<PlayerDTO> getPlayerList(int startIndx, int emdIndx) {
		Iterable<User> iterables = userRepo.findAll();
		List<User> users = StreamSupport.stream(iterables.spliterator(), false).collect(Collectors.toList());
		List<PlayerDTO> players = EntityToDTOMapper.getPlayers(users);
		return players;
	}

	@Override
	public PlayerDTO getPlayer(int playerId) {
		User player = userRepo.findById(playerId).get();
		PlayerDTO dto = EntityToDTOMapper.getPlayer(player);
		List<BattingScore> battingScores = player.getBattingScores();
		List<BowlingScore> bowlingScores = player.getBowlingScores();

		dto.setScore(getPlayerScores(battingScores, bowlingScores));
		return dto;
	}

	private PlayerScoreDTO getPlayerScores(List<BattingScore> battingScores, List<BowlingScore> bowlingScores) {

		PlayerScoreDTO scoreDTO = new PlayerScoreDTO();

		int runsScored = battingScores.stream().mapToInt(BattingScore::getRuns).sum();
		int notOuts = (int) battingScores.stream().filter(score -> score.getDismissal() == null).count();
		int highestScore = getHighestScore(battingScores);
		int ballsFaced = battingScores.stream().mapToInt(BattingScore::getBalls).sum();
		double strikeRate = getStrikeRate(runsScored, ballsFaced);
		int battingInnings = battingScores.size();
		int fifties = (int) battingScores.stream().filter(score -> score.getRuns() >= 50 && score.getRuns() < 100)
				.count();
		int hundreds = (int) battingScores.stream().filter(score -> score.getRuns() >= 100).count();
		double average = getBattingAverage(runsScored, battingInnings);

		scoreDTO.setBattingInnings(battingInnings);
		scoreDTO.setRunsScored(runsScored);
		scoreDTO.setNotOut(notOuts);
		scoreDTO.setHighestScore(highestScore);
		scoreDTO.setStrikeRate(strikeRate);
		scoreDTO.setBattingAvg(average);
		scoreDTO.setFifties(fifties);
		scoreDTO.setHundreds(hundreds);

		int bowlingInnings = bowlingScores.size();
		double oversBowled = bowlingScores.stream().mapToDouble(BowlingScore::getOvers).sum();
		int ballsBowled = getBallsBowled(oversBowled);
		int runsGiven = bowlingScores.stream().mapToInt(BowlingScore::getRunsGiven).sum();
		int wickets = bowlingScores.stream().mapToInt(BowlingScore::getWickets).sum();
		double bowlingAverage = getBowlingAverage(ballsBowled, wickets);
		double economy = getEconomy(runsGiven, oversBowled);
		int fiver = (int) bowlingScores.stream().filter(score -> score.getWickets() >= 5).count();

		scoreDTO.setMatches(battingInnings > bowlingInnings ? battingInnings : bowlingInnings);
		scoreDTO.setBowlingInnings(bowlingInnings);
		scoreDTO.setBallsBowled(ballsBowled);
		scoreDTO.setRunsGiven(runsGiven);
		scoreDTO.setWickets(wickets);
		scoreDTO.setBowlingAvg(bowlingAverage);
		scoreDTO.setEconomy(economy);
		scoreDTO.setFiver(fiver);

		return scoreDTO;
	}

	private int getHighestScore(List<BattingScore> battingScores) {
		try {
			int highestScore = battingScores.stream().max(Comparator.comparing(BattingScore::getRuns)).get().getRuns();
			return highestScore;
		} catch (Exception e) {
			return 0;
		}
	}

	private double getEconomy(int runsGiven, double oversBowled) {
		double eco = 0;
		if (oversBowled != 0) {
			eco = runsGiven / oversBowled;
		}
		return eco;
	}

	private double getBowlingAverage(int ballsBowled, int wickets) {
		double average = 0.0;
		if (wickets != 0) {
			average = ballsBowled / wickets;
		}

		return average;
	}

	private int getBallsBowled(double oversBowled) {
		int totalBalls = 0;
		if (oversBowled != 0) {
			int completedOvers = (int) oversBowled;
			int remainingBalls = (int) ((oversBowled * 10) % 10);

			totalBalls = completedOvers + remainingBalls;
		}

		return totalBalls;
	}

	private double getBattingAverage(int runsScored, int innings) {
		double average = 0.0;
		if (innings != 0) {
			average = runsScored / innings;
		}
		return average;
	}

	private double getStrikeRate(int runsScored, int ballsFaced) {
		double strikeRate = 0.0;
		if (ballsFaced != 0) {
			strikeRate = runsScored / ballsFaced;
		}
		return strikeRate;
	}

}
