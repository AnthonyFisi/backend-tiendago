package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.UbicacionDAO;
import com.backend.tienda.entity.Ubicacion;
import com.backend.tienda.rowmapper.UbicacionRowMapper;

@Transactional
@Repository
public class UbicacionDAOImpl implements UbicacionDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Ubicacion> listaUbicacion(int idUsuario) {
		String sql="SELECT u.idubicacion,u.ubicacion_nombre,u.ubicacion_comentarios ,u.idusuario,u.ubicacion_estado,u.eliminado" + 
				"         FROM ubicacion AS u JOIN usuario AS us ON  u.idusuario=us.idusuario  " + 
				"          WHERE us.idusuario = ? and u.eliminado=FALSE and u.ubicacion_estado='desactivo' ";
		
		RowMapper<Ubicacion> rowMapper= new UbicacionRowMapper();
		return jdbcTemplate.query(sql,rowMapper,idUsuario);
	}


	@Override
	public int registrarUbicacion(Ubicacion ubicacion) {
		String sql="INSERT INTO ubicacion(ubicacion_nombre,ubicacion_comentarios,idusuario,ubicacion_estado,eliminado) " + 
				"VALUES (?,?,?,?,?);";
		
		return jdbcTemplate.update(sql,
				ubicacion.getUbicacion_nombre(),
				ubicacion.getUbicacion_comentarios(),
				ubicacion.getIdusuario(),
				ubicacion.getUbicacion_estado(),
				ubicacion.getEliminado()
				);
	}


	@Override
	public Ubicacion findByIdUsuarioAndIdUbicacion(int idUsuario) {
		String sql="SELECT u.idubicacion,u.ubicacion_nombre,u.ubicacion_comentarios ,u.idusuario,u.ubicacion_estado,u.eliminado" + 
				"         FROM ubicacion AS u JOIN usuario AS us ON  u.idusuario=us.idusuario  " + 
				"          WHERE us.idusuario = ?  and u.ubicacion_estado= 'activo' ";
		
		RowMapper<Ubicacion> rowMapper= new BeanPropertyRowMapper<Ubicacion>(Ubicacion.class);
		
		return jdbcTemplate.queryForObject(sql,rowMapper,idUsuario);
	}

	
	@Override
	public int actualizarEstadoUbicacionDesactivo(int idUsuario) {
		String sql="UPDATE ubicacion SET ubicacion_estado='desactivo' WHERE idusuario = ? ";
		return jdbcTemplate.update(sql,idUsuario);
	}

	@Override
	public int actualizarEstadoUbicacionActivo(int idUbicacion) {
		String sql="UPDATE ubicacion SET ubicacion_estado='activo' WHERE idubicacion = ? ";
		return jdbcTemplate.update(sql,idUbicacion);
	}


	@Override
	public int eliminarUbicacion(int idUbicacion) {
		String sql="UPDATE ubicacion SET eliminado=TRUE  WHERE idubicacion = ? ";
		return jdbcTemplate.update(sql,idUbicacion);
	}


	@Override
	public Ubicacion findByIdUbicacion(int idUbicacion) {
		String sql="SELECT idubicacion,ubicacion_nombre,ubicacion_comentarios ,idusuario,ubicacion_estado,eliminado" + 
				"         FROM ubicacion  " + 
				"          WHERE  idubicacion =  ? and  ubicacion_estado='activo' ";
		
		RowMapper<Ubicacion> rowMapper= new BeanPropertyRowMapper<Ubicacion>(Ubicacion.class);
		
		return jdbcTemplate.queryForObject(sql,rowMapper,idUbicacion);
	}
	
	

}
