package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.TipoPago;
import com.backend.tienda.repository.TipoPagoRepository;
import com.backend.tienda.service.TipoPagoService;

@Service
public class TipoPagoServiceImpl implements TipoPagoService{
	
	@Autowired
	TipoPagoRepository tipoPagoRepository;

	@Override
	public List<TipoPago> listaTipoPago() {
		return tipoPagoRepository.findAll();
	}

	@Override
	public List<TipoPago> listaTipoPagoEnable() {
		return tipoPagoRepository.listaEnableTipoPago(true);
	}
	
	

}
