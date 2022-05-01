package com.bits.cpad.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bits.cpad.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>, UserRepositoryCustom {

}