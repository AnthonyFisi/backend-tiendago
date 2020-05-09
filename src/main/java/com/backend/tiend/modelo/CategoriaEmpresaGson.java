package com.backend.tiend.modelo;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.CategoriaEmpresa;

public class CategoriaEmpresaGson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<CategoriaEmpresa> listaCategoriaEmpresa;


	public List<CategoriaEmpresa> getListaCategoriaEmpresa() {
		return listaCategoriaEmpresa;
	}


	public void setListaCategoriaEmpresa(List<CategoriaEmpresa> listaCategoriaEmpresa) {
		this.listaCategoriaEmpresa = listaCategoriaEmpresa;
	}
	
	

}
