package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.CuentaEmpresa;

public interface CuentaEmpresaService {
	
	List<CuentaEmpresa> listaCuentaEmpresa();
	
	CuentaEmpresa insertarCuentaEmpresa(CuentaEmpresa cuentaEmpresa);

}
