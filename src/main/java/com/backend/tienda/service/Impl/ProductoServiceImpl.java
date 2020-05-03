package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.ProductoDAO;
import com.backend.tienda.entity.Producto;
import com.backend.tienda.service.ProductoService;

@Service
public class ProductoServiceImpl  implements ProductoService{

	@Autowired
	ProductoDAO productoDAO;
	
	@Override
	public void ingresarProducto(Producto producto) {
		productoDAO.ingresarProducto(producto);	
	}

	@Override
	public boolean eliminarProducto(int codigo) {
		
		return productoDAO.eliminarProducto(codigo);

	}

	@Override
	public void actualizarProducto(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> listaProductos() {
		return productoDAO.listaProductos();
	}

	@Override
	public List<Producto> listaProductosByCategoria(int idCategoria) {
			return productoDAO.listaProductosByCategoria(idCategoria);
	}

}
