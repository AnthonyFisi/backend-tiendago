package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Provincia;

public interface ProvinciaRepository  extends JpaRepository<Provincia,Integer>{
	
	List<Provincia> findByiddepartamento(int iddepartamento);

}
