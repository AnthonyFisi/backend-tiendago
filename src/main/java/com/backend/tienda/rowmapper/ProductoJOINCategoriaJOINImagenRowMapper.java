package com.backend.tienda.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.ProductoJOINCategoriaJOINImagen;

public class ProductoJOINCategoriaJOINImagenRowMapper implements RowMapper<ProductoJOINCategoriaJOINImagen>{

	@Override
	public ProductoJOINCategoriaJOINImagen mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductoJOINCategoriaJOINImagen producto=new ProductoJOINCategoriaJOINImagen();
		producto.setIdProducto(rs.getInt("idProducto"));
		producto.setProducto_nombre(rs.getString("producto_nombre"));
		producto.setProducto_precio(rs.getFloat("producto_precio"));
		producto.setIdCategoria(rs.getInt("idCategoria"));
		producto.setCategoria_nombre(rs.getString("categoria_nombre"));
		producto.setCategoria_descripcion(rs.getString("categoria_descripcion"));
		
		producto.setProducto_uri_imagen(rs.getString("producto_uri_imagen"));
		
		producto.setProducto_marca(rs.getString("producto_marca"));
		producto.setProducto_envase(rs.getString("producto_envase"));
		producto.setProducto_detalle(rs.getString("producto_detalle"));
		producto.setProducto_cantidad(rs.getString("producto_cantidad"));
		
		producto.setNombresubcategoria(rs.getString("nombresubcategoria"));
		producto.setIdSubcategoria(rs.getInt("idSubcategoria"));
		producto.setDetalle(rs.getString("detalle"));
		return producto;
	}

}
