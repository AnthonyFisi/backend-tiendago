package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Orden_estado_delivery;
import com.backend.tienda.entity.Orden_estado_deliveryPK;

@Repository
public interface Orden_estado_deliveryRepository extends JpaRepository<Orden_estado_delivery,Orden_estado_deliveryPK>{
	
	@Query(value="SELECT idventa,idestado_delivery,idrepartidor ,detalle ,fecha FROM orden_estado_delivery WHERE idventa = ?1 ",nativeQuery=true)
	List<Orden_estado_delivery> listaEstadosByIdVenta(int idventa);


}
