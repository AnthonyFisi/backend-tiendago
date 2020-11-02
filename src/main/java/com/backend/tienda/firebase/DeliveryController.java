package com.backend.tienda.firebase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Delivery_Pedido;
import com.backend.tienda.entity.EmpresaOficial;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.Restaurante_Pedido;
import com.backend.tienda.entity.Restaurante_PedidoModified;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.gson.Delivery_PedidoGson;
import com.backend.tienda.gson.Restaurante_PedidoGson;
import com.backend.tienda.service.EmpresaOficialService;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;
import com.backend.tienda.service.Restaurante_PedidoService;
import com.backend.tienda.service.VentaService;
import com.backend.tienda.util.CalculatePriceDelivery;
import com.backend.tienda.util.GoogleMapsApi;
import com.backend.tienda.util.HaversineDistanceDelivery;
import com.pusher.rest.Pusher;

@RequestMapping(DeliveryController.DIRECCION)
@RestController
public class DeliveryController {

	public static final String DIRECCION="/delivery/v";

	public static final String LISTA_FIREBASE="/lista/v/total";

	public static final String LOAD_DATA="/load/{data}";

	public static final String LOAD_DATA2="/load/{idventa}/{idempresa}";


	@Autowired
	DeliveryService deliveryService;


	@Autowired
	GoogleMapsApi api;

	@Autowired
	Restaurante_PedidoService restaurante_PedidoService;

	@Autowired
	EmpresaOficialService empresaOficialService;

	@Autowired
	VentaService ventaService;

	@Autowired
	ProductoJOINregistroPedidoJOINpedidoService productoJOINregistroPedidoJOINpedidoService;



	static Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");


	@PostMapping(LISTA_FIREBASE)
	public ResponseEntity<?> listaDelivery(@RequestBody Delivery_PedidoGson pedidoPropuesta ){




		List<Delivery> lista=null;


		Delivery_PedidoGson pedido=pedidoPropuesta;

		try {



			double resultado=10000;
			int position=0;
			int positionElegida=0;

			lista = deliveryService.listaDeliveryAble(true);

			pusher.setCluster("us2");


			String error=lista.size()+"TAMAÑO";

			pusher.trigger("canal-orden-delivery", "my-event", error);


			for(Delivery data:lista) {


				//REALIZAR LA TRANSFORMACION DE STRING A DOUBLE LAS COORDENADAS

				List<Double> point1=HaversineDistanceDelivery.convertStringToPoint(data.getLocation());

				String coordenada=pedido.getDelivery_information().getEmpresa_coordenada_x()+","+pedido.getDelivery_information().getEmpresa_coordenada_y();

				List<Double> point2=HaversineDistanceDelivery.convertStringToPoint(coordenada);

				double distancia=HaversineDistanceDelivery.calculateDistance(point1, point2);


				//CALCULAR EN LA FUNCION EVALUADORA PARA GENERAR EL MEJOR RECOMENDADO

				double puntuacion=HaversineDistanceDelivery.funcionEvaluadora(data.getFrecuencia(),data.getPedido(),data.getCalificacion(),data.getHora(),distancia);


				//EVALUAR QUE PUNTUACION ES LA MAS RECOMENDABLE

				if(resultado>puntuacion) {
					resultado=puntuacion;
					positionElegida=position;
				}

				position++;

			}

			//CALCULAR LAS NUEVAS COORDENADS GPS
			List<Double> point1=HaversineDistanceDelivery.convertStringToPoint(lista.get(positionElegida).getLocation());

			String coordenada=pedido.getDelivery_information().getEmpresa_coordenada_x()+","+pedido.getDelivery_information().getEmpresa_coordenada_y();

			List<Double> point2=HaversineDistanceDelivery.convertStringToPoint(coordenada);



			//CONSULTAR POR LA DISTANCIA EN GOOGLEMAPS API

			String data=api.getLocation(point1, point2);


			// OBTENER EL TIEMPO Y LA DISTANCIA DE DE GOOGLEMAPS API


			HashMap<String,String> distancia_tiempo=HaversineDistanceDelivery.calculateDistanceAndTime(data);


			Double distancia_1=CalculatePriceDelivery.transformDistancia(pedido.getDelivery_information().getDistancia_delivery());

			Double distancia_2=CalculatePriceDelivery.transformDistancia(distancia_tiempo.get("distance"));

			Double suma_distancia=distancia_1+distancia_2;

			//CALCULAR EL PRECIO ESTIMADO QUE COSTARA EL ENVIO DELIVERY


			double precioTotal=CalculatePriceDelivery
					.calculatePriceDelivery(suma_distancia,distancia_tiempo.get("duration"),"0");


			pedido.getDelivery_information().setCosto_delivery((float)precioTotal);

			pedido.getDelivery_information().setDistancia_delivery(String.valueOf(suma_distancia));

			pedido.getDelivery_information().setIdrepartidor((lista.get(positionElegida).getIdRepartidor()));



			//deliveryService.updateDataDisponible(lista.get(positionElegida).getIdUsuario());


			//ENVIAR ATRAVES DE UN PUSH EL PEDIDO AL REPARTIDOR
			pusher.setCluster("us2");

			pusher.trigger("canal-orden-delivery-"+lista.get(positionElegida).getIdRepartidor(), "my-event", pedido);




			return ResponseEntity.ok(true);


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			pusher.setCluster("us2");


			String error=e.getMessage() + e.getCause()+e.getLocalizedMessage()+e.getStackTrace();

			pusher.trigger("canal-orden-delivery", "my-event", error);

			System.out.println();
			e.printStackTrace();
			return ResponseEntity.badRequest().build();

		} catch (ExecutionException e) {
			pusher.setCluster("us2");


			String error=e.getMessage() + e.getCause()+e.getLocalizedMessage()+e.getStackTrace();

			pusher.trigger("canal-orden-delivery", "my-event", error);
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());

			e.printStackTrace();
			return ResponseEntity.badRequest().build();

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());

