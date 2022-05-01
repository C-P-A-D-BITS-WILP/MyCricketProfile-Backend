package com.bits.cpad.repository;

import com.bits.cpad.entity.User;

public interface UserRepositoryCustom {
	
	public User findByEmailId(String emailid);
}
