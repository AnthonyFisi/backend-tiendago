package com.backend.tienda.firebase;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Restaurante_PedidoModified;
import com.backend.tienda.gson.Delivery_PedidoGson;
import com.backend.tienda.gson.Restaurante_PedidoGson;
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

	@Autowired
	DeliveryService deliveryService;


	@Autowired
	GoogleMapsApi api;


	Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");




	@PostMapping(LISTA_FIREBASE)
	public ResponseEntity<?> listaDelivery(@RequestBody Delivery_PedidoGson pedidoPropuesta ){




		List<Delivery> lista=null;


		Delivery_PedidoGson pedido=pedidoPropuesta;

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


			//ENVIAR ATRAVES DE UN PUSH EL PEDIDO AL REPARTIDOR
			pusher.setCluster("us2");

			pusher.trigger("canal-orden-reciente-"+lista.get(positionElegida).getIdRepartidor(), "my-event", pedido);




			return ResponseEntity.ok(true);


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().build();

		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());

			e.printStackTrace();
			return ResponseEntity.badRequest().build();

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().build();

		}


	}




	@PostMapping(LOAD_DATA)
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


	public void searchRepartidor(Delivery_PedidoGson pedidoPropuesta ) {
		List<Delivery> lista=null;


		Delivery_PedidoGson pedido=pedidoPropuesta;

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


			//ENVIAR ATRAVES DE UN PUSH EL PEDIDO AL REPARTIDOR
			pusher.setCluster("us2");

			pusher.trigger("canal-orden-reciente-"+lista.get(positionElegida).getIdRepartidor(), "my-event", pedido);






		} catch (InterruptedException e) {
			// TODO Auto-generated catch block

			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());
			e.printStackTrace();

		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + e.getCause()+e.getLocalizedMessage());

			e.printStackTrace();

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}





}
