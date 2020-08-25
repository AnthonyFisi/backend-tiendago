package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Categoria_producto_empresa;
import com.backend.tienda.repository.Categoria_producto_empresaRepository;
import com.backend.tienda.service.Categoria_producto_empresaService;

@Service
public class Categoria_producto_empresaServiceImpl implements Categoria_producto_empresaService {

	@Autowired
	Categoria_producto_empresaRepository categoria_producto_empresaRepository;
	
	@Override
	public List<Categoria_producto_empresa> listaCategoria(int idempresa) {
		return categoria_producto_empresaRepository.findByIdempresa(idempresa);
	}

}
