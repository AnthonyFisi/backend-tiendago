package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Repartidor_historial;

public interface Repartidor_historialRepository extends JpaRepository<Repartidor_historial,Integer>{
	
	List<Repartidor_historial> findByIdrepartidorAndIdestadodeliveryOrderByFechahistorialDesc(int idrepartidor,int idestadodelivery);
}
