package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.PedidoSend;

public class PedidoSendRowMapper implements RowMapper<PedidoSend>{

	@Override
	public PedidoSend mapRow(ResultSet rs, int rowNum) throws SQLException {
		PedidoSend pedidoSend=new PedidoSend();
		pedidoSend.setIdProducto(rs.getInt("idProducto"));
		pedidoSend.setCantidad(rs.getInt("cantidad"));
		pedidoSend.setPrecio(rs.getFloat("precio"));
		pedidoSend.setIdUsuario(rs.getInt("idUsuario"));
		return pedidoSend;
	}

}
