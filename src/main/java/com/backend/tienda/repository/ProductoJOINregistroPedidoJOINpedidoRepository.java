package com.backend.tienda.repository;


import java.util.List;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;

@Repository
public interface ProductoJOINregistroPedidoJOINpedidoRepository extends JpaRepository<ProductoJOINregistroPedidoJOINpedido,Integer>{
	
	@Query(value=
	 		"SELECT  idempresa," + 
	 		"	idproducto," + 
	 		"	producto_nombre," + 
	 		"	producto_precio," + 
	 		"	producto_uriimagen," + 
	 		"	producto_calificacion," + 
	 		"	producto_descuento," + 
	 		"	producto_precio_descuento," + 
	 		"	registropedido_cantidadtotal," + 
	 		"   registropedido_preciototal," + 
	 		"	idpedido," + 
	 		"	idusuario," + 
	 		"	pedido_estado," + 
	 		"	pedido_montototal," + 
	 		"	pedido_cantidadtotal," + 
	 		"	nombre_empresa," + 
	 		"	costo_delivery," + 
	 		"	urlfoto_empresa," + 
	 		"	icono_empresa , comentario" + 
	 		"   FROM  carrito WHERE idpedido = ?1  AND pedido_estado = false ",nativeQuery=true)
	 List<ProductoJOINregistroPedidoJOINpedido> GfindByidpedido(int idpedido);
	 
	
	@Query(value=
	 		"SELECT idempresa," + 
	 		"	idproducto," + 
	 		"	producto_nombre," + 
	 		"	producto_precio," + 
	 		"	producto_uriimagen," + 
	 		"	producto_calificacion," + 
	 		"	producto_descuento," + 
	 		"	producto_precio_descuento," + 
	 		"	registropedido_cantidadtotal," + 
	 		"   registropedido_preciototal," + 
	 		"	idpedido," + 
	 		"	idusuario," + 
	 		"	pedido_estado," + 
	 		"	pedido_montototal," + 
	 		"	pedido_cantidadtotal," + 
	 		"	nombre_empresa," + 
	 		"	costo_delivery," + 
	 		"	urlfoto_empresa," + 
	 		"	icono_empresa ,comentario" + 
	 		"   FROM  carrito WHERE idusuario = ?1  AND pedido_estado = false ",nativeQuery=true)
	 List<ProductoJOINregistroPedidoJOINpedido> GfindByidusuario(int idusuario);

	 
	 @Query(value=
	 		"SELECT DISTINCT ON (idempresa) idempresa," + 
	 		"	idproducto," + 
	 		"	producto_nombre," + 
	 		"	producto_precio," + 
	 		"	producto_uriimagen," + 
	 		"	producto_calificacion," + 
	 		"	producto_descuento," + 
	 		"	producto_precio_descuento," + 
	 		"	registropedido_cantidadtotal," + 
	 		"   registropedido_preciototal," + 
	 		"	idpedido," + 
	 		"	idusuario," + 
	 		"	pedido_estado," + 
	 		"	pedido_montototal," + 
	 		"	pedido_cantidadtotal," + 
	 		"	nombre_empresa," + 
	 		"	costo_delivery," + 
	 		"	urlfoto_empresa," + 
	 		"	icono_empresa  ,comentario" +  
	 		"   FROM  carrito WHERE idusuario = ?1    AND pedido_estado = false  ",nativeQuery=true)
	 List<ProductoJOINregistroPedidoJOINpedido> listaCarritos(int idusuario);

	 
	 @Query(value=
		 		"SELECT  idempresa," + 
		 		"	idproducto," + 
		 		"	producto_nombre," + 
		 		"	producto_precio," + 
		 		"	producto_uriimagen," + 
		 		"	producto_calificacion," + 
		 		"	producto_descuento," + 
		 		"	producto_precio_descuento," + 
		 		"	registropedido_cantidadtotal," + 
		 		"   registropedido_preciototal," + 
		 		"	idpedido," + 
		 		"	idusuario," + 
		 		"	pedido_estado," + 
		 		"	pedido_montototal," + 
		 		"	pedido_cantidadtotal," + 
		 		"	nombre_empresa," + 
		 		"	costo_delivery," + 
		 		"	urlfoto_empresa," + 
		 		"	icono_empresa ,comentario" +  
		 		"   FROM  carrito WHERE idpedido = ?1   ",nativeQuery=true)
		 List<ProductoJOINregistroPedidoJOINpedido> ventaFindByidPedido(int idpedido);
	 
	 
	 

	 

}
