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
		
		empresaOficial.setPrecio_menu(valordescuento);
		
		empresaOficialResponse=empresaOficialRepository.save(empresaOficial);
		
		if(empresaOficialResponse==null) {
			return null;
		}
		
		return empresaOficialResponse;
		
	}

	@Override
	public EmpresaOficial updateDisponibilidad(int idEmpresaOficial, boolean disponible) {
		 EmpresaOficial empresa=null;

	        try {
	            empresa=empresaOficialRepository.findById(idEmpresaOficial).get();
	            empresa.setDisponible(disponible);
	            empresa=empresaOficialRepository.save(empresa);

	        }catch(Exception e) {
	            return empresa;
	        }
	        return empresa;
	}

	@Override
	public EmpresaOficial updateTelefono(int idEmpresaOficial, String numeroTelefono) {
		 EmpresaOficial empresa=null;

	        try {
	            empresa=empresaOficialRepository.findById(idEmpresaOficial).get();
	            empresa.setTelefono_empresa(numeroTelefono);
	            empresa=empresaOficialRepository.save(empresa);

	        }catch(Exception e) {
	            return empresa;
	        }
	        return empresa;
	}

	@Override
	public EmpresaOficial updateCelular(int idEmpresaOficial, String numeroCelular) {
		 EmpresaOficial empresa=null;

	        try {
	            empresa=empresaOficialRepository.findById(idEmpresaOficial).get();
	            empresa.setCelular_empresa(numeroCelular);
	            empresa=empresaOficialRepository.save(empresa);

	        }catch(Exception e) {
	            return empresa;
	        }
	        return empresa;
	}

	@Override
	public EmpresaOficial updateHorarioAtencion(int idEmpresaOficial, int inicio, int fin) {
		EmpresaOficial empresa=null;

        try {
            empresa=empresaOficialRepository.findById(idEmpresaOficial).get();
            empresa.setHorario_inicio(inicio);
            empresa.setHorario_fin(fin);
            empresa=empresaOficialRepository.save(empresa);

        }catch(Exception e) {
            return empresa;
        }
        return empresa;
	}

	@Override
	public EmpresaOficial updateTiempoEntrega(int idEmpresaOficial, String tiempoAproximado) {
		  EmpresaOficial empresa=null;

	        try {
	            empresa=empresaOficialRepository.findById(idEmpresaOficial).get();
	            empresa.setTiempo_aproximado_entrega(tiempoAproximado);
	            empresa=empresaOficialRepository.save(empresa);

	        }catch(Exception e) {
	            return empresa;
	        }
	        return empresa;
	}

	@Override
	public EmpresaOficial updateDescripcion(EmpresaOficial empresaOficial) {
		  EmpresaOficial empresaResult=null;

	        try {
	            empresaResult=empresaOficialRepository.findById(empresaOficial.getIdempresa()).get();
	            empresaResult.setDescripcion_empresa(empresaOficial.getDescripcion_empresa());
	            empresaResult=empresaOficialRepository.save(empresaOficial);

	        }catch(Exception e) {
	            return empresaResult;
	        }
	        return empresaResult;
	}

	@Override
	public EmpresaOficial findByIdUsuarioGeneral(int idusuariogeneral) {
		return empresaOficialRepository.findByIdusuariogeneral(idusuariogeneral);
	}

}
