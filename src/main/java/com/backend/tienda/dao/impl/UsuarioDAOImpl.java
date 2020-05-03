package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.UsuarioDAO;
import com.backend.tienda.entity.Usuario;
import com.backend.tienda.rowmapper.UsuarioRowMapper;


@Transactional
@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public boolean eliminarUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> listaUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario mostrarByUsuario(int idUsuario) {
		String sql="SELECT idusuario,usuario_nombre,usuario_correo,usuario_contraseña,usuario_apellido,usuario_foto,usuario_celular FROM usuario " + 
				" WHERE idusuario = ? ";
		RowMapper<Usuario> rowMapper= new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario usuario= this.jdbcTemplate.queryForObject(sql, rowMapper,idUsuario);
		return usuario;
	}

	@Override
	public int añadirUsuario(Usuario usuario) {
		String sql="INSERT INTO usuario  ("
				+ " usuario_nombre,"
				+ " usuario_correo,"
				+ " usuario_contraseña,"
				+ " usuario_apellido,"
				+ " usuario_foto,"
				+ " usuario_celular ) VALUES(?,?,?,?,?,?) ";
		
		
		return jdbcTemplate.update(sql,
									usuario.getUsuario_nombre(),
									usuario.getUsuario_correo(),
									usuario.getUsuario_contraseña(),
									usuario.getUsuario_apellido(),
									usuario.getUsuario_foto(),
									usuario.getUsuario_celular());
	}

	@Override
	public Usuario mostrarUsuarioByCorreo(String correo) {
		String sql="SELECT idusuario,usuario_nombre,usuario_correo,usuario_contraseña,usuario_apellido,usuario_foto,usuario_celular FROM usuario " + 
				" WHERE usuario_correo = ? ";
		RowMapper<Usuario> rowMapper= new BeanPropertyRowMapper<Usuario>(Usuario.class);
		Usuario usuario= this.jdbcTemplate.queryForObject(sql, rowMapper,correo);
		return usuario;
	}

}
