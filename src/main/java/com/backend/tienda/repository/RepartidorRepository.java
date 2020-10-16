package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Repartidor;

@Repository
public interface RepartidorRepository extends JpaRepository<Repartidor,Integer>{

	List<Repartidor> findByIdempresa(int idempresa);
}
