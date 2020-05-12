package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.CategoriaEmpresa;

public class CategoriaEmpresaRowMapper implements RowMapper<CategoriaEmpresa> {

	@Override
	public CategoriaEmpresa mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoriaEmpresa categoriaEmpresa= new CategoriaEmpresa();
		//categoriaEmpresa.setIdCategoriaEmpresa(rs.getInt("idCategoriaEmpresa"));
		categoriaEmpresa.setNombre_categoria(rs.getString("nombre_categoria"));
		categoriaEmpresa.setDescripcion_categoria(rs.getString("descripcion_categoria"));
		categoriaEmpresa.setPorcentajebusqueda(rs.getFloat("porcentajebusqueda"));
		categoriaEmpresa.setUrl_imagen_categoria(rs.getString("url_imagen_categoria"));
		return categoriaEmpresa;
	}

}
