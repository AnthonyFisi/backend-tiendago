package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.TipoCuenta;

public class TipoCuentaRowMapper  implements RowMapper<TipoCuenta>{

	@Override
	public TipoCuenta mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoCuenta tipoCuenta= new TipoCuenta();
		tipoCuenta.setIdtipocuenta(rs.getInt("idtipocuenta"));
		tipoCuenta.setNombrecuenta(rs.getString("nombrecuenta"));
		return tipoCuenta;
	}

}
