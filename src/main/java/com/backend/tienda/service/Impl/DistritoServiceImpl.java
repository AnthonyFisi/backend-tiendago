package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Distrito;
import com.backend.tienda.repository.DistritoRepository;
import com.backend.tienda.service.DistritoService;

@Service
public class DistritoServiceImpl  implements DistritoService{
	
	@Autowired
	DistritoRepository distritoRepository;

	@Override
	public List<Distrito> listaDistrito() {
		return distritoRepository.findAll();
	}

}
