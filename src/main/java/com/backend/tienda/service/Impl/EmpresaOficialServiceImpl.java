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

	@Override
	public EmpresaOficial updateValorDescuento(int idempresa, float valordescuento) {
		
		EmpresaOficial empresaOficial=null;
		
		EmpresaOficial empresaOficialResponse=null;
		
		empresaOficial=empresaOficialRepository.findById(idempresa).get();
		
		empresaOficial.setMonto_descuento_menu(valordescuento);
		
		empresaOficialResponse=empresaOficialRepository.save(empresaOficial);
		
		if(empresaOficialResponse==null) {
			return null;
		}
		
		return empresaOficialResponse;
		
	}

}
