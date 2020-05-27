package com.backend.tienda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RegistroPedidoPK implements Serializable{

	@Column(name="idpedido")
	private int idpedido;
	
	@Column(name="idproducto")
	private int idproducto;

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idpedido;
		result = prime * result + idproducto;
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
		RegistroPedidoPK other = (RegistroPedidoPK) obj;
		if (idpedido != other.idpedido)
			return false;
		if (idproducto != other.idproducto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegistroPedidoPK [idpedido=" + idpedido + ", idproducto=" + idproducto + "]";
	}
	
	
	
}
