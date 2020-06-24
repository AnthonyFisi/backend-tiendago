package com.backend.tienda.api;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.Orden_estado_restaurantePK;
import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.entity.VentaAndroid;
import com.backend.tienda.service.Orden_estado_restauranteService;
import com.backend.tienda.service.PedidoService;
import com.backend.tienda.service.VentaService;

@RestController
@RequestMapping(VentaController.VENTA_CONTROLLER)
public class VentaController {
	
	public final static String VENTA_CONTROLLER="/VentaController";
	
	public final static String REGISTRAR_VENTA="/registrar";
	
	public final static String LISTA_VENTA="/lista";
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	Orden_estado_restauranteService ordenService;
	
	
	@RequestMapping(value=REGISTRAR_VENTA,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VentaAndroid>  registrarVenta(@RequestBody VentaAndroid ventaAndroid){
		
		Venta respuesta=null;
		
		VentaAndroid ventaAndroidAnswer=null;
		
		Pedido respuestaPedido =new Pedido();
		
		boolean answerPedido= false;

		
		respuestaPedido=pedidoService.findByIdUsuario(ventaAndroid.getIdUsuario(),ventaAndroid.getIdEmpresa());
		
		try {
			
			respuesta=ventaService.registrarVenta(VentaAndroid.createVenta(ventaAndroid, respuestaPedido.getIdpedido()));
			
			/*
			 * 
			 * FALTA CALCULAR LOS DATOS DE KILOMETROS ,TIEMPO RECORRIDO ,COSTO DPRO KM
			 * ETC
			 * */
			answerPedido=true;
		
			pedidoService.updatePedidoEstado(answerPedido,respuesta.getIdpedido());
			
			ventaAndroidAnswer = new VentaAndroid();
			ventaAndroidAnswer.setRepsuesta_registro_venta(true);
			Timestamp time=new Timestamp(System.currentTimeMillis());

			Orden_estado_restaurante ordenEstado=new Orden_estado_restaurante();
			Orden_estado_restaurantePK pk = new Orden_estado_restaurantePK();
			pk.setIdventa(respuesta.getIdventa());
			pk.setIdestado_venta(1);
			
			ordenEstado.setId(pk);
			ordenEstado.setDetalle("");
			ordenEstado.setFecha(time);
			
			ordenService.registrarEstado(ordenEstado);
			
			/*EN EL FUTURO PODEMOS AGREGAR UN PUSHER PARA MANDAR A NOTIFICAR A LA APP DE RESTAURANTE */
			
		}catch(Exception e) {
			return new  ResponseEntity<VentaAndroid>(ventaAndroidAnswer,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<VentaAndroid>(ventaAndroidAnswer,HttpStatus.OK);
	}
	
	
	@RequestMapping(value=LISTA_VENTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Venta>>  listaTotalVenta(){
		
		List<Venta> respuesta=null;
		try {
			
			respuesta=ventaService.listaVentaTotal();
			
		}catch(Exception e) {
			return new  ResponseEntity<List<Venta>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<List<Venta>>(respuesta,HttpStatus.OK);
	}
}
