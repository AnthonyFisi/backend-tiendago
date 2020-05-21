package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Distrito;


public interface DistritoRepository extends JpaRepository<Distrito,Integer> {
	
	List<Distrito> findByidprovincia(int idprovincia);

}
