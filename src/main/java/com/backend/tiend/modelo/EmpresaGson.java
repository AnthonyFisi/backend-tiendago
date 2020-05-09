package com.backend.tiend.modelo;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Empresa;

public class EmpresaGson  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Empresa> listaEmpresa;

	public List<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaEmpresa == null) ? 0 : listaEmpresa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaGson other = (EmpresaGson) obj;
		if (listaEmpresa == null) {
			if (other.listaEmpresa != null)
				return false;
		} else if (!listaEmpresa.equals(other.listaEmpresa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmpresaGson [listaEmpresa=" + listaEmpresa + "]";
	}
	
	

}