			pusher.setCluster("us2");


			String error=e.getMessage() + e.getCause()+e.getLocalizedMessage()+e.getStackTrace();

			pusher.trigger("canal-orden-delivery", "my-event", error);

			return ResponseEntity.badRequest().build();

		}


	}




	//@PostMapping(LOAD_DATA)
	public ResponseEntity<String> loadData(@PathVariable("data")int data ){


		//deliveryService.updateData();

		try {
			deliveryService.loadData(data);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());

			e.printStackTrace();
		}

		return ResponseEntity.ok("SALIO BIEN ");



	}

	@PostMapping(LOAD_DATA2)
	public void entregaProgramda(@PathVariable("idventa")int idventa,@PathVariable("idempresa")int idempresa) {

		Venta venta=new Venta();

		venta=ventaService.getVenta(idventa);

		long tiempoEspera=new Long(venta.getTiempototal_espera());

		long tiempo=(long) (tiempoEspera*0.6);


		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Inicio "+dateFormat.format(date));

		Timer timer;
		timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run()
			{


				DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date2 = new Date();

				System.out.println("Fin tiempo"+dateFormat2.format(date2));


				searchRepartidor(idventa,idempresa);


				DateFormat dateFormat3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date3 = new Date();

				System.out.println("Fin :"+dateFormat3.format(date3));


			}
		};

		timer.schedule(task,tiempo);

	}


	public  void searchRepartidor(int idventa,int idempresa) {

		//Delivery_PedidoGson pedidoPropuesta=;

		List<Delivery> lista=null;

		Delivery_PedidoGson pedido=createGsonPedido(idventa,idempresa);

		System.out.println(pedido.getDelivery_information().getEmpresa_coordenada_x()+","+pedido.getDelivery_information().getEmpresa_coordenada_y()+"5555555");

		try {



			double resultado=10000;
			int position=0;
			int positionElegida=0;

			lista = deliveryService.listaDeliveryAble(true);

			for(Delivery data:lista) {


				//REALIZAR LA TRANSFORMACION DE STRING A DOUBLE LAS COORDENADAS

				List<Double> point1=HaversineDistanceDelivery.convertStringToPoint(data.getLocation());

				String coordenada=pedido.getDelivery_information().getEmpresa_coordenada_x()+","+pedido.getDelivery_information().getEmpresa_coordenada_y();

				List<Double> point2=HaversineDistanceDelivery.convertStringToPoint(coordenada);

				double distancia=HaversineDistanceDelivery.calculateDistance(point1, point2);


				//CALCULAR EN LA FUNCION EVALUADORA PARA GENERAR EL MEJOR RECOMENDADO

				double puntuacion=HaversineDistanceDelivery.funcionEvaluadora(data.getFrecuencia(),data.getPedido(),data.getCalificacion(),data.getHora(),distancia);


				//EVALUAR QUE PUNTUACION ES LA MAS RECOMENDABLE

				if(resultado>puntuacion) {
					resultado=puntuacion;
					positionElegida=position;
				}

				position++;

			}

			//CALCULAR LAS NUEVAS COORDENADS GPS
			List<Double> point1=HaversineDistanceDelivery.convertStringToPoint(lista.get(positionElegida).getLocation());

			String coordenada=pedido.getDelivery_information().getEmpresa_coordenada_x()+","+pedido.getDelivery_information().getEmpresa_coordenada_y();

			List<Double> point2=HaversineDistanceDelivery.convertStringToPoint(coordenada);



			//CONSULTAR POR LA DISTANCIA EN GOOGLEMAPS API

			String data=api.getLocation(point1, point2);

			System.out.println(data.isEmpty() + "RESPUESTA DE CADENA"+data);

			// OBTENER EL TIEMPO Y LA DISTANCIA DE DE GOOGLEMAPS API


			HashMap<String,String> distancia_tiempo=HaversineDistanceDelivery.calculateDistanceAndTime(data);


			Double distancia_1=CalculatePriceDelivery.transformDistancia(pedido.getDelivery_information().getDistancia_delivery());

			Double distancia_2=CalculatePriceDelivery.transformDistancia(distancia_tiempo.get("distance"));

			Double suma_distancia=distancia_1+distancia_2;

			//CALCULAR EL PRECIO ESTIMADO QUE COSTARA EL ENVIO DELIVERY


			double precioTotal=CalculatePriceDelivery
					.calculatePriceDelivery(suma_distancia,distancia_tiempo.get("duration"),"0");


			pedido.getDelivery_information().setCosto_delivery((float)precioTotal);

			pedido.getDelivery_information().setDistancia_delivery(String.valueOf(suma_distancia));

			pedido.getDelivery_information().setIdrepartidor((lista.get(positionElegida).getIdRepartidor()));



			System.out.println(lista.get(positionElegida).getIdRepartidor()+ "REPARTIDOR");


			//ENVIAR ATRAVES DE UN PUSH EL PEDIDO AL REPARTIDOR
			pusher.setCluster("us2");

			//pusher.trigger("canal-orden-reciente-"+lista.get(positionElegida).getIdRepartidor(), "my-event", pedido);


			pusher.trigger("canal-orden-delivery-"+lista.get(positionElegida).getIdRepartidor(), "my-event", pedido);



		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());
			e.printStackTrace();

		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());

			e.printStackTrace();

		}catch (Exception e) {

			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());

			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}


	public   Delivery_PedidoGson createGsonPedido(int idventa,int idempresa) {

		Delivery_PedidoGson delivery=null;

		//List<ProductoJOINregistroPedidoJOINpedido> listaProductos=null;

		Restaurante_Pedido restaurante_pedido=restaurante_PedidoService.findByIdVenta(idventa);

		delivery = new Delivery_PedidoGson();

		EmpresaOficial empresaOficial=empresaOficialService.findByIdempresa(idempresa);

		delivery=convert(restaurante_pedido,empresaOficial);


		//listaProductos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(restaurante_pedido.getIdpedido());

		//delivery.setProductos(listaProductos);


		return delivery;
	}



	private  Delivery_PedidoGson convert(Restaurante_Pedido mRestaurante_pedido,EmpresaOficial empresa ) {
		Delivery_PedidoGson gson=new Delivery_PedidoGson();
		Delivery_Pedido pedido=new Delivery_Pedido();

		pedido.setIdventa(mRestaurante_pedido.getIdventa());
		pedido.setIdtipopago(mRestaurante_pedido.getIdtipopago());
		pedido.setTipopago_nombre(mRestaurante_pedido.getTipopago_nombre());
		pedido.setUbicacion_nombre(mRestaurante_pedido.getUbicacion_nombre());
		pedido.setIdusuario(mRestaurante_pedido.getIdusuario());
		pedido.setUsuario_coordenada_x(mRestaurante_pedido.getMaps_coordenada_x());
		pedido.setUsuario_coordenada_y(mRestaurante_pedido.getMaps_coordenada_y());
		pedido.setIdpedido(mRestaurante_pedido.getIdpedido());
		pedido.setVenta_costodelivery(mRestaurante_pedido.getVenta_costodelivery());
		pedido.setVenta_costototal(mRestaurante_pedido.getVenta_costototal());
		pedido.setCancelar(mRestaurante_pedido.isCancelar());
		pedido.setComentario_global(mRestaurante_pedido.getComentario());
		pedido.setCosto_delivery(mRestaurante_pedido.getVenta_costodelivery());
		pedido.setDistancia_delivery(mRestaurante_pedido.getDistancia_delivery());
		pedido.setTiempo(mRestaurante_pedido.getTiempo_aprox_delivery());
		pedido.setOrden_disponible(true);
		pedido.setIdestado_delivery(mRestaurante_pedido.getIdestadodelivery());
		pedido.setIdrepartidor(mRestaurante_pedido.getIdrepartidor());
		pedido.setIdestado_pago(mRestaurante_pedido.getIdtipopago());
		pedido.setNombre_estadopago(mRestaurante_pedido.getNombre_estadopago());
		pedido.setNombre(mRestaurante_pedido.getNombre());
		pedido.setCelular(mRestaurante_pedido.getCelular());
		pedido.setIdempresa(empresa.getIdempresa());
		pedido.setDireccion_empresa(empresa.getDireccion_empresa());
		pedido.setEmpresa_coordenada_x(empresa.getMaps_coordenada_x());
		pedido.setEmpresa_coordenada_y(empresa.getMaps_coordenada_y());
		pedido.setNombre_empresa(empresa.getNombre_empresa());
		pedido.setUbicacion_comentarios(pedido.getUbicacion_comentarios());
		pedido.setVenta_fechaentrega(mRestaurante_pedido.getVentafechaentrega());

		gson.setDelivery_information(pedido);
		return  gson;

	}


}
