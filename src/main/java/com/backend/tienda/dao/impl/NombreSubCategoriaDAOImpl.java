package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.NombreSubCategoriaDAO;
import com.backend.tienda.entity.NombreSubcategoria;
import com.backend.tienda.rowmapper.NombreSubCategoriaRowMapper;

@Transactional
@Repository
public class NombreSubCategoriaDAOImpl  implements NombreSubCategoriaDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<NombreSubcategoria> listaNombreSubCategoria() {
		String sql="SELECT idnombresubcategoria,productospopulares,ofertas,categoria1,categoria2,categoria3,idempresa FROM nombresubcategoria";
		RowMapper<NombreSubcategoria> rowMapper=new NombreSubCategoriaRowMapper();
		return jdbcTemplate.query(sql, rowMapper);
	}

}
