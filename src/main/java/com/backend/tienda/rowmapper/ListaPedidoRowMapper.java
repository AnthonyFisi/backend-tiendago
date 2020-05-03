package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.ListaPedido;

public class ListaPedidoRowMapper implements RowMapper<ListaPedido> {

		@Override
	public ListaPedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		ListaPedido listaPedido=new ListaPedido();
		listaPedido.setIdpedido(rs.getInt("idpedido"));
		listaPedido.setVenta_estadopago(rs.getString("venta_estadopago"));
		listaPedido.setVenta_fechaentrega(rs.getString("venta_fechaentrega"));
		listaPedido.setVenta_costodelivery(rs.getString("venta_costodelivery"));
		listaPedido.setVenta_costototal(rs.getFloat("venta_costototal"));
		listaPedido.setTipopago_nombre(rs.getString("tipopago_nombre"));
		listaPedido.setUbicacion_nombre(rs.getString("ubicacion_nombre"));
		listaPedido.setHorario_nombre(rs.getString("horario_nombre"));
	
		return listaPedido;
	}

}
