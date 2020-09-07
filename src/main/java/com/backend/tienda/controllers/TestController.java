package com.backend.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Usuario_general;
import com.backend.tienda.repositorys.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	public String allAccess() {
		int id=9;
		Usuario_general general=userRepository.findById(id).get();
		System.out.println(general.getContrasena()+ "/ "+general.getCorreo() );
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_EMPRESA_ASOCIADA')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('ROLE_MOTORIZADO')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}