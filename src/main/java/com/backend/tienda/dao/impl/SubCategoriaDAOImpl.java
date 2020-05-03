package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.SubCategoriaDAO;
import com.backend.tienda.entity.SubCategoria;
import com.backend.tienda.rowmapper.SubCategoriaRowMapper;


@Transactional
@Repository
public class SubCategoriaDAOImpl  implements SubCategoriaDAO{
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<SubCategoria> listaSubcategoria() {
		String sql="select idsubcategoria," + 
				"		idcategoria," + 
				"		nombresubcategoria," + 
				"		urisubcategoria," + 
				"		detalle" + 
				"		FROM subcategoria" ;
	RowMapper<SubCategoria> rowMapper= new SubCategoriaRowMapper();
		
		return jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public List<SubCategoria> listaSubCategoriaByidCategoria(int idCategoria) {
		String sql="select idsubcategoria," + 
				"		idcategoria," + 
				"		nombresubcategoria," + 
				"		urisubcategoria," + 
				"		detalle" + 
				"		FROM subcategoria" + 
				"		WHERE idcategoria= ? ";
		
		RowMapper<SubCategoria> rowMapper= new SubCategoriaRowMapper();
		
		return jdbcTemplate.query(sql,rowMapper,idCategoria);
		
	}

}
