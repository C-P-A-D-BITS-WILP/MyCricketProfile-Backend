package com.bits.cpad.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bits.cpad.entity.Team;

@Repository
@Transactional
public class TeamRepositoryCustomImpl implements TeamRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Team> findMyTeams(int userId) {
		TypedQuery<Team> myTeamsQuery = entityManager.createNamedQuery("findByUserId", Team.class);
		myTeamsQuery.setParameter("userId", userId);
		
		List<Team> myTeamList = myTeamsQuery.getResultList();
		
		return myTeamList;
	}

}
