package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.TipoPago;

public interface TipoPagoService {
	
	void registrarTipoPago(TipoPago tipoPago);
	List<TipoPago>  listaTipoPago();

}
