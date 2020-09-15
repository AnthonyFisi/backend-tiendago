package com.backend.tienda.models;

import java.util.List;

import com.backend.tienda.entity.Empresa_historial;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.Repartidor_Bi;

public class Empresa_historialDetail {
		
	private Repartidor_Bi repartidor_bi;
	
	List<ProductoJOINregistroPedidoJOINpedido> listaProductos;


	public Repartidor_Bi getRepartidor_bi() {
		return repartidor_bi;
	}

	public void setRepartidor_bi(Repartidor_Bi repartidor_bi) {
		this.repartidor_bi = repartidor_bi;
	}

	public List<ProductoJOINregistroPedidoJOINpedido> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoJOINregistroPedidoJOINpedido> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	

}
