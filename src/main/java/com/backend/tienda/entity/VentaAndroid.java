package com.backend.tienda.entity;

import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

public class VentaAndroid {

	
	private int idEmpresa;
	
	private int idtipopago;
	
	private int idhorario;
	
	private int idubicacion;
	
	private int idpedido;
	
	private String venta_fecha;
	
	private String venta_fechaentrega;
	
	private float venta_costodelivery;
	
	private float venta_costototal;
	
	private String comentario;
	
	private int idestado_venta;
	
	private int idestado_pago;
	
	private int idtipo_envio;
	
	private int idUsuario;

	private boolean repsuesta_registro_venta;	
	

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdtipopago() {
		return idtipopago;
	}

	public void setIdtipopago(int idtipopago) {
		this.idtipopago = idtipopago;
	}

	public int getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

	public int getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	
	


	public String getVenta_fecha() {
		return venta_fecha;
	}

	public void setVenta_fecha(String venta_fecha) {
		this.venta_fecha = venta_fecha;
	}

	public String getVenta_fechaentrega() {
		return venta_fechaentrega;
	}

	public void setVenta_fechaentrega(String venta_fechaentrega) {
		this.venta_fechaentrega = venta_fechaentrega;
	}

	public float getVenta_costodelivery() {
		return venta_costodelivery;
	}

	public void setVenta_costodelivery(float venta_costodelivery) {
		this.venta_costodelivery = venta_costodelivery;
	}

	public float getVenta_costototal() {
		return venta_costototal;
	}

	public void setVenta_costototal(float venta_costototal) {
		this.venta_costototal = venta_costototal;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdestado_venta() {
		return idestado_venta;
	}

	public void setIdestado_venta(int idestado_venta) {
		this.idestado_venta = idestado_venta;
	}

	public int getIdestado_pago() {
		return idestado_pago;
	}

	public void setIdestado_pago(int idestado_pago) {
		this.idestado_pago = idestado_pago;
	}

	public int getIdtipo_envio() {
		return idtipo_envio;
	}

	public void setIdtipo_envio(int idtipo_envio) {
		this.idtipo_envio = idtipo_envio;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
	public boolean isRepsuesta_registro_venta() {
		return repsuesta_registro_venta;
	}

	public void setRepsuesta_registro_venta(boolean repsuesta_registro_venta) {
		this.repsuesta_registro_venta = repsuesta_registro_venta;
	}

	public static Venta createVenta(VentaAndroid ventaAndroid,int idPedido) {
		
		String newDate=ventaAndroid.getVenta_fechaentrega()+" 00:00:00.000";
		
		Timestamp ventaFecha=new Timestamp(System.currentTimeMillis());
		Timestamp ventaFecha_entrega=Timestamp.valueOf(newDate);

		
		Venta venta= new Venta
				(
					0,
					ventaAndroid.getIdtipopago(),
					ventaAndroid.getIdhorario(),
					ventaAndroid.getIdubicacion(),
					idPedido,
					ventaFecha,
					ventaFecha_entrega,
					ventaAndroid.getVenta_costodelivery(),
					ventaAndroid.getVenta_costototal(),
					ventaAndroid.getComentario(),
					ventaAndroid.getIdestado_venta(),
					ventaAndroid.getIdestado_pago(),
					ventaAndroid.getIdtipo_envio(),
					"",
					0,
					0,
					true,
					"20 minutos",
					1,
					false,
					"",
					6
				);
		return venta;
	}

	
	
	
	
	
}
