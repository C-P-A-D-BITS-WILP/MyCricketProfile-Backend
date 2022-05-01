package com.bits.cpad.repository;

import java.util.List;

import com.bits.cpad.entity.Team;

public interface TeamRepositoryCustom {
	List<Team> findMyTeams(int userId);
}
