package com.backend.tienda.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.type.LatLng;


/**
 * This is the implementation Haversine Distance Algorithm between two places
 * @author ananth
 * R = earth’s radius (mean radius = 6,371km)
 Δlat = lat2− lat1
 Δlong = long2− long1
 a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
 c = 2.atan2(√a, √(1−a))
 d = R.c
 *
 */

/**
 * @param args
 * arg 1- latitude 1
 * arg 2 — latitude 2
 * arg 3 — longitude 1
 * arg 4 — longitude 2
 */
public class HaversineDistance {

	
	
	public static double calculateDistance(List<Double> point1,List<Double> point2) {

		final int R = 6371; // Radious of the earth
		Double lat1 =point1.get(0);
		Double lon1 = point1.get(1);
		Double lat2 = point2.get(0);
		Double lon2 = point2.get(1);
		Double latDistance = toRad(lat2-lat1);
		Double lonDistance = toRad(lon2-lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
				Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
				Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		Double distance = R * c;


		return distance;

	}

	private static Double toRad(Double value) {
		return value * Math.PI / 180;
	}

	public static List<Double> convertStringToPoint(String position) {
		
		List<Double> lista=new ArrayList<>();
		
		String data[] =position.split(",");
		
		for(int i=0;i<data.length;i++) {
			
			Double p=Double.valueOf(data[i]);
		
			lista.add(p);
		}
		
		return lista;
		
	}
	
	
	public static double funcionEvaluadora(double frecuencia,double cantidadpedido,double puntuacion,int horas,double distancia) {
		//VALORES EN PORCENTAJE PARA DEFINIR LA FUNCION EVALUADORA
		double porcentaje_frecuencia=0.1;
		
		double porcentaje_cantidad_pedidos=0.15;
		
		double porcentaje_puntuacion=0.25;
		
		double porcentaje_distancia=0.3;
		
		double procentaje_horas=0.2;
		
		
		
		double funcionEvaluadora=porcentaje_frecuencia*frecuencia
								+porcentaje_cantidad_pedidos*cantidadpedido
								+porcentaje_puntuacion*puntuacion
								+porcentaje_distancia*distancia
								+procentaje_horas*horas;	
		
		return funcionEvaluadora;
	}
	
	
	public static HashMap<String,String> calculateDistanceAndTime(String data) {
		
		HashMap<String,String> listaTiempoDistancia= new HashMap<String,String>();

		JSONObject parse ;
        JSONArray jRoutes;
        JSONArray jLegs;
        try {
            parse = new JSONObject(data);
            jRoutes=parse.getJSONArray("routes");
             jLegs = ( (JSONObject)jRoutes.get(0)).getJSONArray("legs");

              for(int j=0;j<jLegs.length();j++) {

                    JSONObject object= jLegs.getJSONObject(j);

                    System.out.println("DISTANCIA" + object.getJSONObject("distance").get("text")+"SOLO DISTANCIA");

                    String dis=object.getJSONObject("distance").get("text").toString();

                    listaTiempoDistancia.put("distance",dis);

                    System.out.println("TIEMPO "+object.getJSONObject("duration").get("text")+"SOLO DISTANCIA");

                    String tiem=object.getJSONObject("duration").get("text").toString();
                    
                    listaTiempoDistancia.put("duration",tiem);


                }
              
              
              return listaTiempoDistancia;
              
        } catch (JSONException e) {
            
        	e.printStackTrace();
            
            return listaTiempoDistancia;
        }
		
	}


}