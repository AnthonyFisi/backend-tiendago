package com.backend.tienda.api;

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

import com.backend.tienda.entity.Carrito;
import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Ubicacion;
import com.backend.tienda.service.CarritoService;
import com.backend.tienda.service.PedidoService;

@RequestMapping("/Carrito")
@RestController
public class CarritoController {
	
	@Autowired
	CarritoService carritoService;
	
	@Autowired
	PedidoService pedidoService;
	
	
	
	@RequestMapping(value="/mostrarCarrito/{idUsuario}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Carrito>> mostrarByIdPedido(@PathVariable("idUsuario") int idUsuario){
		
		Pedido pedido=pedidoService.findByidUsuario(idUsuario);
		List<Carrito> listaCarrito=carritoService.listaCompras(idUsuario, pedido.getIdpedido());

		return new ResponseEntity<List<Carrito>>(listaCarrito,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/mostrarPedidoRealizados/{idPedido}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Carrito>> mostrarByIdPedidoRealizado(@PathVariable("idPedido") int idPedido){
	
		
		List<Carrito> listaCarrito=carritoService.listaComprasRealizada(idPedido);

		return new ResponseEntity<List<Carrito>>(listaCarrito,HttpStatus.OK);	
	}
	
	
	public List<Carrito> mostrarByIdPedidoPusher(int idUsuario){
		
		Pedido pedido=pedidoService.findByidUsuario(idUsuario);
		List<Carrito> listaCarrito=carritoService.listaCompras(idUsuario, pedido.getIdpedido());

		return listaCarrito;	
	}
	
	
	@RequestMapping(value = "/eliminarCarrito/{idPedido}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminarCarrito(@PathVariable("idPedido") int idPedido){
	
		
		Integer respuesta=0;
		try {
			respuesta= carritoService.eliminarCarrito(idPedido);
			pedidoService.actualizarPrecioTotalPedido(0,0, idPedido);
			return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);

		}catch(Exception e) {
		
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


}
