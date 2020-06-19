package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.TipoPago;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago,Integer>{

}
