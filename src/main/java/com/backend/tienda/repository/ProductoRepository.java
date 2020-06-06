package com.backend.tienda.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{
	
	
	@Query(value="SELECT idproducto,idcategoriaproducto,idempresa,producto_nombre,producto_precio,"
			+ "producto_stock,producto_fechacreacion,producto_uriimagen,producto_calificacion,"
			+ "producto_detalle,producto_descuento FROM producto WHERE idcategoriaproducto = ?1 AND idempresa = ?2",nativeQuery=true)
	List<Producto>  listafindByidcategoriaproductoAndidempresa(int idcategoriaproducto,int idempresa);
	
	
	List<Producto>  findByidempresa(int idempresa);

}
