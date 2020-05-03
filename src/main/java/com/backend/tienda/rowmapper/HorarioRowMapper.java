package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Horario;

public class HorarioRowMapper implements RowMapper<Horario> {

	@Override
	public Horario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Horario horario= new Horario();
		horario.setIdHorario(rs.getInt("idHorario"));
		horario.setHorario_nombre(rs.getString("horario_nombre"));
		
		return horario;
	}

}
