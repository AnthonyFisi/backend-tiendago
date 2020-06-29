package com.backend.tienda.api;

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

import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.Orden_estado_restaurantePK;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.gson.Orden_estado_restauranteGson;
import com.backend.tienda.service.Orden_estado_restauranteService;
import com.backend.tienda.service.VentaService;
import com.pusher.rest.Pusher;

@RestController
@RequestMapping(Orden_estado_restauranteController.ORDEN_ESTADO_RESTAURANTE_CONTROLLER)
public class Orden_estado_restauranteController {

	public static final String ORDEN_ESTADO_RESTAURANTE_CONTROLLER="/Orden_Estado_RestauranteController";
	
	public static final String ORDEN_REGISTRAR="/registrarOrden/{tiempo_espera}/{idUsuario}";
	
	public static final String ORDEN_UPDATE_PROCES="/updateOrdenProces/{idUsuario}";

	
	public static final String ORDEN_UPDATE_READY="/updateOrdenReady/{idUsuario}";

	
	public static final String LISTA_ESTADO_BY_VENTA="/listaOrden/{idVenta}";
	
	
	@Autowired
	Orden_estado_restauranteService ordenService;
	
	@Autowired
	VentaService ventaService;
	
	Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");
	
	@RequestMapping(value=LISTA_ESTADO_BY_VENTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_restauranteGson> listaOrdenByVenta(@PathVariable ("idVenta") int idVenta){
		
		Orden_estado_restauranteGson ordenGson=null;
		
		List<Orden_estado_restaurante> listaOrden =null;
		
		try {
			
			listaOrden=ordenService.listaEstadosOrden(idVenta);
			
			ordenGson= new Orden_estado_restauranteGson();
			
			ordenGson.setListaOrden_estado_restaurante(listaOrden);
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_restauranteGson>(ordenGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<Orden_estado_restauranteGson>(ordenGson,HttpStatus.OK);
	}
	



	

	@RequestMapping(value=ORDEN_REGISTRAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_restaurante> updateOrdenProces(@RequestBody Orden_estado_restaurante orden,@PathVariable ("tiempo_espera") String tiempo_espera,@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		
		List<Orden_estado_restaurante> listaOrden =null;
		
		Venta venta=null;
		Orden_estado_restaurante ordenResult=null;
		orden.setFecha(time);
	
		try 
		{
			
			venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_venta(),tiempo_espera);
			
			if(venta!=null) {
				
				ordenResult=ordenService.registrarEstado(orden);
				
				listaOrden=ordenService.listaEstadosOrden(orden.getId().getIdventa());
						
				pusher.setCluster("us2");
				
				pusher.trigger("canal-orden-reciente-"+idUsuario, "my-event", listaOrden);
				
			}
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		
		
		
		
		
		return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.OK);
		
	}
	
	
	
	
	@RequestMapping(value=ORDEN_UPDATE_PROCES,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_restaurante> registrar(@RequestBody Orden_estado_restaurante orden,
			@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		List<Orden_estado_restaurante> listaOrden =null;
		Venta venta=null;
		Orden_estado_restaurante ordenResult=null;
		orden.setFecha(time);
	
		try 
		{
			
			venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_venta());
			
			if(venta!=null) {
				
				ordenResult=ordenService.registrarEstado(orden);
				
				
				listaOrden=ordenService.listaEstadosOrden(orden.getId().getIdventa());
				
				pusher.setCluster("us2");
				
				pusher.trigger("canal-orden-proces-"+idUsuario, "my-event", listaOrden);
				
				
				
				
			}
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		
		
		return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value=ORDEN_UPDATE_READY,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_restaurante> updateOrdenReady(@RequestBody Orden_estado_restaurante orden,
			@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		List<Orden_estado_restaurante> listaOrden =null;
		Venta venta=null;
		Orden_estado_restaurante ordenResult=null;
		orden.setFecha(time);
	
		//try 
		//{
			
			venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_venta());
			
			if(venta!=null) {
				
				ordenResult=ordenService.registrarEstado(orden);
				
				System.out.println("idventa" + orden.getId().getIdventa());
				
				
				listaOrden=ordenService.listaEstadosOrden(orden.getId().getIdventa());
				
				pusher.setCluster("us2");
				
				pusher.trigger("canal-orden-ready-"+idUsuario, "my-event", listaOrden);
				
				
				
				
			}
			
		/*}catch(Exception e) {
			return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}*/
		
		return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.OK);
		
	}
	
	
	
	
	
}








