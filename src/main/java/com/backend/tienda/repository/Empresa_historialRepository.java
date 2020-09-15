package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Empresa_historial;

public interface Empresa_historialRepository extends JpaRepository<Empresa_historial,Integer> {
	
	
	List<Empresa_historial> findByIdestadoempresaofiAndIdempresaOrderByFechahistorialDesc(int idestadoempresaofi,int idempresa);


}
