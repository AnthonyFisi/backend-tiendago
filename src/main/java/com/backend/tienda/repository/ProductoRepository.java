package com.backend.tienda.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{
	
	
	List<Producto>  findByIdcategoriaproductoAndIdempresa(int idcategoriaproducto,int idempresa);
	
	List<Producto>  findByidempresaOrderByIdcategoriaproductoAsc(int idempresa);
	
	List<Producto> findByIdempresaAndIdcategoriaproductoAndProductofechacreacionBefore(int idempresa,int idcategoriaproducto,Timestamp fechacreacion);
	
	Producto findByIdproductoAndIdempresa(int idproducto,int idempresa);
	
	@Query(value= "SELECT idproducto,idcategoriaproducto,idempresa,producto_nombre,producto_precio,\r\n" + 
			"			 producto_stock,productofechacreacion,producto_uriimagen,producto_calificacion,\r\n" + 
			"			 producto_detalle,producto_descuento,producto_precio_descuento,disponible,tipomenu FROM producto AS p	\r\n" + 
			"WHERE p.idempresa= ?1 AND plainto_tsquery( ?2 ) @@ to_tsvector(coalesce(p.producto_nombre,'')       \r\n" + 
			"										|| ' '  ||coalesce(p.producto_detalle,''))",nativeQuery=true)
	List<Producto>  listafindByPalabra(int idempresa,String palabra);
	

}
