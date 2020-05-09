package com.backend.tienda.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.backend.tienda.dao.TipoCuentaDAO;
import com.backend.tienda.entity.TipoCuenta;
import com.backend.tienda.rowmapper.TipoCuentaRowMapper;

@Transactional
@Repository
public class TipoCuentaDAOImpl implements TipoCuentaDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<TipoCuenta> listaTipoCuenta() {
		String sql="SELECT idtipocuenta, nombrecuenta FROM tipocuenta";
		RowMapper<TipoCuenta> rowMapper=new TipoCuentaRowMapper();
		
		return jdbcTemplate.query(sql,rowMapper);
	}
	
	

}
