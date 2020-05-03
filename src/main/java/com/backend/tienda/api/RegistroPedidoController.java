package com.backend.tienda.api;

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

import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.PedidoSend;
import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.service.PedidoService;
import com.backend.tienda.service.RegistroPedidoService;
import com.pusher.rest.Pusher;


@RestController
@RequestMapping("/RegistroPedido")
public class RegistroPedidoController {
	@Autowired
	RegistroPedidoService service;
	
	@Autowired
	PedidoService servicePedido;
	
	@RequestMapping(value="/agregarRegistroPedido", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void agregarPedido(@RequestBody RegistroPedido registroPedido) {
		service.guardarRegistroPedido(registroPedido);
	}
	
	
	@RequestMapping(value="/mostrarRegistroPedido",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegistroPedido>> mostrarByIdPedido(){
		List<RegistroPedido> listaPedido=service.listaRegistroPedido();
		return new ResponseEntity<List<RegistroPedido>>(listaPedido,HttpStatus.OK);	
	}
	
	
	@RequestMapping(value="/mostrarProductoExistente/{idUsuario}/{idProducto}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistroPedido> mostrarProductoExistente(
			@PathVariable("idUsuario")int idUsuario,
			@PathVariable("idProducto")int  idProducto
			){

		Pedido pedido=servicePedido.findByidUsuarioAutenticacion(idUsuario);
		RegistroPedido registroPedido3=null;
		
		try {
			
			registroPedido3=service.findByPedidoAndProducto(pedido.getIdpedido(),idProducto);
			
			
		}catch(Exception e) {
			
			if(registroPedido3 == null) {
				 registroPedido3 = new RegistroPedido();
				
			}
			return new ResponseEntity<RegistroPedido>(registroPedido3, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return new ResponseEntity<RegistroPedido>(registroPedido3,HttpStatus.OK);	

	
	}
	
	
	@RequestMapping(value="/eliminarRegistroPedido/{idUsuario}/{idProducto}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarProducto(@PathVariable("idUsuario")int idUsuario,@PathVariable("idProducto")int idProducto){
		
		Pedido pedido=servicePedido.findByidUsuario(idUsuario);
		RegistroPedido registroPedido2=service.findByPedidoAndProducto(pedido.getIdpedido(),idProducto);
		int nuevaCantidad=pedido.getPedido_cantidadtotal();
		float nuevoCosto=pedido.getPedido_montototal();
		
		service.eliminarRegistroPedido(pedido.getIdpedido(), idProducto);
		
		nuevaCantidad=nuevaCantidad-registroPedido2.getRegistropedido_cantidad();
		nuevoCosto=nuevoCosto-registroPedido2.getRegistropedido_preciototal();
		
		
		servicePedido.actualizarPrecioTotalPedido(nuevoCosto,nuevaCantidad, pedido.getIdpedido());
	
		try {
			String rpta="";
			RegistroPedido registroPedido=service.findByPedidoAndProducto(pedido.getIdpedido(),idProducto);
			if(registroPedido==null) {
				rpta="NoEliminado";
			}
			return new ResponseEntity<String>(rpta,HttpStatus.BAD_REQUEST);	
		}catch(Exception e) {
			return new ResponseEntity<String>("Eliminado",HttpStatus.OK);	
		}
	
	}
	

	@RequestMapping(value="/incrementarCantidad",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> incrementarCantidadProducto(@RequestBody PedidoSend pedidoSend){
		
		Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");
		pusher.setCluster("us2");
		pusher.setEncrypted(true);
		Pedido pedidoGlobal=servicePedido.findByidUsuario(pedidoSend.getIdUsuario());
				
		RegistroPedido registroPedido=service.findByPedidoAndProducto(pedidoGlobal.getIdpedido(),pedidoSend.getIdProducto());
				
		
		int nuevaCantidad=registroPedido.getRegistropedido_cantidad() + pedidoSend.getCantidad();
		float nuevoPrecio=registroPedido.getRegistropedido_preciototal()+pedidoSend.getPrecio();
		float nuevoCostoTotal=0;
		int cantidadTotal=0;
		
		nuevoCostoTotal=pedidoGlobal.getPedido_montototal()+pedidoSend.getPrecio();
		cantidadTotal=pedidoGlobal.getPedido_cantidadtotal()+pedidoSend.getCantidad();
		
		servicePedido.actualizarPrecioTotalPedido(nuevoCostoTotal,cantidadTotal, pedidoGlobal.getIdpedido());
		
		service.actualizarRegistroPedido(pedidoGlobal.getIdpedido(),pedidoSend.getIdProducto(),nuevaCantidad,nuevoPrecio);
		pusher.trigger("my-channel2", "my-event2", Collections.singletonMap("message",nuevaCantidad));
		pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", cantidadTotal));



		return new ResponseEntity<String>("fue aumentado",HttpStatus.OK);	
	}
	
	@RequestMapping(value="/disminuirCantidad",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> disminuirCantidadProducto(@RequestBody PedidoSend pedidoSend){
		
		Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");
		pusher.setCluster("us2");
		pusher.setEncrypted(true);
		
		Pedido pedidoGlobal=servicePedido.findByidUsuario(pedidoSend.getIdUsuario());
		
		RegistroPedido registroPedido=service.findByPedidoAndProducto(pedidoGlobal.getIdpedido(),pedidoSend.getIdProducto());
		
		int nuevaCantidad=registroPedido.getRegistropedido_cantidad() - pedidoSend.getCantidad();
		float nuevoPrecio=registroPedido.getRegistropedido_preciototal()-pedidoSend.getPrecio();
		float nuevoCostoTotal=0;
		int cantidadTotal=0;

		nuevoCostoTotal=pedidoGlobal.getPedido_montototal()-pedidoSend.getPrecio();
		cantidadTotal=pedidoGlobal.getPedido_cantidadtotal()-pedidoSend.getCantidad();

		servicePedido.actualizarPrecioTotalPedido(nuevoCostoTotal,cantidadTotal,pedidoGlobal.getIdpedido());
		
		service.actualizarRegistroPedido(pedidoGlobal.getIdpedido(),pedidoSend.getIdProducto(),nuevaCantidad,nuevoPrecio);
		
		pusher.trigger("my-channel2", "my-event2", Collections.singletonMap("message",nuevaCantidad));
		pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", cantidadTotal));

		return new ResponseEntity<String>("fue disminuido",HttpStatus.OK);	
	}
	
	
	
}
