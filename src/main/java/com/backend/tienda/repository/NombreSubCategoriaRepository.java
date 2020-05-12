package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.NombreSubcategoria;


@Repository
public interface NombreSubCategoriaRepository extends JpaRepository<NombreSubcategoria,Integer> {

}
