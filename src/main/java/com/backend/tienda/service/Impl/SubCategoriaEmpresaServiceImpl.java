package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.SubCategoriaEmpresa;
import com.backend.tienda.repository.SubCategoriaEmpresaRepository;
import com.backend.tienda.service.SubCategoriaEmpresaService;

@Service
public class SubCategoriaEmpresaServiceImpl implements SubCategoriaEmpresaService{
	
	@Autowired
	SubCategoriaEmpresaRepository subCategoriaEmpresaRepository;
	
	@Override
	public List<SubCategoriaEmpresa> listaSubCategoriaEmpresaByIdCategoria(int idCategoriaEmpresa) {
		return subCategoriaEmpresaRepository.findByidcategoriaempresa(idCategoriaEmpresa);
	}

}
