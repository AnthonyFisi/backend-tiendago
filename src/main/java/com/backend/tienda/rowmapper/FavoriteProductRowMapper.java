package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.FavoriteProduct;

public class FavoriteProductRowMapper implements RowMapper<FavoriteProduct> {

	@Override
	public FavoriteProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		FavoriteProduct favoriteProduct =new FavoriteProduct();
		favoriteProduct.setIdFavorite(rs.getInt("idFavorite"));
		favoriteProduct.setIdUsuario(rs.getInt("idUsuario"));
		favoriteProduct.setIdProducto(rs.getInt("idProducto"));
		favoriteProduct.setActivo(rs.getBoolean("activo"));
		favoriteProduct.setFecha(rs.getTimestamp("fecha"));
		return favoriteProduct;
	}

}
