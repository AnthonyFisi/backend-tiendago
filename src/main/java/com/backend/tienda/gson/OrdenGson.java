package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Orden;

public class OrdenGson implements Serializable{

	private List<Orden> listaOrden;

	public List<Orden> getListaOrden() {
		return listaOrden;
	}

	public void setListaOrden(List<Orden> listaOrden) {
		this.listaOrden = listaOrden;
	}
	
	
}
