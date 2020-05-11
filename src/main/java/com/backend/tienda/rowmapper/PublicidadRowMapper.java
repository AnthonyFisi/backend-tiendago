package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Publicidad;

public class PublicidadRowMapper implements RowMapper<Publicidad>{

	@Override
	public Publicidad mapRow(ResultSet rs, int rowNum) throws SQLException {
		Publicidad publicidad=new Publicidad();
		publicidad.setIdpublicidad(rs.getInt("idpublicidad"));
		publicidad.setDetalle_publicidad(rs.getString("detalle_publicidad"));
		publicidad.setUrl_imagen_publicidad(rs.getString("url_imagen_publicidad"));
		return publicidad;
	}

}
