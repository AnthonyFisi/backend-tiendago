package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.CuentaEmpresa;

@Repository
public interface CuentaEmpresaRepository extends JpaRepository<CuentaEmpresa,Integer>{

}
