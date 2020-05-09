package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.CategoriaEmpresaDAO;
import com.backend.tienda.entity.CategoriaEmpresa;
import com.backend.tienda.service.CategoriaEmpresaService;

@Service
public class CategoriaEmpresaServiceImpl implements CategoriaEmpresaService {
	
	@Autowired
	CategoriaEmpresaDAO categoriaEmpresaDAO;
	
	@Override
	public List<CategoriaEmpresa> listaCategoriaEmpresa() {
		return categoriaEmpresaDAO.listaCategoriaEmpresa();
	}

}
