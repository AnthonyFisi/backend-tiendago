package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.ListaPedidoDAO;
import com.backend.tienda.entity.ListaPedido;
import com.backend.tienda.rowmapper.ListaPedidoRowMapper;

@Transactional
@Repository
public class ListaPedidoDAOImpl implements ListaPedidoDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ListaPedido> mostrarListaPedidoByIdUsuario(int idUsuario, int idPedido) {
		/*String sql="select p.idProducto,p.producto_nombre,p.producto_marca ,p.producto_envase,p.producto_detalle,p.producto_cantidad,p.Producto_precio," + 
				"         rpe.registropedido_cantidad,rpe.registropedido_preciototal,p.producto_uri_imagen,v.venta_estadopago," + 
				"		to_char( v.venta_fechaentrega ,'YYYY-MM-DD HH24:MI:SS') AS venta_fechaentrega,v.venta_costodelivery,v.venta_costototal,v.venta_costodelivery," + 
				"		 tp.tipopago_nombre,to_char(pe.pedido_fecha_registro,'YYYY-MM-DD HH24:MI:SS') AS pedido_fecha_registro" + 
				"         from  producto as p  JOIN registropedido as rpe ON rpe.idproducto=p.idproducto   " + 
				"            JOIN pedido as pe ON pe.idpedido=rpe.idpedido    " + 
				"        	JOIN venta AS v ON V.idpedido=pe.idpedido" + 
				"			JOIN tipopago AS tp ON tp.idtipopago=v.idtipopago" + 
				"         where pe.usuario_idusuario = ? and pe.idpedido = ? and pe.pedido_estado='Atendido'   " ;
		RowMapper<ListaPedido> rowMapper= new ListaPedidoRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper,idUsuario,idPedido);*/
		return null;
	}

	@Override
	public List<ListaPedido> mostrarListaByIdUsuario(int idUsuario) {
		String sql="SELECT  	pe.idpedido ," + 
				"			v.venta_estadopago,  " + 
				"           to_char( v.venta_fechaentrega ,'YYYY-MM-DD HH24:MI:SS') AS venta_fechaentrega," + 
				"		   v.venta_costodelivery," + 
				"		   v.venta_costototal," + 
				"		   tp.tipopago_nombre," + 
				"		   u.ubicacion_nombre," + 
				"		   h.horario_nombre" + 
				"             FROM  pedido as pe JOIN  venta AS v ON pe.idpedido=v.idpedido    " + 
				"             JOIN tipopago AS tp ON tp.idtipopago=v.idtipopago  " + 
				"			 JOIN ubicacion AS u ON u.idubicacion=v.idubicacion" + 
				"			 JOIN horario AS h ON h.idhorario=v.idhorario" + 
				"                 WHERE pe.usuario_idusuario = ?   AND pe.pedido_estado='Atendido' AND   v.venta_estadopago='SinCancelar'" + 
				"				 ORDER BY v.venta_fechaentrega DESC " ;
		RowMapper<ListaPedido> rowMapper= new ListaPedidoRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper,idUsuario);
	}

	@Override
	public List<ListaPedido> mostrarListaByIdUsuarioHoy(int idUsuario) {
		String sql="SELECT  	pe.idpedido ," + 
				"			v.venta_estadopago,  " + 
				"           to_char( v.venta_fechaentrega ,'YYYY-MM-DD HH24:MI:SS') AS venta_fechaentrega," + 
				"		   v.venta_costodelivery," + 
				"		   v.venta_costototal," + 
				"		   tp.tipopago_nombre," + 
				"		   u.ubicacion_nombre," + 
				"		   h.horario_nombre" + 
				"             FROM  pedido as pe JOIN  venta AS v ON pe.idpedido=v.idpedido    " + 
				"             JOIN tipopago AS tp ON tp.idtipopago=v.idtipopago  " + 
				"			 JOIN ubicacion AS u ON u.idubicacion=v.idubicacion" + 
				"			 JOIN horario AS h ON h.idhorario=v.idhorario" + 
				"                 WHERE pe.usuario_idusuario = ?   AND pe.pedido_estado='Atendido' AND   v.venta_estadopago='SinCancelar'  AND v.venta_fechaentrega::timestamp::date >= current_date" + 
				"				 ORDER BY v.venta_fechaentrega ASC " ;
		RowMapper<ListaPedido> rowMapper= new ListaPedidoRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper,idUsuario);
	}

	@Override
	public List<ListaPedido> mostrarListaByIdUsuarioPendiente(int idUsuario) {
		String sql="SELECT  	pe.idpedido ," + 
				"			v.venta_estadopago,  " + 
				"           to_char( v.venta_fechaentrega ,'YYYY-MM-DD HH24:MI:SS') AS venta_fechaentrega," + 
				"		   v.venta_costodelivery," + 
				"		   v.venta_costototal," + 
				"		   tp.tipopago_nombre," + 
				"		   u.ubicacion_nombre," + 
				"		   h.horario_nombre" + 
				"             FROM  pedido as pe JOIN  venta AS v ON pe.idpedido=v.idpedido    " + 
				"             JOIN tipopago AS tp ON tp.idtipopago=v.idtipopago  " + 
				"			 JOIN ubicacion AS u ON u.idubicacion=v.idubicacion" + 
				"			 JOIN horario AS h ON h.idhorario=v.idhorario" + 
				"                 WHERE pe.usuario_idusuario = ?   AND pe.pedido_estado='Atendido' AND   v.venta_estadopago='SinCancelar'  AND v.venta_fechaentrega::timestamp::date > current_date" + 
				"				 ORDER BY v.venta_fechaentrega DESC " ;
		RowMapper<ListaPedido> rowMapper= new ListaPedidoRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper,idUsuario);
	}

	@Override
	public List<ListaPedido> mostrarListaByIdUsuarioHistorial(int idUsuario) {
		String sql="SELECT  	pe.idpedido ," + 
				"			v.venta_estadopago,  " + 
				"           to_char( v.venta_fechaentrega ,'YYYY-MM-DD HH24:MI:SS') AS venta_fechaentrega," + 
				"		   v.venta_costodelivery," + 
				"		   v.venta_costototal," + 
				"		   tp.tipopago_nombre," + 
				"		   u.ubicacion_nombre," + 
				"		   h.horario_nombre" + 
				"             FROM  pedido as pe JOIN  venta AS v ON pe.idpedido=v.idpedido    " + 
				"             JOIN tipopago AS tp ON tp.idtipopago=v.idtipopago  " + 
				"			 JOIN ubicacion AS u ON u.idubicacion=v.idubicacion" + 
				"			 JOIN horario AS h ON h.idhorario=v.idhorario" + 
				"                 WHERE pe.usuario_idusuario = ?   AND pe.pedido_estado='Atendido' AND   v.venta_estadopago='Cancelado'  " + 
				"				 ORDER BY v.venta_fechaentrega ASC " ;
		RowMapper<ListaPedido> rowMapper= new ListaPedidoRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper,idUsuario);
	}
	
	
	
	
	

}
