package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Venta;

public class VentaRowMapper implements RowMapper<Venta> {

	@Override
	public Venta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Venta venta=new Venta();
		venta.setIdventa(rs.getInt("idventa"));
		venta.setVenta_fecha(rs.getTimestamp("venta_fecha"));
		venta.setVenta_estadoPago(rs.getString("venta_estadoPago"));
		venta.setVenta_fechaEntrega(rs.getTimestamp("venta_fechaEntrega"));
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
