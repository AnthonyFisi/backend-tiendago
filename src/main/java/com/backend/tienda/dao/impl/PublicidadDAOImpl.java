package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.PublicidadDAO;
import com.backend.tienda.entity.Publicidad;
import com.backend.tienda.rowmapper.PublicidadRowMapper;

@Transactional
@Repository
public class PublicidadDAOImpl implements PublicidadDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Publicidad> listaPublicidad() {
		String sql="SELECT idpublicidad,detalle_publicidad,url_imagen_publicidad FROM publicidad";
		RowMapper<Publicidad> rowMapper=new PublicidadRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
