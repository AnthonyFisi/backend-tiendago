package com.backend.tienda.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.backend.tienda.models.Role;

@Entity
@Table(	name = "usuario_general", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "correo") 
		})
public class Usuario_general {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuariogeneral;

	
	private String nombre;

	
	@Email
	private String correo;

	
	private String contrasena;
	
	
	private String apellido;
	
	
	private String celular;
	
	
	private String foto;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "usuariogeneral_roles", 
				joinColumns = @JoinColumn(name = "idusuariogeneral"), 
				inverseJoinColumns = @JoinColumn(name = "idrole")
	
			)
	private Set<Roles> roles = new HashSet<>();
	
	public Usuario_general() {
		
	}
	
	
	

	public Usuario_general( String nombre,
			String correo,  String contrasena,
			String apellido,  String celular,
			 String foto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.apellido = apellido;
		this.celular = celular;
		this.foto = foto;
	}



	

	
	public int getIdusuariogeneral() {
		return idusuariogeneral;
	}




	public void setIdusuariogeneral(int idusuariogeneral) {
		this.idusuariogeneral = idusuariogeneral;
	}




	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}



	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	

	

	
	
	
	
	


}
