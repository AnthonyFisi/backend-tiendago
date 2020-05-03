package com.backend.tienda.dao.impl;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.FavoriteProductMoreDAO;
import com.backend.tienda.entity.FavoriteProductMore;
import com.backend.tienda.rowmapper.FavoriteProductMoreRowMapper;

@Transactional
@Repository
public class FavoriteProductMoreDAOImpl implements FavoriteProductMoreDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<FavoriteProductMore> listaFavoriteProduct(int idUsuario) {
		String sql="select " + 
				"p.idProducto," + 
				"p.producto_nombre," + 
				"p.producto_marca ," + 
				"p.producto_envase," + 
				"p.producto_detalle," + 
				"p.producto_cantidad," + 
				"p.Producto_precio,  " + 
				"p.producto_uri_imagen" + 
				" from  producto as p  JOIN favoriteProduct as fp ON fp.idProducto=p.idproducto     " + 
				"				    where fp.idusuario =  ? ";
		
		RowMapper<FavoriteProductMore> rowMapper=new FavoriteProductMoreRowMapper();
		return jdbcTemplate.query(sql,rowMapper,idUsuario);
	}

}
