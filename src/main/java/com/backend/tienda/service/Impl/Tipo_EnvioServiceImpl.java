package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Tipo_Envio;
import com.backend.tienda.repository.Tipo_EnvioRepository;
import com.backend.tienda.service.Tipo_EnvioService;

@Service
public class Tipo_EnvioServiceImpl implements Tipo_EnvioService {
	
	@Autowired
	Tipo_EnvioRepository tipo_EnvioRepository;

	@Override
	public List<Tipo_Envio> listaTipo_Envio() {
		return tipo_EnvioRepository.findAll();
	}
	

}
