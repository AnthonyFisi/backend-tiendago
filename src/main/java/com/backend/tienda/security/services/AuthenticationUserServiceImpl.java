package com.backend.tienda.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Ubicacion;
import com.backend.tienda.payload.response.JwtResponse;
import com.backend.tienda.repository.UbicacionRepository;
import com.backend.tienda.security.jwt.JwtUtils;
@Service
public class AuthenticationUserServiceImpl implements AuthenticationUserService {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UbicacionRepository ubicacionRepository;
	
	@Override
	public JwtResponse jwtToken(String username,String password) {
		
		List<Ubicacion> lista=null;
		int idubicacion=0;
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username,password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		try {
			
			lista=ubicacionRepository.findByIdusuario(userDetails.getId().intValue());

		}catch(Exception e) {
			
			lista=new ArrayList<>();
		}
		
		if(!lista.isEmpty()) {
			idubicacion=lista.size();
		}
		
		return new JwtResponse(jwt, 
				 userDetails.getId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 roles,
				 idubicacion
				);
		
		

		
	}
	

}
