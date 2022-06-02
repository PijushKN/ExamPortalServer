package com.exam.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	// Creating User
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User receivedUser = userRepository.findByUsername(user.getUsername());
		if (receivedUser != null) {
			System.out.println("User Already Exists");
			throw new Exception("User Already Exists");
		} else {
			for (UserRole userRole : userRoles) {
				roleRepository.save(userRole.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			receivedUser = userRepository.save(user);
		}
		return receivedUser;
	}
}
