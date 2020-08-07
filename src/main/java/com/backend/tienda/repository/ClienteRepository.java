package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	

}
