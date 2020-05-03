package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Mesa;

public class MesaRowMapper implements RowMapper<Mesa> {

	@Override
	public Mesa mapRow(ResultSet row, int rowNum) throws SQLException {
		Mesa mesa=new Mesa();
		mesa.setIdMesa(row.getInt("idMesa"));
		mesa.setMesa_estado(row.getString("Mesa_estado"));
		mesa.setMesa_capacidad(row.getInt("Mesa_capacidad"));
		mesa.setMesa_numero(row.getInt("Mesa_numero"));
		return mesa;
	}

}
