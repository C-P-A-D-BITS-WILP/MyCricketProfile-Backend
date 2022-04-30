package com.bits.cpad.repository;

import org.springframework.data.repository.CrudRepository;

import com.bits.cpad.entity.Tournament;

public interface TournamentRepository extends CrudRepository<Tournament, Integer>  {

}
