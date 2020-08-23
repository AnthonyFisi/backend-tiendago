package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		
		return empresaRepository.findByIdsubcategoriaempresa(idSubCategoria);

	}

	@Override
	public List<Empresa> listaEmpresaIdCategoria( int idCategoria) {
	
		//CARGAMOS TODOS LOS DATOS DE LAS EMPRESAS 
		return empresaRepository.findByIdcategoriaempresa(idCategoria);
	
	}

	@Override
	public List<Empresa> listaEmpresaSortByBusquedaRating(int idCategoria) {
		return empresaRepository.findByIdcategoriaempresaOrderByPopularidadAsc(idCategoria);

	}


	@Override
	public Empresa InsertEmpresa(Empresa empresa) {
		return  empresaRepository.save(empresa);
	}

	@Override
	public Empresa findByIdEmpresaTotal(int idEmpresa) {
		return empresaRepository.findById(idEmpresa).get();
	}

	@Override
	public Empresa updateDisponibilidad(int idEmpresa, boolean disponible) {
		Empresa empresa=null;

		try {
			empresa=empresaRepository.findById(idEmpresa).get();
			empresa.setDisponible(disponible);
			empresa=empresaRepository.save(empresa);

		}catch(Exception e) {
			return empresa;
		}
		return empresa;
	}

	@Override
	public Empresa updateTelefono(int idEmpresa, String numeroTelefono) {
		Empresa empresa=null;

		try {
			empresa=empresaRepository.findById(idEmpresa).get();
			empresa.setTelefono_empresa(numeroTelefono);
			empresa=empresaRepository.save(empresa);

		}catch(Exception e) {
			return empresa;
		}
		return empresa;
	}

	@Override
	public Empresa updateCelular(int idEmpresa, String numeroCelular) {
		Empresa empresa=null;

		try {
			empresa=empresaRepository.findById(idEmpresa).get();
			empresa.setCelular_empresa(numeroCelular);
			empresa=empresaRepository.save(empresa);

		}catch(Exception e) {
			return empresa;
		}
		return empresa;
	}

	@Override
	public Empresa updateHorarioAtencion(int idEmpresa, int inicio, int fin) {
		Empresa empresa=null;

		try {
			empresa=empresaRepository.findById(idEmpresa).get();
			empresa.setHorario_inicio(inicio);
			empresa.setHorario_fin(fin);
			empresa=empresaRepository.save(empresa);

		}catch(Exception e) {
			return empresa;
		}
		return empresa;
	}

	@Override
	public Empresa updateTiempoEntrega(int idEmpresa, String tiempoAproximado) {
		Empresa empresa=null;

		try {
			empresa=empresaRepository.findById(idEmpresa).get();
			empresa.setTiempo_aproximado_entrega(tiempoAproximado);
			empresa=empresaRepository.save(empresa);

		}catch(Exception e) {
			return empresa;
		}
		return empresa;
	}

	@Override
	public Empresa updateDescripcion(Empresa empresa) {
		Empresa empresaResult=null;

		try {
			empresaResult=empresaRepository.findById(empresa.getIdempresa()).get();
			empresaResult.setDescripcion_empresa(empresa.getDescripcion_empresa());
			empresaResult=empresaRepository.save(empresa);

		}catch(Exception e) {
			return empresaResult;
		}
		return empresaResult;
	}



}
