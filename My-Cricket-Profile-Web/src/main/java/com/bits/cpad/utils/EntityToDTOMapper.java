package com.bits.cpad.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bits.cpad.dto.BattingScoreDTO;
import com.bits.cpad.dto.BowlingScoreDTO;
import com.bits.cpad.dto.DashboardScoreCardDTO;
import com.bits.cpad.dto.InningsDTO;
import com.bits.cpad.dto.MatchScoreCardDTO;
import com.bits.cpad.dto.PlayerDTO;
import com.bits.cpad.dto.TeamDTO;
import com.bits.cpad.dto.TournamentDTO;
import com.bits.cpad.dto.UserDTO;
import com.bits.cpad.entity.BattingScore;
import com.bits.cpad.entity.BowlingScore;
import com.bits.cpad.entity.CricketMatch;
import com.bits.cpad.entity.InningsScore;
import com.bits.cpad.entity.ScoreCard;
import com.bits.cpad.entity.Team;
import com.bits.cpad.entity.TeamMembers;
import com.bits.cpad.entity.Tournament;
import com.bits.cpad.entity.User;

public class EntityToDTOMapper {
	public static List<TournamentDTO> getTournament(List<Tournament> tournamentList) {

		List<TournamentDTO> tournamentDTOList = tournamentList.stream().map(tournament -> {
			TournamentDTO dto = getTournament(tournament);
			return dto;
		}).collect(Collectors.toList());

		return tournamentDTOList;
	}

	public static TournamentDTO getTournament(Tournament entity) {
		TournamentDTO dto = new TournamentDTO();
		if (entity != null) {
			dto.setName(entity.getName());
			dto.setStartDate(entity.getStartDate());
			dto.setEndDate(entity.getEndDate());
			dto.setId(entity.getId());
			dto.setFee(entity.getFee());
			dto.setRunner(getTeam(entity.getRunner()));
			dto.setWinner(getTeam(entity.getWinner()));
			dto.setOraganizer(getUser(entity.getOrganizer()));
		}
		return dto;
	}

	public static List<TeamDTO> getTeam(List<Team> teamList) {

		List<TeamDTO> tournamentDTOList = teamList.stream().map(team -> {
			TeamDTO dto = getTeam(team);
			return dto;
		}).collect(Collectors.toList());

		return tournamentDTOList;
	}

	public static TeamDTO getTeam(Team entity) {
		TeamDTO dto = new TeamDTO();
		if (entity != null) {
			dto.setId(entity.getId());
			dto.setIdentifier(entity.getTeamIdentifier());
			dto.setLocation(entity.getLocation());
			dto.setName(entity.getTeamName());
			dto.setTeamSize(entity.getSize());
			dto.setCaptain(getPlayer(entity.getCaptain()));
			dto.setOwner(getUser(entity.getOwner()));
			dto.setPlayers(getPlayersFromTeamMembers(entity.getTeamMembers()));
//			dto.setPlayers(getPlayers(entity.getPlayers()));
		}
		return dto;
	}

	private static List<PlayerDTO> getPlayersFromTeamMembers(List<TeamMembers> teamMembers) {
		List<PlayerDTO> playerDTOList = null;
		if (teamMembers != null && teamMembers.size() > 0) {
			playerDTOList = teamMembers.stream().map(member -> {
				PlayerDTO dto = getPlayer(member.getPlayer());
				dto.setTeamMemberId(member.getId());
				dto.setPlayerStatus(member.getPlayerStatus());
				return dto;
			}).collect(Collectors.toList());
		}
		return playerDTOList;
	}

	public static List<PlayerDTO> getPlayers(List<User> players) {
		List<PlayerDTO> playerDTOList = null;
		if (players != null && players.size() > 0) {
			playerDTOList = players.stream().map(player -> {
				PlayerDTO dto = getPlayer(player);
				return dto;
			}).collect(Collectors.toList());
		}
		return playerDTOList;
	}

	public static PlayerDTO getPlayer(User entity) {
		PlayerDTO dto = new PlayerDTO();
		if (entity != null) {
			dto.setId(entity.getId());
			dto.setName(entity.getUserFName() + " " + entity.getUserLName());
			dto.setAge(Utility.getAge(entity.getDob()));
			dto.setBattingStyle(entity.getBattingStyle());
			dto.setBowlingStyle(entity.getBowlingStyle());
			dto.setRole(entity.getRole());
		}
		return dto;
	}

	public static UserDTO getUser(User entity) {
		UserDTO dto = new UserDTO();
		if (entity != null) {
			dto.setId(entity.getId());
			dto.setEmail(entity.getEmail());
			dto.setFname(entity.getUserFName());
			dto.setLname(entity.getUserLName());
		}
		return dto;
	}

