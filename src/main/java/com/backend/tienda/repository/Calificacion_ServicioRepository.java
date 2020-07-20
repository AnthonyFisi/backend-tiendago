package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Calificacion_Servicio;

@Repository
public interface Calificacion_ServicioRepository  extends JpaRepository <Calificacion_Servicio,Integer>{

}
