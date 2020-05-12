package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.TipoCuenta;
import com.backend.tienda.repository.TipoCuentaRepository;
import com.backend.tienda.service.TipoCuentaService;

@Service
public class TipoCuentaServiceImpl implements TipoCuentaService {
	
	@Autowired
	TipoCuentaRepository tipoCuentaRepository;

	@Override
	public List<TipoCuenta> listaTipoCuenta() {
		return tipoCuentaRepository.findAll();
	}

}
