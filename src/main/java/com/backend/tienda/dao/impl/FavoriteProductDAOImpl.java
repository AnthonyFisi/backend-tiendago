package com.backend.tienda.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.FavoriteProductDAO;
import com.backend.tienda.entity.FavoriteProduct;

@Transactional
@Repository
public class FavoriteProductDAOImpl implements FavoriteProductDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int registrarFavoriteProduct(FavoriteProduct favoriteProduct) {
		String sql = "INSERT INTO favoriteProduct (idUsuario,idProducto,activo,fecha) VALUES (?,?,?,?) ";
		
		return jdbcTemplate.update(sql,
				favoriteProduct.getIdUsuario(),
				favoriteProduct.getIdProducto(),
				favoriteProduct.isActivo(),
				favoriteProduct.getFecha()
				);
	}

	@Override
	public FavoriteProduct findFavoriteProduct(int idUsuario, int idProducto) {
		String sql="SELECT idFavorite,idUsuario,idProducto,activo,fecha FROM favoriteProduct WHERE idUsuario = ? AND idProducto = ? ";
		RowMapper<FavoriteProduct> rowMapper=new BeanPropertyRowMapper<FavoriteProduct>(FavoriteProduct.class);
		FavoriteProduct favoriteProduct= jdbcTemplate.queryForObject(sql, rowMapper,idUsuario,idProducto);
		
		
		return favoriteProduct;
		
	}

	@Override
	public int updateStateFavoriteProduct(int idFavoriteProduct,boolean activo) {
		String sql="UPDATE favoriteProduct SET activo = ?  WHERE idFavorite = ? ";
		
		return jdbcTemplate.update(sql,activo,idFavoriteProduct);
	}
	

}
