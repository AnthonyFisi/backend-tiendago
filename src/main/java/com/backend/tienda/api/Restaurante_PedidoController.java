package com.backend.tienda.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.entity.Restaurante_PedidoModified;
import com.backend.tienda.gson.Restaurante_PedidoGson;
import com.backend.tienda.gson.Tipo_EnvioGson;
import com.backend.tienda.service.Restaurante_PedidoService;

@RestController
@RequestMapping(Restaurante_PedidoController.RESTAURANTE_PEDIDO_CONTROLLER)
public class Restaurante_PedidoController {


	public static final String RESTAURANTE_PEDIDO_CONTROLLER="/RestaurantePedido";

	public static final String LISTA_BY_IDEMPRESA_FECHAVENTA="/listaPedidos/{idEmpresa}";

	public static final String LISTA_BY_IDEMPRESA_DISTINCT="/listaPedidosDistinct/{idEmpresa}";


	public static final String PEDIDO_RECIENTE="/reciente/{idEmpresa}/{idPedido}/{idVenta}";



	@Autowired
	Restaurante_PedidoService restaurante_PedidoService;


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

		List<Restaurante_Pedido> listaProductos=null;

		List<Restaurante_PedidoModified> listaTotal=null;

		try {

			listaProductos=restaurante_PedidoService.listaRestaurantePedidosNuevos(idEmpresa);

			listaRestaurante=restaurante_PedidoService.listaRestaurantePedidosNuevosDistinct(idEmpresa);

			listaTotal= new ArrayList<>();

			for(Restaurante_Pedido pedido:listaRestaurante) {

				Restaurante_PedidoModified res = new Restaurante_PedidoModified();
				res.setIdpedido(pedido.getIdpedido());
				res.setIdempresa(pedido.getIdempresa());
				res.setIdventa(pedido.getIdventa());
				res.setIdubicacion(pedido.getIdubicacion());
				res.setVenta_fecha(pedido.getVenta_fecha());
				res.setVenta_costototal(pedido.getVenta_costototal());
				res.setIdusuario(pedido.getIdusuario());
				res.setUsuario_nombre(pedido.getUsuario_nombre());
				res.setIdestado_venta(pedido.getIdestado_venta());
				res.setTiempo_espera(pedido.getTiempo_espera());

				List<Restaurante_Pedido> lista= new ArrayList<>();

				for(Restaurante_Pedido productos:listaProductos) {
					if(productos.getIdventa()==pedido.getIdventa()) {
						lista.add(productos);
					}
				}
				res.setListaProductos(lista);


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



		Restaurante_Pedido restauranteGson= null;

		List<Restaurante_Pedido> listaProductos=null;

		Restaurante_PedidoModified res =null;


		try {

			listaProductos=restaurante_PedidoService.listaRestaurantePedidosNuevos(idEmpresa);

			restauranteGson=restaurante_PedidoService.recientePedido(idEmpresa, idPedido, idVenta);


		

				res= new Restaurante_PedidoModified();
				res.setIdpedido(restauranteGson.getIdpedido());
				res.setIdempresa(restauranteGson.getIdempresa());
				res.setIdventa(restauranteGson.getIdventa());
				res.setIdubicacion(restauranteGson.getIdubicacion());
				res.setVenta_fecha(restauranteGson.getVenta_fecha());
				res.setVenta_costototal(restauranteGson.getVenta_costototal());
				res.setIdusuario(restauranteGson.getIdusuario());
				res.setUsuario_nombre(restauranteGson.getUsuario_nombre());
				res.setIdestado_venta(restauranteGson.getIdestado_venta());
				res.setTiempo_espera(restauranteGson.getTiempo_espera());

				List<Restaurante_Pedido> lista= new ArrayList<>();

				for(Restaurante_Pedido productos:listaProductos) {
					if(productos.getIdventa()==restauranteGson.getIdventa()) {
						lista.add(productos);
					}
				}
				res.setListaProductos(lista);


			
			


		}catch(Exception e) {

			System.out.println(e.getMessage());

			return new ResponseEntity<Restaurante_PedidoModified> ( res,HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return new ResponseEntity<Restaurante_PedidoModified>( res,HttpStatus.OK);
	}



}
