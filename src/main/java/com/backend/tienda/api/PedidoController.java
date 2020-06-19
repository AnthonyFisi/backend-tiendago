package com.backend.tienda.api;



import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.MainPedido;
import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.entity.RegistroPedidoPK;
import com.backend.tienda.service.PedidoService;
import com.backend.tienda.service.RegistroPedidoService;

@RestController
@RequestMapping(PedidoController.PEDIDO_CONTROLLER)
public class PedidoController {
	
	public static final String PEDIDO_CONTROLLER="/pedidoController";
	
	public static final String REGISTRAR_PEDIDO="/registrarPedido";
	
	public static final String FIND_BY_IDUSARIO="/findBy/{idUsuario}";
	
	public static final String UPDATE_PEDIDO="/updatePedido";
	
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	RegistroPedidoService registroPedidoService;
	
	@RequestMapping(value=REGISTRAR_PEDIDO,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistroPedido> agregarPedido(@RequestBody MainPedido mainPedido){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		Pedido respuesta = null;
		RegistroPedido registroPedido1=null;

		try {
			
			respuesta=pedidoService.findByIdUsuario(mainPedido.getIdusuario(),mainPedido.getIdempresa());

			RegistroPedidoPK pk=new RegistroPedidoPK();
			pk.setIdpedido(respuesta.getIdpedido());
			pk.setIdproducto(mainPedido.getidproducto());

			registroPedido1=registroPedidoService.registrar
					(new RegistroPedido(pk,mainPedido.getCantidad(),mainPedido.getPrecio(),time,mainPedido.getIdempresa(),"Comentario 1 :"+mainPedido.getComentario()));

			try {
						
				int cantidad_total=respuesta.getPedido_cantidadtotal()+mainPedido.getCantidad();
				float precio_total=respuesta.getPedido_montototal()+mainPedido.getPrecio();
				System.out.println("el id pedido es : "+ respuesta.getIdpedido());
				
				pedidoService.updatePedido2(cantidad_total, precio_total, respuesta.getIdpedido());
				
				System.out.println("Se ACTUALIZO en PEDIDO ");
			}catch(Exception m) {
				
				System.out.println("NO se ACTUALIZA el PEDIDO");	
			}
						
		}catch(Exception e) {
			
			RegistroPedido registroPedido=null;
			
			Pedido rpta1=null;
			
			Pedido pedido=new Pedido(0,mainPedido.getPrecio(),mainPedido.getCantidad(),time,false,mainPedido.getIdusuario(),mainPedido.getIdempresa());
				
			try {	
				
				rpta1=pedidoService.registrarPedido(pedido);
				
				RegistroPedidoPK pk=new RegistroPedidoPK();
				pk.setIdpedido(rpta1.getIdpedido());
				pk.setIdproducto(mainPedido.getidproducto());
					
				registroPedido=registroPedidoService.registrar
						(new RegistroPedido(pk,mainPedido.getCantidad(),mainPedido.getPrecio(),time,mainPedido.getIdempresa(),"Comentario 1 :"+mainPedido.getComentario()));
				
				
			}catch(Exception j) {
				
				j.notifyAll();
				return new ResponseEntity<RegistroPedido>(registroPedido,HttpStatus.INTERNAL_SERVER_ERROR);

			}
			return new ResponseEntity<RegistroPedido>(registroPedido,HttpStatus.OK);

		}
		
		return new ResponseEntity<RegistroPedido>(registroPedido1,HttpStatus.OK);
		
		
		
	}
	

}
