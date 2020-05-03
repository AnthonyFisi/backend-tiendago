package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.CarritoDAO;
import com.backend.tienda.entity.Carrito;
import com.backend.tienda.rowmapper.CarritoRowMapper;

@Transactional
@Repository
public class CarritoDAOImpl implements CarritoDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Carrito> listaCompras(int idUsuario,int idPedido) {
			String sql="select p.idProducto,p.producto_nombre,p.producto_marca ,p.producto_envase,p.producto_detalle,p.producto_cantidad,p.Producto_precio," + 
					"            rpe.registropedido_cantidad,rpe.registropedido_preciototal,p.producto_uri_imagen" + 
					"             from  producto as p  JOIN registropedido as rpe ON rpe.idproducto=p.idproducto   " + 
					"            JOIN pedido as pe ON pe.idpedido=rpe.idpedido    " + 
					"            where pe.usuario_idusuario = ?  and pe.idpedido = ? and pe.pedido_estado='NoAtendido'   " + 
					"             order by pe.pedido_fecha_registro ";
		
		RowMapper<Carrito> rowMapper= new CarritoRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper,idUsuario,idPedido);
	}


	@Override
	public List<Carrito> listaComprasRealizada(int idPedido) {
		String sql="select p.idProducto,p.producto_nombre,p.producto_marca ,p.producto_envase,p.producto_detalle,p.producto_cantidad,p.Producto_precio," + 
				"            rpe.registropedido_cantidad,rpe.registropedido_preciototal,p.producto_uri_imagen" + 
				"             from  producto as p  JOIN registropedido as rpe ON rpe.idproducto=p.idproducto   " + 
				"            JOIN pedido as pe ON pe.idpedido=rpe.idpedido   " + 
				"            where pe.idpedido = ?    and  pe.pedido_estado='Atendido'" + 
				"             order by pe.pedido_fecha_registro ";
	
	RowMapper<Carrito> rowMapper= new CarritoRowMapper();
	return this.jdbcTemplate.query(sql, rowMapper,idPedido);
	}


	@Override
	public int eliminarCarrito(int idPedido) {
		String sql="DELETE FROM registropedido WHERE idpedido = ? ";
		return this.jdbcTemplate.update(sql,idPedido);
	}

}
