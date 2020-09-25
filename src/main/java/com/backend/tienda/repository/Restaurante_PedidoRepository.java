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
	
	
	List<Restaurante_Pedido> findByIdestadoempresaAndOrdendisponibleAndIdempresaAndVentafechaentregaBetweenOrderByVentafechaAsc(int idestadoempresa,boolean ordendisponible,int idEmpresa,Timestamp fecha1,Timestamp fecha2);


	Restaurante_Pedido findByIdestadoempresaAndOrdendisponibleAndIdempresaAndIdpedidoAndIdventa(int idestadoempresa,boolean disponbile,int idempresa,int idpedido,int idventa);

	
	List<Restaurante_Pedido> findByIdestadoempresaAndOrdendisponibleAndIdempresaAndCancelarOrderByVentafechaentregaDesc(int idestadoempresa,boolean disponbile,int idempresa,boolean cancelar);

	
	List<Restaurante_Pedido> findByIdestadoempresaAndIdempresa(int idestadoempresa,int idempresa);

	

}
