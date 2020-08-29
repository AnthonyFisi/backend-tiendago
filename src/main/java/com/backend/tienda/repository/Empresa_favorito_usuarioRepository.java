package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Empresa_favorito_usuario;

public interface Empresa_favorito_usuarioRepository extends JpaRepository<Empresa_favorito_usuario,Integer> {
	
	
	Empresa_favorito_usuario findByIdempresaAndIdusuario(int idempresa,int idusuario);
	
	List<Empresa_favorito_usuario>  findByIdusuario(int idusuario);
}
