package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.TipoCuenta;


@Repository
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta,Integer>{

}
