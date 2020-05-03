package com.backend.tienda.api;

import java.sql.Date;
import java.sql.Timestamp;
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
import com.backend.tienda.entity.Venta;
import com.backend.tienda.entity.VentaSend;
import com.backend.tienda.service.PedidoService;
import com.backend.tienda.service.VentaService;

@RestController
@RequestMapping("/Venta")
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	PedidoService servicePedido;
	

	
	@RequestMapping(value = "/guardarVenta/{idUsuario}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> guardarVenta(@RequestBody VentaSend venta,@PathVariable("idUsuario")int idUsuario){
	
		
		System.out.println(venta.getVenta_fecha());
		
		Pedido pedido=servicePedido.findByidUsuario(idUsuario);
			System.out.println(pedido.getIdpedido());
		Venta venta2=new Venta();
		Timestamp timestamp1 = Timestamp.valueOf(venta.getVenta_fecha());
		Timestamp timestamp2 = Timestamp.valueOf(venta.getVenta_fechaEntrega());
System.out.println(timestamp1);
		
		venta2.setVenta_fecha(timestamp1);
		venta2.setVenta_estadoPago(venta.getVenta_estadoPago());
		venta2.setVenta_fechaEntrega(timestamp2);
		venta2.setVenta_costodelivery(venta.getVenta_costodelivery());
		venta2.setVenta_costoTotal(venta.getVenta_costoTotal());
		venta2.setIdPedido(pedido.getIdpedido());
		venta2.setIdtipopago(venta.getIdtipopago());
		venta2.setIdubicacion(venta.getIdubicacion());
		venta2.setIdhorario(venta.getIdhorario());
		venta2.setComentario(venta.getComentario());
		
		System.out.println("venta2 fecha");
		System.out.println(venta2.getVenta_fecha());
		
		
		Integer respuesta=null;
		
		try {
			respuesta=ventaService.añadirVenta(venta2);
			
		}catch(Exception e) {
			
			return new ResponseEntity<Integer>(123,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		servicePedido.actualizarEstadoPedido(pedido.getIdpedido());
		
		
		return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);
		
	}
	
	
	
	

	@RequestMapping(value="/listaVenta",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Venta>> listaVenta(){
	
		List<Venta> listaVenta=ventaService.listaVentas();
		
		return new ResponseEntity<List<Venta>>(listaVenta,HttpStatus.OK);	
	}

}
