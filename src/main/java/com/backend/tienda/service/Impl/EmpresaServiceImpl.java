package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Empresa;
import com.backend.tienda.repository.EmpresaRepository;
import com.backend.tienda.service.EmpresaService;

@Service
public class EmpresaServiceImpl  implements EmpresaService{
	
	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	public List<Empresa> listaEmpresaFindByIdSubCategoria(int idSubCategoria) {
		return empresaRepository.listaEmpresaFindByIdSubCategoria(idSubCategoria);
	}

	@Override
	public List<Empresa> listaEmpresaFindByIdCategoriaAndUbicacion(int idCategoria, String Ubicacion) {
		return empresaRepository.listaEmpresaFindByIdCategoriaAnddireccion(idCategoria, Ubicacion);
	}

	@Override
	public List<Empresa> listaEmpresaSortByBusquedaRating(int idCategoria) {
		return empresaRepository.listaEmpresaSortByBusquedaRating(idCategoria);
	}

	@Override
	public List<Empresa> listaEmpresaFindByIdSubCategoriaAndUbicacion(int idSubCategoria, String Ubicacion) {

		return empresaRepository.listaEmpresaFindByIdSubCategoriaAnddireccion(idSubCategoria, Ubicacion);
	}

	@Override
	public Empresa InsertEmpresa(Empresa empresa) {
		return  empresaRepository.save(empresa);
	}

	@Override
	public Empresa findByIdEmpresaTotal(int idEmpresa) {
		return empresaRepository.findById(idEmpresa).get();
	}

	

}
