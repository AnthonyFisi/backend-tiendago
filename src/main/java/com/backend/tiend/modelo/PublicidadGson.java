package com.backend.tiend.modelo;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Publicidad;

public class PublicidadGson implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<Publicidad> listaPublicidad;


	public List<Publicidad> getListaPublicidad() {
		return listaPublicidad;
	}


	public void setListaPublicidad(List<Publicidad> listaPublicidad) {
		this.listaPublicidad = listaPublicidad;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaPublicidad == null) ? 0 : listaPublicidad.hashCode());
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
		PublicidadGson other = (PublicidadGson) obj;
		if (listaPublicidad == null) {
			if (other.listaPublicidad != null)
				return false;
		} else if (!listaPublicidad.equals(other.listaPublicidad))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PublicidadGson [listaPublicidad=" + listaPublicidad + "]";
	}
	
	
	

}
