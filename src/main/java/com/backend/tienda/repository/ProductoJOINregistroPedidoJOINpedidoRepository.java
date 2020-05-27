package com.backend.tienda.repository;


import java.util.List;

import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;

@Repository
public interface ProductoJOINregistroPedidoJOINpedidoRepository extends JpaRepository<ProductoJOINregistroPedidoJOINpedido,Integer>{
	
	 List<ProductoJOINregistroPedidoJOINpedido> findByidpedido(int idpedido);

}
