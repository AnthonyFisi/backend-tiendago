package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Pedido;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.entity.VentaAndroid;
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
	
	
	@RequestMapping(value=REGISTRAR_VENTA,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venta>  registrarVenta(@RequestBody VentaAndroid ventaAndroid){
		
		Venta respuesta=null;
		
		Pedido respuestaPedido =new Pedido();
		
		boolean answerPedido= false;

		
		respuestaPedido=pedidoService.findByIdUsuario(ventaAndroid.getIdUsuario(),ventaAndroid.getIdEmpresa());
		
		
		try {
			
			respuesta=ventaService.registrarVenta(VentaAndroid.createVenta(ventaAndroid, respuestaPedido.getIdpedido()));
			
			answerPedido=true;
		
			pedidoService.updatePedidoEstado(answerPedido,respuesta.getIdpedido());
			
		}catch(Exception e) {
			return new  ResponseEntity<Venta>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<Venta>(respuesta,HttpStatus.OK);
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
