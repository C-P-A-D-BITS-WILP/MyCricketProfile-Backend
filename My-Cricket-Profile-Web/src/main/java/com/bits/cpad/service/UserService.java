package com.bits.cpad.service;

import java.util.Map;

import com.bits.cpad.dto.UserDTO;

public interface UserService {

	public UserDTO registerUser(Map<?, ?> newUser);
}
