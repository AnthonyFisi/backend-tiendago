package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoriaproducto")
public class CategoriaProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoriaproducto", updatable = false, nullable = false)
	private int idcategoriaproducto;
	
	private String nombrecategoria;
	
	private String detallecategoria;

	public int getIdcategoriaproducto() {
		return idcategoriaproducto;
	}

	public void setIdcategoriaproducto(int idcategoriaproducto) {
		this.idcategoriaproducto = idcategoriaproducto;
	}

	public String getNombrecategoria() {
		return nombrecategoria;
	}

	public void setNombrecategoria(String nombrecategoria) {
		this.nombrecategoria = nombrecategoria;
	}

	public String getDetallecategoria() {
		return detallecategoria;
	}

	public void setDetallecategoria(String detallecategoria) {
		this.detallecategoria = detallecategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detallecategoria == null) ? 0 : detallecategoria.hashCode());
		result = prime * result + idcategoriaproducto;
		result = prime * result + ((nombrecategoria == null) ? 0 : nombrecategoria.hashCode());
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
		CategoriaProducto other = (CategoriaProducto) obj;
		if (detallecategoria == null) {
			if (other.detallecategoria != null)
				return false;
		} else if (!detallecategoria.equals(other.detallecategoria))
			return false;
		if (idcategoriaproducto != other.idcategoriaproducto)
			return false;
		if (nombrecategoria == null) {
			if (other.nombrecategoria != null)
				return false;
		} else if (!nombrecategoria.equals(other.nombrecategoria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CategoriaProducto [idcategoriaproducto=" + idcategoriaproducto + ", nombrecategoria=" + nombrecategoria
				+ ", detallecategoria=" + detallecategoria + "]";
	}
	
	

}
