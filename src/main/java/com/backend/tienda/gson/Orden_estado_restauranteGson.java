package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Orden_estado_restaurante;

public class Orden_estado_restauranteGson implements Serializable{
	
	private List<Orden_estado_restaurante> listaOrden_estado_restaurante;

	public List<Orden_estado_restaurante> getListaOrden_estado_restaurante() {
		return listaOrden_estado_restaurante;
	}

	public void setListaOrden_estado_restaurante(List<Orden_estado_restaurante> listaOrden_estado_restaurante) {
		this.listaOrden_estado_restaurante = listaOrden_estado_restaurante;
	}
	
	

}
