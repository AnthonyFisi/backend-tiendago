package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.TipoPagoDAO;
import com.backend.tienda.entity.TipoPago;
import com.backend.tienda.service.TipoPagoService;

@Service
public class TipoPagoServiceImpl implements TipoPagoService {
	
	@Autowired
	TipoPagoDAO tipoPagoDAO;
	
	@Override
	public void registrarTipoPago(TipoPago tipoPago) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoPago> listaTipoPago() {
		return tipoPagoDAO.listaTipoPago();
	}

}
