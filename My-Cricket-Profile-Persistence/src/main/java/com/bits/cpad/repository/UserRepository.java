package com.bits.cpad.repository;


import org.springframework.data.repository.CrudRepository;

import com.bits.cpad.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}