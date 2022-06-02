package com.exam.service;

import java.util.NoSuchElementException;
import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;

public interface UserService {
	public User createUser(User user, Set<UserRole> userRole) throws Exception;
	public User getUser(String username) throws Exception;
	public User deleteUser(Long id) throws NoSuchElementException;
}
