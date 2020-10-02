 package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
	

	List<Empresa> findByIdcategoriaempresa(int idCategoria);
	
	List<Empresa> findByIdsubcategoriaempresa(int idSubCategoria);
	
    List<Empresa> findByIdcategoriaempresaOrderByPopularidadAsc(int idCategoria);



}
