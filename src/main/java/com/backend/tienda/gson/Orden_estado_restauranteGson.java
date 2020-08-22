package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Orden_estado_general;
import com.backend.tienda.entity.Orden_estado_empresa;

public class Orden_estado_restauranteGson implements Serializable{
	
	private List<Orden_estado_general> listaOrden_estado_general;

	public List<Orden_estado_general> getListaOrden_estado_general() {
		return listaOrden_estado_general;
	}

	public void setListaOrden_estado_general(List<Orden_estado_general> listaOrden_estado_general) {
		this.listaOrden_estado_general = listaOrden_estado_general;
	}

	
	

}
