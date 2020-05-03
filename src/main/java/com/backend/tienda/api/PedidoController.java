package com.backend.tienda.api;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
import com.backend.tienda.entity.Pedido2;
import com.backend.tienda.entity.PedidoSend;
import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.service.CarritoService;
import com.backend.tienda.service.PedidoService;
import com.backend.tienda.service.RegistroPedidoService;
import com.pusher.rest.Pusher;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {
	
	@Autowired
	PedidoService service;
	
	@Autowired
	RegistroPedidoService serviceRegistro;
	

	@Autowired
	CarritoService carritoService;

	
	@RequestMapping(value="/agregarPedido", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void agregarPedido(@RequestBody Pedido pedido) {
		service.agregarPedido(pedido);
		
		
	}
	
	
	@RequestMapping(value="/mostrarPedido/{idPedido}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> mostrarByIdPedido(@PathVariable("idPedido") int idPedido){
		Pedido pedido=service.mostrarPedido(idPedido);
		
		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
		
	}
	
	

	@RequestMapping(value="/mostrarMontoTotal/{idUsuario}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> mostrarMontoTotal(@PathVariable("idUsuario") int idUsuario){
		
		Pedido pedidoGlobal=service.findByidUsuario(idUsuario);

		Pedido pedido=service.mostrarPedido(pedidoGlobal.getIdpedido());
		
		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
		
	}

	@RequestMapping(value="/mostrarMontoTotal2/{idUsuario}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido2> mostrarMontoTotal2(@PathVariable("idUsuario") int idUsuario){

		
		Pedido pedidoGlobal=service.findByidUsuario(idUsuario);

		Pedido2 pedido=service.mostrar(pedidoGlobal.getIdpedido());
				
		return new ResponseEntity<Pedido2>(pedido,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/mostrarUsuario/{idUsuario}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> mostrarByIdUsuario(@PathVariable("idUsuario") int idUsuario){
		Pedido pedido=service.findByidUsuario(idUsuario);

		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);	
	}
	
	

	@RequestMapping(value="/mostrarUsuarioListaPedido/{idUsuario}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> mostrarByIdUsuarioListaPedido(@PathVariable("idUsuario") int idUsuario){
		Pedido pedido=service.findByidUsuarioListaPedido(idUsuario);

		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);	
	}
	
	
	
	/*TODO EL REGISTRO DE PRODUCTOS VAMOS A MANEJARLO INTERNAMENTE PARA MAYOR FLEXIBILIDAD EN EL FRONTED CON FLUTTER*/
	@RequestMapping(value="/agregarCarrito/{idUsuario}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarPedidoCarrito(@RequestBody Pedido pedido,@PathVariable("idUsuario")int idUsuario){
			
		Pedido p=service.agregarPedidocarrito(pedido);
		String cadena="este id es : "+idUsuario;
		return new ResponseEntity<String>(cadena,HttpStatus.OK);
	
	}

	
	@RequestMapping(value="/RegistrarProducto",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarPedidoCarrito2(@RequestBody PedidoSend pedidoSend){
		Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");
		pusher.setCluster("us2");
		pusher.setEncrypted(true);
		
		
		try {
			Pedido pedidoGlobal=service.findByidUsuario(pedidoSend.getIdUsuario());
			
			if(pedidoGlobal.getPedido_estado().equals("NoAtendido")) {
				
				float total=0;
				int cantidadTotal=0;
				
				total=pedidoGlobal.getPedido_montototal()+pedidoSend.getPrecio();
				cantidadTotal=pedidoGlobal.getPedido_cantidadtotal()+pedidoSend.getCantidad();
				
				try {
					int m=service.actualizarPrecioTotalPedido(total,cantidadTotal, pedidoGlobal.getIdpedido());
					System.out.println(m);
				}catch(Exception e) {
					System.out.println("Estoy en Exception de actualizar precio total");
				}
				
				RegistroPedido n =new RegistroPedido(pedidoSend.getIdProducto(),pedidoGlobal.getIdpedido(),pedidoSend.getCantidad(),pedidoSend.getPrecio(),"","");	
				serviceRegistro.guardarRegistroPedido(n);
				System.out.println("estoy aca 1");
				List<Carrito> listCarrito=carritoService.listaCompras(pedidoSend.getIdUsuario(),pedidoGlobal.getIdpedido());

				/*List<Carrito> listCarrito=carrito.mostrarByIdPedidoPusher(pedidoGlobal.getUsuario_idusuario());

				System.out.println(listCarrito);*/
				pusher.trigger("my-channel2", "my-event2", Collections.singletonMap("message",1));

				pusher.trigger("my-channel1", "my-event", listCarrito);
			   pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", cantidadTotal));
			   
			
			
			return new ResponseEntity<String>("Registrado con exito segunda vez",HttpStatus.OK);
			}else {
				
				Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
				Pedido pedidoFirst= new Pedido("NoAtendido",pedidoSend.getPrecio(),pedidoSend.getCantidad(),fecha,1,pedidoSend.getIdUsuario(),"no",1,1);	
				Pedido pedidoID=service.agregarPedidocarrito(pedidoFirst);
				RegistroPedido n =new RegistroPedido(pedidoSend.getIdProducto(),pedidoID.getIdpedido(),pedidoSend.getCantidad(),pedidoSend.getPrecio(),"","");
				serviceRegistro.guardarRegistroPedido(n);
				System.out.println("estoy aca 2");
				List<Carrito> listCarrito=carritoService.listaCompras(pedidoSend.getIdUsuario(),pedidoGlobal.getIdpedido());

				/*List<Carrito> listCarrito=carrito.mostrarByIdPedidoPusher(pedidoGlobal.getUsuario_idusuario());

				System.out.println(listCarrito);*/
				pusher.trigger("my-channel2", "my-event2", Collections.singletonMap("message",1));

				pusher.trigger("my-channel1", "my-event", listCarrito);
				pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", pedidoSend.getCantidad()));

				return new ResponseEntity<String>(" salio bien creo mano ",HttpStatus.OK);	

			}
			
		}catch(Exception e) {
			Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
			Pedido pedidoFirst= new Pedido("NoAtendido",pedidoSend.getPrecio(),pedidoSend.getCantidad(),fecha,1,pedidoSend.getIdUsuario(),"no",1,1);	
			Pedido pedidoID=service.agregarPedidocarrito(pedidoFirst);
			RegistroPedido n =new RegistroPedido(pedidoSend.getIdProducto(),pedidoID.getIdpedido(),pedidoSend.getCantidad(),pedidoSend.getPrecio(),"","");
			serviceRegistro.guardarRegistroPedido(n);
			System.out.println("estoy aca 3");
			List<Carrito> listCarrito=carritoService.listaCompras(pedidoSend.getIdUsuario(),pedidoID.getIdpedido());

			/*List<Carrito> listCarrito=carrito.mostrarByIdPedidoPusher(pedidoSend.getIdUsuario());

			System.out.println(listCarrito);*/

			pusher.trigger("my-channel2", "my-event2", Collections.singletonMap("message",1));

			pusher.trigger("my-channel1", "my-event", listCarrito);
			pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", pedidoSend.getCantidad()));

			return new ResponseEntity<String>(" Estoy en el Exception ",HttpStatus.OK);	

		}
			
	}
	
	
	
	
	@RequestMapping(value="/nuevo/{montototal}/{cantidad}/{idPedido}",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> nuevo(@PathVariable("montototal")float montototal,  @PathVariable("cantidad") int cantidad,@PathVariable("idPedido")int idPedido){
		String respuesta="";
		try {
			int m=service.actualizarPrecioTotalPedido(montototal,cantidad, idPedido);
			System.out.println(m);
			respuesta="me actualize";
			return new ResponseEntity<String>(respuesta,HttpStatus.OK);	

		}catch(Exception e) {
			System.out.println("Estoy en Exception de actualizar precio total");
			respuesta="No me actualize";
			return new ResponseEntity<String>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);	

		}

	}
	

	@RequestMapping(value="/RegistrarProductoDetalle",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> agregarPedidoCarrito3(@RequestBody PedidoSend pedidoSend){
		
		try {
			
			Pedido pedidoGlobal=service.findByidUsuario(pedidoSend.getIdUsuario());
			
			System.out.println(pedidoGlobal.getPedido_estado()+"  -  "+pedidoGlobal.getIdpedido());
			
			if(pedidoGlobal.getPedido_estado().equals("NoAtendido")) {
				

			try {
				RegistroPedido registroPedido=serviceRegistro.findByPedidoAndProducto(pedidoGlobal.getIdpedido(),pedidoSend.getIdProducto());

				if(registroPedido!=null) {
					
					int nuevaCantidad=0;
					float nuevoPrecio=0;
					nuevaCantidad=registroPedido.getRegistropedido_cantidad()+pedidoSend.getCantidad();
					nuevoPrecio=registroPedido.getRegistropedido_preciototal()+(pedidoSend.getPrecio()*pedidoSend.getCantidad());
					
					float costoTotal=0;
					int cantidadTotal=0;
					
					costoTotal=pedidoGlobal.getPedido_montototal()+(pedidoSend.getPrecio()*pedidoSend.getCantidad());
					cantidadTotal=pedidoGlobal.getPedido_cantidadtotal()+pedidoSend.getCantidad();
					
					int num=service.actualizarPrecioTotalPedido(costoTotal,cantidadTotal, pedidoGlobal.getIdpedido());
					System.out.println(num);
					
					serviceRegistro.actualizarRegistroPedido(pedidoGlobal.getIdpedido(),pedidoSend.getIdProducto(),nuevaCantidad,nuevoPrecio);
					return new ResponseEntity<String>("Registrado con exito segunda vez",HttpStatus.OK);

				}else {
					float costoTotal=0;
					int cantidadTotal=0;
					
					costoTotal=pedidoGlobal.getPedido_montototal()+(pedidoSend.getPrecio()*pedidoSend.getCantidad());
					cantidadTotal=pedidoGlobal.getPedido_cantidadtotal()+pedidoSend.getCantidad();
					
					service.actualizarPrecioTotalPedido(costoTotal,cantidadTotal, pedidoGlobal.getIdpedido());
					
					RegistroPedido n =new RegistroPedido(pedidoSend.getIdProducto(),pedidoGlobal.getIdpedido(),pedidoSend.getCantidad(),pedidoSend.getPrecio(),"","");	
					serviceRegistro.guardarRegistroPedido(n);
				
				
				return new ResponseEntity<String>("Registrado con exito segunda vez",HttpStatus.OK);
				}
				
			}
			 
			catch(Exception e) {
				
				float nuevoPrecio=0;
				nuevoPrecio=(pedidoSend.getPrecio()*pedidoSend.getCantidad());
				
				float costoTotal=0;
				int cantidadTotal=0;
				
				costoTotal=pedidoGlobal.getPedido_montototal()+(pedidoSend.getPrecio()*pedidoSend.getCantidad());
				cantidadTotal=pedidoGlobal.getPedido_cantidadtotal()+pedidoSend.getCantidad();
				
				int num=service.actualizarPrecioTotalPedido(costoTotal,cantidadTotal, pedidoGlobal.getIdpedido());
				
				
				RegistroPedido n =new RegistroPedido(pedidoSend.getIdProducto(),pedidoGlobal.getIdpedido(),pedidoSend.getCantidad(),nuevoPrecio,"","");	
				serviceRegistro.guardarRegistroPedido(n);
			
			
			return new ResponseEntity<String>("Registrado con exito segunda vez",HttpStatus.OK);
			}

				

			}else {
				float nuevoPrecio=0;
				
				nuevoPrecio=(pedidoSend.getPrecio()*pedidoSend.getCantidad());
				Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
				Pedido pedidoFirst= new Pedido("NoAtendido",nuevoPrecio,pedidoSend.getCantidad(),fecha,1,pedidoSend.getIdUsuario(),"no",1,1);	
				Pedido pedidoID=service.agregarPedidocarrito(pedidoFirst);
				RegistroPedido n =new RegistroPedido(pedidoSend.getIdProducto(),pedidoID.getIdpedido(),pedidoSend.getCantidad(),nuevoPrecio,"","");
				serviceRegistro.guardarRegistroPedido(n);
				return new ResponseEntity<String>(" salio bien creo mano  2.0 ",HttpStatus.OK);	

			}
			
		}catch(Exception e) {
			Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
			
			
			
			float nuevoPrecio=0;
			
			nuevoPrecio=(pedidoSend.getPrecio()*pedidoSend.getCantidad());
			Pedido pedidoFirst= new Pedido("NoAtendido",nuevoPrecio,pedidoSend.getCantidad(),fecha,1,pedidoSend.getIdUsuario(),"no",1,1);	
			Pedido pedidoID=service.agregarPedidocarrito(pedidoFirst);
			
			
			
			RegistroPedido n =new RegistroPedido(pedidoSend.getIdProducto(),pedidoID.getIdpedido(),pedidoSend.getCantidad(),nuevoPrecio,"","");
			serviceRegistro.guardarRegistroPedido(n);
			return new ResponseEntity<String>(" Registrado primera vez TRY CATCH 1 ",HttpStatus.OK);	

		}
			
	}
	
}
