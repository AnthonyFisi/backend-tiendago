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

import com.backend.tienda.entity.Orden_estado_delivery;
import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.Repartidor;
import com.backend.tienda.entity.Usuario;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.repositorys.UserRepository;
import com.backend.tienda.service.Orden_estado_deliveryService;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;
import com.backend.tienda.service.RepartidorService;
import com.backend.tienda.service.VentaService;
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
	UserRepository userRepository;
	
	@Autowired
	RepartidorService repartidorService;
	
	Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");

	
	@RequestMapping(value=ORDEN_REGISTRAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_delivery> updateOrdenProces(@RequestBody Orden_estado_delivery orden,@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());

		Venta venta=null;

		List<Orden_estado_delivery> listaOrden =null;
		
		Orden_estado_delivery ordenResult=null;

		orden.setFecha(time);
	
		try 
		{
				
		
				venta=ventaService.updateDeliveryEstado(orden.getId().getIdventa(),orden.getId().getIdestado_delivery());
 
				if(venta!=null) {
					
					if(orden.getId().getIdestado_delivery() == 5) {
						
						venta=ventaService.updateDisponibilidad(orden.getId().getIdventa());
						
					}
					
					
					//AÑADIR UN METODO PARA AGREGAR EL ESTADO DE LLEGAR A PUNTO DESTINO ,TODO ESTO EN LA TABLA "orden_estado_venta"
					//COMPLETAR
						
					
					ordenResult=orden_estado_deliveryService.saveState(orden);
					
					listaOrden=orden_estado_deliveryService.listaEstadosByIdVenta(orden.getId().getIdventa());
					
					
					if(orden.getId().getIdestado_delivery()==1) {
						
						
						Repartidor repartidor=repartidorService.findRepartidorById(orden.getIdrepartidor());

						
						Usuario usuario=userRepository.findById((long)repartidor.getIdusuario()).get();
						
						usuario.setContrasena("");
						
						usuario.setRoles(null);
						
						pusher.setCluster("us2");
						
						pusher.trigger("canal-estado-delivery-"+idUsuario, "my-event", usuario);
						
					}
					
				
					
				
				}
				
				
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_delivery>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<Orden_estado_delivery>(ordenResult,HttpStatus.OK);
		
	}
	
	

}
