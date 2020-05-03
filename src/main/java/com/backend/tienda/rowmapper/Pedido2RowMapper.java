package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Pedido2;



public class Pedido2RowMapper implements RowMapper<Pedido2>{

	@Override
	public Pedido2 mapRow(ResultSet row, int rowNum) throws SQLException {
		Pedido2 pedido=new Pedido2();
		pedido.setIdpedido(row.getInt("idpedido"));
		pedido.setPedido_estado(row.getString("Pedido_estado"));
		return pedido;
	}

}