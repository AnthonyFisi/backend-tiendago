package com.backend.tienda.service.Impl;

import java.util.ArrayList;
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
	/*	
		List<Integer> lista=new ArrayList<>();
		lista.add(1);
		List<Empresa_favorita> lis=null;
		
		lis=empresa_favoriaRepository.findAllById(lista);
		*/
		
		return empresa_favoriaRepository.findByIdusuario(idusuario);
		}

}
