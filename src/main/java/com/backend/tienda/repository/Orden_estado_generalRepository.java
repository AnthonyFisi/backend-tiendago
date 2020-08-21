package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Orden_estado_general;

public interface Orden_estado_generalRepository extends JpaRepository<Orden_estado_general,Integer> {
	
	List<Orden_estado_general> findByIdventa(int idventa);

}
