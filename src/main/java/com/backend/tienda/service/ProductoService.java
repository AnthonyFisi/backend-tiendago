package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Producto;
import com.backend.tienda.entity.ProductoApp;

public interface ProductoService {
	
	List<Producto> listaProducto();
	
	Producto insertarProducto(Producto producto);
	
	List<Producto> listaIdcategoriaproductoAndIdempresa(int idcategoriaproducto,int idempresa);
	
	
	List<Producto>  findByidempresa(int idempresa);
	
	Producto updateDisponibilidadProducto(int idproducto,int idempresa,boolean disponibilidad);
	
	List<Producto> listafindByPalabra(int idempresa,String palabra);

}
