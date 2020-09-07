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
import com.backend.tienda.entity.Orden_estado_empresa;
import com.backend.tienda.entity.Orden_estado_empresaPK;
import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.firebase.DeliveryController;
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
	
	@Autowired
	DeliveryController deliveryController;
	
	Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");
	
	@RequestMapping(value=LISTA_ESTADO_BY_VENTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_restauranteGson> listaOrdenByVenta(@PathVariable ("idVenta") int idVenta){
		
		Orden_estado_restauranteGson ordenGson=null;
		
		List<Orden_estado_empresa> listaOrden =null;
		
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
	public ResponseEntity<Orden_estado_empresa> updateOrdenProces(@RequestBody Orden_estado_empresa orden,@PathVariable ("tiempo_espera") String tiempo_espera,@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		List<Orden_estado_general> lista_estado_general =null;
		
		Orden_estado_restauranteGson gson=null;
		
		Venta venta=null;
		
		Orden_estado_empresa ordenResult=null;
		
		orden.setFecha(time);
		
		Orden_estado_general orden_general= new Orden_estado_general();
		
		//ESTE ES EL ESTADO QUE VA ACTUALIZAR EN LA TABLA DE ESTADO_GENERAL
		int idestado_general=1;
	
		try 
		{
			
			// ESTOY ACTUALIZANDO EN LA TABLA DE VENTA EL ESTADO DE EMPRESA CON EL TIEMPO DE ESPERA
			venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_empresa(),tiempo_espera);
			
			if(venta!=null) {
				
				//PRIMERO GUARDO EL ESTADO QUE MANDO DESDE LA APLICACION DE EMPRESA
				ordenResult=ordenService.registrarEstado(orden);
				
				//ACTUALIZO LA TABLA DE ORDEN_ESTADO_EMPRESA CON EL NUEVO ESTADO QUE ACABO DE GUARDAR ANTERIORMENTE
				ventaService.updateVentaEstadoGeneral(orden.getId().getIdventa(),idestado_general);

				
				//AÑADIR NUEVA TABLA DE ORDEN ESTADO GENERAL
				
				
				
				
				//(ESTOY TRANSFORMANDO LOS DATOS SUELTO EN UN OBJETO TIPO ORDEN_ESTADO_GENERAL)
				orden_general=convert_object(orden,tiempo_espera,idestado_general,time,orden.getIdempresa());
				
				// ESTOY GUARDANDO EL ESTADO ANTERIOR CREADO EN LA TABLA GENERAL
				orden_estado_generalService.guardar_estado(orden_general);
				
				
				//DESPUES DE TODO ESTO VOY A SACAR LOS ESTADO QUE  TENGO EN LA TABL DE ORDEN_ESTADO_GENERAL PARA ENVIARSELO A LA APLICACION DE CLIENTE
				lista_estado_general=orden_estado_generalService.listaOrdenByidVenta(orden.getId().getIdventa());
				
				
				
				
				
				gson=new Orden_estado_restauranteGson();
				
				gson.setListaOrden_estado_general(lista_estado_general);
						
				pusher.setCluster("us2");
				
				pusher.trigger("canal-orden-reciente-"+idUsuario, "my-event", gson);
				
			}
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_empresa>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
			
		return new ResponseEntity<Orden_estado_empresa>(ordenResult,HttpStatus.OK);
		
	}
	
	
	
	
	@RequestMapping(value=ORDEN_UPDATE_PROCES,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_empresa> registrar(@RequestBody Orden_estado_empresa orden,
			@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		Venta venta=null;
		
		Orden_estado_empresa ordenResult=null;
		
		orden.setFecha(time);
		
		Orden_estado_restauranteGson gson=null;
		
		List<Orden_estado_general> lista_estado_general =null;
		
		Orden_estado_general orden_general= new Orden_estado_general();
	
		

		
	
		try 
		{
			
				int idestado_general=2;
				
				venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_empresa());
				
				System.out.println("PASO1");

				if(venta!=null) {
					
					ordenResult=ordenService.registrarEstado(orden);
					
					//AÑADIR NUEVA TABLA DE ORDEN ESTADO GENERAL
					
					ventaService.updateVentaEstadoGeneral(orden.getId().getIdventa(),idestado_general);

					
					orden_general=convert_object(orden,"",idestado_general,time,orden.getIdempresa());
					
					//GUARDAR EL ESTADO EN LA TABLA GENERAL
					orden_estado_generalService.guardar_estado(orden_general);
					
					
					
					lista_estado_general=orden_estado_generalService.listaOrdenByidVenta(orden.getId().getIdventa());
					
					
				
					
					gson=new Orden_estado_restauranteGson();
					gson.setListaOrden_estado_general(lista_estado_general);
					
					pusher.setCluster("us2");
					
					pusher.trigger("canal-orden-reciente-"+idUsuario, "my-event", gson);
					
					
					
					
					
					//deliveryController.searchRepartidor(pedidoPropuesta);
					
					
					
	
							
		
			}
			
		}catch(Exception e) {
			return new ResponseEntity<Orden_estado_empresa>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		
		
		return new ResponseEntity<Orden_estado_empresa>(ordenResult,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value=ORDEN_UPDATE_READY,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orden_estado_empresa> updateOrdenReady(@RequestBody Orden_estado_empresa orden,
			@PathVariable ("idUsuario") int idUsuario){
		
		Timestamp time=new Timestamp(System.currentTimeMillis());
		List<Orden_estado_empresa> listaOrden =null;
		Venta venta=null;
		Orden_estado_empresa ordenResult=null;
		orden.setFecha(time);
		Orden_estado_restauranteGson gson=null;

	
		//try 
		//{
			
			venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_empresa());
			
			if(venta!=null) {
				
				ordenResult=ordenService.registrarEstado(orden);
				
		
				
			}
			
		/*}catch(Exception e) {
			return new ResponseEntity<Orden_estado_restaurante>(ordenResult,HttpStatus.INTERNAL_SERVER_ERROR);

		}*/
		
		return new ResponseEntity<Orden_estado_empresa>(ordenResult,HttpStatus.OK);
		
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

	private Orden_estado_general convert_object(Orden_estado_empresa empresa,String tiempo,int idestado,Timestamp time,int idusuario) {
		
		Orden_estado_general estado= new Orden_estado_general();
		
		estado.setIdventa(empresa.getId().getIdventa());
		estado.setIdestadogeneral(idestado);
		estado.setTiempo_aproximado(tiempo);
		estado.setFecha(time);
		estado.setIdusuario(idusuario);
		
		return estado;
	}
	
	
	public void updateOrdenProcesMethod( Orden_estado_empresa orden,int idUsuario){
		
	Timestamp time=new Timestamp(System.currentTimeMillis());
		
		Venta venta=null;
		
		orden.setFecha(time);
		
		Orden_estado_restauranteGson gson=null;
		
		List<Orden_estado_general> lista_estado_general =null;
		
		Orden_estado_general orden_general= new Orden_estado_general();
	
		
			
				int idestado_general=2;
				
				venta=ventaService.updateVentaEstado(orden.getId().getIdventa(), orden.getId().getIdestado_empresa());
				
				System.out.println("PASO1");

				if(venta!=null) {
					
					ordenService.registrarEstado(orden);
					
					//AÑADIR NUEVA TABLA DE ORDEN ESTADO GENERAL
					
					ventaService.updateVentaEstadoGeneral(orden.getId().getIdventa(),idestado_general);

					
					orden_general=convert_object(orden,"",idestado_general,time,orden.getIdempresa());
					
					//GUARDAR EL ESTADO EN LA TABLA GENERAL
					orden_estado_generalService.guardar_estado(orden_general);
					
					
					
					lista_estado_general=orden_estado_generalService.listaOrdenByidVenta(orden.getId().getIdventa());
					
					
				
					
					gson=new Orden_estado_restauranteGson();
					gson.setListaOrden_estado_general(lista_estado_general);
					
					pusher.setCluster("us2");
					
					pusher.trigger("canal-orden-reciente-"+idUsuario, "my-event", gson);
	
							
		
			}
			
	
		

		
	}
	
	
	
}








