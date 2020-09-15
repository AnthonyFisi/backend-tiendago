package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Empresa_historial;
import com.backend.tienda.repository.Empresa_historialRepository;
import com.backend.tienda.service.Empresa_historialService;

@Service
public class Empresa_historialServiceImpl implements Empresa_historialService{
	
	@Autowired
	Empresa_historialRepository empresa_historialRepository;

	@Override
	public List<Empresa_historial> findByEstado(int idestadoempresaofi, int idempresa) {
		return empresa_historialRepository.findByIdestadoempresaofiAndIdempresaOrderByFechahistorialDesc(idestadoempresaofi, idempresa);
	}

}
