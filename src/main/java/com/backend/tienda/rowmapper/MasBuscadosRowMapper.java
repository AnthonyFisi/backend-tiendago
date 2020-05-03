package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.MasBuscados;

public class MasBuscadosRowMapper implements RowMapper<MasBuscados>{

	@Override
	public MasBuscados mapRow(ResultSet rs, int rowNum) throws SQLException {
		MasBuscados producto=new MasBuscados();
		producto.setIdProducto(rs.getInt("idProducto"));
		producto.setProducto_nombre(rs.getString("producto_nombre"));
		producto.setProducto_precio(rs.getFloat("producto_precio"));
		producto.setIdCategoria(rs.getInt("idCategoria"));
		producto.setCategoria_nombre(rs.getString("categoria_nombre"));
		producto.setCategoria_descripcion(rs.getString("categoria_descripcion"));
		producto.setIdImagenesProducto(rs.getInt("idImagenesProducto"));
		producto.setImagenesProducto_nombre(rs.getString("imagenesProducto_nombre"));
		producto.setImagenesProducto_uri(rs.getString("imagenesProducto_uri"));
		producto.setProducto_marca(rs.getString("producto_marca"));
		producto.setProducto_envase(rs.getString("producto_envase"));
		producto.setProducto_detalle(rs.getString("producto_detalle"));
		producto.setProducto_cantidad(rs.getString("producto_cantidad"));
		producto.setPorcentaje(rs.getFloat("porcentaje"));
		return producto;
	}

}
