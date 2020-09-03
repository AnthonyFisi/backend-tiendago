package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.EmpresaOficial;
import com.backend.tienda.repository.EmpresaOficialRepository;
import com.backend.tienda.service.EmpresaOficialService;

@Service
public class EmpresaOficialServiceImpl implements EmpresaOficialService{
	
	@Autowired
	EmpresaOficialRepository empresaOficialRepository;

	@Override
	public EmpresaOficial guardarEmpresaOficial(EmpresaOficial empresa) {
		return empresaOficialRepository.save(empresa);
	}

}
