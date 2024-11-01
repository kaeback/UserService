package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.user.model.User;
import com.example.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		
		return "index";
	}
	
	@PostMapping("users")
	public String saveUser(@ModelAttribute User user) {
		
		log.info("사용자 등록: {}", user);
		
		userService.saveUser(user);
		
		return "redirect:/";
	}
	
	@PostMapping("users/{id}")
	public String deleteUser(@PathVariable(name = "id") Long id) {
		
		log.info("사용자 삭제: id={}", id);
		
		userService.deleteUser(id);
		
		return "redirect:/";
	}

}
