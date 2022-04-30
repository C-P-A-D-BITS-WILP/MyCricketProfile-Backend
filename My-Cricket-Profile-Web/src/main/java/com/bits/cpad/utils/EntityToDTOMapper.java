package com.bits.cpad.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.bits.cpad.dto.PlayerDTO;
import com.bits.cpad.dto.TeamDTO;
import com.bits.cpad.dto.TournamentDTO;
import com.bits.cpad.dto.UserDTO;
import com.bits.cpad.entity.Team;
import com.bits.cpad.entity.Tournament;
import com.bits.cpad.entity.User;

public class EntityToDTOMapper {
	public static List<TournamentDTO> tournament(List<Tournament> tournamentList) {

		List<TournamentDTO> tournamentDTOList = tournamentList.stream().map(tournament -> {
			TournamentDTO dto = tournament(tournament);
			return dto;
		}).collect(Collectors.toList());

		return tournamentDTOList;
	}

	public static TournamentDTO tournament(Tournament entity) {
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

	private static TeamDTO getTeam(Team entity) {
		TeamDTO dto = new TeamDTO();
		if (entity != null) {
			dto.setId(entity.getId());
			dto.setIdentifier(entity.getTeamIdentifier());
			dto.setLocation(entity.getLocation());
			dto.setName(entity.getTeamName());
			dto.setTeamSize(entity.getSize());
			dto.setCaptain(getPlayer(entity.getCaptain()));
			dto.setOwner(getUser(entity.getOwner()));
			dto.setPlayers(getPlayers(entity.getPlayers()));
		}
		return dto;
	}

	private static List<PlayerDTO> getPlayers(List<User> players) {
		List<PlayerDTO> playerDTOList = players.stream().map(player -> {
			PlayerDTO dto = getPlayer(player);
			return dto;
		}).collect(Collectors.toList());

		return playerDTOList;
	}

	private static PlayerDTO getPlayer(User entity) {
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

	private static UserDTO getUser(User entity) {
		UserDTO dto = new UserDTO();
		if (entity != null) {
			dto.setId(entity.getId());
			dto.setEmail(entity.getEmail());
			dto.setFname(entity.getUserFName());
			dto.setLname(entity.getUserLName());
		}
		return dto;
	}
}
