package com.backend.tienda.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden,Integer>{
	
	
	/*@Query(value="SELECT    	" + 
			"			idempresa," + 
			"			nombre_empresa," + 
			"			celular_empresa," + 
			"			urlfoto_empresa," + 
			"			tiempo_aproximado_entrega," + 
			"					emp_maps_coordenada_x, emp_maps_coordenada_Y,detalle_ubicacion," + 
			"					idtipopago,tipopago_nombre," + 
			"					idhorario,horario_nombre,horario_inicio,horario_fin," + 
			"					idubicacion,ubicacion_nombre,ubicacion_comentarios,maps_coordenada_x,maps_coordenada_y," + 
			"					idventa,venta_fecha,venta_fechaentrega,venta_costodelivery,venta_costototal,comentario," + 
			"					idpedido,idusuario," + 
			"					idestado_venta,tipo_estado," + 
			"					idestado_pago,nombre_estado"
			+ "     FROM orden "
			+ "    WHERE idestado_venta<> ?1  AND  idestado_venta<> ?2 AND  idestado_venta<> ?3 AND idusuario= ?4 ",nativeQuery=true)
	List<Orden> findByidestadoventaNotAndidestadoventaNotAndidestadoventaNotAndidusario(int idestado1,int idestado2,int idestado3,int idusuario);*/
	
	List<Orden> findByIdusuarioAndOrdendisponibleAndVentafechaGreaterThanEqual(int idusuario,boolean disponible,Timestamp fecha);
	
	


}
