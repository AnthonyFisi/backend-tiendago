package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Envio_empresa;
import com.backend.tienda.repository.Envio_empresaRepository;
import com.backend.tienda.service.Envio_empresaService;

@Service
public class Envio_empresaServiceImpl  implements Envio_empresaService{
	
	@Autowired
	Envio_empresaRepository envio_empresaRepository;

	@Override
	public List<Envio_empresa> findByIdempresa(int idempresa) {

		return envio_empresaRepository.findByIdempresa(idempresa);
	}

	@Override
	public List<Envio_empresa> listaAll() {
		return envio_empresaRepository.findAll();
	}

	@Override
	public List<Envio_empresa> listafindByIdtipoenvio(int id) {
		return null;
	}

}
