package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Provincia;

public class ProvinciaGson implements Serializable{

	
	List<Provincia> listaProvincia;

	public List<Provincia> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<Provincia> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaProvincia == null) ? 0 : listaProvincia.hashCode());
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
		ProvinciaGson other = (ProvinciaGson) obj;
		if (listaProvincia == null) {
			if (other.listaProvincia != null)
				return false;
		} else if (!listaProvincia.equals(other.listaProvincia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProvinciaGson [listaProvincia=" + listaProvincia + "]";
	}
	
	
	
}
