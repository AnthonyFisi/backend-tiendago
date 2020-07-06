package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.ProductoApp;

public class ProductoAppGson implements Serializable{
	
	private List<ProductoApp> listaProductos;

	public List<ProductoApp> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoApp> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	

}
