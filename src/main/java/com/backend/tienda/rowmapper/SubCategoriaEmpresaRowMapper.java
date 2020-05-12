package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.SubCategoriaEmpresa;

public class SubCategoriaEmpresaRowMapper implements RowMapper<SubCategoriaEmpresa> {

	@Override
	public SubCategoriaEmpresa mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubCategoriaEmpresa subCategoriaEmpresa =new SubCategoriaEmpresa();

		//subCategoriaEmpresa.setIdCategoriaEmpresa(rs.getInt("idcategoriaempresa"));
		subCategoriaEmpresa.setNombre_subcategoria(rs.getString("nombre_subcategoria"));
		subCategoriaEmpresa.setDescripcion_subcategoria(rs.getString("descripcion_subcategoria"));
		subCategoriaEmpresa.setPorcentajebusqueda(rs.getFloat("porcentajebusqueda"));
		subCategoriaEmpresa.setUrl_imagen_subcategoria(rs.getString("url_imagen_subcategoria"));
		return subCategoriaEmpresa;
	}

}
