package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.CategoriaProducto;
import com.backend.tienda.repository.CategoriaProductoRepository;
import com.backend.tienda.service.CategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService{
	
	@Autowired
	CategoriaProductoRepository categoriaProductoRepository;

	@Override
	public List<CategoriaProducto> listaCategoriaProducto() {
		return categoriaProductoRepository.findAll();
	}

}
