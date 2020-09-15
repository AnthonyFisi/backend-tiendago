package com.backend.tienda.gson;

import java.util.List;

import com.backend.tienda.entity.Empresa_historial;
import com.backend.tienda.models.Empresa_historialDetail;

public class Empresa_historialGson {
	
	
	private List<Empresa_historial> listaEmpresaHistorial;

	public List<Empresa_historial> getListaEmpresaHistorial() {
		return listaEmpresaHistorial;
	}

	public void setListaEmpresaHistorial(List<Empresa_historial> listaEmpresaHistorial) {
		this.listaEmpresaHistorial = listaEmpresaHistorial;
	}

	

}
