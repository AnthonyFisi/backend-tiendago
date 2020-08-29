package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Empresa_favorita;

public class Empresa_favoritaGson  implements Serializable{
	
	private List<Empresa_favorita> listaEmpresaFavorita;

	public List<Empresa_favorita> getListaEmpresaFavorita() {
		return listaEmpresaFavorita;
	}

	public void setListaEmpresaFavorita(List<Empresa_favorita> listaEmpresaFavorita) {
		this.listaEmpresaFavorita = listaEmpresaFavorita;
	}
	
	

}
