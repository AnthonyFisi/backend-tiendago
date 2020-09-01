package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.tienda.entity.Envio_empresa;

public interface Envio_empresaRepository extends JpaRepository<Envio_empresa,Integer> {
	

	List<Envio_empresa> findByIdempresa(int idempresa);
	

}
