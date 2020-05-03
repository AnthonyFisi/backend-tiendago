package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.TipoPago;

public class TipoPagoRowMapper implements RowMapper<TipoPago> {

	@Override
	public TipoPago mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoPago tipoPago=new TipoPago();
		tipoPago.setIdtipopago(rs.getInt("idtipopago"));
		tipoPago.setTipopago_nombre(rs.getString("tipopago_nombre"));
		return tipoPago;
	}

}
