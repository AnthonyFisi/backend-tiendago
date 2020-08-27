package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	

}
