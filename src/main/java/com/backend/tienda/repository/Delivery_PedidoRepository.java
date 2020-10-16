package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Delivery_Pedido;


@Repository
public interface Delivery_PedidoRepository extends JpaRepository<Delivery_Pedido,Integer>{
	
	Delivery_Pedido  findByidrepartidor(int idrepartidor);
	
	Delivery_Pedido  findByidventa(int idventa);
	
	List<Delivery_Pedido> findByIdrepartidor(int idrepartidor);

}
