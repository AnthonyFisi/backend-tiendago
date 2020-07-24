package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Repartidor_Bi;

@Repository
public interface Repartidor_BiRepository extends JpaRepository<Repartidor_Bi,Integer> {
	
	

}
