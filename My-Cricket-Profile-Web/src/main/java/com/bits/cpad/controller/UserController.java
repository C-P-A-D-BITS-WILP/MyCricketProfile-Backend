package com.bits.cpad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.entity.Team;
import com.bits.cpad.entity.User;
import com.bits.cpad.repository.TeamRepository;
import com.bits.cpad.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TeamRepository teamRepository;

	@GetMapping(path = "/addUser")
	public String addNewUser() {
		System.out.println("Adding Dummy User");
		User n = populateUser();
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/addTeam")
	public String createTeam() {
		System.out.println("Adding Dummy User");
		
		Team team = getTeam();
		teamRepository.save(team);
		return "Team Created";
	}

	@GetMapping(path = "/addTeamMembers")
	public String addTeamMembers() {
		Team team = teamRepository.findById(4).get();

		List<User> players = team.getPlayers();

		players.add(userRepository.findById(1003).get());
		players.add(userRepository.findById(1004).get());
		players.add(userRepository.findById(1005).get());

		team.setPlayers(players);
		
		teamRepository.save(team);
		return "Success";
	}

	private Team getTeam() {
		User u = populateUser();
		Team team = new Team();
		team.setCaptain(u);
		team.setOwner(u);
		team.setLocation("Bengaluru");
		team.setSize(16);
		team.setTeamName("Bengaluru Bulls");
		team.setTeamIdentifier("#ad21f");
		return team;
	}

	private User populateUser() {
		User n = new User();
		n.setUserFName("FirstName");
		n.setUserLName("LastName");
		n.setEmail("TestEmail@abc.com");
		return n;
	}

}
