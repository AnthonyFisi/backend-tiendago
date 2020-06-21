package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.TipoPago;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago,Integer>{
	
	@Query(value="SELECT idtipopago,tipopago_nombre,tipopago_estado,tipopago_url FROM tipopago WHERE tipopago_estado = ?1 ",nativeQuery=true)
	List<TipoPago> listaEnableTipoPago( boolean estado);

}
