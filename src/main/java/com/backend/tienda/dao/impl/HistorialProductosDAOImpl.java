package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.HistorialProductosDAO;
import com.backend.tienda.entity.HistorialProductos;
import com.backend.tienda.rowmapper.HistorialProductosRowMapper;


@Transactional
@Repository
public class HistorialProductosDAOImpl implements HistorialProductosDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<HistorialProductos> listaHistorialProductos(int idUsuario) {
		String sql=" select  distinct ON (p.idProducto)p.idProducto,p.producto_nombre,p.producto_marca ," + 
				"		 p.producto_envase,p.producto_detalle,p.producto_cantidad,p.Producto_precio," + 
				"         p.producto_uri_imagen,to_char(pe.pedido_fecha_registro,'YYYY-MM-DD HH24:MI:SS') AS pedido_fecha_registro " + 
				"         from  producto as p  JOIN registropedido as rpe ON rpe.idproducto=p.idproducto   " + 
				"            JOIN pedido as pe ON pe.idpedido=rpe.idpedido    " + 
				"         where pe.usuario_idusuario = ?  and pe.pedido_estado='Atendido' ";
		
		RowMapper<HistorialProductos> rowMapper =new HistorialProductosRowMapper();
		
		return jdbcTemplate.query(sql, rowMapper,idUsuario);
	}

}
