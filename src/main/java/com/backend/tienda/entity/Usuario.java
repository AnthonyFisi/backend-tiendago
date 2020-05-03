package com.backend.tienda.entity;

import java.io.Serializable;


/*
 * 
 * PONER AUTOMATICAMENTE LA UBICACION DE COMPRA en la APP
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario", updatable = false, nullable = false)
	private int idusuario;
	private String Usuario_nombre;
	private String Usuario_correo;
	private String Usuario_contraseña;
	private String Usuario_apellido;
	private String Usuario_foto;
	private String Usuario_celular;
	

	
	
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getUsuario_apellido() {
		return Usuario_apellido;
	}
	public void setUsuario_apellido(String usuario_apellido) {
		Usuario_apellido = usuario_apellido;
	}
	public String getUsuario_foto() {
		return Usuario_foto;
	}
	public void setUsuario_foto(String usuario_foto) {
		Usuario_foto = usuario_foto;
	}
	public String getUsuario_celular() {
		return Usuario_celular;
	}
	public void setUsuario_celular(String usuario_celular) {
		Usuario_celular = usuario_celular;
	}
	
	
	
	
	
	
	public String getUsuario_nombre() {
		return Usuario_nombre;
	}
	public void setUsuario_nombre(String usuario_nombre) {
		Usuario_nombre = usuario_nombre;
	}
	public String getUsuario_correo() {
		return Usuario_correo;
	}
	public void setUsuario_correo(String usuario_correo) {
		Usuario_correo = usuario_correo;
	}
	public String getUsuario_contraseña() {
		return Usuario_contraseña;
	}
	public void setUsuario_contraseña(String usuario_contraseña) {
		Usuario_contraseña = usuario_contraseña;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idusuario;
		result = prime * result + ((Usuario_contraseña == null) ? 0 : Usuario_contraseña.hashCode());
		result = prime * result + ((Usuario_correo == null) ? 0 : Usuario_correo.hashCode());
		result = prime * result + ((Usuario_nombre == null) ? 0 : Usuario_nombre.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idusuario != other.idusuario)
			return false;
		if (Usuario_contraseña == null) {
			if (other.Usuario_contraseña != null)
				return false;
		} else if (!Usuario_contraseña.equals(other.Usuario_contraseña))
			return false;
		if (Usuario_correo == null) {
			if (other.Usuario_correo != null)
				return false;
		} else if (!Usuario_correo.equals(other.Usuario_correo))
			return false;
		if (Usuario_nombre == null) {
			if (other.Usuario_nombre != null)
				return false;
		} else if (!Usuario_nombre.equals(other.Usuario_nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [Usuario=" + idusuario + ", Usuario_nombre=" + Usuario_nombre + ", Usuario_correo="
				+ Usuario_correo + ", Usuario_contraseña=" + Usuario_contraseña + "]";
	}
	
	
	

}
