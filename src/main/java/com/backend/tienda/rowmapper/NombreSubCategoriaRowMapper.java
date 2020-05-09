package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.NombreSubcategoria;

public class NombreSubCategoriaRowMapper  implements RowMapper<NombreSubcategoria>{

	@Override
	public NombreSubcategoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		NombreSubcategoria nombreSubCategoria= new NombreSubcategoria();
		nombreSubCategoria.setIdnombresubcategoria(rs.getInt("idnombresubcategoria"));
		nombreSubCategoria.setIdempresa(rs.getInt("idempresa"));
		nombreSubCategoria.setProductospopulares(rs.getString("productospopulares"));
		nombreSubCategoria.setOfertas(rs.getString("ofertas"));
		nombreSubCategoria.setCategoria1(rs.getString("categoria1"));
		nombreSubCategoria.setCategoria2(rs.getString("categoria2"));
		nombreSubCategoria.setCategoria3(rs.getString("categoria3"));
		
		return nombreSubCategoria;
	}

}
