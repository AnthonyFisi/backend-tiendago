package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

public class OrdenGeneralGson implements Serializable{
	
	private List<OrdenGson> lista;

	public List<OrdenGson> getLista() {
		return lista;
	}

	public void setLista(List<OrdenGson> lista) {
		this.lista = lista;
	}
	
	

}
