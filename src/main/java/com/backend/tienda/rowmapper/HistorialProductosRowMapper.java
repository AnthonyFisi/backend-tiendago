package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.HistorialProductos;

public class HistorialProductosRowMapper implements RowMapper<HistorialProductos> {

	@Override
	public HistorialProductos mapRow(ResultSet rs, int rowNum) throws SQLException {
		HistorialProductos historialProductos=new HistorialProductos();
		historialProductos.setIdproducto(rs.getInt("idproducto"));
		historialProductos.setProducto_nombre(rs.getString("producto_nombre"));
		historialProductos.setProducto_marca(rs.getString("producto_marca"));
		historialProductos.setProducto_envase(rs.getString("producto_envase"));
		historialProductos.setProducto_detalle(rs.getString("producto_detalle"));
		historialProductos.setProducto_cantidad(rs.getString("producto_cantidad"));
		historialProductos.setProducto_precio(rs.getFloat("producto_precio"));
		historialProductos.setProducto_uri_imagen(rs.getString("producto_uri_imagen"));
		historialProductos.setPedido_fecha_registro(rs.getString("pedido_fecha_registro"));
		return historialProductos;
	}

}
