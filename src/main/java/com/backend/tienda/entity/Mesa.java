package com.backend.tienda.entity;

import java.io.Serializable;

public class Mesa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idMesa;
	private String Mesa_estado;
	private int Mesa_capacidad;
	private int Mesa_numero;
	
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	public String getMesa_estado() {
		return Mesa_estado;
	}
	public void setMesa_estado(String mesa_estado) {
		this.Mesa_estado = mesa_estado;
	}
	public int getMesa_capacidad() {
		return Mesa_capacidad;
	}
	public void setMesa_capacidad(int mesa_capacidad) {
		this.Mesa_capacidad = mesa_capacidad;
	}
	public int getMesa_numero() {
		return Mesa_numero;
	}
	public void setMesa_numero(int Mesa_numero) {
		this.Mesa_numero = Mesa_numero;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Mesa_capacidad;
		result = prime * result + ((Mesa_estado == null) ? 0 : Mesa_estado.hashCode());
		result = prime * result + Mesa_numero;
		result = prime * result + idMesa;
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
		Mesa other = (Mesa) obj;
		if (Mesa_capacidad != other.Mesa_capacidad)
			return false;
		if (Mesa_estado == null) {
			if (other.Mesa_estado != null)
				return false;
		} else if (!Mesa_estado.equals(other.Mesa_estado))
			return false;
		if (Mesa_numero != other.Mesa_numero)
			return false;
		if (idMesa != other.idMesa)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", Mesa_estado=" + Mesa_estado + ", Mesa_capacidad=" + Mesa_capacidad
				+ ", Mesa_numero=" + Mesa_numero + "]";
	}
	
	
	
	
}
