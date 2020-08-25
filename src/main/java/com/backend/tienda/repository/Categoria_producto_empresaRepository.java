package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.Categoria_producto_empresa;

public interface Categoria_producto_empresaRepository extends JpaRepository<Categoria_producto_empresa,Integer>{
	
	
	List<Categoria_producto_empresa> findByIdempresa(int idempresa);

}
