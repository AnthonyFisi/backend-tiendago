package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Ubicacion;

public class UbicacionGson implements Serializable{
	

	private List<Ubicacion> listaUbicacion;

	public List<Ubicacion> getListaUbicacion() {
		return listaUbicacion;
	}

	public void setListaUbicacion(List<Ubicacion> listaUbicacion) {
		this.listaUbicacion = listaUbicacion;
	}
	
	
}
