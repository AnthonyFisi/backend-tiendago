package com.backend.tienda.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Restaurante_Pedido;

@Repository
public interface Restaurante_PedidoRepository  extends JpaRepository<Restaurante_Pedido,Integer>{
	
	
	@Query(value="SELECT    	" + 
			"					idpedido,idempresa," + 
			"					idventa,idubicacion,venta_fecha,venta_fechaentrega,venta_costodelivery,venta_costototal,comentario_global," + 
			"					idestado_pago,nombre_estado," + 
			"					producto_nombre,producto_precio,producto_uriimagen,comentario_pedido," + 
			"					idusuario,usuario_nombre,usuario_celular," + 
			"					orden_disponible,idrepartidor," + 
			"					idtipopago,tipopago_nombre," + 
			"					idestado_venta,tipo_estado," + 
			"					idtipo_envio," + 
			"					nombre_tipo_envio"+
			"                 FROM restaurante_pedido"+
			"                 WHERE   idestado_venta <> 4  AND orden_disponible=true" + 
			"					AND idempresa= ?1  AND venta_fechaentrega >= ?2 ",nativeQuery=true)
	List<Restaurante_Pedido> listfindByIdEmpresaAndIdVenta_fechaEntrega(int idEmpresa,Timestamp fecha_entrega);

}
