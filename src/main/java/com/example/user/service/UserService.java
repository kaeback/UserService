package com.example.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	@Transactional
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
