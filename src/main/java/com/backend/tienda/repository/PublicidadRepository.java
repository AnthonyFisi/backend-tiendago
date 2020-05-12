package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Publicidad;


@Repository
public interface PublicidadRepository extends JpaRepository<Publicidad,Integer>{

}
