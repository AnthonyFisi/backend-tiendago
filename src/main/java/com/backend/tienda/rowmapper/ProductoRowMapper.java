package com.backend.tienda.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Producto;

public class ProductoRowMapper implements RowMapper<Producto>{

	@Override
	public Producto mapRow(ResultSet row, int rowNum) throws SQLException {
		Producto producto=new Producto();
		producto.setIdProducto(row.getInt("idProducto"));
		producto.setProducto_nombre(row.getString("Producto_nombre"));
		producto.setProducto_precio(row.getInt("Producto_precio"));
		producto.setProducto_stock(row.getInt("Producto_stock"));
		producto.setProducto_codigo(row.getString("Producto_codigo"));
		producto.setProducto_fechaCreacion(row.getDate("Producto_fechaCreacion"));
		producto.setIdImagenesProducto(row.getInt("idImagenesProducto"));
		producto.setIdCategoria(row.getInt("idCategoria"));	
		producto.setProducto_fechaVencimiento(row.getDate("producto_fechaVencimiento"));
		producto.setProducto_marca(row.getString("producto_marca"));
		producto.setProducto_envase(row.getString("producto_envase"));
		producto.setProducto_detalle(row.getString("producto_detalle"));
		producto.setProducto_cantidad(row.getString("producto_cantidad"));
		return producto;
	}

}
