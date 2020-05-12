package com.backend.tienda.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoriaempresa")
public class CategoriaEmpresa  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoriaempresa", updatable = false, nullable = false)
	private int idcategoriaempresa ;
	
	private String nombre_categoria;
	
	private String descripcion_categoria;
	
	private float porcentajebusqueda;
	
	private String url_imagen_categoria;

	

	public int getIdcategoriaempresa() {
		return idcategoriaempresa;
	}

	public void setIdcategoriaempresa(int idcategoriaempresa) {
		this.idcategoriaempresa = idcategoriaempresa;
	}

	public String getNombre_categoria() {
		return nombre_categoria;
	}

	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}

	public String getDescripcion_categoria() {
		return descripcion_categoria;
	}

	public void setDescripcion_categoria(String descripcion_categoria) {
		this.descripcion_categoria = descripcion_categoria;
	}

	public float getPorcentajebusqueda() {
		return porcentajebusqueda;
	}

	public void setPorcentajebusqueda(float porcentajebusqueda) {
		this.porcentajebusqueda = porcentajebusqueda;
	}

	public String getUrl_imagen_categoria() {
		return url_imagen_categoria;
	}

	public void setUrl_imagen_categoria(String url_imagen_categoria) {
		this.url_imagen_categoria = url_imagen_categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion_categoria == null) ? 0 : descripcion_categoria.hashCode());
		result = prime * result + idcategoriaempresa;
		result = prime * result + ((nombre_categoria == null) ? 0 : nombre_categoria.hashCode());
		result = prime * result + Float.floatToIntBits(porcentajebusqueda);
		result = prime * result + ((url_imagen_categoria == null) ? 0 : url_imagen_categoria.hashCode());
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
		CategoriaEmpresa other = (CategoriaEmpresa) obj;
		if (descripcion_categoria == null) {
			if (other.descripcion_categoria != null)
				return false;
		} else if (!descripcion_categoria.equals(other.descripcion_categoria))
			return false;
		if (idcategoriaempresa != other.idcategoriaempresa)
			return false;
		if (nombre_categoria == null) {
			if (other.nombre_categoria != null)
				return false;
		} else if (!nombre_categoria.equals(other.nombre_categoria))
			return false;
		if (Float.floatToIntBits(porcentajebusqueda) != Float.floatToIntBits(other.porcentajebusqueda))
			return false;
		if (url_imagen_categoria == null) {
			if (other.url_imagen_categoria != null)
				return false;
		} else if (!url_imagen_categoria.equals(other.url_imagen_categoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaEmpresa [idcategoriaempresa=" + idcategoriaempresa + ", nombre_categoria=" + nombre_categoria
				+ ", descripcion_categoria=" + descripcion_categoria + ", porcentajebusqueda=" + porcentajebusqueda
				+ ", url_imagen_categoria=" + url_imagen_categoria + "]";
	}

	
	
	
	

}
