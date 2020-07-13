package com.backend.tienda.api;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Orden_estado_restaurante;
import com.backend.tienda.entity.Orden_estado_restaurantePK;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.entity.Restaurante_PedidoModified;
import com.backend.tienda.gson.Restaurante_PedidoGson;
import com.backend.tienda.gson.Tipo_EnvioGson;
import com.backend.tienda.service.Orden_estado_restauranteService;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;
import com.backend.tienda.service.Restaurante_PedidoService;

@RestController
@RequestMapping(Restaurante_PedidoController.RESTAURANTE_PEDIDO_CONTROLLER)
public class Restaurante_PedidoController {


	public static final String RESTAURANTE_PEDIDO_CONTROLLER="/RestaurantePedido";

	public static final String LISTA_BY_IDEMPRESA_FECHAVENTA="/listaPedidos/{idEmpresa}";

	public static final String LISTA_BY_IDEMPRESA_DISTINCT="/listaPedidosDistinct/{idEmpresa}";

	public static final String LISTA_BY_IDEMPRESA_PROCES="/listaPedidosProces/{idEmpresa}";

	public static final String LISTA_BY_IDEMPRESA_READY="/listaPedidosReady/{idEmpresa}";

	public static final String LISTA_BY_IDEMPRESA_HISTORIAL="/listaPedidosHistorial/{idEmpresa}";

	public static final String PEDIDO_RECIENTE="/reciente/{idEmpresa}/{idPedido}/{idVenta}";



	@Autowired
	Restaurante_PedidoService restaurante_PedidoService;

	@Autowired
	ProductoJOINregistroPedidoJOINpedidoService productoJOINregistroPedidoJOINpedidoService;
	
	@Autowired
	Orden_estado_restauranteService ordenService;

