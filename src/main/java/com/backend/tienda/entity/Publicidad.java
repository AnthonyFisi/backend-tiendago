package com.backend.tienda.entity;

import java.io.Serializable;

public class Publicidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int idpublicidad;
	
	private String detalle_publicidad;
	
	private String url_imagen_publicidad;

	public int getIdpublicidad() {
		return idpublicidad;
	}

	public void setIdpublicidad(int idpublicidad) {
		this.idpublicidad = idpublicidad;
	}

	public String getDetalle_publicidad() {
		return detalle_publicidad;
	}

	public void setDetalle_publicidad(String detalle_publicidad) {
		this.detalle_publicidad = detalle_publicidad;
	}

	public String getUrl_imagen_publicidad() {
		return url_imagen_publicidad;
	}

	public void setUrl_imagen_publicidad(String url_imagen_publicidad) {
		this.url_imagen_publicidad = url_imagen_publicidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalle_publicidad == null) ? 0 : detalle_publicidad.hashCode());
		result = prime * result + idpublicidad;
		result = prime * result + ((url_imagen_publicidad == null) ? 0 : url_imagen_publicidad.hashCode());
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
		Publicidad other = (Publicidad) obj;
		if (detalle_publicidad == null) {
			if (other.detalle_publicidad != null)
				return false;
		} else if (!detalle_publicidad.equals(other.detalle_publicidad))
			return false;
		if (idpublicidad != other.idpublicidad)
			return false;
		if (url_imagen_publicidad == null) {
			if (other.url_imagen_publicidad != null)
				return false;
		} else if (!url_imagen_publicidad.equals(other.url_imagen_publicidad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publicidad [idpublicidad=" + idpublicidad + ", detalle_publicidad=" + detalle_publicidad
				+ ", url_imagen_publicidad=" + url_imagen_publicidad + "]";
	}
	
	

}
