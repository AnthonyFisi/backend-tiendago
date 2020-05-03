package com.backend.tienda.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.HorarioDAO;
import com.backend.tienda.entity.Horario;
import com.backend.tienda.rowmapper.HorarioRowMapper;


@Transactional
@Repository
public class HorarioDAOImpl implements HorarioDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Horario> listaHorarios() {
		String sql="SELECT idhorario, horario_nombre FROM horario";
		RowMapper<Horario>  listHorario= new HorarioRowMapper();
		List<Horario> list=jdbcTemplate.query(sql,listHorario);
		try {
			jdbcTemplate.getDataSource().getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	

}
