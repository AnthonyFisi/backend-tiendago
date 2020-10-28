package com.backend.tienda.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden,Integer>{
	

	List<Orden> findByIdusuarioAndVentafechaGreaterThanEqual(int idusuario,Timestamp fecha);
	
	//List<Orden> findByIdusuarioAndOrdendisponibleAndVentafechaGreaterThanEqual(int idusuario,boolean disponible,Timestamp fecha);

	


}
