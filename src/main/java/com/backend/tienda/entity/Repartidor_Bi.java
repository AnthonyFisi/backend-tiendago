package com.backend.tienda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="repartidor_bi")
public class Repartidor_Bi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuariogeneral", updatable = false, nullable = false)
	private int idusuariogeneral;

	private int idrepartidor;
		
	private String nombre_usuario;
	
	private String correo;
	
	private String apellido;
	
	private String celular;
	
	private String foto;
	
	private  int idcuentarepartidor;
	
	private boolean activa;
	
	private int idtarifa;
	
	private String nombre_tarifa;
	
	private float monto;
	
	private int idtipocuenta;
	
	private String nombre_cuenta;
		
	private String placa_vehiculo;
	
	private String imagen_vehiculo;

	private boolean disponible;
	
	private int idempresa;

	public int getIdusuariogeneral() {
		return idusuariogeneral;
	}

	public void setIdusuariogeneral(int idusuariogeneral) {
		this.idusuariogeneral = idusuariogeneral;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIdcuentarepartidor() {
		return idcuentarepartidor;
	}

	public void setIdcuentarepartidor(int idcuentarepartidor) {
		this.idcuentarepartidor = idcuentarepartidor;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public int getIdtarifa() {
		return idtarifa;
	}

	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}

	public String getNombre_tarifa() {
		return nombre_tarifa;
	}

	public void setNombre_tarifa(String nombre_tarifa) {
		this.nombre_tarifa = nombre_tarifa;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public int getIdtipocuenta() {
		return idtipocuenta;
	}

	public void setIdtipocuenta(int idtipocuenta) {
		this.idtipocuenta = idtipocuenta;
	}

	public String getNombre_cuenta() {
		return nombre_cuenta;
	}

	public void setNombre_cuenta(String nombre_cuenta) {
		this.nombre_cuenta = nombre_cuenta;
	}

	public int getIdrepartidor() {
		return idrepartidor;
	}

	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}

	public String getPlaca_vehiculo() {
		return placa_vehiculo;
	}

	public void setPlaca_vehiculo(String placa_vehiculo) {
		this.placa_vehiculo = placa_vehiculo;
	}

	public String getImagen_vehiculo() {
		return imagen_vehiculo;
	}

	public void setImagen_vehiculo(String imagen_vehiculo) {
		this.imagen_vehiculo = imagen_vehiculo;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDiponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	
	
	

}
