package com.backend.tienda.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Restaurante_Pedido;

@Repository
public interface Restaurante_PedidoRepository  extends JpaRepository<Restaurante_Pedido,Integer>{
			/*  					rep.nombre AS nombre_repartidor,rep.url_imagen AS imagen_repartidor,rep.codigo AS codigo_repartidor
*/
	
	@Query(value="SELECT    	" + 
			"					idpedido,idempresa," + 
			"					idventa,idubicacion,venta_fecha,venta_fechaentrega,venta_costodelivery,venta_costototal,comentario_global," + 
			"					idestado_pago,nombre_estado," + 
			"					comentario_pedido," + 
			"					idusuario,usuario_nombre,usuario_celular," + 
			"					orden_disponible,idrepartidor," + 
			"					idtipopago,tipopago_nombre," + 
			"					idestado_venta,tipo_estado," + 
			"					idtipo_envio," + 
			"					nombre_tipo_envio, tiempo_espera,pedido_cantidadtotal"+
			"					,nombre_repartidor,imagen_repartidor,codigo_repartidor"+
			"                 FROM restaurante_pedido"+
			"                 WHERE   idestado_venta <> 4  AND orden_disponible=true" + 
			"					AND idempresa= ?1 ",nativeQuery=true)
	List<Restaurante_Pedido> listfindByIdEmpresaAndIdVenta_fechaEntrega(int idEmpresa);
	

	@Query(value="SELECT    	 		idventa,\r\n" + 
			"					idtipopago,tipopago_nombre,\r\n" + 
			"					idhorario,horario_nombre,\r\n" + 
			"					idubicacion,\r\n" + 
			"					idpedido,idempresa,pedido_cantidadtotal,idusuario,idusuariogeneral,nombre,apellido,celular,\r\n" + 
			"					ventafecha,\r\n" + 
			"					ventafechaentrega,\r\n" + 
			"					venta_costodelivery ,\r\n" + 
			"					venta_costototal,\r\n" + 
			"					comentario,\r\n" + 
			"					idestadoempresa,\r\n" + 
			"					idestado_pago,nombre_estadopago,\r\n" + 
			"					idtipo_envio,nombre_tipo_envio,\r\n" + 
			"					ordendisponible,\r\n" + 
			"					tiempo_espera,\r\n" + 
			"					idrepartidor,\r\n" + 
			"					cancelar,\r\n" + 
			"					comentario_cancelar,\r\n" + 
			"					idestadodelivery,\r\n" + 
			"					idestadogeneral,\r\n" + 
			"					numeromesa ,descuento_mesa,mesa"+
			"                 FROM restaurante_pedido"+
			"                 WHERE   idestadoempresa = 1  AND ordendisponible=true" + 
			"					AND idempresa= ?1  AND  ventafechaentrega BETWEEN ?2 AND ?3  ",nativeQuery=true)
	List<Restaurante_Pedido> listfindByIdEmpresaAndIdVenta_fechaEntregaDistinct(int idEmpresa,Timestamp fecha1,Timestamp fecha2);
	
	@Query(value="SELECT    	 		idventa,\r\n" + 
			"					idtipopago,tipopago_nombre,\r\n" + 
			"					idhorario,horario_nombre,\r\n" + 
			"					idubicacion,\r\n" + 
			"					idpedido,idempresa,pedido_cantidadtotal,idusuario,idusuariogeneral,nombre,apellido,celular,\r\n" + 
			"					ventafecha,\r\n" + 
			"					ventafechaentrega,\r\n" + 
			"					venta_costodelivery ,\r\n" + 
			"					venta_costototal,\r\n" + 
			"					comentario,\r\n" + 
			"					idestadoempresa,\r\n" + 
			"					idestado_pago,nombre_estadopago,\r\n" + 
			"					idtipo_envio,nombre_tipo_envio,\r\n" + 
			"					ordendisponible,\r\n" + 
			"					tiempo_espera,\r\n" + 
			"					idrepartidor,\r\n" + 
			"					cancelar,\r\n" + 
			"					comentario_cancelar,\r\n" + 
			"					idestadodelivery,\r\n" + 
			"					idestadogeneral,\r\n" + 
			"					numeromesa ,descuento_mesa,mesa"+
			"                 FROM restaurante_pedido"+
			"                 WHERE   idestadoempresa = 1  AND ordendisponible=true" + 
			"					AND idempresa= ?1 AND idpedido = ?2 AND idventa = ?3  ",nativeQuery=true)
	Restaurante_Pedido findRecentOrden(int idEmpresa,int idPedido,int idVenta);
	
	Restaurante_Pedido findByIdestadoempresaAndOrdendisponibleAndIdempresaAndIdpedidoAndIdventa(int idestadoempresa,boolean disponbile,int idempresa,int idpedido,int idventa);

