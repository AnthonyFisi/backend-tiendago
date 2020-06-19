package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.TipoPago;

public class TipoPagoGson implements Serializable{
	
	private List<TipoPago> listaTipoPago;

	public List<TipoPago> getListaTipoPago() {
		return listaTipoPago;
	}

	public void setListaTipoPago(List<TipoPago> listaTipoPago) {
		this.listaTipoPago = listaTipoPago;
	}
	
	
	

}
