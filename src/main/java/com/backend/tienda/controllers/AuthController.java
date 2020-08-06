package com.backend.tienda.controllers;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Roles;
import com.backend.tienda.entity.Usuario;
import com.backend.tienda.entity.UsuarioInfo;
import com.backend.tienda.models.ERole;
import com.backend.tienda.models.Role;
import com.backend.tienda.models.User;
import com.backend.tienda.payload.request.LoginRequest;
import com.backend.tienda.payload.request.SignupRequest;
import com.backend.tienda.payload.response.JwtResponse;
import com.backend.tienda.payload.response.MessageResponse;
import com.backend.tienda.repositorys.RoleRepository;
import com.backend.tienda.repositorys.UserRepository;
import com.backend.tienda.security.jwt.JwtUtils;
import com.backend.tienda.security.services.AuthenticationUserService;
import com.backend.tienda.security.services.UserDetailsImpl;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationUserService authenticationUserService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		
		JwtResponse jwt=authenticationUserService.jwtToken(loginRequest.getUsername(),loginRequest.getPassword());
		
		return ResponseEntity.ok(jwt);
	}
	
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		

		
		if (userRepository.existsByNombre(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByCorreo(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Usuario user = new Usuario(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 "nada",
							 "nada",
							 "nada",
							 1);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Roles> roles = new HashSet<>();

		if (strRoles == null) {
			Roles userRole = roleRepository.findByNombre(ERole.ROLE_CLIENTE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "cliente":
					Roles cliRole = roleRepository.findByNombre(ERole.ROLE_CLIENTE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(cliRole);

					break;
				case "empresa":
					Roles empRole = roleRepository.findByNombre(ERole.ROLE_EMPRESA_ASOCIADA)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(empRole);

					break;
				case "motorizado":
					Roles motoRole = roleRepository.findByNombre(ERole.ROLE_MOTORIZADO)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(motoRole);
					break;
						
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	
	@PostMapping("/signupProvider")
	public ResponseEntity<?> registerUserProvider(@Valid @RequestBody UsuarioInfo usuarioInfo) {
				
		
		String default_password="provedor";
		

		if (userRepository.existsByCorreo(usuarioInfo.getCorreo().trim())) {
			
			JwtResponse jwt=authenticationUserService.jwtToken(usuarioInfo.getCorreo(),default_password);
			
			return ResponseEntity.ok(jwt);
		}

		// Create new user's account
		Usuario user = new Usuario(usuarioInfo.getNombre(), 
							usuarioInfo.getCorreo().trim(),
							 encoder.encode("provedor"),
							 "",
							 usuarioInfo.getCelular(),
							 usuarioInfo.getFoto(),
							 1);
		
		

		Set<String> strRoles =new HashSet<String>();
		strRoles.add("cliente");
		
		Set<Roles> roles = new HashSet<>();

		
		strRoles.forEach(role -> {
			switch (role) {
			case "cliente":
				Roles cliRole = roleRepository.findByNombre(ERole.ROLE_CLIENTE)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(cliRole);

				break;
			case "empresa":
				Roles empRole = roleRepository.findByNombre(ERole.ROLE_EMPRESA_ASOCIADA)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(empRole);

				break;
			case "motorizado":
				Roles motoRole = roleRepository.findByNombre(ERole.ROLE_MOTORIZADO)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(motoRole);
				break;
					
			}
		});

		user.setRoles(roles);
		userRepository.save(user);
		
		JwtResponse jwt=authenticationUserService.jwtToken(usuarioInfo.getCorreo(),default_password);
		
		return ResponseEntity.ok(jwt);

	}
	
	
}
