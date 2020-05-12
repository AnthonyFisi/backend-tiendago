package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.tienda.entity.SubCategoriaEmpresa;

public interface SubCategoriaEmpresaRepository extends JpaRepository<SubCategoriaEmpresa,Integer>{
	
	List<SubCategoriaEmpresa> findByidcategoriaempresa(int idcategoriaempresa);

}
