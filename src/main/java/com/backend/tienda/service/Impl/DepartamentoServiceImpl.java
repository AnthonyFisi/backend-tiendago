package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Departamento;
import com.backend.tienda.repository.DepartamentoRepository;
import com.backend.tienda.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	DepartamentoRepository departamentoRepository;

	@Override
	public List<Departamento> listaDepartamento() {
		return departamentoRepository.findAll();
	}
	
	

}
