package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.ProductoJOINCategoriaJOINImagenDAO;
import com.backend.tienda.entity.ProductoJOINCategoriaJOINImagen;
import com.backend.tienda.rowmapper.ProductoJOINCategoriaJOINImagenRowMapper;

@Transactional
@Repository
public class ProductoJOINCategoriaJOINImagenDAOImpl implements ProductoJOINCategoriaJOINImagenDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagen() {
		
		String sql="SELECT   " + 
				"				 	p.idProducto,  " + 
				"					p.Producto_nombre,  " + 
				"					p.Producto_precio,  " + 
				"					c.idcategoria," + 
				"					c.Categoria_nombre,  " + 
				"					c.Categoria_descripcion,  " + 
				"					p.producto_uri_imagen," + 
				"				   	p.producto_marca," + 
				"				   	p.producto_envase," + 
				"				   	p.producto_detalle," + 
				"				   	p.producto_cantidad ," + 
				"				   	sc.nombresubcategoria," + 
				"				   	sc.idsubcategoria," + 
				"					sc.detalle" + 
				"				  	FROM   " + 
				"					producto AS p JOIN subcategoria AS sc ON p.idsubcategoria=sc.idsubcategoria    " + 
				"					JOIN categoria AS c ON c.idcategoria=sc.idcategoria " ;
		RowMapper<ProductoJOINCategoriaJOINImagen> rowMapper= new ProductoJOINCategoriaJOINImagenRowMapper();
		
		return this.jdbcTemplate.query(sql,rowMapper);
	}



	@Override
	public List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagenByCategoria(int idCategoria) {
		
		String sql="SELECT   " + 
				"				 	p.idProducto,  " + 
				"					p.Producto_nombre,  " + 
				"					p.Producto_precio,  " + 
				"					c.idcategoria," + 
				"					c.Categoria_nombre,  " + 
				"					c.Categoria_descripcion,  " + 
				"					p.producto_uri_imagen," + 
				"				   	p.producto_marca," + 
				"				   	p.producto_envase," + 
				"				   	p.producto_detalle," + 
				"				   	p.producto_cantidad ," + 
				"				   	sc.nombresubcategoria," + 
				"				   	sc.idsubcategoria," + 
				"					sc.detalle" + 
				"				  	FROM   " + 
				"					producto AS p JOIN subcategoria AS sc ON p.idsubcategoria=sc.idsubcategoria    " + 
				"					JOIN categoria AS c ON c.idcategoria=sc.idcategoria" + 
				"                    WHERE c.idcategoria= ?";
		RowMapper<ProductoJOINCategoriaJOINImagen> rowMapper= new ProductoJOINCategoriaJOINImagenRowMapper();
		
		return this.jdbcTemplate.query(sql,rowMapper,idCategoria);
	}



	@Override
	public List<ProductoJOINCategoriaJOINImagen> listaBusquedaByTexto(String palabraClave) {
		String sql="SELECT   " + 
				"				 	p.idProducto,  " + 
				"					p.Producto_nombre,  " + 
				"					p.Producto_precio,  " + 
				"					c.idcategoria," + 
				"					c.Categoria_nombre,  " + 
				"					c.Categoria_descripcion,  " + 
				"					p.producto_uri_imagen," + 
				"				   	p.producto_marca," + 
				"				   	p.producto_envase," + 
				"				   	p.producto_detalle," + 
				"				   	p.producto_cantidad ," + 
				"				   	sc.nombresubcategoria," + 
				"				   	sc.idsubcategoria," + 
				"					sc.detalle" + 
				"				  	FROM   " + 
				"					producto AS p JOIN subcategoria AS sc ON p.idsubcategoria=sc.idsubcategoria    " + 
				"					JOIN categoria AS c ON c.idcategoria=sc.idcategoria " + 				
				"				 WHERE plainto_tsquery( ? ) @@ to_tsvector(coalesce(p.Producto_nombre,'')     " + 
				"						|| ' ' ||coalesce(p.producto_marca,'') || ' ' ||coalesce(p.producto_detalle,''))   ";
		
		
		RowMapper<ProductoJOINCategoriaJOINImagen> rowMapper= new ProductoJOINCategoriaJOINImagenRowMapper();
		
		return this.jdbcTemplate.query(sql,rowMapper,palabraClave);		
		}



	@Override
	public List<ProductoJOINCategoriaJOINImagen> listaProductoJOINCategoriaJOINImagenBySubCategoria(
			int idSubCategoria) {
		String sql="SELECT   " + 
				"				 	p.idProducto,  " + 
				"					p.Producto_nombre,  " + 
				"					p.Producto_precio,  " + 
				"					c.idcategoria," + 
				"					c.Categoria_nombre,  " + 
				"					c.Categoria_descripcion,  " + 
				"					p.producto_uri_imagen," + 
				"				   	p.producto_marca," + 
				"				   	p.producto_envase," + 
				"				   	p.producto_detalle," + 
				"				   	p.producto_cantidad ," + 
				"				   	sc.nombresubcategoria," + 
				"				   	sc.idsubcategoria," + 
				"					sc.detalle" + 
				"				  	FROM   " + 
				"					producto AS p JOIN subcategoria AS sc ON p.idsubcategoria=sc.idsubcategoria    " + 
				"					JOIN categoria AS c ON c.idcategoria=sc.idcategoria" + 
				"                    WHERE sc.idsubcategoria= ?";
		RowMapper<ProductoJOINCategoriaJOINImagen> rowMapper= new ProductoJOINCategoriaJOINImagenRowMapper();
		
		return this.jdbcTemplate.query(sql,rowMapper,idSubCategoria);
	}

}
