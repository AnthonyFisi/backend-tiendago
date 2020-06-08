package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Horario;
import com.backend.tienda.repository.HorarioRepository;
import com.backend.tienda.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService{
	
	@Autowired
	HorarioRepository horarioRepository;
	

	@Override
	public List<Horario> listahorario() {
		return horarioRepository.findAll();
	}

}
