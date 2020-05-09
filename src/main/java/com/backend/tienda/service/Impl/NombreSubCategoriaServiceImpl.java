package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.NombreSubcategoria;
import com.backend.tienda.service.NombreSubCategoriaService;

@Service
public class NombreSubCategoriaServiceImpl implements NombreSubCategoriaService {
	
	
	@Autowired
	NombreSubCategoriaService nombreSubCategoriaService;
	
	
	@Override
	public List<NombreSubcategoria> listaNombreSubCategoria() {
		// TODO Auto-generated method stub
		return nombreSubCategoriaService.listaNombreSubCategoria();
	}

}
