package com.backend.tienda.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.tienda.entity.Empresa;

public class EmpresaRowMapper implements RowMapper<Empresa> {

	@Override
	public Empresa mapRow(ResultSet rs, int rowNum) throws SQLException {
		Empresa empresa=new Empresa();
		empresa.setIdempresa(rs.getInt("idempresa"));
		empresa.setIdsubcategoriaempresa(rs.getInt("idsubcategoriaempresa"));
		empresa.setNombre_empresa(rs.getString("nombre_empresa"));
		empresa.setUbicacion_empresa(rs.getString("ubicacion_empresa"));
		empresa.setRuc_empresa(rs.getString("ruc_empresa"));
		empresa.setTelefono_empresa(rs.getString("telefono_empresa"));
		empresa.setCelular_empresa(rs.getString("celular_empresa"));
		empresa.setBoletas(rs.getBoolean("boletas"));
		empresa.setDescripcion_empresa(rs.getString("descripcion_empresa"));
		empresa.setUrlfoto_empresa(rs.getString("urlfoto_empresa"));
		empresa.setNombredueno_empresa(rs.getString("nombredueno_empresa"));
		empresa.setNumerolocales(rs.getInt("numerolocales"));
		return empresa;
	}

}
