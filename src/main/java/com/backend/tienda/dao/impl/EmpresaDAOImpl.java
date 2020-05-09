package com.backend.tienda.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.tienda.dao.EmpresaDAO;
import com.backend.tienda.entity.Empresa;
import com.backend.tienda.rowmapper.EmpresaRowMapper;

@Transactional
@Repository
public class EmpresaDAOImpl  implements EmpresaDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Empresa> listaEmpresaFindByIdSubCategoria(int idSubCategoria) {
		String sql="SELECT e.idempresa,e.idsubcategoriaempresa,e.nombre_empresa,"
				+ "e.ubicacion_empresa,e.ruc_empresa,e.telefono_empresa,e.celular_empresa,e.boletas,e.descripcion_empresa"
				+ ",e.urlfoto_empresa,e.nombredueno_empresa,e.numerolocales"
				+ " FROM empresa AS e INNER JOIN cuentaempresa AS c ON e.idempresa = c.idempresa "
				+ " WHERE e.idsubcategoriaempresa = ?  AND c.cuentaactiva = true  ";
		RowMapper<Empresa> rowMapper= new EmpresaRowMapper();
		
		return jdbcTemplate.query(sql,rowMapper,idSubCategoria);
	}
	
	

	

}
