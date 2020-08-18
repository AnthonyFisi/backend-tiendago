package com.backend.tienda.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.backend.tienda.entity.MainPedido;
import com.backend.tienda.entity.Orden;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.entity.Usuario;
import com.backend.tienda.gson.OrdenGeneralGson;
import com.backend.tienda.gson.OrdenGson;
import com.backend.tienda.repositorys.UserRepository;
import com.backend.tienda.service.OrdenService;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;

@RestController
@RequestMapping(OrdenController.ORDEN_CONTROLLER)
public class OrdenController {
	
	public static final String ORDEN_CONTROLLER="/ordenController";
	
	public static final String LISTA_DISPONIBLE="/listaDisponible/{idUsuario}";
	
	
	@Autowired
	OrdenService ordenService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductoJOINregistroPedidoJOINpedidoService productoJOINregistroPedidoJOINpedidoService;
	
	@RequestMapping(value=LISTA_DISPONIBLE,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdenGeneralGson> listaOrdenesDisponibles(@PathVariable ("idUsuario") int idUsuario){
		
		List<Orden> lista=null;
		
		List<OrdenGson> ordenGson=new ArrayList<>();
				
		OrdenGeneralGson ordenGeneral=null;
		
		List<ProductoJOINregistroPedidoJOINpedido> productos=null;


		
		try {
			
			lista=ordenService.ordenDisponible(idUsuario);
			
			OrdenGson data=new OrdenGson();
			
			for(Orden orden:lista) {
				
				data.setDetalle_orden(orden);
				
				if(orden.getIdrepartidor()!=0) {

					Usuario usuario=userRepository.findById((long)orden.getIdrepartidor()).get();
					
					usuario.setContrasena("");
					
					usuario.setRoles(null);
					
					data.setUsuario(usuario);

					
				}
				
				
				productos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(orden.getIdpedido());

				data.setLista_productos(productos);
				
				ordenGson.add(data);
				
				
			}
			
			ordenGeneral=new OrdenGeneralGson();
			ordenGeneral.setLista(ordenGson);
			
	
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<OrdenGeneralGson>(ordenGeneral,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<OrdenGeneralGson>(ordenGeneral,HttpStatus.OK);

	}
	

}
