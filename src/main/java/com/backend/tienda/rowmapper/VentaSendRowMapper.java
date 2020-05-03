package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.VentaSend;

public class VentaSendRowMapper implements RowMapper<VentaSend> {

	@Override
	public VentaSend mapRow(ResultSet rs, int rowNum) throws SQLException {
		VentaSend venta=new VentaSend();
		venta.setVenta_fecha(rs.getString("venta_fecha"));
		venta.setVenta_estadoPago(rs.getString("venta_estadoPago"));
		venta.setVenta_fechaEntrega(rs.getString("venta_fechaEntrega"));
		venta.setVenta_costodelivery(rs.getFloat("venta_costodelivery"));
		venta.setVenta_costoTotal(rs.getFloat("venta_costoTotal"));
		venta.setIdPedido(rs.getInt("idPedido"));
		venta.setIdtipopago(rs.getInt("idtipopago"));
		venta.setIdubicacion(rs.getInt("idubicacion"));
		venta.setIdhorario(rs.getInt("idhorario"));
		venta.setComentario(rs.getString("comentario"));

		return venta;
	}

}
