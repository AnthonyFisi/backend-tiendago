package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.EmpresaDAO;
import com.backend.tienda.entity.Empresa;
import com.backend.tienda.service.EmpresaService;

@Service
public class EmpresaServiceImpl  implements EmpresaService{
	
	@Autowired
	EmpresaDAO empresaDAO;

	@Override
	public List<Empresa> listaEmpresaFindByIdSubCategoria(int idSubCategoria) {
		return empresaDAO.listaEmpresaFindByIdSubCategoria(idSubCategoria);
	}

	@Override
	public List<Empresa> listaEmpresaFindByIdCategoriaAndUbicacion(int idCategoria, String Ubicacion) {
		return empresaDAO.listaEmpresaFindByIdCategoriaAndUbicacion(idCategoria, Ubicacion);
	}

	@Override
	public List<Empresa> listaEmpresaSortByBusquedaRating(int idCategoria) {
		return empresaDAO.listaEmpresaSortByBusquedaRating(idCategoria);
	}

	@Override
	public List<Empresa> listaEmpresaFindByIdSubCategoriaAndUbicacion(int idSubCategoria, String Ubicacion) {
		return empresaDAO.listaEmpresaFindByIdSubCategoriaAndUbicacion(idSubCategoria, Ubicacion);
	}

}
