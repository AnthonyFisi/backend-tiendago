package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Horario;

public class HorarioGson implements Serializable{
	
	
	List<Horario> listaHorario;

	public List<Horario> getListaHorario() {
		return listaHorario;
	}

	public void setListaHorario(List<Horario> listaHorario) {
		this.listaHorario = listaHorario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaHorario == null) ? 0 : listaHorario.hashCode());
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
		HorarioGson other = (HorarioGson) obj;
		if (listaHorario == null) {
			if (other.listaHorario != null)
				return false;
		} else if (!listaHorario.equals(other.listaHorario))
			return false;
		return true;
	} 
	
	
	

}
