package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {

}
