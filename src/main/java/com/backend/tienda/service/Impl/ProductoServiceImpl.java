package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Producto;
import com.backend.tienda.repository.ProductoRepository;
import com.backend.tienda.service.ProductoService;


@Service
public class ProductoServiceImpl  implements ProductoService{
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<Producto> listaProducto() {
		return productoRepository.findAll();
	}

	@Override
	public Producto insertarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> listaIdcategoriaproductoAndIdempresa(int idcategoriaproducto, int idempresa) {
		
		return productoRepository.listafindByidcategoriaproductoAndidempresa(idcategoriaproducto, idempresa);
	
	}

	@Override
	public List<Producto> findByidempresa(int idempresa) {
		return productoRepository.findByidempresa(idempresa);
	}


	
}
