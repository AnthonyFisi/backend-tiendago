package com.backend.tienda.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresa")

public class Empresa{

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
	
	private int idcuentaempresa;
	
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
	
	
	private String productospopulares;
	
	private String categoria1;
	
	private String categoria2;
	
	private String categoria3;

	private String categoria4;

	

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

	
	public int getIdcuentaempresa() {
		return idcuentaempresa;
	}

	public void setIdcuentaempresa(int idcuentaempresa) {
		this.idcuentaempresa = idcuentaempresa;
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

	public String getProductospopulares() {
		return productospopulares;
	}

	public void setPropductospopulares(String propductospopulares) {
		this.productospopulares = propductospopulares;
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

	public String getCategoria4() {
		return categoria4;
	}

	public void setCategoria4(String categoria4) {
		this.categoria4 = categoria4;
	}


	
	
	

}
