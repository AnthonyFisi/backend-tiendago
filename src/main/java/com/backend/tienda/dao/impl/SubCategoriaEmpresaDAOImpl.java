package com.backend.tienda.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.backend.tienda.dao.SubCategoriaEmpresaDAO;
import com.backend.tienda.entity.SubCategoriaEmpresa;
import com.backend.tienda.rowmapper.SubCategoriaEmpresaRowMapper;

@Transactional
@Repository
public class SubCategoriaEmpresaDAOImpl implements SubCategoriaEmpresaDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;	

	@Override
	public List<SubCategoriaEmpresa> listaSubCategoriaEmpresaByIdCategoria(int idCategoriaEmpresa) {
		String sql="SELECT idsubcategoriaempresa,idcategoriaempresa, nombre_subcategoria,descripcion_subcategoria,porcentajebusqueda,url_imagen_subcategoria"
				+ " FROM subcategoriaempresa"
				+ " WHERE idcategoriaempresa = ? ";
		
		RowMapper<SubCategoriaEmpresa> rowMapper=new SubCategoriaEmpresaRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper,idCategoriaEmpresa);
	}

}
