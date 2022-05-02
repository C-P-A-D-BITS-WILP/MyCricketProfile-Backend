package com.bits.cpad.service;

import java.util.List;

import com.bits.cpad.dto.PlayerDTO;

public interface PlayerService {

	List<PlayerDTO> getPlayerList(int startIndx, int emdIndx);

	PlayerDTO getPlayer(int playerId);

}
