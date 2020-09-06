package com.backend.tienda.entity;

import java.sql.Timestamp;
import java.util.List;

public class Restaurante_PedidoModified {
	
	private int idventa;

	private int idtipopago;
	
	private String tipopago_nombre;
	
	private int idhorario;
	
	private String horario_nombre;
	
	private int idubicacion;
	
	private int idpedido;
	
	private int idempresa;
	
	private int pedido_cantidadtotal;

	private int idusuario;
	
	private int idusuariogeneral;
	
	private String nombre;
	
	private String apellido;
	
	private String celular;
	
	
	private Timestamp ventafecha;
	
	private Timestamp ventafechaentrega;
	
	private float venta_costodelivery;
	
	private float venta_costototal;
	
	private String comentario;
	
	private int idestadoempresa;

	private int idestado_pago;
	
	private String nombre_estadopago;
	
	private int idtipo_envio;

	private String nombre_tipo_envio;

	private boolean ordendisponible;

	
	private String tiempo_espera;
	
	private int idrepartidor;

	private boolean cancelar;

	private String comentario_cancelar;
	
	private int idestadodelivery;
	
	private int idestadogeneral;
	
	private int numeromesa;
	
	private float descuento_mesa;
	
	private boolean mesa;
	
	private String fechaAceptado;
		
	private Repartidor_Bi repartidor_bi;
	
	List<ProductoJOINregistroPedidoJOINpedido> listaProductos;
	
	
	public boolean isCancelar() {
		return cancelar;
	}

	public void setCancelar(boolean cancelar) {
		this.cancelar = cancelar;
	}

	public int getPedido_cantidadtotal() {
		return pedido_cantidadtotal;
	}

