package com.backend.tienda.dao.impl;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.PedidoDAO;
import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Pedido2;

@Transactional
@Repository
public class PedidoDAOImpl  implements PedidoDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void agregarPedido(Pedido pedido) {
		String sql="INSERT INTO pedido ( "
				+ "pedido_estado,pedido_montototal,"
				+ "pedido_cantidadtotal,pedido_fecha_registro,ubicacion_idubicacion,usuario_idusuario ,"
				+ "pedido_estadopago,tipopago_idtipopago,horario_idhorario) values (?,?,?,?,?,?,?,?,?)";
		
		
		this.jdbcTemplate.update(sql,
				pedido.getPedido_estado(),
				pedido.getPedido_montototal(),
		pedido.getPedido_cantidadtotal(),
		Calendar.getInstance(),
		pedido.getUbicacion_idubicacion(),
		pedido.getUsuario_idusuario(),
		pedido.getPedido_estadopago(),
		pedido.getTipopago_idtipopago(),
		pedido.getHorario_idhorario()
				);
		
	}

	@Override
	public int actualizarEstadoPedido(int idPedido) {
		String sql="UPDATE pedido SET pedido_estado = 'Atendido' WHERE idpedido = ? ";
		return this.jdbcTemplate.update(sql,idPedido);
		
	}

	@Override
	public Pedido mostrarPedido(int idPedido) {
		String sql="select idpedido,pedido_estado,pedido_montototal, " + 
				"				pedido_cantidadtotal,pedido_fecha_registro,ubicacion_idubicacion,usuario_idusuario, " + 
				"			    pedido_estadopago,tipopago_idtipopago,horario_idhorario FROM pedido  "
								+ " WHERE idPedido = ? ";
		RowMapper<Pedido> rowMapper = new BeanPropertyRowMapper<Pedido>(Pedido.class);
		Pedido pedido=this.jdbcTemplate.queryForObject(sql,rowMapper,idPedido);
		return pedido;
	}

	@Override
	public void eliminarPedido(int pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido findByidUsuario(int idUsuario) {
		String sql="select idpedido,pedido_estado,pedido_montototal, " + 
				"				pedido_cantidadtotal,pedido_fecha_registro,ubicacion_idubicacion,usuario_idusuario, " + 
				"			    pedido_estadopago,tipopago_idtipopago,horario_idhorario FROM pedido "
				+ "WHERE Usuario_idUsuario = ? "
				+ " ORDER BY Pedido_fecha_registro DESC LIMIT 1";
		RowMapper<Pedido> rowMapper= new BeanPropertyRowMapper<Pedido>(Pedido.class);
		Pedido pedido=this.jdbcTemplate.queryForObject(sql, rowMapper,idUsuario);
		return pedido;
	}
	

	@Override
	public Pedido agregarPedidocarrito(Pedido pedido) {
		String sql="INSERT INTO pedido ( "
				+ "pedido_estado,pedido_montototal,"
				+ "pedido_cantidadtotal,pedido_fecha_registro,ubicacion_idubicacion,usuario_idusuario ,"
				+ "pedido_estadopago,tipopago_idtipopago,horario_idhorario) values (?,?,?,?,?,?,?,?,?)";
		
		
		this.jdbcTemplate.update(sql,
				pedido.getPedido_estado(),
				pedido.getPedido_montototal(),
		pedido.getPedido_cantidadtotal(),
		Calendar.getInstance(),
		pedido.getUbicacion_idubicacion(),
		pedido.getUsuario_idusuario(),
		pedido.getPedido_estadopago(),
		pedido.getTipopago_idtipopago(),
		pedido.getHorario_idhorario()
				);
		
		
		String sql2="select idpedido,pedido_estado,pedido_montototal, " + 
				"				pedido_cantidadtotal,pedido_fecha_registro,ubicacion_idubicacion,usuario_idusuario ," + 
				"			    pedido_estadopago,tipopago_idtipopago,horario_idhorario FROM pedido WHERE Usuario_idUsuario = ? "
				+ " ORDER BY Pedido_fecha_registro DESC LIMIT 1";
		RowMapper<Pedido> rowMapper= new BeanPropertyRowMapper<Pedido>(Pedido.class);
		Pedido pedido2=this.jdbcTemplate.queryForObject(sql2, rowMapper,pedido.getUsuario_idusuario());
		return pedido2;
	}

	@Override
	public int actualizarPrecioTotalPedido( float precioTotal,int cantidadTotal,int idPedido) {
		String sql="UPDATE pedido SET pedido_montototal = ? ,  pedido_cantidadtotal = ? WHERE idpedido = ?";
		return this.jdbcTemplate.update(sql,precioTotal,cantidadTotal,idPedido);
	}

	@Override
	public Pedido2 mostrar(int pedido) {
		String sql="select idpedido,pedido_estado,pedido_montototal, " + 
				"				pedido_cantidadtotal,ubicacion_idubicacion,usuario_idusuario, " + 
				"			    pedido_estadopago,tipopago_idtipopago,horario_idhorario FROM pedido  "
								+ " WHERE idPedido = ? ";
		RowMapper<Pedido2> rowMapper = new BeanPropertyRowMapper<Pedido2>(Pedido2.class);
		Pedido2 Pedido=this.jdbcTemplate.queryForObject(sql,rowMapper,pedido);
		return Pedido;
	}

	@Override
	public Pedido findByidUsuarioListaPedido(int idUsuario) {
		String sql="select idpedido,pedido_estado,pedido_montototal, " + 
				"				pedido_cantidadtotal,pedido_fecha_registro,ubicacion_idubicacion,usuario_idusuario, " + 
				"			    pedido_estadopago,tipopago_idtipopago,horario_idhorario FROM pedido "
				+ "WHERE Usuario_idUsuario = ?   and  pedido_estado = 'Atendido' "
				+ " ORDER BY Pedido_fecha_registro DESC LIMIT 1";
		RowMapper<Pedido> rowMapper= new BeanPropertyRowMapper<Pedido>(Pedido.class);
		Pedido pedido=this.jdbcTemplate.queryForObject(sql, rowMapper,idUsuario);
		return pedido;
	}

	@Override
	public Pedido findByidUsuarioAutenticacion(int idUsuario) {
		String sql="select idpedido,pedido_estado,pedido_montototal, " + 
				"				pedido_cantidadtotal,pedido_fecha_registro,ubicacion_idubicacion,usuario_idusuario, " + 
				"			    pedido_estadopago,tipopago_idtipopago,horario_idhorario FROM pedido "
				+ "WHERE Usuario_idUsuario = ? AND pedido_estado = 'NoAtendido' "
				+ " ORDER BY Pedido_fecha_registro DESC LIMIT 1";
		RowMapper<Pedido> rowMapper= new BeanPropertyRowMapper<Pedido>(Pedido.class);
		Pedido pedido=this.jdbcTemplate.queryForObject(sql, rowMapper,idUsuario);
		return pedido;
	}

}
