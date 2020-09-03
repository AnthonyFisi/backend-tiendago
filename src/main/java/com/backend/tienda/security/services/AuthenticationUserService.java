package com.backend.tienda.security.services;

import com.backend.tienda.payload.response.JwtResponse;

public interface AuthenticationUserService {
	
	JwtResponse jwtToken(String username,String password);
	
}
