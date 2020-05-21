package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.NombreSubcategoria;


@Repository
public interface NombreSubCategoriaRepository extends JpaRepository<NombreSubcategoria,Integer> {
	
	@Query(value="UPDATE nombresubcategoria SET productospopulares = ?1  WHERE idempresa = ?2  ",nativeQuery=true)
	NombreSubcategoria actualizarProductosPopulares(String productospopulares,int idEmpresa);
	
	
	@Query(value="UPDATE nombresubcategoria SET ofertas = ?1  WHERE idempresa = ?2  ",nativeQuery=true)
	NombreSubcategoria actualizarOfertas(String ofertas,int idEmpresa);
	
	@Query(value="UPDATE nombresubcategoria SET  = ?1  WHERE idempresa = ?2  ",nativeQuery=true)
	NombreSubcategoria actualizarCategoria1(String ofertas,int idEmpresa);

}
