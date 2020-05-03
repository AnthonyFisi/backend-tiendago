package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario=new Usuario();
		usuario.setIdusuario(rs.getInt("idusuario"));
		usuario.setUsuario_nombre(rs.getString("usuario_nombre"));
		usuario.setUsuario_correo(rs.getString("usuario_correo"));
		usuario.setUsuario_contraseña(rs.getString("usuario_contraseña"));
		usuario.setUsuario_apellido(rs.getString("usuario_apellido"));
		usuario.setUsuario_foto(rs.getString("usuario_foto"));
		usuario.setUsuario_celular(rs.getString("usuario_celular"));
		
		return usuario;
	}

}
