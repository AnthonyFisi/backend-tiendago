package com.backend.tienda.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/*ESTE MODELO SOLO SERA USADO PARA REBIR DATOS DE LOS PRODUCTOS REGSTRADOS EN LA APLICACION  , NO ESTA IMPLEMENTADO EN OTROS METODOS*/

public class MainPedido implements Serializable{
	
	private int idproducto;
	
	private int idusuario;
	
	private int idempresa;
	
	private float precio;
	
	private int cantidad;
	
	private Timestamp fecha_registro;

	public int getidproducto() {
		return idproducto;
	}

	public void setidproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Timestamp getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Timestamp fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((fecha_registro == null) ? 0 : fecha_registro.hashCode());
		result = prime * result + idempresa;
		result = prime * result + idproducto;
		result = prime * result + idusuario;
		result = prime * result + Float.floatToIntBits(precio);
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
		MainPedido other = (MainPedido) obj;
		if (cantidad != other.cantidad)
			return false;
		if (fecha_registro == null) {
			if (other.fecha_registro != null)
				return false;
		} else if (!fecha_registro.equals(other.fecha_registro))
			return false;
		if (idempresa != other.idempresa)
			return false;
		if (idproducto != other.idproducto)
			return false;
		if (idusuario != other.idusuario)
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MainPedido [idproducto=" + idproducto + ", idusuario=" + idusuario + ", idempresa=" + idempresa
				+ ", precio=" + precio + ", cantidad=" + cantidad + ", fecha_registro=" + fecha_registro + "]";
	}
	
	
		
}
