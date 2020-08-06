package com.backend.tienda.util;

public class CalculatePriceDelivery {
	
	//PRECIO BASE DE CADA ENTREGA
	private static double precio_base= 2.0;
	
	// PRECIO POR CADA KILOMETRO RECORRIDO POR EL DELIVERY
	private static double precio_kilometro=0.5;
	
	//PRECIO POR DIFICULTAD DE ENTREGA
	private static double precio_dificultad=0;
	
	
	public static double calculatePriceDelivery(Double distancia, String tiempo, String dificultad) {
		
		//LA DISTANCIA ESTA EN KM
		double dis=distancia;
		
		//EL TIEMPO ESTA EN MIN
		double tiem=transformTiempo(tiempo);		
		
		double priceTotal=precio_base+dis*precio_kilometro+precio_dificultad;
		
		return priceTotal;
		
	}
	
	public static double transformDistancia(String distancia) {
		
		String data[] =distancia.split(" ");
		
		return Float.valueOf(data[0]);
		
	}
	
	public static double transformTiempo(String tiempo) {
		
		String data[] =tiempo.split(" ");
		
		return Float.valueOf(data[0]);
		
	}
	

}
