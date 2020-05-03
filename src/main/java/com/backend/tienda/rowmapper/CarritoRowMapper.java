package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Carrito;

public class CarritoRowMapper implements RowMapper<Carrito> {

	
	@Override
	public Carrito mapRow(ResultSet rs, int rowNum) throws SQLException {
		Carrito carrito= new Carrito();
		carrito.setIdProducto(rs.getInt("idProducto"));
		carrito.setProducto_nombre(rs.getString("producto_nombre"));
		carrito.setProducto_marca(rs.getString("producto_marca"));
		carrito.setProducto_envase(rs.getString("producto_envase"));
		carrito.setProducto_detalle(rs.getString("producto_detalle"));
		carrito.setProducto_cantidad(rs.getString("producto_cantidad"));
		carrito.setProducto_precio(rs.getFloat("producto_precio"));
		carrito.setRegistropedido_cantidad(rs.getInt("registropedido_cantidad"));
		carrito.setregistropedido_preciototal(rs.getFloat("registropedido_preciototal"));
		carrito.setProducto_uri_imagen(rs.getString("producto_uri_imagen"));
		return carrito;
	}

}