	public static List<DashboardScoreCardDTO> getDashboardScoreCard(List<CricketMatch> matchList) {
		List<DashboardScoreCardDTO> DashboardScoreCardDTOs = null;

		if (matchList != null && matchList.size() > 0) {
			DashboardScoreCardDTOs = matchList.stream().map(match -> {
				DashboardScoreCardDTO dto = getDashboardScoreCard(match);
				return dto;
			}).collect(Collectors.toList());
		}
		return DashboardScoreCardDTOs;
	}

	private static DashboardScoreCardDTO getDashboardScoreCard(CricketMatch entity) {
		DashboardScoreCardDTO dto = new DashboardScoreCardDTO();

		dto.setId(entity.getId());
		dto.setTeam1(entity.getTeam1().getTeamName());
		dto.setOvers1(entity.getScoreCard().getInnings1().getOvers());
		dto.setScore1(entity.getScoreCard().getInnings1().getTotalScore());
		dto.setWickets1(entity.getScoreCard().getInnings1().getWickets());

		dto.setTeam2(entity.getTeam2().getTeamName());
		dto.setOvers2(entity.getScoreCard().getInnings2().getOvers());
		dto.setScore2(entity.getScoreCard().getInnings2().getTotalScore());
		dto.setWickets2(entity.getScoreCard().getInnings2().getWickets());

		dto.setSummary("GT won by 6 wickets");
		dto.setTournamentName(entity.getTournament().getName());
		return dto;
	}

	public static MatchScoreCardDTO getMatchScoreCard(CricketMatch match) {
		MatchScoreCardDTO dto = new MatchScoreCardDTO();

		dto.setId(match.getId());
		dto.setMatchResult("GT won by 6 wickets");
		dto.setInnings(getInningsList(match.getScoreCard()));

		return dto;
	}

	private static List<InningsDTO> getInningsList(ScoreCard scoreCard) {
		List<InningsDTO> inningsDTOList = new ArrayList<InningsDTO>();

		// Innings 1
		InningsDTO dto = new InningsDTO();
		dto.setBattingTeamName(scoreCard.getInnings1().getBattingTeam().getTeamName());
		dto.setOvers(scoreCard.getInnings1().getOvers());
		dto.setWickets(scoreCard.getInnings1().getWickets());
		dto.setTotalScore(scoreCard.getInnings1().getTotalScore());
		dto.setBattingScores(getBattingScores(scoreCard.getInnings1().getBattingScore()));
		dto.setBowlingTeamName(scoreCard.getInnings1().getBowlingTeam().getTeamName());
		dto.setBowlingScores(getBowlingScores(scoreCard.getInnings1().getBowlingScore()));
		inningsDTOList.add(dto);

		// Innings 2
		dto = new InningsDTO();
		dto.setOvers(scoreCard.getInnings2().getOvers());
		dto.setWickets(scoreCard.getInnings2().getWickets());
		dto.setTotalScore(scoreCard.getInnings2().getTotalScore());
		dto.setBattingTeamName(scoreCard.getInnings2().getBattingTeam().getTeamName());
		dto.setBattingScores(getBattingScores(scoreCard.getInnings2().getBattingScore()));
		dto.setBowlingTeamName(scoreCard.getInnings2().getBowlingTeam().getTeamName());
		dto.setBowlingScores(getBowlingScores(scoreCard.getInnings2().getBowlingScore()));
		inningsDTOList.add(dto);

		return inningsDTOList;
	}

	private static List<BowlingScoreDTO> getBowlingScores(List<BowlingScore> list) {
		List<BowlingScoreDTO> dtolist = null;
		if (list != null && list.size() > 0) {
			dtolist = list.stream().map(score -> {
				BowlingScoreDTO dto = new BowlingScoreDTO();
				dto.setBowlerName(score.getPlayer().getUserFName() + " " + score.getPlayer().getUserLName());
				dto.setMaidens(score.getMaidens());
				dto.setOvers(score.getOvers());
				dto.setRunsGiven(score.getRunsGiven());
				dto.setWickets(score.getWickets());
				return dto;
			}).collect(Collectors.toList());
		}

		return dtolist;
	}

	private static List<BattingScoreDTO> getBattingScores(List<BattingScore> battingScore) {
		List<BattingScoreDTO> battingScores = null;
		if (battingScore != null && battingScore.size() > 0) {
			battingScores = battingScore.stream().map(score -> {
				BattingScoreDTO dto = new BattingScoreDTO();
				dto.setBatsmanName(score.getPlayer().getUserFName() + " " + score.getPlayer().getUserLName());
				dto.setRuns(score.getRuns());
				dto.setBalls(score.getBalls());
				dto.setBowledBy(score.getDismissal() == null ? ""
						: score.getDismissal().getBowler().getUserLName());
				dto.setCaughtBy(score.getDismissal() == null ? ""
						: score.getDismissal().getFielder() == null ? "" : score.getDismissal().getFielder().getUserLName());
				dto.setFours(score.getBalls());
				dto.setSixers(score.getSixers());

				return dto;
			}).collect(Collectors.toList());
		}

		return battingScores;

	}
}
