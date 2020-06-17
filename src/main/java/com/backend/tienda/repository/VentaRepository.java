package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta,Integer> {

}
