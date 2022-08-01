package com.exam.examserver.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.model.User;
import com.exam.examserver.model.UserRole;
import com.exam.examserver.repository.RoleRepository;
import com.exam.examserver.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User u=this.userRepository.findByUsername(user.getUsername());
		
		if(u!=null) {
			System.out.println("User is already present!");
			throw new Exception("USer already present!");
		} else {
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			u=this.userRepository.save(user);
		}
		return u;
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}
}
