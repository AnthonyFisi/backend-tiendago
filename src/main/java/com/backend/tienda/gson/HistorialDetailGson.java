package com.backend.tienda.gson;

import java.util.List;

import com.backend.tienda.entity.Orden_estado_delivery;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;

public class HistorialDetailGson {
	
	private List<ProductoJOINregistroPedidoJOINpedido> listaProducto;
	
	private List<Orden_estado_delivery> listaEstados;
	
	private String ubicacionEmpresa;
	
	private String ubicacionUsuario;


	public List<ProductoJOINregistroPedidoJOINpedido> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<ProductoJOINregistroPedidoJOINpedido> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public List<Orden_estado_delivery> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Orden_estado_delivery> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public String getUbicacionEmpresa() {
		return ubicacionEmpresa;
	}

	public void setUbicacionEmpresa(String ubicacionEmpresa) {
		this.ubicacionEmpresa = ubicacionEmpresa;
	}

	public String getUbicacionUsuario() {
		return ubicacionUsuario;
	}

	public void setUbicacionUsuario(String ubicacionUsuario) {
		this.ubicacionUsuario = ubicacionUsuario;
	}
	
	
	
	

}
