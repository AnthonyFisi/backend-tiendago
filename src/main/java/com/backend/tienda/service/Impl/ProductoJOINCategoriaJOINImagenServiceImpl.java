package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.ProductoJOINCategoriaJOINImagenDAO;
import com.backend.tienda.entity.ProductoJOINCategoriaJOINImagen;
import com.backend.tienda.service.ProductoJOINCategoriaJOINImagenService;

@Service
public class ProductoJOINCategoriaJOINImagenServiceImpl implements ProductoJOINCategoriaJOINImagenService{

	@Autowired
	
	ProductoJOINCategoriaJOINImagenDAO  producto;
	
	@Override
	public List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagen() {
		
		return producto.listaProductoJOINCategoriaJOINImagen();
	}

	@Override
	public List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagenByCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		return producto.listaProductoJOINCategoriaJOINImagenByCategoria(idCategoria);
	}

	@Override
	public List<ProductoJOINCategoriaJOINImagen> listaBusquedaByTexto(String palabraClave) {
		return producto.listaBusquedaByTexto(palabraClave);
	}

	@Override
	public List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagenBySubCategoria(
			int idSubCategoria) {
		return producto.listaProductoJOINCategoriaJOINImagenBySubCategoria(idSubCategoria);
	}

}
