package com.bits.cpad.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.cpad.dto.UserDTO;
import com.bits.cpad.entity.User;
import com.bits.cpad.repository.UserRepository;
import com.bits.cpad.service.UserService;
import com.bits.cpad.utils.DTOToEntityMapper;
import com.bits.cpad.utils.EntityToDTOMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDTO registerUser(Map<?, ?> newUser) {

		String emailId = newUser.get("email").toString();

		User user = userRepo.findByEmailId(emailId);

		if (user == null) {
			user = DTOToEntityMapper.getUser(newUser);
			userRepo.save(user);
		}
		UserDTO dto = EntityToDTOMapper.getUser(user);
		return dto;
	}

}
