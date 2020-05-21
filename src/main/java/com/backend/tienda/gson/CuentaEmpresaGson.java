package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.CuentaEmpresa;

public class CuentaEmpresaGson implements Serializable {
	
	List<CuentaEmpresa> listaCuentaEmpresa;

	public List<CuentaEmpresa> getListaCuentaEmpresa() {
		return listaCuentaEmpresa;
	}

	public void setListaCuentaEmpresa(List<CuentaEmpresa> listaCuentaEmpresa) {
		this.listaCuentaEmpresa = listaCuentaEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaCuentaEmpresa == null) ? 0 : listaCuentaEmpresa.hashCode());
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
		CuentaEmpresaGson other = (CuentaEmpresaGson) obj;
		if (listaCuentaEmpresa == null) {
			if (other.listaCuentaEmpresa != null)
				return false;
		} else if (!listaCuentaEmpresa.equals(other.listaCuentaEmpresa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CuentaEmpresaGson [listaCuentaEmpresa=" + listaCuentaEmpresa + "]";
	}
	
	

}
