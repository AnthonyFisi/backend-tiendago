package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Empresa_favorita;

public interface Empresa_favoritaRepository  extends JpaRepository<Empresa_favorita,Integer>{
	
	List<Empresa_favorita> findByIdusuario(int idusuario);


}
