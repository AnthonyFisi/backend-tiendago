package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.VentaDAO;
import com.backend.tienda.entity.Producto;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.rowmapper.VentaRowMapper;

@Transactional
@Repository
public class VentaDAOImpl implements VentaDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int añadirVenta(Venta venta) {
		String sql="INSERT INTO venta(" + 
				"  Venta_fecha , " + 
				"  Venta_estadoPago, " + 
				"  Venta_fechaEntrega, " + 
				"  Venta_costodelivery,  " + 
				"  Venta_costoTotal ," + 
				"  idPedido  ," + 
				"  idtipopago , " + 
				"  idubicacion ," + 
				"  idhorario ,comentario) VALUES " + 
				"  (?,?,?,?,?,?,?,?,?,?)";	
		
		
	return	this.jdbcTemplate.update(sql,
				venta.getVenta_fecha(),
				venta.getVenta_estadoPago(),
				venta.getVenta_fechaEntrega(),
				venta.getVenta_costodelivery(),
				venta.getVenta_costoTotal(),
				venta.getIdPedido(),
				venta.getIdtipopago(),
				venta.getIdubicacion(),
				venta.getIdhorario(),
				venta.getComentario()
				);
		
	}

	@Override
	public List<Venta> listaVentas() {
		String sql ="SELECT idventa," + 
				"  Venta_fecha , " + 
				"  Venta_estadoPago, " + 
				"  Venta_fechaEntrega, " + 
				"  Venta_costodelivery,  " + 
				"  Venta_costoTotal ," + 
				"  idPedido  ," + 
				"  idtipopago , " + 
				"  idubicacion ," + 
				"  idhorario , comentario FROM venta ";
		
		RowMapper<Venta> rowMapper= new VentaRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper);
	}

}
