package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nombresubcategoria")
public class NombreSubcategoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idnombresubcategoria", updatable = false, nullable = false)
	private int idnombresubcategoria;
		
	private String productospopulares;
	
	private String ofertas;
	
	private String categoria1;
	
	private String categoria2;
	
	private String categoria3;
	
	private int idempresa;


	public int getIdnombresubcategoria() {
		return idnombresubcategoria;
	}

	public void setIdnombresubcategoria(int idnombresubcategoria) {
		this.idnombresubcategoria = idnombresubcategoria;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public String getProductospopulares() {
		return productospopulares;
	}

	public void setProductospopulares(String productospopulares) {
		this.productospopulares = productospopulares;
	}

	public String getOfertas() {
		return ofertas;
	}

	public void setOfertas(String ofertas) {
		this.ofertas = ofertas;
	}

	public String getCategoria1() {
		return categoria1;
	}

	public void setCategoria1(String categoria1) {
		this.categoria1 = categoria1;
	}

	public String getCategoria2() {
		return categoria2;
	}

	public void setCategoria2(String categoria2) {
		this.categoria2 = categoria2;
	}

	public String getCategoria3() {
		return categoria3;
	}

	public void setCategoria3(String categoria3) {
		this.categoria3 = categoria3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria1 == null) ? 0 : categoria1.hashCode());
		result = prime * result + ((categoria2 == null) ? 0 : categoria2.hashCode());
		result = prime * result + ((categoria3 == null) ? 0 : categoria3.hashCode());
		result = prime * result + idempresa;
		result = prime * result + idnombresubcategoria;
		result = prime * result + ((ofertas == null) ? 0 : ofertas.hashCode());
		result = prime * result + ((productospopulares == null) ? 0 : productospopulares.hashCode());
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
		NombreSubcategoria other = (NombreSubcategoria) obj;
		if (categoria1 == null) {
			if (other.categoria1 != null)
				return false;
		} else if (!categoria1.equals(other.categoria1))
			return false;
		if (categoria2 == null) {
			if (other.categoria2 != null)
				return false;
		} else if (!categoria2.equals(other.categoria2))
			return false;
		if (categoria3 == null) {
			if (other.categoria3 != null)
				return false;
		} else if (!categoria3.equals(other.categoria3))
			return false;
		if (idempresa != other.idempresa)
			return false;
		if (idnombresubcategoria != other.idnombresubcategoria)
			return false;
		if (ofertas == null) {
			if (other.ofertas != null)
				return false;
		} else if (!ofertas.equals(other.ofertas))
			return false;
		if (productospopulares == null) {
			if (other.productospopulares != null)
				return false;
		} else if (!productospopulares.equals(other.productospopulares))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NombreSubcategoria [idnombresubcategoria=" + idnombresubcategoria + ", idempresa=" + idempresa
				+ ", productospopulares=" + productospopulares + ", ofertas=" + ofertas + ", categoria1=" + categoria1
				+ ", categoria2=" + categoria2 + ", categoria3=" + categoria3 + "]";
	}
	
	
	
	
	
}
