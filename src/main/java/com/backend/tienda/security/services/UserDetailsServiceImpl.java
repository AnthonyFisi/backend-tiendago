package com.backend.tienda.security.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.entity.Usuario;
import com.backend.tienda.models.User;
import com.backend.tienda.repositorys.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		
		System.out.println("ENTRAMIS CON EL CORREO "+ correo);
		
		//Usuario user = userRepository.findByNombre(username)
		Usuario user = userRepository.findByCorreo(correo)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + correo));

		return UserDetailsImpl.build(user);
	}

}
