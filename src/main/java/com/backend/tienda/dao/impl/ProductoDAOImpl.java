package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.ProductoDAO;
import com.backend.tienda.entity.Producto;
import com.backend.tienda.rowmapper.ProductoRowMapper;

@Transactional
@Repository
public class ProductoDAOImpl implements ProductoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void ingresarProducto(Producto producto) {
			
			String sql="Insert into Producto"+
				"(  "+
					" Producto_nombre   ," + 
					"Producto_precio   ," + 
					"Producto_stock  ," + 
					"Producto_codigo   ," + 
					"Producto_fechaCreacion  ," + 
					"idImagenesProducto  ," + 
					"idCategoria,"+
					"Producto_fechaVencimiento,"+
					"producto_marca,"+
					"producto_envase,"+
					"producto_detalle,"+
					"producto_cantidad"+
					 " ) "+
					 " values (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
		jdbcTemplate.update(
				sql,
			
				producto.getProducto_nombre(),
				producto.getProducto_precio() ,
				producto.getProducto_stock(),
				producto.getProducto_codigo(),
				producto.getProducto_fechaCreacion(),
				producto.getIdImagenesProducto(),
				producto.getIdCategoria(),
				producto.getProducto_fechaVencimiento(),
				producto.getProducto_marca(),
				producto.getProducto_envase(),
				producto.getProducto_detalle(),
				producto.getProducto_cantidad()
				);
			
	}
	
	
	
		@Override
		public void actualizarProducto(int codigo) {
			// TODO Auto-generated method stub
			
		}

	@Override
	public List<Producto> listaProductos() {
		String sql ="SELECT idProducto," + 
				"					 Producto_nombre   ," + 
				"					Producto_precio   ," + 
				"					Producto_stock  ," + 
				"					Producto_codigo   ," + 
				"					Producto_fechaCreacion   ," + 
				"					idImagenesProducto   ," + 
				"					idCategoria,Producto_fechaVencimiento ,"
				+ "producto_marca,"
				+ "producto_envase,"
				+ "producto_detalle,"
				+ "producto_cantidad"
				+ "FROM Producto";
		
		RowMapper<Producto> rowMapper= new ProductoRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public List<Producto> listaProductosByCategoria(int idCategoria) {
		
		String sql ="SELECT idProducto," + 
				"					 Producto_nombre   ," + 
				"					Producto_precio   ," + 
				"					Producto_stock  ," + 
				"					Producto_codigo   ," + 
				"					Producto_fechaCreacion   ," + 
				"					idImagenesProducto   ," + 
				"					idCategoria,Producto_fechaVencimiento ,"
				+ "producto_marca,"
				+ "producto_envase,"
				+ "producto_detalle,"
				+ "producto_cantidad"
				+ "FROM Producto WHERE idCategoria = ?";
		
		RowMapper<Producto> rowMapper= new ProductoRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper,idCategoria);
	}



	@Override
	public boolean eliminarProducto(int codigo) {
		boolean rpt=false;
		String sql ="Delete FROM Producto WHERE idProducto = ?";
		this.jdbcTemplate.update(sql,codigo);
		
		String sql2="select * From Producto WHERE idProducto=?";
		RowMapper<Producto> rowMapper= new ProductoRowMapper();
		if(rowMapper == null) {
			rpt=true;
		}else {
			rpt=false;
		}
		return rpt;
	}




	

}