	@RequestMapping(value=LISTA_BY_IDEMPRESA_FECHAVENTA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurante_PedidoGson>  listaPedidosRecientes(@PathVariable("idEmpresa") int idEmpresa){



		Restaurante_PedidoGson restauranteGson= null;

		List<Restaurante_Pedido> listaRestaurante=null;

		try {

			listaRestaurante=restaurante_PedidoService.listaRestaurantePedidosNuevos(idEmpresa);
			restauranteGson= new Restaurante_PedidoGson();
			//restauranteGson.setListaRestaurante_Pedido(listaRestaurante);

		}catch(Exception e) {
			return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.OK);
	}

	@RequestMapping(value=LISTA_BY_IDEMPRESA_DISTINCT,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurante_PedidoGson>  listaPedidosRecientesDistinct(@PathVariable("idEmpresa") int idEmpresa){



		Restaurante_PedidoGson restauranteGson= null;

		List<Restaurante_Pedido> listaRestaurante=null;

		List<ProductoJOINregistroPedidoJOINpedido> listaProductos=null;

		List<Restaurante_PedidoModified> listaTotal=null;
		
		

		try {


			listaRestaurante=restaurante_PedidoService.listaRestaurantePedidosNuevosDistinct(idEmpresa);
			
			listaProductos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(listaRestaurante.get(0).getIdpedido());

			
			
			listaTotal= new ArrayList<>();

			for(Restaurante_Pedido pedido:listaRestaurante) {
				
		
				Restaurante_PedidoModified res = new Restaurante_PedidoModified();
				
				res.setIdpedido(pedido.getIdpedido());
				res.setIdempresa(pedido.getIdempresa());
				res.setIdventa(pedido.getIdventa());
				res.setIdubicacion(pedido.getIdubicacion());
				res.setVenta_fecha(pedido.getVenta_fecha());
				res.setVenta_fechaentrega(pedido.getVenta_fechaentrega());
				res.setVenta_costodelivery(pedido.getVenta_costodelivery());
				res.setVenta_costototal(pedido.getVenta_costototal());
				res.setComentario_global(pedido.getComentario_global());
				res.setIdestado_pago(pedido.getIdestado_pago());
				res.setNombre_estado(pedido.getNombre_estado());				
				res.setComentario_pedido(pedido.getComentario_pedido());				
				res.setIdusuario(pedido.getIdusuario());
				res.setUsuario_nombre(pedido.getUsuario_nombre());
				res.setUsuario_celular(pedido.getUsuario_celular());
				res.setOrden_disponible(pedido.isOrden_disponible());
				res.setIdrepartidor(pedido.getIdrepartidor());
				res.setIdtipopago(pedido.getIdtipopago());				
				res.setTipopago_nombre(pedido.getTipopago_nombre());			
				res.setIdestado_venta(pedido.getIdestado_venta());
				res.setTipo_estado(pedido.getTipo_estado());
				res.setIdtipopago(pedido.getIdtipopago());
				res.setTipopago_nombre(pedido.getTipopago_nombre());			
				res.setTiempo_espera(pedido.getTiempo_espera());
				res.setListaProductos(listaProductos);				
				res.setPedido_cantidadtotal(pedido.getPedido_cantidadtotal());
				res.setNombre_tipo_envio(pedido.getNombre_tipo_envio());
				res.setNombre_repartidor(pedido.getNombre_repartidor());
				res.setImagen_repartidor(pedido.getImagen_repartidor());
				
				res.setCodigo_repartidor(pedido.getCodigo_repartidor());
				
				res.setCancelar(pedido.isCancelar());
				res.setTelefono(pedido.getTelefono());

				
				
				listaTotal.add(res);
			}



			restauranteGson= new Restaurante_PedidoGson();
			restauranteGson.setListaRestaurante_Pedido(listaTotal);

		}catch(Exception e) {
			return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.OK);
	}

	
	@RequestMapping(value=LISTA_BY_IDEMPRESA_READY,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurante_PedidoGson>  listaPedidosReady(@PathVariable("idEmpresa") int idEmpresa){



		Restaurante_PedidoGson restauranteGson= null;

		List<Restaurante_Pedido> listaRestaurante=null;

		List<ProductoJOINregistroPedidoJOINpedido> listaProductos=null;

		List<Restaurante_PedidoModified> listaTotal=null;

		try {


			listaRestaurante=restaurante_PedidoService.listaRestaurantePedidosReady(idEmpresa);
			
			listaProductos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(listaRestaurante.get(0).getIdpedido());


			listaTotal= new ArrayList<>();

			for(Restaurante_Pedido pedido:listaRestaurante) {
				
		
				Restaurante_PedidoModified res = new Restaurante_PedidoModified();
				res.setIdpedido(pedido.getIdpedido());
				res.setIdempresa(pedido.getIdempresa());
				res.setIdventa(pedido.getIdventa());
				res.setIdubicacion(pedido.getIdubicacion());
				res.setVenta_fecha(pedido.getVenta_fecha());
				res.setVenta_fechaentrega(pedido.getVenta_fechaentrega());
				res.setVenta_costodelivery(pedido.getVenta_costodelivery());
				
				
				
				res.setVenta_costototal(pedido.getVenta_costototal());
				res.setComentario_global(pedido.getComentario_global());
				res.setIdestado_pago(pedido.getIdestado_pago());
				res.setNombre_estado(pedido.getNombre_estado());
				
				res.setComentario_pedido(pedido.getComentario_pedido());
				
				res.setIdusuario(pedido.getIdusuario());
				res.setUsuario_nombre(pedido.getUsuario_nombre());
				res.setUsuario_celular(pedido.getUsuario_celular());
				res.setOrden_disponible(pedido.isOrden_disponible());
				res.setIdrepartidor(pedido.getIdrepartidor());
				res.setIdtipopago(pedido.getIdtipopago());
				
				res.setTipopago_nombre(pedido.getTipopago_nombre());
				res.setPedido_cantidadtotal(pedido.getPedido_cantidadtotal());

				
				res.setIdestado_venta(pedido.getIdestado_venta());
				res.setTipo_estado(pedido.getTipo_estado());
				res.setIdtipopago(pedido.getIdtipopago());
				res.setTipopago_nombre(pedido.getTipopago_nombre());
				
				
				res.setTiempo_espera(pedido.getTiempo_espera());

				res.setListaProductos(listaProductos);
				
				res.setNombre_tipo_envio(pedido.getNombre_tipo_envio());
				res.setNombre_repartidor(pedido.getNombre_repartidor());
				res.setImagen_repartidor(pedido.getImagen_repartidor());
				res.setCodigo_repartidor(pedido.getCodigo_repartidor());

				res.setCancelar(pedido.isCancelar());
				res.setTelefono(pedido.getTelefono());

				listaTotal.add(res);
			}



			restauranteGson= new Restaurante_PedidoGson();
			restauranteGson.setListaRestaurante_Pedido(listaTotal);

		}catch(Exception e) {
			return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.OK);
	}

	
	
	@RequestMapping(value=LISTA_BY_IDEMPRESA_PROCES,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurante_PedidoGson>  listaPedidosProces(@PathVariable("idEmpresa") int idEmpresa){



		Restaurante_PedidoGson restauranteGson= null;

		List<Restaurante_Pedido> listaRestaurante=null;

		List<ProductoJOINregistroPedidoJOINpedido> listaProductos=null;

		List<Restaurante_PedidoModified> listaTotal=null;
				
		List<Orden_estado_restaurante> listaEstados=null;

		try {


			listaRestaurante=restaurante_PedidoService.listaRestaurantePedidosProceso(idEmpresa);
			System.out.println("PASO 1 ");
			
			listaProductos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(listaRestaurante.get(0).getIdpedido());
			System.out.println("PASO 1 ");

		
			
			List<Orden_estado_restaurantePK> pklist=new ArrayList<>();
			
			for(Restaurante_Pedido pedido:listaRestaurante) {
				
				Orden_estado_restaurantePK pk=new Orden_estado_restaurantePK();
				pk.setIdventa(pedido.getIdventa());
				pk.setIdestado_venta(pedido.getIdestado_venta());
				pklist.add(pk);
				
			}
			
			
			listaEstados=ordenService.listaEstados(pklist);
			System.out.println("PASO 2 ");

			listaEstados.stream().forEach(p->{
				System.out.println(p.getFecha().toString());

			});


			listaTotal= new ArrayList<>();
			
			int position=0;
			
			
			
			
			
			

			for(Restaurante_Pedido pedido:listaRestaurante) {
				
				
		
				Restaurante_PedidoModified res = new Restaurante_PedidoModified();
				res.setIdpedido(pedido.getIdpedido());
				res.setIdempresa(pedido.getIdempresa());
				res.setIdventa(pedido.getIdventa());
				res.setIdubicacion(pedido.getIdubicacion());
				res.setVenta_fecha(pedido.getVenta_fecha());
				res.setVenta_fechaentrega(pedido.getVenta_fechaentrega());
				res.setVenta_costodelivery(pedido.getVenta_costodelivery());
				
				
				
				res.setVenta_costototal(pedido.getVenta_costototal());
				res.setComentario_global(pedido.getComentario_global());
				res.setIdestado_pago(pedido.getIdestado_pago());
				res.setNombre_estado(pedido.getNombre_estado());
				
				res.setComentario_pedido(pedido.getComentario_pedido());
				
				res.setIdusuario(pedido.getIdusuario());
				res.setUsuario_nombre(pedido.getUsuario_nombre());
				res.setUsuario_celular(pedido.getUsuario_celular());
				res.setOrden_disponible(pedido.isOrden_disponible());
				res.setIdrepartidor(pedido.getIdrepartidor());
				res.setIdtipopago(pedido.getIdtipopago());
				
				res.setTipopago_nombre(pedido.getTipopago_nombre());
		
				res.setPedido_cantidadtotal(pedido.getPedido_cantidadtotal());

				res.setIdestado_venta(pedido.getIdestado_venta());
				res.setTipo_estado(pedido.getTipo_estado());
				res.setIdtipopago(pedido.getIdtipopago());
				res.setTipopago_nombre(pedido.getTipopago_nombre());
				
				
				res.setTiempo_espera(pedido.getTiempo_espera());

				res.setListaProductos(listaProductos);
				
				res.setNombre_tipo_envio(pedido.getNombre_tipo_envio());
				res.setNombre_repartidor(pedido.getNombre_repartidor());
				res.setImagen_repartidor(pedido.getImagen_repartidor());
				
				res.setCodigo_repartidor(listaEstados.get(position).getFecha().toString());
				

				res.setCancelar(pedido.isCancelar());
				res.setTelefono(pedido.getTelefono());

				listaTotal.add(res);
				
				position++;
			}



			restauranteGson= new Restaurante_PedidoGson();
			restauranteGson.setListaRestaurante_Pedido(listaTotal);

		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println("HERE");

			return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.OK);
	}

	
	
	
	@RequestMapping(value=LISTA_BY_IDEMPRESA_HISTORIAL,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurante_PedidoGson>  listaPedidosHistorial(@PathVariable("idEmpresa") int idEmpresa){



		Restaurante_PedidoGson restauranteGson= null;

		List<Restaurante_Pedido> listaRestaurante=null;

		List<ProductoJOINregistroPedidoJOINpedido> listaProductos=null;

		List<Restaurante_PedidoModified> listaTotal=null;

	try {


			listaRestaurante=restaurante_PedidoService.listaRestaurantePedidosHistorial(idEmpresa);
			
			listaProductos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(listaRestaurante.get(0).getIdpedido());


			listaTotal= new ArrayList<>();

			for(Restaurante_Pedido pedido:listaRestaurante) {
				
		
				Restaurante_PedidoModified res = new Restaurante_PedidoModified();
				res.setIdpedido(pedido.getIdpedido());
				res.setIdempresa(pedido.getIdempresa());
				res.setIdventa(pedido.getIdventa());
				res.setIdubicacion(pedido.getIdubicacion());
				res.setVenta_fecha(pedido.getVenta_fecha());
				res.setVenta_fechaentrega(pedido.getVenta_fechaentrega());
				res.setVenta_costodelivery(pedido.getVenta_costodelivery());
				
				
				
				res.setVenta_costototal(pedido.getVenta_costototal());
				res.setComentario_global(pedido.getComentario_global());
				res.setIdestado_pago(pedido.getIdestado_pago());
				res.setNombre_estado(pedido.getNombre_estado());
				
				res.setComentario_pedido(pedido.getComentario_pedido());
				
				res.setIdusuario(pedido.getIdusuario());
				res.setUsuario_nombre(pedido.getUsuario_nombre());
				res.setUsuario_celular(pedido.getUsuario_celular());
				res.setOrden_disponible(pedido.isOrden_disponible());
				res.setIdrepartidor(pedido.getIdrepartidor());
				res.setIdtipopago(pedido.getIdtipopago());
				
				res.setTipopago_nombre(pedido.getTipopago_nombre());
		
				res.setPedido_cantidadtotal(pedido.getPedido_cantidadtotal());

				res.setIdestado_venta(pedido.getIdestado_venta());
				res.setTipo_estado(pedido.getTipo_estado());
				res.setIdtipopago(pedido.getIdtipopago());
				res.setTipopago_nombre(pedido.getTipopago_nombre());
				
				
				res.setTiempo_espera(pedido.getTiempo_espera());

				res.setListaProductos(listaProductos);
				
				res.setNombre_tipo_envio(pedido.getNombre_tipo_envio());
				res.setNombre_repartidor(pedido.getNombre_repartidor());
				res.setImagen_repartidor(pedido.getImagen_repartidor());
				res.setCodigo_repartidor(pedido.getCodigo_repartidor());
				

				res.setCancelar(pedido.isCancelar());
				res.setTelefono(pedido.getTelefono());

				listaTotal.add(res);
			}



			restauranteGson= new Restaurante_PedidoGson();
			restauranteGson.setListaRestaurante_Pedido(listaTotal);

		}catch(Exception e) {
			return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Restaurante_PedidoGson>( restauranteGson,HttpStatus.OK);
	}

	
	
	
	
	@RequestMapping(value=PEDIDO_RECIENTE,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurante_PedidoModified>  pedidosRecientes(
			@PathVariable("idEmpresa") int idEmpresa,@PathVariable("idPedido") int idPedido,@PathVariable("idVenta") int idVenta){


		Restaurante_Pedido pedido= null;

		List<ProductoJOINregistroPedidoJOINpedido> listaProductos=null;

		Restaurante_PedidoModified res =null;


		try {


			pedido=restaurante_PedidoService.recientePedido(idEmpresa, idPedido, idVenta);
			
			System.out.println("paso por pedido" + pedido.getIdempresa());

			listaProductos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(pedido.getIdpedido());
			System.out.println("paso porlista productos" + pedido.getIdempresa());


		

			 res = new Restaurante_PedidoModified();
			res.setIdpedido(pedido.getIdpedido());
			res.setIdempresa(pedido.getIdempresa());
			res.setIdventa(pedido.getIdventa());
			res.setIdubicacion(pedido.getIdubicacion());
			res.setVenta_fecha(pedido.getVenta_fecha());
			res.setVenta_fechaentrega(pedido.getVenta_fechaentrega());
			res.setVenta_costodelivery(pedido.getVenta_costodelivery());
			
			
			
			res.setVenta_costototal(pedido.getVenta_costototal());
			res.setComentario_global(pedido.getComentario_global());
			res.setIdestado_pago(pedido.getIdestado_pago());
			res.setNombre_estado(pedido.getNombre_estado());
			
			res.setComentario_pedido(pedido.getComentario_pedido());
			
			res.setIdusuario(pedido.getIdusuario());
			res.setUsuario_nombre(pedido.getUsuario_nombre());
			res.setUsuario_celular(pedido.getUsuario_celular());
			res.setOrden_disponible(pedido.isOrden_disponible());
			res.setIdrepartidor(pedido.getIdrepartidor());
			res.setIdtipopago(pedido.getIdtipopago());
			
			res.setTipopago_nombre(pedido.getTipopago_nombre());
	
			
			res.setIdestado_venta(pedido.getIdestado_venta());
			res.setTipo_estado(pedido.getTipo_estado());
			res.setIdtipopago(pedido.getIdtipopago());
			res.setTipopago_nombre(pedido.getTipopago_nombre());
			
			res.setPedido_cantidadtotal(pedido.getPedido_cantidadtotal());

			res.setTiempo_espera(pedido.getTiempo_espera());

			res.setListaProductos(listaProductos);


			res.setNombre_repartidor(pedido.getNombre_repartidor());
			res.setImagen_repartidor(pedido.getImagen_repartidor());
			res.setCodigo_repartidor(pedido.getCodigo_repartidor());
			res.setNombre_tipo_envio(pedido.getNombre_tipo_envio());

			res.setCancelar(pedido.isCancelar());
			res.setTelefono(pedido.getTelefono());
			
			


		}catch(Exception e) {

			System.out.println(e.getMessage());

			return new ResponseEntity<Restaurante_PedidoModified> ( res,HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Restaurante_PedidoModified>( res,HttpStatus.OK);
	}


	
	public Restaurante_PedidoModified  recientes(int idEmpresa,int idPedido, int idVenta){



		Restaurante_Pedido pedido= null;

		List<ProductoJOINregistroPedidoJOINpedido> listaProductos=null;

		Restaurante_PedidoModified res =null;


		try {


			pedido=restaurante_PedidoService.recientePedido(idEmpresa, idPedido, idVenta);

			listaProductos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(pedido.getIdpedido());


		

			 res = new Restaurante_PedidoModified();
			res.setIdpedido(pedido.getIdpedido());
			res.setIdempresa(pedido.getIdempresa());
			res.setIdventa(pedido.getIdventa());
			res.setIdubicacion(pedido.getIdubicacion());
			res.setVenta_fecha(pedido.getVenta_fecha());
			res.setVenta_fechaentrega(pedido.getVenta_fechaentrega());
			res.setVenta_costodelivery(pedido.getVenta_costodelivery());
			
			
			
			res.setVenta_costototal(pedido.getVenta_costototal());
			res.setComentario_global(pedido.getComentario_global());
			res.setIdestado_pago(pedido.getIdestado_pago());
			res.setNombre_estado(pedido.getNombre_estado());
			
			res.setComentario_pedido(pedido.getComentario_pedido());
			
			res.setIdusuario(pedido.getIdusuario());
			res.setUsuario_nombre(pedido.getUsuario_nombre());
			res.setUsuario_celular(pedido.getUsuario_celular());
			res.setOrden_disponible(pedido.isOrden_disponible());
			res.setIdrepartidor(pedido.getIdrepartidor());
			res.setIdtipopago(pedido.getIdtipopago());
			
			res.setTipopago_nombre(pedido.getTipopago_nombre());
	
			
			res.setIdestado_venta(pedido.getIdestado_venta());
			res.setTipo_estado(pedido.getTipo_estado());
			res.setIdtipopago(pedido.getIdtipopago());
			res.setTipopago_nombre(pedido.getTipopago_nombre());
			
			res.setPedido_cantidadtotal(pedido.getPedido_cantidadtotal());

			res.setTiempo_espera(pedido.getTiempo_espera());

			res.setListaProductos(listaProductos);

			res.setNombre_repartidor(pedido.getNombre_repartidor());
			res.setImagen_repartidor(pedido.getImagen_repartidor());
			res.setCodigo_repartidor(pedido.getCodigo_repartidor());
			
			res.setNombre_tipo_envio(pedido.getNombre_tipo_envio());


			res.setCancelar(pedido.isCancelar());
			res.setTelefono(pedido.getTelefono());
			


		}catch(Exception e) {

		return res;
		}

		return res;
	}

	
	


}
