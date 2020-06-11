package com.backend.tienda.repository;


import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.entity.RegistroPedidoPK;

@Repository
public interface RegistroPedidoRepository extends JpaRepository<RegistroPedido,RegistroPedidoPK> {
	
	
	@Query(value="SELECT idpedido,idproducto,registropedido_cantidadtotal,registropedido_preciototal,registro_fecha,idempresa WHERE "
			+ " idpedido= ?1 AND idpedido = ?2 ",nativeQuery=true)
	RegistroPedido findByid_pedidoAndid_producto(int idpedido,int idproducto);
	
	
	RegistroPedido findByid(RegistroPedidoPK pk);
	
	@Query(value="UPDATE registropedido SET  registropedido_cantidadtotal = ?1 , registropedido_preciototal = ?2 WHERE idpedido = ?3  AND idproducto = ?4" ,nativeQuery=true)
	void updateRegistroPedidoCantidadAndPrecio(int registro_cantidad,float registro_costo,int idpedido,int idproducto);
	
	@Query(value="DELETE FROM registropedido WHERE idpedido = ?1 ",nativeQuery=true)
	void eliminarCarrito(int idpedido);
	
	
}
