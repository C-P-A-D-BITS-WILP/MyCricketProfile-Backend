package com.bits.cpad.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.cpad.dto.PlayerDTO;
import com.bits.cpad.dto.TeamDTO;
import com.bits.cpad.entity.Team;
import com.bits.cpad.entity.TeamMembers;
import com.bits.cpad.entity.User;
import com.bits.cpad.repository.TeamMemberRepository;
import com.bits.cpad.repository.TeamRepository;
import com.bits.cpad.repository.UserRepository;
import com.bits.cpad.service.TeamService;
import com.bits.cpad.utils.EntityToDTOMapper;
import com.bits.cpad.utils.Utility;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamRepository teamRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	TeamMemberRepository teamMemberRepo;

	@Override
	public List<TeamDTO> getTeamList(int startIndx, int endIdx) {
		Iterable<Team> teams = teamRepo.findAll();

		List<TeamDTO> teamDTOList = EntityToDTOMapper
				.getTeam(StreamSupport.stream(teams.spliterator(), false).collect(Collectors.toList()));
		return teamDTOList;
	}

	@Override
	public List<TeamDTO> getMyTeamList(int userId, int startIndx, int endIdx) {
		List<Team> teams = teamRepo.findMyTeams(userId);
		List<TeamDTO> teamDTOList = EntityToDTOMapper.getTeam(teams);
		return teamDTOList;
	}

	@Override
	public TeamDTO getTeam(int teamId) {
		Team team = teamRepo.findById(teamId).get();
		TeamDTO teamDTO = EntityToDTOMapper.getTeam(team);
		return teamDTO;
	}

	@Override
	public TeamDTO createTeam(Map<?, ?> newTeam) {
		Team team = new Team();

		team.setOwner(userRepo.findById(Integer.parseInt(newTeam.get("teamOwner").toString())).get());
		team.setLocation(newTeam.get("teamLocation").toString());
		team.setSize(Integer.parseInt(newTeam.get("teamSize").toString()));
		team.setTeamName(newTeam.get("teamName").toString());
		team.setTeamIdentifier(Utility.generateHashValue(5));
		teamRepo.save(team);
		TeamDTO dto = EntityToDTOMapper.getTeam(team);

		return dto;
	}

	@Override
	public TeamDTO updateTeam(TeamDTO teamDTO) {
		Team team = teamRepo.findById(teamDTO.getId()).get();
		User captain = userRepo.findById(teamDTO.getCaptain().getId()).get();
		team.setCaptain(captain);
		team.setLocation(teamDTO.getLocation());
		team.setSize(teamDTO.getTeamSize());
		team.setTeamName(teamDTO.getName());

//		updateTeamMembers(team, teamDTO);

		teamRepo.save(team);

		return teamDTO;
	}

	@Override
	public TeamDTO removePlayer(Map<?, ?> playerMap) {
		int teamId = Integer.parseInt(playerMap.get("teamId").toString());
		int memberId = Integer.parseInt(playerMap.get("teamMemberId").toString());

		Team team = teamRepo.findById(teamId).get();

		List<TeamMembers> teamMembers = team.getTeamMembers();
		int index = identifyChangedIndex(teamMembers, memberId);
		teamMembers.remove(index);
		team.setTeamMembers(teamMembers);

//		List<User> players = team.getPlayers();
//		List<User> updatedPlayers = removePlayers(players, member) 

		teamRepo.save(team);

		return EntityToDTOMapper.getTeam(team);
	}

	private int identifyChangedIndex(List<TeamMembers> teamMembers, int memberId) {
		int i = 0;
		for (i = 0; i < teamMembers.size(); i++) {
			if (teamMembers.get(i).getId() == memberId) {
				break;
			}
		}
//		teamMembers.remove(i);
		return i;
	}

	@Override
	public TeamDTO acceptPlayer(Map<?, ?> playerMap) {
		int teamId = Integer.parseInt(playerMap.get("teamId").toString());
		int memberId = Integer.parseInt(playerMap.get("teamMemberId").toString());

		Team team = teamRepo.findById(teamId).get();

		List<TeamMembers> teamMembers = team.getTeamMembers();
		int index = identifyChangedIndex(teamMembers, memberId);
		teamMembers.get(index).setPlayerStatus("CONFIRMED");
		team.setTeamMembers(teamMembers);

		teamRepo.save(team);
		return EntityToDTOMapper.getTeam(team);
	}

	private void updateTeamMembers(Team team, TeamDTO teamDTO) {
		List<TeamMembers> memberList = team.getTeamMembers();
		List<PlayerDTO> playerList = teamDTO.getPlayers();

		List<Integer> itemsToRemove = new ArrayList<>();
//		for(int i = 0; i < memberList.size(); i++) {
//			TeamMembers m = memberList.get(i);
//			boolean flagToRemove = true;
//			
//			playerList.stream().map(player -> {
//				
//			})
//		}

//		memberList.stream().filter(null)
	}

//	@Override
//	public TeamDTO updateTeam(TeamDTO teamDTO) {
//		Team team = new Team();
//		team = DTOToEntityMapper.getTeam(teamDTO);
//
//		team.setOwner(userRepo.findById(team.getOwner().getId()).get());
//		team.setCaptain(completePlayer(team.getCaptain()));
//		team.setTeamMembers(completeTeamMemberList(team.getTeamMembers()));
//		team.setPlayers(completeUserList(team.getTeamMembers()));
//
//		teamRepo.save(team);
//
//		return teamDTO;
//	}

	private List<User> completeUserList(List<TeamMembers> teamMembers) {
		List<User> playerList = null;

		if (teamMembers != null) {
			playerList = teamMembers.stream().map(members -> {
				User user = completeUser(members.getPlayer().getId());
				return user;
			}).collect(Collectors.toList());
		}

		return playerList;
	}

	private User completeUser(Integer id) {
		User player = userRepo.findById(id).get();
		return player;
	}

	private List<TeamMembers> completeTeamMemberList(List<TeamMembers> teamMembers) {
		List<TeamMembers> teamMemberList = null;
		if (teamMembers != null) {
			teamMemberList = teamMembers.stream().map(teamMember -> {
				TeamMembers fullTeamMember = completeTeamMember(teamMember);
				fullTeamMember.setPlayerStatus(teamMember.getPlayerStatus());
				return fullTeamMember;
			}).collect(Collectors.toList());
		}

		return teamMemberList;
	}

	private TeamMembers completeTeamMember(TeamMembers teamMember) {
		TeamMembers member = teamMemberRepo.findById(teamMember.getId()).get();
		return member;
	}

	private List<User> completePlayersList(List<User> players) {
		List<User> playerList = players.stream().map(player -> {
			return completePlayer(player);
		}).collect(Collectors.toList());

		return playerList;
	}

	private User completePlayer(User player) {
		return userRepo.findById(player.getId()).get();
	}

	@Override
	public void requestToJoin(Map<?, ?> map) {
		User user = userRepo.findById(Integer.parseInt(map.get("userId").toString())).get();
		Team team = teamRepo.findById(Integer.parseInt(map.get("teamId").toString())).get();

		TeamMembers member = new TeamMembers();
		member.setPlayer(user);
		member.setTeam(team);
		member.setPlayerStatus("PENDING");

		teamMemberRepo.save(member);

	}

}
