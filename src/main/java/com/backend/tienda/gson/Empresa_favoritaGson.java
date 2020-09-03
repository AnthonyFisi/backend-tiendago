package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Empresa_bi2;

public class Empresa_favoritaGson  implements Serializable{
	
	private List<Empresa_bi2> listaEmpresaFavorita;

	public List<Empresa_bi2> getListaEmpresaFavorita() {
		return listaEmpresaFavorita;
	}

	public void setListaEmpresaFavorita(List<Empresa_bi2> listaEmpresaFavorita) {
		this.listaEmpresaFavorita = listaEmpresaFavorita;
	}
	
	

}
