package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Empresa_favorita;
import com.backend.tienda.repository.Empresa_favoritaRepository;
import com.backend.tienda.service.Empresa_favoritaService;

@Service
public class Empresa_favoritaServiceImpl implements Empresa_favoritaService{
	
	@Autowired
	Empresa_favoritaRepository empresa_favoriaRepository;

	@Override
	public List<Empresa_favorita> listaEmpresas(int idusuario) {
		
		return empresa_favoriaRepository.findByIdusuario(idusuario);
		}

}
