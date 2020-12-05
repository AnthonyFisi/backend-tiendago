package com.backend.tienda.api;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Orden_estado_delivery;
import com.backend.tienda.entity.Orden_estado_general;
import com.backend.tienda.entity.Orden_estado_empresa;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.Repartidor;
import com.backend.tienda.entity.Usuario_general;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.gson.Orden_estado_restauranteGson;
import com.backend.tienda.gson.RepartidorInformationGson;
import com.backend.tienda.repository.Usuario_generalRepository;
import com.backend.tienda.service.Orden_estado_deliveryService;
import com.backend.tienda.service.Orden_estado_generalService;
import com.backend.tienda.service.Orden_estado_restauranteService;
import com.backend.tienda.service.RepartidorService;
import com.backend.tienda.service.VentaService;
import com.backend.tienda.util.Pushers;
import com.pusher.rest.Pusher;

@RestController
@RequestMapping(Orden_estado_deliveryController.ORDEN_ESTADO_DELIVERY_CONTROLLER)
public class Orden_estado_deliveryController {
	
	
	public static final String ORDEN_ESTADO_DELIVERY_CONTROLLER="/Orden_Estado_DeliveryController";
	
	public static final String ORDEN_REGISTRAR="/aceptar/{idUsuario}";
	
	public static final String ORDEN_LISTA_ESTADOS="/listaEstados/{idVenta}";
	
	
	@Autowired
	Orden_estado_deliveryService orden_estado_deliveryService;
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	Usuario_generalRepository usuario_generalRepository;
	
	@Autowired
	RepartidorService repartidorService;
	
	
	@Autowired
	Orden_estado_restauranteService ordenService;
	
	
	@Autowired
	Orden_estado_generalService orden_estado_generalService;
	

	@Autowired
	Pushers pushernotifications;
	
	@RequestMapping(value=ORDEN_REGISTRAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_delivery> updateOrdenProces(@RequestBody Orden_estado_delivery orden,@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());

		Venta venta=null;

		//List<Orden_estado_delivery> listaOrden =null;
		
		Orden_estado_delivery ordenResult=null;
		
		List<Orden_estado_general> lista_estado_general =null;
		
		Orden_estado_restauranteGson gson=null;
		
		Orden_estado_general orden_general= new Orden_estado_general();
	

		orden.setFecha(time);
	
	//	try 
//		{
				
		
			//FALTA QUE SEA UNA ACTUALIZACION CON EL ID DEL REPARTIDOR
			
				venta=ventaService.updateDeliveryEstado(orden.getId().getIdventa(),orden.getId().getIdestado_delivery(),orden.getIdrepartidor());
 
				if(venta!=null) {
					
					
					
					//AÑADIR UN METODO PARA AGREGAR EL ESTADO DE LLEGAR A PUNTO DESTINO ,TODO ESTO EN LA TABLA "orden_estado_venta"
					//COMPLETAR
						
					
					ordenResult=orden_estado_deliveryService.saveState(orden);
					
					//listaOrden=orden_estado_deliveryService.listaEstadosByIdVenta(orden.getId().getIdventa());
					
					
					if(orden.getId().getIdestado_delivery()==1) {
						
						RepartidorInformationGson repartidorInformation=new RepartidorInformationGson();
						
						Repartidor repartidor=repartidorService.findRepartidorById(orden.getIdrepartidor());
						
						//VA TENER QUE IR A LA TABLA DE REPARTIDOR
						//falta COREGIR ACA
						
						Usuario_general usuario=usuario_generalRepository.findById(repartidor.getIdusuariogeneral()).get();
						
						
						usuario.setContrasena("");
						
						usuario.setRoles(null);
						
						
						repartidorInformation.setUsuario_general(usuario);
						
						repartidorInformation.setIdventa(orden.getId().getIdventa());
						//Pusher ps=Pushers.instance();
						pushernotifications.instance().trigger("canal-estado-delivery-"+idUsuario, "my-event", repartidorInformation);
						
					}
					
					if(orden.getId().getIdestado_delivery() == 3) {
						
						ventaService.updateVentaEstadoGeneral(orden.getId().getIdventa(), 3);

						
						//venta=ventaService.updateDisponibilidad(orden.getId().getIdventa());
						
						//AÑADIR NUEVA TABLA DE ORDEN ESTADO GENERAL
						
						orden_general=convert_object(orden,venta.getTiempo_aprox_delivery(),3,time);
						
						//GUARDAR EL ESTADO EN LA TABLA GENERAL
						orden_estado_generalService.guardar_estado(orden_general);
						
						lista_estado_general=orden_estado_generalService.listaOrdenByidVenta(orden.getId().getIdventa());
						
						
						gson=new Orden_estado_restauranteGson();
						
						gson.setListaOrden_estado_general(lista_estado_general);
								
						
						pushernotifications.instance().trigger("canal-orden-reciente-"+idUsuario, "my-event", gson);
						
						
						
					}
					
					
					
					if(orden.getId().getIdestado_delivery() == 4) {
						
						ventaService.updateVentaEstadoGeneral(orden.getId().getIdventa(), 4);

						
						venta=ventaService.updateDisponibilidad(orden.getId().getIdventa());
						
						//AÑADIR NUEVA TABLA DE ORDEN ESTADO GENERAL
						
						orden_general=convert_object(orden,"",4,time);
						
						//GUARDAR EL ESTADO EN LA TABLA GENERAL
						orden_estado_generalService.guardar_estado(orden_general);
						
						lista_estado_general=orden_estado_generalService.listaOrdenByidVenta(orden.getId().getIdventa());
						
						
						gson=new Orden_estado_restauranteGson();
						
						gson.setListaOrden_estado_general(lista_estado_general);
								
						pushernotifications.instance().trigger("canal-orden-reciente-"+idUsuario, "my-event", gson);
						
					}
					

					if(orden.getId().getIdestado_delivery() == 5) {
						
						venta=ventaService.updateDisponibilidad(orden.getId().getIdventa());
					}
					
					
				
					
				
				}
				
	/*			
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_delivery>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}*/
		
		return new ResponseEntity<Orden_estado_delivery>(ordenResult,HttpStatus.OK);
		
	}
	
	
	private Orden_estado_general convert_object(Orden_estado_delivery delivery,String tiempo,int idestado,Timestamp time) {
		
		Orden_estado_general estado= new Orden_estado_general();
		
		estado.setIdventa(delivery.getId().getIdventa());
		estado.setIdestadogeneral(idestado);
		estado.setTiempo_aproximado(tiempo);
		estado.setFecha(time);
		
		return estado;
	}
	
	
	

}
