package com.backend.tienda.api;



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
@RequestMapping(RegistroPedidoController.REGISTROPEDIDO_CONTROLLER)
public class RegistroPedidoController {
	
	public static final String REGISTROPEDIDO_CONTROLLER="/registroPedido";
	
	public static final String AÑADIR_PEDIDO_CONTROLLER="/agregarProducto";
	
	public static final String DISMINUIR_PEDIDO_CONTROLLER="/disminuirProducto";

	@Autowired
	RegistroPedidoService registroPedidoService;
	
	@Autowired
	PedidoService pedidoService;
	
	
	@RequestMapping(value=AÑADIR_PEDIDO_CONTROLLER,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistroPedido> añadirProducto(@RequestBody MainPedido mainPedido){
	
		Pedido respuesta = null;
		RegistroPedido respuestaFinal=null;
		try {
			
			respuesta=pedidoService.findByIdUsuario(mainPedido.getIdusuario());
			
			
			RegistroPedidoPK pk=new RegistroPedidoPK();
			pk.setIdpedido(respuesta.getIdpedido());
			pk.setIdproducto(mainPedido.getidproducto());
			 respuestaFinal=registroPedidoService.updateRegistroPedidoCantidadAndPrecio(mainPedido.getCantidad(), mainPedido.getPrecio(),pk);

				
			int cantidad_total=respuesta.getPedido_cantidadtotal()+mainPedido.getCantidad();
			float precio_total=respuesta.getPedido_montototal()+mainPedido.getPrecio();
			System.out.println("el id pedido es : "+ respuesta.getIdpedido());
			
			pedidoService.updatePedido2(cantidad_total, precio_total, respuesta.getIdpedido());
			System.out.println("paso2");
			
		}catch(Exception e) {
			return new ResponseEntity<RegistroPedido>(respuestaFinal,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<RegistroPedido>(respuestaFinal,HttpStatus.OK);

	}
	
	
	@RequestMapping(value=DISMINUIR_PEDIDO_CONTROLLER,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistroPedido> disminuirProducto(@RequestBody MainPedido mainPedido){
		
		Pedido respuesta = null;
		RegistroPedido respuestaFinal=null;
		try {
			
			respuesta=pedidoService.findByIdUsuario(mainPedido.getIdusuario());
			
			
			RegistroPedidoPK pk=new RegistroPedidoPK();
			pk.setIdpedido(respuesta.getIdpedido());
			pk.setIdproducto(mainPedido.getidproducto());
			
			if(registroPedidoService.findByid(pk).getRegistropedido_cantidadtotal()>0) {
				
				if(registroPedidoService.findByid(pk).getRegistropedido_cantidadtotal()==1) {
					
					int i=registroPedidoService.eliminarProductoRegistro(pk);
					

					int cantidad_total=respuesta.getPedido_cantidadtotal()-mainPedido.getCantidad();
					float precio_total=respuesta.getPedido_montototal()-mainPedido.getPrecio();
					
					pedidoService.updatePedido2(cantidad_total, precio_total, respuesta.getIdpedido());
					
					if(i==0) {
						System.out.println("Eliminado");
					}
				
				}else {
					
					 respuestaFinal=registroPedidoService. updateDisminuirCantidadAndPrecio(mainPedido.getCantidad(), mainPedido.getPrecio(),pk);

					
					int cantidad_total=respuesta.getPedido_cantidadtotal()-mainPedido.getCantidad();
					float precio_total=respuesta.getPedido_montototal()-mainPedido.getPrecio();
					
					pedidoService.updatePedido2(cantidad_total, precio_total, respuesta.getIdpedido());
				}		
			}
			
			
			
			
			
		}catch(Exception e) {
			return new ResponseEntity<RegistroPedido>(respuestaFinal,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<RegistroPedido>(respuestaFinal,HttpStatus.OK);
	}
	
	

}
