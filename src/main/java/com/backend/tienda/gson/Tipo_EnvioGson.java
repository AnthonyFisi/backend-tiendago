package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Tipo_Envio;

public class Tipo_EnvioGson implements Serializable{

	private List<Tipo_Envio> listaTipo_Envio;

	public List<Tipo_Envio> getListaTipo_Envio() {
		return listaTipo_Envio;
	}

	public void setListaTipo_Envio(List<Tipo_Envio> listaTipo_Envio) {
		this.listaTipo_Envio = listaTipo_Envio;
	}
	
	
}
