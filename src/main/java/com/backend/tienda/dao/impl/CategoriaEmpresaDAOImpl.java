package com.backend.tienda.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.backend.tienda.dao.CategoriaEmpresaDAO;
import com.backend.tienda.entity.CategoriaEmpresa;
import com.backend.tienda.rowmapper.CategoriaEmpresaRowMapper;

@Transactional 
@Repository
public class CategoriaEmpresaDAOImpl implements CategoriaEmpresaDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CategoriaEmpresa> listaCategoriaEmpresa() {
		String sql="SELECT idcategoriaempresa, nombre_categoria,descripcion_categoria,porcentajebusqueda,url_imagen_categoria FROM categoriaempresa";		
		RowMapper<CategoriaEmpresa> rowMapper= new CategoriaEmpresaRowMapper();
		return jdbcTemplate.query(sql,rowMapper);
	}

}
