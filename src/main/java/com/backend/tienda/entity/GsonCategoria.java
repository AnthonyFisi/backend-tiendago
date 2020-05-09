package com.backend.tienda.entity;

import java.util.List;

public class GsonCategoria {
	
	private String key;
	private List<Categoria> listCategoria=null;
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Categoria> getListCategoria() {
		return listCategoria;
	}
	public void setListCategoria(List<Categoria> listCategoria) {
		this.listCategoria = listCategoria;
	}
	
	

	
}
