package com.backend.tienda.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.backend.tienda.dao.MesaDAO;
import com.backend.tienda.entity.Mesa;
import com.backend.tienda.rowmapper.MesaRowMapper;

@Transactional
@Repository
public class MesaDAOImpl implements MesaDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void añadirMesa(Mesa mesa) {
		String sql="insert into Mesa(idMesa,Mesa_estado,Mesa_capacidad,Mesa_numero) values (?,?,?,?)";
		this.jdbcTemplate.update(sql,mesa.getIdMesa(),mesa.getMesa_estado(),mesa.getMesa_capacidad(),mesa.getMesa_numero());
	}

	@Override
	public boolean eliminarMesa(int idMesa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizaMesa(int idMesa) {
		// TODO Auto-generated method stubthis
		return false;
	}

	@Override
	public List<Mesa> listaMesa() {
		String sql= "Select idMesa,Mesa_estado,Mesa_capacidad,Mesa_numero FROM Mesa";
		RowMapper<Mesa> rowMapper= new MesaRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper);

	}

}
