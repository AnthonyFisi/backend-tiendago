package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.CategoriaProducto;

public class CategoriaProductoGson implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
	List<CategoriaProducto> listaCategoriaProducto;

	public List<CategoriaProducto> getListaCategoriaProducto() {
		return listaCategoriaProducto;
	}

	public void setListaCategoriaProducto(List<CategoriaProducto> listaCategoriaProducto) {
		this.listaCategoriaProducto = listaCategoriaProducto;
	}
	
	
	

}
