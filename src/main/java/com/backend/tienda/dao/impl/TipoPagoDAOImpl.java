package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.TipoPagoDAO;
import com.backend.tienda.entity.TipoPago;
import com.backend.tienda.rowmapper.TipoPagoRowMapper;

@Transactional
@Repository
public class TipoPagoDAOImpl implements TipoPagoDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void registrarTipoPago(TipoPago tipoPago) {
		
		
	}

	@Override
	public List<TipoPago> listaTipoPago() {
		String sql="SELECT idtipopago, tipopago_nombre FROM tipopago";
		RowMapper<TipoPago> rowMapper= new TipoPagoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
