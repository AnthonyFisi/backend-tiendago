package com.backend.tienda.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer>{
	
	@Query(value="SELECT idpedido ,pedido_montototal,pedido_cantidadtotal,pedido_fecha_registro,pedido_estado,idusuario FROM pedido WHERE"
			+ " idusuario = ?1 AND  pedido_estado = false ",nativeQuery=true)
	Pedido  findByIdUsuario(int idUsuario);
	
	@Modifying
	@Query(value="UPDATE pedido SET pedido_cantidadtotal = ?1 , pedido_montototal = ?2 WHERE idpedido = ?3 ",nativeQuery=true)
	void  updatePedido(int cantidad_total,float precio_total,int idpedido);

}
