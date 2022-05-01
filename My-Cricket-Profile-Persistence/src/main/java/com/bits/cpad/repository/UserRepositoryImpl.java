package com.bits.cpad.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.bits.cpad.entity.User;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User findByEmailId(String emailId) {
		User user;
		try {
			Query query = entityManager.createNativeQuery("SELECT u.* FROM user u " + "WHERE u.email_id = ?",
					User.class);
			query.setParameter(1, emailId);

			user = (User) query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}

}
