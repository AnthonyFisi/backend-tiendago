package com.backend.tienda.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Usuario;
import com.backend.tienda.models.User;


@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByNombre(String usuario_nombre);

	Optional<Usuario> findByCorreo(String correo);
		
	Boolean existsByNombre(String usuario_nombre);

	Boolean existsByCorreo(String usuario_correo);
}