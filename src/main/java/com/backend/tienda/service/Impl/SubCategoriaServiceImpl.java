package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.SubCategoriaDAO;
import com.backend.tienda.entity.SubCategoria;
import com.backend.tienda.service.SubCategoriaService;


@Service
public class SubCategoriaServiceImpl implements SubCategoriaService{

	@Autowired
	SubCategoriaDAO subCategoriaDAO;
	
	@Override
	public List<SubCategoria> listaSubcategoria() {
		return subCategoriaDAO.listaSubcategoria();
	}

	@Override
	public List<SubCategoria> listaSubCategoriaByidCategoria(int idCategoria) {
		return subCategoriaDAO.listaSubCategoriaByidCategoria(idCategoria);
	}

}
