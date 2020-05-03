package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.backend.tienda.entity.FavoriteProductMore;

public class FavoriteProductMoreRowMapper implements RowMapper<FavoriteProductMore>{

	@Override
	public FavoriteProductMore mapRow(ResultSet rs, int rowNum) throws SQLException {
		FavoriteProductMore favoriteProductMore= new FavoriteProductMore();
		favoriteProductMore.setIdProducto(rs.getInt("idProducto"));
		favoriteProductMore.setProducto_nombre(rs.getString("producto_nombre"));
		favoriteProductMore.setProducto_marca(rs.getString("producto_marca"));
		favoriteProductMore.setProducto_envase(rs.getString("producto_envase"));
		favoriteProductMore.setProducto_detalle(rs.getString("producto_detalle"));
		favoriteProductMore.setProducto_cantidad(rs.getString("producto_cantidad"));
		favoriteProductMore.setProducto_precio(rs.getFloat("producto_precio"));
		favoriteProductMore.setProducto_uri_imagen(rs.getString("producto_uri_imagen"));
		return favoriteProductMore;
	}

}
