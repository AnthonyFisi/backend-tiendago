package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.CategoriaDAO;
import com.backend.tienda.entity.Categoria;
import com.backend.tienda.rowmapper.CategoriaRowMapper;


@Transactional
@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Categoria> listaCategoria() {
		String sql= "Select idCategoria,Categoria_nombre,Categoria_descripcion ,Categoria_imagen,Categoria_uri_post FROM Categoria";
		RowMapper<Categoria> rowMapper= new CategoriaRowMapper();
		return this.jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public void añadirCategoria(Categoria categoria) {
		
		String sql="Insert into Categoria ( Categoria_nombre,Categoria_descripcion,Categoria_imagen,Categoria_uri_post) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql,
		
				categoria.getCategoria_nombre(),
				categoria.getCategoria_descripcion(),
				categoria.getCategoria_imagen(),
				categoria.getCategoria_uri_post());
		
	}

	@Override
	public void eliminarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCategoria(int idCategoria) {
		// TODO Auto-generated method stub
		
	}

}
