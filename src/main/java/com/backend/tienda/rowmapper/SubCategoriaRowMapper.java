package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.SubCategoria;

public class SubCategoriaRowMapper implements RowMapper<SubCategoria>{

	@Override
	public SubCategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		SubCategoria subCategoria=new SubCategoria();
		subCategoria.setIdsubcategoria(rs.getInt("idsubcategoria"));
		subCategoria.setIdcategoria(rs.getInt("idcategoria"));
		subCategoria.setNombresubcategoria(rs.getString("nombresubcategoria"));
		subCategoria.setUrisubcategoria(rs.getString("urisubcategoria"));
		subCategoria.setDetalle(rs.getString("detalle"));
		return subCategoria;
	}

}
