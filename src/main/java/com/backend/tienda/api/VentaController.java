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

import com.backend.tienda.entity.Orden_estado_empresa;
import com.backend.tienda.entity.Orden_estado_empresaPK;
import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.entity.Restaurante_PedidoModified;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.entity.VentaAndroid;
import com.backend.tienda.service.Orden_estado_restauranteService;
import com.backend.tienda.service.PedidoService;
import com.backend.tienda.service.Restaurante_PedidoService;
import com.backend.tienda.service.VentaService;
import com.backend.tienda.util.CalculatePriceDelivery;
import com.backend.tienda.util.CalculatePriceRestaurante;
import com.backend.tienda.util.CreateVenta;
import com.pusher.rest.Pusher;

@RestController
@RequestMapping(VentaController.VENTA_CONTROLLER)
public class VentaController {
	
	public final static String VENTA_CONTROLLER="/VentaController";
	
	public final static String REGISTRAR_VENTA="/registrar";
	
	public final static String LISTA_VENTA="/lista";
	
	public final static String UPDATE_VENTA="/updateTiempo/{idVenta}/{tiempo}";
	
	public final static String UPDATE_COSTO_TOTAL="/updateCosto/{idVenta}/{costoTotal}";
	
	public final static String CANCELAR_PEDIDO="/cancelar";


	
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
			
			respuesta=ventaService.registrarVenta(CreateVenta.venta(ventaAndroid, respuestaPedido.getIdpedido()));
			
			
			answerPedido=true;
		
			pedidoService.updatePedidoEstado(answerPedido,respuesta.getIdpedido());
			
			ventaAndroidAnswer = new VentaAndroid();
			ventaAndroidAnswer.setRepsuesta_registro_venta(true);
			Timestamp time=new Timestamp(System.currentTimeMillis());

			
			if(ventaAndroid.getNumeromesa()!=0) {
				Orden_estado_empresa ordenEstado=new Orden_estado_empresa();
				Orden_estado_empresaPK pk = new Orden_estado_empresaPK();
				pk.setIdventa(respuesta.getIdventa());
				pk.setIdestado_empresa(1);
				
				ordenEstado.setId(pk);
				ordenEstado.setIdempresa(ventaAndroid.getIdEmpresa());
				ordenEstado.setDetalle("");
				ordenEstado.setFecha(time);
				
				ordenService.registrarEstado(ordenEstado);
				
				//Restaurante_Pedido ordenReciente=restaurante_PedidoService.recientePedido(respuestaPedido.getIdempresa(), respuestaPedido.getIdpedido(), respuesta.getIdventa());
				
				Restaurante_PedidoModified ordenReciente=pedidoController.recientes(respuestaPedido.getIdempresa(), respuestaPedido.getIdpedido(), respuesta.getIdventa());

				pusher.setCluster("us2");
				
				pusher.trigger("canal-orden-reciente-"+respuestaPedido.getIdempresa(), "my-event", ordenReciente);
				
			}else {
				
				Orden_estado_empresa ordenEstado=new Orden_estado_empresa();
				Orden_estado_empresaPK pk = new Orden_estado_empresaPK();
				pk.setIdventa(respuesta.getIdventa());
				pk.setIdestado_empresa(1);
				
				ordenEstado.setId(pk);
				ordenEstado.setIdempresa(ventaAndroid.getIdEmpresa());
				ordenEstado.setDetalle("");
				ordenEstado.setFecha(time);
				
				ordenService.registrarEstado(ordenEstado);
				
				/*INSERTAMOS DOS ESTADO*/
				
				Timestamp time2=new Timestamp(System.currentTimeMillis());

				Orden_estado_empresa ordenEstado2=new Orden_estado_empresa();
				Orden_estado_empresaPK pk2 = new Orden_estado_empresaPK();
				pk.setIdventa(respuesta.getIdventa());
				pk.setIdestado_empresa(2);
				
				ordenEstado2.setId(pk2);
				ordenEstado2.setIdempresa(ventaAndroid.getIdEmpresa());
				ordenEstado2.setDetalle("");
				ordenEstado2.setFecha(time2);
				
				ordenService.registrarEstado(ordenEstado2);

				
				//Restaurante_Pedido ordenReciente=restaurante_PedidoService.recientePedido(respuestaPedido.getIdempresa(), respuestaPedido.getIdpedido(), respuesta.getIdventa());
				
				Restaurante_PedidoModified ordenReciente=pedidoController.recientes(respuestaPedido.getIdempresa(), respuestaPedido.getIdpedido(), respuesta.getIdventa());

				pusher.setCluster("us2");
				
				pusher.trigger("canal-orden-proces-"+respuestaPedido.getIdempresa(), "my-event", ordenReciente);
			}
			
			
		

			
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
		Venta venta2=null;
		
		
		try {
		
			venta2=ventaService.updateVentaCancelarPedido(venta.getIdestado_empresa(),venta.getComentario());
			
			
			respuesta= new VentaAndroid();
			
			respuesta.setRepsuesta_registro_venta(true);
			
		}catch(Exception e) {
			return new  ResponseEntity<VentaAndroid> (respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<VentaAndroid> (respuesta,HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
