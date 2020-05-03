package com.backend.tienda.entity;


public class RegistroPedido {

	
	private int idproducto;
	private int idpedido;
	private int registropedido_cantidad;
	private float registropedido_preciototal;
	private String registropedido_detalles;
	private String registropedido_idoferta;
	
	
	public RegistroPedido() {
		
	}
	
	
	public RegistroPedido(int idproducto, int idpedido, int registropedido_cantidad, float registropedido_preciototal,
			String registropedido_detalles, String registropedido_idoferta) {
		this.idproducto = idproducto;
		this.idpedido = idpedido;
		this.registropedido_cantidad = registropedido_cantidad;
		this.registropedido_preciototal = registropedido_preciototal;
		this.registropedido_detalles = registropedido_detalles;
		this.registropedido_idoferta = registropedido_idoferta;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public int getRegistropedido_cantidad() {
		return registropedido_cantidad;
	}
	public void setRegistropedido_cantidad(int registropedido_cantidad) {
		this.registropedido_cantidad = registropedido_cantidad;
	}
	public float getRegistropedido_preciototal() {
		return registropedido_preciototal;
	}
	public void setRegistropedido_preciototal(float registropedido_preciototal) {
		this.registropedido_preciototal = registropedido_preciototal;
	}
	public String getRegistropedido_detalles() {
		return registropedido_detalles;
	}
	public void setRegistropedido_detalles(String registropedido_detalles) {
		this.registropedido_detalles = registropedido_detalles;
	}
	public String getRegistropedido_idoferta() {
		return registropedido_idoferta;
	}
	public void setRegistropedido_idoferta(String registropedido_idoferta) {
		this.registropedido_idoferta = registropedido_idoferta;
	}
	
	

}
