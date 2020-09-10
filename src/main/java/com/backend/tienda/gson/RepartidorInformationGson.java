package com.backend.tienda.gson;

import com.backend.tienda.entity.Usuario_general;

public class RepartidorInformationGson {
	
	private Usuario_general usuario_general;
	
	private int idventa;

	public Usuario_general getUsuario_general() {
		return usuario_general;
	}

	public void setUsuario_general(Usuario_general usuario_general) {
		this.usuario_general = usuario_general;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}
	
	

}
