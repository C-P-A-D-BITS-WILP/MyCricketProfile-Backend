package com.bits.cpad.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cpad.dto.PlayerDTO;
import com.bits.cpad.testds.PlayerDS;

@RestController
public class PlayerController {

	@GetMapping(path = "/players")
	public List<PlayerDTO> getPlayers() {
		List<PlayerDTO> list = PlayerDS.getPlayerList(0, 10);
		return list;
	}

	@GetMapping(path = "/player/{playerId}")
	public PlayerDTO getPlayerDetails(@PathVariable int playerId) {
		PlayerDTO player = PlayerDS.getPlayer(playerId);
		return player;
	}
}
