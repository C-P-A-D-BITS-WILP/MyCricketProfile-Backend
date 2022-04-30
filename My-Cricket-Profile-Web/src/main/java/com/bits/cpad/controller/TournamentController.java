package com.bits.cpad.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.dto.TournamentDTO;
import com.bits.cpad.entity.Team;
import com.bits.cpad.entity.Tournament;
import com.bits.cpad.repository.TeamRepository;
import com.bits.cpad.repository.TournamentRepository;
import com.bits.cpad.repository.UserRepository;
import com.bits.cpad.utils.EntityToDTOMapper;

@RestController
public class TournamentController {

	@Autowired
	private TournamentRepository tournamentRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/addTournamentTest")
	public String addTournamentTest() {

		Tournament t = new Tournament();
		t.setName("IPL");
		t.setFee(100);
		t.setStartDate(new Date(2022, 4, 1));
		t.setEndDate(new Date(2022, 5, 1));
		t.setOrganizer(userRepository.findById(5).get());

		List<Team> teams = t.getTeams();

		if (teams == null) {
			teams = new ArrayList<>();
		}

		teams.add(teamRepository.findById(4).get());
		t.setTeams(teams);

		tournamentRepository.save(t);

		return "success";
	}

	@GetMapping("/getTournamentDetails")
	public List<TournamentDTO> getTournamentDetails() {
		Iterable<Tournament> t = tournamentRepository.findAll();
		List<TournamentDTO> tournamentDTOList = EntityToDTOMapper
				.tournament(StreamSupport.stream(t.spliterator(), false).collect(Collectors.toList()));
		return tournamentDTOList;
	}

}
