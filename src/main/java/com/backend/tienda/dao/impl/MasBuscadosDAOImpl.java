package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.MasBuscadosDAO;
import com.backend.tienda.entity.MasBuscados;
import com.backend.tienda.rowmapper.MasBuscadosRowMapper;


@Transactional
@Repository
public class MasBuscadosDAOImpl implements MasBuscadosDAO{
	@Autowired 
	JdbcTemplate jdbcTemplate;

	@Override
	public List<MasBuscados> listaMasBuscadosCategoria(int idCategoria) {
		String sql=
				"		SELECT		 p.idProducto,  " + 
				"					p.Producto_nombre,  " + 
				"					p.Producto_precio,  " + 
				"					c.idCategoria,  " + 
				"					c.Categoria_nombre,  " + 
				"					c.Categoria_descripcion,  " + 
				"					ip.idImagenesProducto,  " + 
				"					ip.ImagenesProducto_nombre,  " + 
				"					ip.ImagenesProducto_uri , " + 
				"				   p.producto_marca," + 
				"				   p.producto_envase," + 
				"				   p.producto_detalle," + 
				"				   p.producto_cantidad," + 
				"				   mb.porcentaje" + 
				"				  from    " + 
				"				producto AS p JOIN categoria AS c ON p.idcategoria=c.idcategoria    " + 
				"				JOIN imagenesproducto AS ip ON ip.idimagenesproducto=p.idimagenesproducto " + 
				"				JOIN  MasBuscado AS mb ON mb.idproducto=p.idproducto" + 
				"				 WHERE c.idCategoria=  ?   ORDER BY mb.porcentaje ASC" ;
		RowMapper<MasBuscados> rowMapper= new MasBuscadosRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper,idCategoria);
	}

}
