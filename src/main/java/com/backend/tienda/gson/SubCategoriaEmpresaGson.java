package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.SubCategoriaEmpresa;

public class SubCategoriaEmpresaGson implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SubCategoriaEmpresa> listaSubCategoriaEmpresa;
	
	public List<SubCategoriaEmpresa> getListaSubCategoriaEmpresa() {
		return listaSubCategoriaEmpresa;
	}
	public void setListaSubCategoriaEmpresa(List<SubCategoriaEmpresa> listaSubCategoriaEmpresa) {
		this.listaSubCategoriaEmpresa = listaSubCategoriaEmpresa;
	}
	

}
