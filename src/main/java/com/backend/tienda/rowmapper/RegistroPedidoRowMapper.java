package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.RegistroPedido;

public class RegistroPedidoRowMapper implements RowMapper<RegistroPedido> {

	@Override
	public RegistroPedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegistroPedido registroPedido=new RegistroPedido();
		registroPedido.setIdpedido(rs.getInt("idpedido"));
		registroPedido.setIdpedido(rs.getInt("idpedido"));
		registroPedido.setRegistropedido_cantidad(rs.getInt("registropedido_cantidad"));
		registroPedido.setRegistropedido_preciototal(rs.getFloat("registropedido_preciototal"));
		registroPedido.setRegistropedido_detalles(rs.getString("registropedido_detalles"));
		registroPedido.setRegistropedido_idoferta(rs.getString("registropedido_idoferta"));
		return registroPedido;
	}

}
