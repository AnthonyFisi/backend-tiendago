package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.ListaPedido;
import com.backend.tienda.service.ListaPedidoService;
import com.backend.tienda.service.PedidoService;

@RestController
@RequestMapping("/ListaPedido")
public class ListaPedidoController {
	
	@Autowired
	ListaPedidoService listaPedidoService;
	
	@Autowired
	PedidoService pedidoService;
	
	/*@RequestMapping(value = "/lista/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ListaPedido>> obtenerListaListaPedido(@PathVariable("idUsuario")int idUsuario){
		for(int i=1;i<=24;i++) {
			System.out.println(" INSERT INTO horario (horario_nombre) VALUES (' "+i+":00 am') ; ");
		}
		Pedido pedido=pedidoService.findByidUsuarioListaPedido(idUsuario);
		List<ListaPedido> alu;
		try {
			alu= listaPedidoService.mostrarListaPedidoByIdUsuario(idUsuario,pedido.getIdpedido());
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.OK);

		}catch(Exception e) {
			alu= null;
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}*/
	
	
	@RequestMapping(value = "/listaDeOrdenes/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ListaPedido>> obtenerListaDeOrdenes(@PathVariable("idUsuario")int idUsuario){
		/*for(int i=1;i<=24;i++) {
			System.out.println(" INSERT INTO horario (horario_nombre) VALUES (' "+i+":00 am') ; ");
		}*/
		List<ListaPedido> alu;
		try {
			alu= listaPedidoService.mostrarListaByIdUsuario(idUsuario);
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.OK);

		}catch(Exception e) {
			alu= null;
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping(value = "/listaDeOrdenesHoy/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ListaPedido>> obtenerListaDeOrdenesHoy(@PathVariable("idUsuario")int idUsuario){
		/*for(int i=1;i<=24;i++) {
			System.out.println(" INSERT INTO horario (horario_nombre) VALUES (' "+i+":00 am') ; ");
		}*/
		List<ListaPedido> alu;
		try {
			alu= listaPedidoService.mostrarListaByIdUsuarioHoy(idUsuario);
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.OK);

		}catch(Exception e) {
			alu= null;
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping(value = "/listaDeOrdenesPendiente/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ListaPedido>> obtenerListaDeOrdenesPendiente(@PathVariable("idUsuario")int idUsuario){
		/*for(int i=1;i<=24;i++) {
			System.out.println(" INSERT INTO horario (horario_nombre) VALUES (' "+i+":00 am') ; ");
		}*/
		List<ListaPedido> alu;
		try {
			alu= listaPedidoService.mostrarListaByIdUsuarioPendiente(idUsuario);
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.OK);

		}catch(Exception e) {
			alu= null;
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping(value = "/listaDeOrdenesHistorial/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<ListaPedido>> obtenerListaDeOrdeneHistorial(@PathVariable("idUsuario")int idUsuario){
		/*for(int i=1;i<=24;i++) {
			System.out.println(" INSERT INTO horario (horario_nombre) VALUES (' "+i+":00 am') ; ");
		}*/
		List<ListaPedido> alu;
		try {
			alu= listaPedidoService.mostrarListaByIdUsuarioHistorial(idUsuario);
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.OK);

		}catch(Exception e) {
			alu= null;
			return new ResponseEntity<List<ListaPedido>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


}
