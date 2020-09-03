package com.backend.tienda.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="empresa")
public class EmpresaOficial{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempresa", updatable = false, nullable = false)
	private int idempresa;

	
	private int idsubcategoriaempresa;
	 	
	private String nombre_empresa;
	
	private String direccion_empresa;
	
	private String ruc_empresa;
	
	private String telefono_empresa;
	
	private String celular_empresa;
	
	private String descripcion_empresa;
	
	private String urlfoto_empresa;
	
	private String nombredueno_empresa;
		
	private double porcentaje_popularidad;

	private boolean cuenta_delivery;
	
	private float costo_delivery;
	
	private String detalle_delivery;
	
	
	private int iddistrito;
	
	private String tiempo_aproximado_entrega;
	
	private String icono_empresa;
	
	private int horario_inicio;
	
	private int horario_fin;
	
	private boolean tarjeta;
	
	private String detalle_tarjeta;
	
	private float estrella_empresa;
	
	
	private String maps_coordenada_x;
	
	private String maps_coordenada_y;
	
	private String detalle_ubicacion;

	private boolean disponible;
		
		
	private float precio_menu;
	
	private float monto_descuento_menu;
	
	private int idusuariogeneral;
	

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getIcono_empresa() {
		return icono_empresa;
	}

	public void setIcono_empresa(String icono_empresa) {
		this.icono_empresa = icono_empresa;
	}

	public String getDireccion_empresa() {
		return direccion_empresa;
	}

	public void setDireccion_empresa(String direccion_empresa) {
		this.direccion_empresa = direccion_empresa;
	}

	public boolean isCuenta_delivery() {
		return cuenta_delivery;
	}

	public void setCuenta_delivery(boolean cuenta_delivery) {
		this.cuenta_delivery = cuenta_delivery;
	}

	public int getIddistrito() {
		return iddistrito;
	}

	public void setIddistrito(int iddistrito) {
		this.iddistrito = iddistrito;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public String getTiempo_aproximado_entrega() {
		return tiempo_aproximado_entrega;
	}

	public void setTiempo_aproximado_entrega(String tiempo_aproximado_entrega) {
		this.tiempo_aproximado_entrega = tiempo_aproximado_entrega;
	}



	public float getCosto_delivery() {
		return costo_delivery;
	}

	public void setCosto_delivery(float costo_delivery) {
		this.costo_delivery = costo_delivery;
	}

	public String getDetalle_delivery() {
		return detalle_delivery;
	}

	public void setDetalle_delivery(String detalle_delivery) {
		this.detalle_delivery = detalle_delivery;
	}

	

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public int getIdsubcategoriaempresa() {
		return idsubcategoriaempresa;
	}

	public void setIdsubcategoriaempresa(int idsubcategoriaempresa) {
		this.idsubcategoriaempresa = idsubcategoriaempresa;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getRuc_empresa() {
		return ruc_empresa;
	}

	public void setRuc_empresa(String ruc_empresa) {
		this.ruc_empresa = ruc_empresa;
	}

	public String getTelefono_empresa() {
		return telefono_empresa;
	}

	public void setTelefono_empresa(String telefono_empresa) {
		this.telefono_empresa = telefono_empresa;
	}

	public String getCelular_empresa() {
		return celular_empresa;
	}

	public void setCelular_empresa(String celular_empresa) {
		this.celular_empresa = celular_empresa;
	}



	public String getDescripcion_empresa() {
		return descripcion_empresa;
	}

	public void setDescripcion_empresa(String descripcion_empresa) {
		this.descripcion_empresa = descripcion_empresa;
	}

	public String getUrlfoto_empresa() {
		return urlfoto_empresa;
	}

	public void setUrlfoto_empresa(String urlfoto_empresa) {
		this.urlfoto_empresa = urlfoto_empresa;
	}

	public String getNombredueno_empresa() {
		return nombredueno_empresa;
	}

	public void setNombredueno_empresa(String nombredueno_empresa) {
		this.nombredueno_empresa = nombredueno_empresa;
	}


	
	

	public double getPorcentaje_popularidad() {
		return porcentaje_popularidad;
	}

	public void setPorcentaje_popularidad(double porcentaje_popularidad) {
		this.porcentaje_popularidad = porcentaje_popularidad;
	}

	public int getHorario_inicio() {
		return horario_inicio;
	}

	public void setHorario_inicio(int horario_inicio) {
		this.horario_inicio = horario_inicio;
	}

	public int getHorario_fin() {
		return horario_fin;
	}

	public void setHorario_fin(int horario_fin) {
		this.horario_fin = horario_fin;
	}

	public boolean isTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(boolean tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getDetalle_tarjeta() {
		return detalle_tarjeta;
	}

	public void setDetalle_tarjeta(String detalle_tarjeta) {
		this.detalle_tarjeta = detalle_tarjeta;
	}

	public float getEstrella_empresa() {
		return estrella_empresa;
	}

	public void setEstrella_empresa(float estrella_empresa) {
		this.estrella_empresa = estrella_empresa;
	}

	
	public String getMaps_coordenada_x() {
		return maps_coordenada_x;
	}

	public void setMaps_coordenada_x(String maps_coordenada_x) {
		this.maps_coordenada_x = maps_coordenada_x;
	}

	public String getMaps_coordenada_y() {
		return maps_coordenada_y;
	}

	public void setMaps_coordenada_y(String maps_coordenada_y) {
		this.maps_coordenada_y = maps_coordenada_y;
	}

	public String getDetalle_ubicacion() {
		return detalle_ubicacion;
	}

	public void setDetalle_ubicacion(String detalle_ubicacion) {
		this.detalle_ubicacion = detalle_ubicacion;
	}



	public float getPrecio_menu() {
		return precio_menu;
	}

	public void setPrecio_menu(float precio_menu) {
		this.precio_menu = precio_menu;
	}

	public float getMonto_descuento_menu() {
		return monto_descuento_menu;
	}

	public void setMonto_descuento_menu(float monto_descuento_menu) {
		this.monto_descuento_menu = monto_descuento_menu;
	}

	public int getIdusuariogeneral() {
		return idusuariogeneral;
	}

	public void setIdusuariogeneral(int idusuariogeneral) {
		this.idusuariogeneral = idusuariogeneral;
	}
	
	



}
