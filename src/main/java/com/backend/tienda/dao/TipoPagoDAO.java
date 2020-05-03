package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.TipoPago;

public interface TipoPagoDAO {
	
	void registrarTipoPago(TipoPago tipoPago);
	List<TipoPago>  listaTipoPago();

}
