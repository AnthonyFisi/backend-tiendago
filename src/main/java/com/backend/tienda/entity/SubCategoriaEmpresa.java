package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subcategoriaempresa")
public class SubCategoriaEmpresa implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsubcategoriaempresa", updatable = false, nullable = false)
	private int idsubcategoriaempresa ;
	
	private int idcategoriaempresa ;
	
	private String nombre_subcategoria;
	
	private String descripcion_subcategoria;
	
	private float porcentajebusqueda;
	
	private String url_imagen_subcategoria;

	

	public int getIdsubcategoriaempresa() {
		return idsubcategoriaempresa;
	}

	public void setIdsubcategoriaempresa(int idsubcategoriaempresa) {
		this.idsubcategoriaempresa = idsubcategoriaempresa;
	}

	

	public int getIdcategoriaempresa() {
		return idcategoriaempresa;
	}

	public void setIdcategoriaempresa(int idcategoriaempresa) {
		this.idcategoriaempresa = idcategoriaempresa;
	}

	public String getNombre_subcategoria() {
		return nombre_subcategoria;
	}

	public void setNombre_subcategoria(String nombre_subcategoria) {
		this.nombre_subcategoria = nombre_subcategoria;
	}

	public String getDescripcion_subcategoria() {
		return descripcion_subcategoria;
	}

	public void setDescripcion_subcategoria(String descripcion_subcategoria) {
		this.descripcion_subcategoria = descripcion_subcategoria;
	}

	public float getPorcentajebusqueda() {
		return porcentajebusqueda;
	}

	public void setPorcentajebusqueda(float porcentajebusqueda) {
		this.porcentajebusqueda = porcentajebusqueda;
	}

	public String getUrl_imagen_subcategoria() {
		return url_imagen_subcategoria;
	}

	public void setUrl_imagen_subcategoria(String url_imagen_subcategoria) {
		this.url_imagen_subcategoria = url_imagen_subcategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion_subcategoria == null) ? 0 : descripcion_subcategoria.hashCode());
		result = prime * result + idcategoriaempresa;
		result = prime * result + idsubcategoriaempresa;
		result = prime * result + ((nombre_subcategoria == null) ? 0 : nombre_subcategoria.hashCode());
		result = prime * result + Float.floatToIntBits(porcentajebusqueda);
		result = prime * result + ((url_imagen_subcategoria == null) ? 0 : url_imagen_subcategoria.hashCode());
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
		SubCategoriaEmpresa other = (SubCategoriaEmpresa) obj;
		if (descripcion_subcategoria == null) {
			if (other.descripcion_subcategoria != null)
				return false;
		} else if (!descripcion_subcategoria.equals(other.descripcion_subcategoria))
			return false;
		if (idcategoriaempresa != other.idcategoriaempresa)
			return false;
		if (idsubcategoriaempresa != other.idsubcategoriaempresa)
			return false;
		if (nombre_subcategoria == null) {
			if (other.nombre_subcategoria != null)
				return false;
		} else if (!nombre_subcategoria.equals(other.nombre_subcategoria))
			return false;
		if (Float.floatToIntBits(porcentajebusqueda) != Float.floatToIntBits(other.porcentajebusqueda))
			return false;
		if (url_imagen_subcategoria == null) {
			if (other.url_imagen_subcategoria != null)
				return false;
		} else if (!url_imagen_subcategoria.equals(other.url_imagen_subcategoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubCategoriaEmpresa [idsubcategoriaempresa=" + idsubcategoriaempresa + ", idcategoriaEmpresa="
				+ idcategoriaempresa + ", nombre_subcategoria=" + nombre_subcategoria + ", descripcion_subcategoria="
				+ descripcion_subcategoria + ", porcentajebusqueda=" + porcentajebusqueda + ", url_imagen_subcategoria="
				+ url_imagen_subcategoria + "]";
	}

	
	

}
