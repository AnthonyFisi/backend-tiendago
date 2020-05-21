package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Departamento;

public class DepartamentoGson implements Serializable{
	
	List<Departamento> listaDepartamento;

	public List<Departamento> getListaDepartamento() {
		return listaDepartamento;
	}

	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaDepartamento == null) ? 0 : listaDepartamento.hashCode());
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
		DepartamentoGson other = (DepartamentoGson) obj;
		if (listaDepartamento == null) {
			if (other.listaDepartamento != null)
				return false;
		} else if (!listaDepartamento.equals(other.listaDepartamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepartamentoGson [listaDepartamento=" + listaDepartamento + "]";
	}
	
	

}
