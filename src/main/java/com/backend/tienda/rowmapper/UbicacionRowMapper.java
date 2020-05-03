package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Ubicacion;

public class UbicacionRowMapper implements RowMapper<Ubicacion> {
	
	@Override
	public Ubicacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ubicacion ubicacion= new Ubicacion();
		ubicacion.setIdubicacion(rs.getInt("idubicacion"));
		ubicacion.setUbicacion_nombre(rs.getString("ubicacion_nombre"));
		ubicacion.setUbicacion_comentarios(rs.getString("ubicacion_comentarios"));
		ubicacion.setIdusuario(rs.getInt("idusuario"));
		ubicacion.setUbicacion_estado(rs.getString("ubicacion_estado"));
		ubicacion.setEliminado(rs.getBoolean("eliminado"));
		return ubicacion;
	}

}