	public void setPedido_cantidadtotal(int pedido_cantidadtotal) {
		this.pedido_cantidadtotal = pedido_cantidadtotal;
	}


	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public int getIdventa() {
		return idventa;
	}

	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}

	public int getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
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


	public int getIdestado_pago() {
		return idestado_pago;
	}

	public void setIdestado_pago(int idestado_pago) {
		this.idestado_pago = idestado_pago;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}



	public int getIdrepartidor() {
		return idrepartidor;
	}

	public void setIdrepartidor(int idrepartidor) {
		this.idrepartidor = idrepartidor;
	}

	public int getIdtipopago() {
		return idtipopago;
	}

	public void setIdtipopago(int idtipopago) {
		this.idtipopago = idtipopago;
	}

	public String getTipopago_nombre() {
		return tipopago_nombre;
	}

	public void setTipopago_nombre(String tipopago_nombre) {
		this.tipopago_nombre = tipopago_nombre;
	}

	

	public int getIdtipo_envio() {
		return idtipo_envio;
	}

	public void setIdtipo_envio(int idtipo_envio) {
		this.idtipo_envio = idtipo_envio;
	}

	public String getNombre_tipo_envio() {
		return nombre_tipo_envio;
	}

	public void setNombre_tipo_envio(String nombre_tipo_envio) {
		this.nombre_tipo_envio = nombre_tipo_envio;
	}

	public String getTiempo_espera() {
		return tiempo_espera;
	}

	public void setTiempo_espera(String tiempo_espera) {
		this.tiempo_espera = tiempo_espera;
	}

	public List<ProductoJOINregistroPedidoJOINpedido> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoJOINregistroPedidoJOINpedido> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	

	

	public Timestamp getVentafecha() {
		return ventafecha;
	}

	public void setVentafecha(Timestamp ventafecha) {
		this.ventafecha = ventafecha;
	}

	public Timestamp getVentafechaentrega() {
		return ventafechaentrega;
	}

	public void setVentafechaentrega(Timestamp ventafechaentrega) {
		this.ventafechaentrega = ventafechaentrega;
	}


	public int getIdestadoempresa() {
		return idestadoempresa;
	}

	public void setIdestadoempresa(int idestadoempresa) {
		this.idestadoempresa = idestadoempresa;
	}

	public int getIdestadodelivery() {
		return idestadodelivery;
	}

	public void setIdestadodelivery(int idestadodelivery) {
		this.idestadodelivery = idestadodelivery;
	}

	public int getIdestadogeneral() {
		return idestadogeneral;
	}

	public void setIdestadogeneral(int idestadogeneral) {
		this.idestadogeneral = idestadogeneral;
	}

	public int getNumeromesa() {
		return numeromesa;
	}

	public void setNumeromesa(int numeromesa) {
		this.numeromesa = numeromesa;
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

	public boolean isOrdendisponible() {
		return ordendisponible;
	}

	public void setOrdendisponible(boolean ordendisponible) {
		this.ordendisponible = ordendisponible;
	}
	
	
/*                ****************************************/
	public int getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

	public String getHorario_nombre() {
		return horario_nombre;
	}

	public void setHorario_nombre(String horario_nombre) {
		this.horario_nombre = horario_nombre;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getNombre_estadopago() {
		return nombre_estadopago;
	}

	public void setNombre_estadopago(String nombre_estadopago) {
		this.nombre_estadopago = nombre_estadopago;
	}

	public String getComentario_cancelar() {
		return comentario_cancelar;
	}

	public void setComentario_cancelar(String comentario_cancelar) {
		this.comentario_cancelar = comentario_cancelar;
	}
	
	

	public String getFechaAceptado() {
		return fechaAceptado;
	}

	public void setFechaAceptado(String fechaAceptado) {
		this.fechaAceptado = fechaAceptado;
	}
	

	public Repartidor_Bi getRepartidor_bi() {
		return repartidor_bi;
	}

	public void setRepartidor_bi(Repartidor_Bi repartidor_bi) {
		this.repartidor_bi = repartidor_bi;
	}

	
	
	public float getDescuento_mesa() {
		return descuento_mesa;
	}

	public void setDescuento_mesa(float descuento_mesa) {
		this.descuento_mesa = descuento_mesa;
	}

	public boolean isMesa() {
		return mesa;
	}

	public void setMesa(boolean mesa) {
		this.mesa = mesa;
	}

	public static Restaurante_PedidoModified convert(Restaurante_Pedido pedido) {
		
		Restaurante_PedidoModified res =null;

			 res = new Restaurante_PedidoModified();
			res.setIdpedido(pedido.getIdpedido());
			res.setIdempresa(pedido.getIdempresa());
			res.setIdventa(pedido.getIdventa());
			res.setIdubicacion(pedido.getIdubicacion());
			res.setVentafecha(pedido.getVentafecha());
			res.setVentafechaentrega(pedido.getVentafechaentrega());
			res.setVenta_costodelivery(pedido.getVenta_costodelivery());
			
			
			
			res.setVenta_costototal(pedido.getVenta_costototal());
			res.setComentario(pedido.getComentario());
			res.setIdestado_pago(pedido.getIdestado_pago());
			res.setNombre_estadopago(pedido.getNombre_estadopago());
			
			
			res.setIdusuario(pedido.getIdusuario());
			res.setNombre(pedido.getNombre());
			res.setCelular(pedido.getCelular());
			res.setOrdendisponible(pedido.isOrdendisponible());
			res.setIdrepartidor(pedido.getIdrepartidor());
			res.setIdtipopago(pedido.getIdtipopago());
			
			res.setTipopago_nombre(pedido.getTipopago_nombre());
			res.setIdtipopago(pedido.getIdtipopago());
			res.setTipopago_nombre(pedido.getTipopago_nombre());
			res.setPedido_cantidadtotal(pedido.getPedido_cantidadtotal());
			res.setTiempo_espera(pedido.getTiempo_espera());
			
			res.setNombre_tipo_envio(pedido.getNombre_tipo_envio());
			res.setCancelar(pedido.isCancelar());
			
			res.setIdestadodelivery(pedido.getIdestadodelivery());
			res.setIdestadoempresa(pedido.getIdestadoempresa());
			res.setIdestadogeneral(pedido.getIdestadogeneral());
			
			res.setIdhorario(pedido.getIdhorario());
			res.setHorario_nombre(pedido.getHorario_nombre());
			res.setNombre_estadopago(pedido.getNombre_estadopago());
			res.setComentario_cancelar(pedido.getComentario_cancelar());
			
			res.setNumeromesa(pedido.getNumeromesa());
			res.setIdusuariogeneral(pedido.getIdusuariogeneral());
			res.setApellido(pedido.getApellido());
			res.setIdtipo_envio(pedido.getIdtipo_envio());
			
			
			res.setDescuento_mesa(pedido.getDescuento_mesa());
			res.setMesa(pedido.isMesa());
		
		return res;
		
	}
	



}
