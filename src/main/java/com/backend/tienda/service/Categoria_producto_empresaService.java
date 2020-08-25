package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Categoria_producto_empresa;

public interface Categoria_producto_empresaService {
	
	List<Categoria_producto_empresa> listaCategoria(int idempresa);

}
