package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Distrito;

public class DistritoGson implements Serializable{
	
	public List<Distrito> listaDistrito;

	public List<Distrito> getListaDistrito() {
		return listaDistrito;
	}

	public void setListaDistrito(List<Distrito> listaDistrito) {
		this.listaDistrito = listaDistrito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaDistrito == null) ? 0 : listaDistrito.hashCode());
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
		DistritoGson other = (DistritoGson) obj;
		if (listaDistrito == null) {
			if (other.listaDistrito != null)
				return false;
		} else if (!listaDistrito.equals(other.listaDistrito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DistritoGson [listaDistrito=" + listaDistrito + "]";
	}
	
	
	

}
