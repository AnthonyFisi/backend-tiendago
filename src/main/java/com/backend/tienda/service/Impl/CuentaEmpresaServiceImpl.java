package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.CuentaEmpresa;
import com.backend.tienda.repository.CuentaEmpresaRepository;
import com.backend.tienda.service.CuentaEmpresaService;

@Service
public class CuentaEmpresaServiceImpl implements CuentaEmpresaService {
	
	@Autowired
	CuentaEmpresaRepository cuentaEmpresaRepository;

	@Override
	public List<CuentaEmpresa> listaCuentaEmpresa() {
		return cuentaEmpresaRepository.findAll();
	}

	@Override
	public CuentaEmpresa insertarCuentaEmpresa(CuentaEmpresa cuentaEmpresa) {
		// TODO Auto-generated method stub
		return cuentaEmpresaRepository.save(cuentaEmpresa);
	}
	

}
