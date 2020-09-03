package com.backend.tienda.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Usuario_general;
import com.backend.tienda.models.User;


@Repository
public interface UserRepository extends JpaRepository<Usuario_general, Long> {
	
	Optional<Usuario_general> findByNombre(String usuario_nombre);

	Optional<Usuario_general> findByCorreo(String correo);
		
	Boolean existsByNombre(String usuario_nombre);

	Boolean existsByCorreo(String usuario_correo);
}