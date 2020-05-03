package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.RegistroPedidoDAO;
import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.rowmapper.RegistroPedidoRowMapper;

@Transactional
@Repository
public class RegistroPedidoDAOImpl implements RegistroPedidoDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void guardarRegistroPedido(RegistroPedido registroPedido) {
		String sql="INSERT INTO registropedido (idproducto,idpedido,registropedido_cantidad,registropedido_preciototal,"
				+ "registropedido_detalles,registropedido_idoferta) VALUES(?,?,?,?,?,?)";
		this.jdbcTemplate.update(sql,
				registroPedido.getIdproducto(),
				registroPedido.getIdpedido(),
				registroPedido.getRegistropedido_cantidad(),
				registroPedido.getRegistropedido_preciototal(),
				registroPedido.getRegistropedido_detalles(),
				registroPedido.getRegistropedido_idoferta()
				);
	}

	

	@Override
	public boolean eliminarRegistroPedido(int idPedido,int idProducto) {
		
		String sql="DELETE FROM  registropedido WHERE idpedido = ? AND idproducto = ?  ";
		this.jdbcTemplate.update(sql,idPedido,idProducto);
		return true;
	}

	@Override
	public List<RegistroPedido> listaRegistroPedido() {
		String sql="select idproducto,idpedido,registropedido_cantidad,registropedido_preciototal, " + 
				"				registropedido_detalles,registropedido_idoferta "
				+ " FROM registropedido ";
		RowMapper<RegistroPedido> rowMapper= new RegistroPedidoRowMapper();
		
		return this.jdbcTemplate.query(sql,rowMapper);
	}



	@Override
	public void actualizarRegistroPedido(int idPedido, int idProducto,int cantidad,float precio) {
		
		String sql="update registropedido set registropedido_cantidad= ? , registropedido_preciototal = ? where idpedido= ? and idproducto= ? ";
		this.jdbcTemplate.update(sql,cantidad,precio,idPedido,idProducto);		
		
	}



	@Override
	public RegistroPedido findByPedidoAndProducto(int idPedido, int idProducto) {
		String sql="select idproducto,idpedido,registropedido_cantidad,registropedido_preciototal, " + 
				"				registropedido_detalles,registropedido_idoferta "
				+ " FROM registropedido where idproducto = ? and idpedido = ? ";
		
		RowMapper<RegistroPedido> rowMapper= new BeanPropertyRowMapper<RegistroPedido>(RegistroPedido.class);
		
		return this.jdbcTemplate.queryForObject(sql,rowMapper,idProducto,idPedido);
	}

}
