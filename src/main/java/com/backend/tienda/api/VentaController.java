package com.backend.tienda.api;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.Orden_estado_restaurantePK;
import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.entity.Restaurante_PedidoModified;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.entity.VentaAndroid;
import com.backend.tienda.service.Orden_estado_restauranteService;
import com.backend.tienda.service.PedidoService;
import com.backend.tienda.service.Restaurante_PedidoService;
import com.backend.tienda.service.VentaService;
import com.pusher.rest.Pusher;

@RestController
@RequestMapping(VentaController.VENTA_CONTROLLER)
public class VentaController {
	
	public final static String VENTA_CONTROLLER="/VentaController";
	
	public final static String REGISTRAR_VENTA="/registrar";
	
	public final static String LISTA_VENTA="/lista";
	
	public final static String UPDATE_VENTA="/updateTiempo/{idVenta}/{tiempo}";
	
	public final static String UPDATE_COSTO_TOTAL="/updateCosto/{idVenta}/{costoTotal}";
	
	public final static String CANCELAR_PEDIDO="/cancelar/{idVenta}/{comentario_cancelar}";


	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	Orden_estado_restauranteService ordenService;
	
	@Autowired
	Restaurante_PedidoService restaurante_PedidoService;
	
	@Autowired
	Restaurante_PedidoController pedidoController;
	
	Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");

	

	
	
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
			
			//Restaurante_Pedido ordenReciente=restaurante_PedidoService.recientePedido(respuestaPedido.getIdempresa(), respuestaPedido.getIdpedido(), respuesta.getIdventa());
			Restaurante_PedidoModified ordenReciente=pedidoController.recientes(respuestaPedido.getIdempresa(), respuestaPedido.getIdpedido(), respuesta.getIdventa());

			pusher.setCluster("us2");
			
			pusher.trigger("canal-orden-reciente-"+respuestaPedido.getIdempresa(), "my-event", ordenReciente);
			

			
			
			
			/*EN EL FUTURO PODEMOS AGREGAR UN PUSHER PARA MANDAR A NOTIFICAR A LA APP DE RESTAURANTE */
			
		}catch(Exception e) {
			System.out.println(e.getMessage());

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
	
	

	@RequestMapping(value=UPDATE_VENTA,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VentaAndroid>  updateTiempo(@PathVariable("idVenta")int idVenta,@PathVariable("tiempo")int tiempo){
		
		VentaAndroid  respuesta=null;
		Venta venta=null;
		
		
		try {
		
			venta=ventaService.updateVentaTiempoEspera(idVenta, tiempo);
			
			
			respuesta= new VentaAndroid();
			
			respuesta.setRepsuesta_registro_venta(true);
			
		}catch(Exception e) {
			return new  ResponseEntity<VentaAndroid> (respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<VentaAndroid> (respuesta,HttpStatus.OK);
	}
	
	
	@RequestMapping(value=UPDATE_COSTO_TOTAL,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VentaAndroid>  updateCostoTotal(@PathVariable("idVenta")int idVenta,@PathVariable("costoTotal")float costoTotal){
		
		VentaAndroid  respuesta=null;
		Venta venta=null;
		
		
		try {
		
			venta=ventaService.updateVentaPrecioTotal(idVenta, costoTotal);
			
			
			respuesta= new VentaAndroid();
			
			respuesta.setRepsuesta_registro_venta(true);
			
		}catch(Exception e) {
			return new  ResponseEntity<VentaAndroid> (respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<VentaAndroid> (respuesta,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value=CANCELAR_PEDIDO,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VentaAndroid>  cancelarPedido(@RequestBody Venta venta){
		 
		VentaAndroid  respuesta=null;
		Venta venta=null;
		
		
		try {
		
			venta=ventaService.updateVentaCancelarPedido(venta.getIdestado_venta(),venta.getComentario());
			
			
			respuesta= new VentaAndroid();
			
			respuesta.setRepsuesta_registro_venta(true);
			
		}catch(Exception e) {
			return new  ResponseEntity<VentaAndroid> (respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<VentaAndroid> (respuesta,HttpStatus.OK);
	}
}
