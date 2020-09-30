package com.backend.tienda.service.Impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Producto;
import com.backend.tienda.entity.ProductoApp;
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
		
		return productoRepository.findByIdcategoriaproductoAndIdempresa(idcategoriaproducto, idempresa);
	
	}

	@Override
	public List<Producto> findByidempresa(int idempresa) {
		return productoRepository.findByidempresaOrderByIdcategoriaproductoAsc(idempresa);
	}

	@Override
	public Producto updateDisponibilidadProducto(int idproducto,int idempresa,boolean disponibilidad) {
		Producto producto=null;
		
		try {
			
			producto=productoRepository.findByIdproductoAndIdempresa(idproducto, idempresa);
			
			producto.setDisponible(disponibilidad);
			
			productoRepository.save(producto);
			
		}catch(Exception e) {
			
			return producto;
			
		}
		
		return producto;
	}

	@Override
	public List<Producto> listafindByPalabra(int idempresa,String palabra) {
		
		return productoRepository.listafindByPalabra(idempresa,palabra);
		
	}

	@Override
	public Boolean eliminarProductoById(int idProducto) {

		Producto producto=null;
		
		productoRepository.deleteById(idProducto);
		
		try {
			producto=productoRepository.findById(idProducto).get();
			return true;
		}catch(Exception e) {
			return false;
		}
	
		
	}

	@Override
	public List<Producto> listaFisrtCategory(int idempresa, int idcategoriaproducto, Timestamp fechacreacion) {
		return  productoRepository.findByIdempresaAndIdcategoriaproductoAndProductofechacreacionBefore(idempresa, idcategoriaproducto, fechacreacion);
	}

	


	
}
