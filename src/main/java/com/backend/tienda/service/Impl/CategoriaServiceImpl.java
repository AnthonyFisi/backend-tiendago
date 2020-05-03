package com.backend.tienda.service.Impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.CategoriaDAO;
import com.backend.tienda.entity.Categoria;
import com.backend.tienda.service.CategoriaService;


@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> listaCategoria() {
		
		return  categoriaDAO.listaCategoria();
	}

	@Override
	public void añadirCategoria(Categoria categoria) {
		categoriaDAO.añadirCategoria(categoria);
		
	}

	@Override
	public void eliminarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		
	}

}
