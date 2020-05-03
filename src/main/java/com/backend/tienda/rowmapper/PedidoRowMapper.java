package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Pedido;



public class PedidoRowMapper implements RowMapper<Pedido>{

	@Override
	public Pedido mapRow(ResultSet row, int rowNum) throws SQLException {
		Pedido pedido=new Pedido();
		pedido.setIdpedido(row.getInt("idpedido"));
		pedido.setPedido_estado(row.getString("Pedido_estado"));
		pedido.setPedido_montototal(row.getFloat("pedido_montototal"));
		pedido.setPedido_fecha_registro(row.getDate("pedido_fecha_registro"));
		pedido.setUbicacion_idubicacion(row.getInt("ubicacion_idubicacion"));;
		pedido.setUsuario_idusuario(row.getInt("usuario_idusuario"));
		pedido.setPedido_estadopago(row.getString("pedido_estadopago"));
		pedido.setTipopago_idtipopago(row.getInt("tipopago_idtipopago"));
		pedido.setHorario_idhorario(row.getInt("horario_idhorario"));	
		return pedido;
	}

}