	//Restaurante_Pedido findByIdestadoempresaAndOrdendisponible(int iempresa,boolean m);
	
	/* PROCES ORDEN */
	
	
	@Query(value="SELECT    	 		idventa,\r\n" + 
			"					idtipopago,tipopago_nombre,\r\n" + 
			"					idhorario,horario_nombre,\r\n" + 
			"					idubicacion,\r\n" + 
			"					idpedido,idempresa,pedido_cantidadtotal,idusuario,idusuariogeneral,nombre,apellido,celular,\r\n" + 
			"					ventafecha,\r\n" + 
			"					ventafechaentrega,\r\n" + 
			"					venta_costodelivery ,\r\n" + 
			"					venta_costototal,\r\n" + 
			"					comentario,\r\n" + 
			"					idestadoempresa,\r\n" + 
			"					idestado_pago,nombre_estadopago,\r\n" + 
			"					idtipo_envio,nombre_tipo_envio,\r\n" + 
			"					ordendisponible,\r\n" + 
			"					tiempo_espera,\r\n" + 
			"					idrepartidor,\r\n" + 
			"					cancelar,\r\n" + 
			"					comentario_cancelar,\r\n" + 
			"					idestadodelivery,\r\n" + 
			"					idestadogeneral,\r\n" + 
			"					numeromesa ,descuento_mesa,mesa"+
			"                 FROM restaurante_pedido"+
			"                 WHERE   idestadoempresa = 2  AND ordendisponible=true" + 
			"					AND idempresa= ?1 AND cancelar=false ",nativeQuery=true)
	List<Restaurante_Pedido> findProcesOrden(int idEmpresa);
	
	
	
	@Query(value="SELECT    	 		idventa,\r\n" + 
			"					idtipopago,tipopago_nombre,\r\n" + 
			"					idhorario,horario_nombre,\r\n" + 
			"					idubicacion,\r\n" + 
			"					idpedido,idempresa,pedido_cantidadtotal,idusuario,idusuariogeneral,nombre,apellido,celular,\r\n" + 
			"					ventafecha,\r\n" + 
			"					ventafechaentrega,\r\n" + 
			"					venta_costodelivery ,\r\n" + 
			"					venta_costototal,\r\n" + 
			"					comentario,\r\n" + 
			"					idestadoempresa,\r\n" + 
			"					idestado_pago,nombre_estadopago,\r\n" + 
			"					idtipo_envio,nombre_tipo_envio,\r\n" + 
			"					ordendisponible,\r\n" + 
			"					tiempo_espera,\r\n" + 
			"					idrepartidor,\r\n" + 
			"					cancelar,\r\n" + 
			"					comentario_cancelar,\r\n" + 
			"					idestadodelivery,\r\n" + 
			"					idestadogeneral,\r\n" + 
			"					numeromesa ,descuento_mesa,mesa"+
			"                 FROM restaurante_pedido"+
			"                 WHERE   idestadoempresa = 3  AND ordendisponible=true" + 
			"					AND idempresa= ?1 AND cancelar=false ",nativeQuery=true)
	List<Restaurante_Pedido> findReadyOrden(int idEmpresa);
	
	
	
	@Query(value="SELECT    	 		idventa,\r\n" + 
			"					idtipopago,tipopago_nombre,\r\n" + 
			"					idhorario,horario_nombre,\r\n" + 
			"					idubicacion,\r\n" + 
			"					idpedido,idempresa,pedido_cantidadtotal,idusuario,idusuariogeneral,nombre,apellido,celular,\r\n" + 
			"					ventafecha,\r\n" + 
			"					ventafechaentrega,\r\n" + 
			"					venta_costodelivery ,\r\n" + 
			"					venta_costototal,\r\n" + 
			"					comentario,\r\n" + 
			"					idestadoempresa,\r\n" + 
			"					idestado_pago,nombre_estadopago,\r\n" + 
			"					idtipo_envio,nombre_tipo_envio,\r\n" + 
			"					ordendisponible,\r\n" + 
			"					tiempo_espera,\r\n" + 
			"					idrepartidor,\r\n" + 
			"					cancelar,\r\n" + 
			"					comentario_cancelar,\r\n" + 
			"					idestadodelivery,\r\n" + 
			"					idestadogeneral,\r\n" + 
			"					numeromesa ,descuento_mesa,mesa"+
			"                 FROM restaurante_pedido"+
			"                 WHERE   idestadoempresa = 4  AND ordendisponible=false" + 
			"					AND idempresa= ?1  ",nativeQuery=true)
	List<Restaurante_Pedido> findHistorialOrden(int idEmpresa);
	

}
