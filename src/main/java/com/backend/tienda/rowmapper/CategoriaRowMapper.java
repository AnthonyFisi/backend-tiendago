package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Categoria;

public class CategoriaRowMapper implements RowMapper<Categoria> {

	@Override
	public Categoria mapRow(ResultSet row, int rowNum) throws SQLException {
		Categoria categoria= new Categoria();
		categoria.setIdCategoria(row.getInt("idCategoria"));
		categoria.setCategoria_nombre(row.getString("Categoria_nombre"));
		categoria.setCategoria_descripcion(row.getString("Categoria_descripcion"));
		categoria.setCategoria_imagen(row.getString("categoria_imagen"));
		categoria.setCategoria_uri_post(row.getString("categoria_uri_post"));
		return categoria;
	}

}
