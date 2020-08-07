package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Ubicacion;

public interface UbicacionRepository extends JpaRepository<Ubicacion,Integer>{
	
	List<Ubicacion> findByIdusuarioAndEliminado(int idusuario,boolean eliminado);
	
	List<Ubicacion> findByIdusuario(int idusuario);
	
	Ubicacion findByidubicacion(int idubicacion);
	
}
