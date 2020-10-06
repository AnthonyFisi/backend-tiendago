package com.backend.tienda.service;

import com.backend.tienda.entity.EmpresaOficial;

public interface EmpresaOficialService {
	
	EmpresaOficial guardarEmpresaOficial(EmpresaOficial empresa);
	
	EmpresaOficial updateValorDescuento(int idempresa,float valordescuento);
	
	EmpresaOficial findByIdUsuarioGeneral(int idusuariogeneral);
	
	EmpresaOficial findByIdempresa(int idempresa);
	
	//UPDATE EMPRESAOFICIAL
	
    EmpresaOficial updateDisponibilidad(int idEmpresaOficial,boolean disponible);
    
    EmpresaOficial updateTelefono(int idEmpresaOficial,String numeroTelefono);
    
    EmpresaOficial updateCelular(int idEmpresaOficial,String numeroCelular);
    
    EmpresaOficial updateHorarioAtencion(int idEmpresaOficial,int inicio,int fin);
    
    EmpresaOficial updateTiempoEntrega(int idEmpresaOficial ,String tiempoAproximado);
    
    EmpresaOficial updateDescripcion(EmpresaOficial empresaOficial);

}
