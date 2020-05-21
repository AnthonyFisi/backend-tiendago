package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Provincia;
import com.backend.tienda.repository.ProvinciaRepository;
import com.backend.tienda.service.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{
	
	@Autowired
	ProvinciaRepository provinciaRepository;

	@Override
	public List<Provincia> listaProvincia(int iddepartamento) {
		return provinciaRepository.findByiddepartamento(iddepartamento);
	}

}
