package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.NombreSubcategoria;

public class NombreSubCategoriaGson implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<NombreSubcategoria> listaNombreSubCategoria;

	public List<NombreSubcategoria> getListaNombreSubCategoria() {
		return listaNombreSubCategoria;
	}

	public void setListaNombreSubCategoria(List<NombreSubcategoria> listaNombreSubCategoria) {
		this.listaNombreSubCategoria = listaNombreSubCategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaNombreSubCategoria == null) ? 0 : listaNombreSubCategoria.hashCode());
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
		NombreSubCategoriaGson other = (NombreSubCategoriaGson) obj;
		if (listaNombreSubCategoria == null) {
			if (other.listaNombreSubCategoria != null)
				return false;
		} else if (!listaNombreSubCategoria.equals(other.listaNombreSubCategoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NombreSubCategoriaGson [listaNombreSubCategoria=" + listaNombreSubCategoria + "]";
	}
	
	
}
