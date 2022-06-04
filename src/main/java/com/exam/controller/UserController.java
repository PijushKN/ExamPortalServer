package com.exam.controller;

import java.net.URI;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	@Autowired
	UserService userService;

	private static Logger logger = LogManager.getLogger(UserController.class);

	@PostMapping("/")
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		Set<UserRole> userRoles = new HashSet<>();
		Role role = new Role(45L, "NORMAL");
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);
		try {
			User createdUser = userService.createUser(user, userRoles);
			logger.info("User Created.");
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
					.toUri();
			return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			logger.error("User Already Exists.");
			return ResponseEntity.badRequest().build();
		}

	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		User createdUser = null;
		try {
			createdUser = userService.getUser(username);
			logger.info("User Fetched.");
			return createdUser;
		} catch (Exception e) {
			logger.error("No user found.");
			return createdUser;
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		try {
			userService.deleteUser(id);
			logger.info("User Deleted with id "+id);
			return ResponseEntity.noContent().build();
		} catch (NoSuchElementException e) {
			logger.error("No user with id "+id+" found");
			return ResponseEntity.notFound().build();
		}
	}

}
