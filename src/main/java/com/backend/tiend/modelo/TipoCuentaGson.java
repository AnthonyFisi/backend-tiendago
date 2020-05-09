package com.backend.tiend.modelo;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.TipoCuenta;

public class TipoCuentaGson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<TipoCuenta> listaTipoCuenta;

	public List<TipoCuenta> getListaTipoCuenta() {
		return listaTipoCuenta;
	}

	public void setListaTipoCuenta(List<TipoCuenta> listaTipoCuenta) {
		this.listaTipoCuenta = listaTipoCuenta;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaTipoCuenta == null) ? 0 : listaTipoCuenta.hashCode());
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
		TipoCuentaGson other = (TipoCuentaGson) obj;
		if (listaTipoCuenta == null) {
			if (other.listaTipoCuenta != null)
				return false;
		} else if (!listaTipoCuenta.equals(other.listaTipoCuenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoCuentaGson [listaTipoCuenta=" + listaTipoCuenta + "]";
	}
	
	

}
