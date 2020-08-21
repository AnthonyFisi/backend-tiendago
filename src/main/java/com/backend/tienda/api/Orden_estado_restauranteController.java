package com.backend.tienda.api;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.backend.tienda.entity.Orden_estado_general;
import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.Orden_estado_restaurantePK;
import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.gson.Orden_estado_restauranteGson;
import com.backend.tienda.service.Orden_estado_generalService;
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
	Orden_estado_generalService orden_estado_generalService;
	
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
			
			//ordenGson.setListaOrden_estado_restaurante(listaOrden);
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_restauranteGson>(ordenGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new ResponseEntity<Orden_estado_restauranteGson>(ordenGson,HttpStatus.OK);
	}
	



	

	@RequestMapping(value=ORDEN_REGISTRAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_restaurante> updateOrdenProces(@RequestBody Orden_estado_restaurante orden,@PathVariable ("tiempo_espera") String tiempo_espera,@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		
		List<Orden_estado_general> lista_estado_general =null;
		
		Orden_estado_restauranteGson gson=null;
		
		Venta venta=null;
		Orden_estado_restaurante ordenResult=null;
		orden.setFecha(time);
		
		Orden_estado_general orden_general= new Orden_estado_general();
	
		try 
		{
			
			venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_venta(),tiempo_espera);
			
			if(venta!=null) {
				
				ordenResult=ordenService.registrarEstado(orden);
				
				ventaService.updateVentaEstadoGeneral(orden.getId().getIdventa(),1);

				
				//AÑADIR NUEVA TABLA DE ORDEN ESTADO GENERAL
				
				orden_general=convert_object(orden,tiempo_espera,1,time);
				
				//GUARDAR EL ESTADO EN LA TABLA GENERAL
				orden_estado_generalService.guardar_estado(orden_general);
				
				lista_estado_general=orden_estado_generalService.listaOrdenByidVenta(orden.getId().getIdventa());
				
				
				gson=new Orden_estado_restauranteGson();
				
				gson.setListaOrden_estado_general(lista_estado_general);
						
				pusher.setCluster("us2");
				
				pusher.trigger("canal-orden-reciente-"+idUsuario, "my-event", gson);
				
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
		
		Venta venta=null;
		
		Orden_estado_restaurante ordenResult=null;
		
		orden.setFecha(time);
		
		Orden_estado_restauranteGson gson=null;
		
		List<Orden_estado_general> lista_estado_general =null;
		
		Orden_estado_general orden_general= new Orden_estado_general();
	
		

		
	
		try 
		{
			
				
				venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_venta());
				
				System.out.println("PASO1");

				if(venta!=null) {
					
					ordenResult=ordenService.registrarEstado(orden);
					
					//AÑADIR NUEVA TABLA DE ORDEN ESTADO GENERAL
					
					ventaService.updateVentaEstadoGeneral(orden.getId().getIdventa(),2);

					
					orden_general=convert_object(orden,"",2,time);
					
					//GUARDAR EL ESTADO EN LA TABLA GENERAL
					orden_estado_generalService.guardar_estado(orden_general);
					
					lista_estado_general=orden_estado_generalService.listaOrdenByidVenta(orden.getId().getIdventa());
					
					
				
					
					gson=new Orden_estado_restauranteGson();
					gson.setListaOrden_estado_general(lista_estado_general);
					
					pusher.setCluster("us2");
					
					pusher.trigger("canal-orden-reciente-"+idUsuario, "my-event", gson);
	
							
		
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
		Orden_estado_restauranteGson gson=null;

	
		//try 
		//{
			
			venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_venta());
			
			if(venta!=null) {
				
				ordenResult=ordenService.registrarEstado(orden);
				
				System.out.println("idventa" + orden.getId().getIdventa());
				
				
				listaOrden=ordenService.listaEstadosOrden(orden.getId().getIdventa());
				
				gson=new Orden_estado_restauranteGson();
			
				//	gson.setListaOrden_estado_restaurante(listaOrden);
				
				//pusher.setCluster("us2");
				
				//pusher.trigger("canal-orden-ready-"+idUsuario, "my-event", listaOrden);
				
			//	pusher.trigger("canal-orden-reciente-"+idUsuario, "my-event", gson);

				
				
			}
			
		/*}catch(Exception e) {
			return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}*/
		
		return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.OK);
		
	}
	
	
	
    private int tiempoRestante(String restante){


        Timestamp ts = Timestamp.valueOf(restante);

        String pattern = "HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String time1=dateFormat.format(ts);





        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String time2 = dateFormat2.format(date);



        System.out.println("dateformated  " +time1+" |  fecha1 "+time2);



        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = null;
        Date date2 =null;
        try {
            date1 = format.parse(time1);
            date2=format.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long difference = date2.getTime() - date1.getTime();

        int tiempo=(int)(difference/1000);

        return tiempo;


    }

	private Orden_estado_general convert_object(Orden_estado_restaurante empresa,String tiempo,int idestado,Timestamp time) {
		
		Orden_estado_general estado= new Orden_estado_general();
		
		estado.setIdventa(empresa.getId().getIdventa());
		estado.setIdestadogeneral(idestado);
		estado.setTiempo_aproximado(tiempo);
		estado.setFecha(time);
		
		return estado;
	}
	
	
	
}








