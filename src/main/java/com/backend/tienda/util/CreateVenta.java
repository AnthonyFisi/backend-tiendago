package com.backend.tienda.util;

import com.backend.tienda.entity.Venta;
import com.backend.tienda.entity.VentaAndroid;

import com.backend.tienda.util.CalculatePriceDelivery;

import java.sql.Timestamp;


public class CreateVenta {


	public static Venta venta(VentaAndroid ventaAndroid,int idPedido) {

		String newDate=ventaAndroid.getVenta_fechaentrega()+" 00:00:00.000";

		Timestamp ventaFecha=new Timestamp(System.currentTimeMillis());

		Timestamp ventaFecha_entrega=Timestamp.valueOf(newDate);



		Venta venta= new Venta();

		venta.setIdventa(0);
		venta.setIdtipopago(ventaAndroid.getIdtipopago());
		venta.setIdhorario(ventaAndroid.getIdhorario());
		venta.setIdubicacion(ventaAndroid.getIdubicacion());
		venta.setIdpedido(idPedido);
		venta.setVenta_fecha(ventaFecha);

		venta.setVenta_fechaentrega(ventaFecha_entrega);
		//REEMPLAZAMOS EL PRECIO DEL DELIVERY DEL COMERCIO POR LA GANANCIA QUE DA A LA EMPRESA YEGoO
		venta.setVenta_costodelivery(ventaAndroid.getVenta_costodelivery());
		venta.setVenta_costototal(ventaAndroid.getVenta_costototal());
		venta.setComentario(ventaAndroid.getComentario());
		venta.setIdestado_empresa(1);
		venta.setIdestado_pago(ventaAndroid.getIdestado_pago());
		venta.setIdtipo_envio(ventaAndroid.getIdtipo_envio());
		venta.setComentario_entrega("");
		venta.setDistancia_delivery("0 km");
		venta.setCosto_delivery(0);
		venta.setOrden_disponible(true);
		venta.setTiempo_espera(String.valueOf(0));
		venta.setTiempo_aprox_delivery("");
		venta.setIdrepartidor(0);
		venta.setCancelar(false);
		venta.setComentario_cancelar("");


		venta.setTiempototal_espera("0");
		venta.setTiempo_espera("0");

		venta.setIdestado_delivery(0);
		venta.setIdestado_general(0);
		venta.setNumeromesa(ventaAndroid.getNumeromesa());
		venta.setMesa(ventaAndroid.isMesa());
		venta.setDescuento_mesa(ventaAndroid.getDescuento_mesa());
		venta.setVenta_costopedido(venta.getVenta_costopedido());
		return venta;
	}



}
