package com.backend.tienda;

import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.tienda.firebase.Delivery;

@SpringBootApplication
public class BackendTiendaAppApplication {
	
	


	public static void main(String[] args) {	
		SpringApplication.run(BackendTiendaAppApplication.class, args);
		
		/*
		for(int i=5;i<60;i++) {
			  int min = 1;
		      int max = 10;
		      
			  //Generate random int value from 50 to 100 
		      int random_hora = (int)(Math.random() * (max - min + 1) + min);
			
		      int min1 = 1;
		      int max1 = 15;
			 
		      //Generate random double value from 50 to 100 
		      double random_pedido = Math.random() * (max1 - min1 + 1) + min1; 
		        
		    
		      int min2 = 1;
		      int max2= 5;
		      double random_frecuencia = Math.random() * (max2 - min2 + 1) + min2; 
		      
		      int min3 = 1;
		      int max3 = 5;
		      double random_calificacion = Math.random() * (max3 - min3 + 1) + min3; 
			
			String data="futures.add(cities.document(String.valueOf("+i+")).set(new Delivery(true,"+i+","+i+","+i+", \""+""+"\"  ,\""+ "nombre"+"\" ,true,true,"+random_hora+","+random_pedido+","+random_frecuencia+","+random_calificacion+")));";
		
			System.out.println(data);
			
		
		}*/
		
		
		
		
		Timestamp fecha_entrega=new Timestamp(System.currentTimeMillis());
		System.out.println(fecha_entrega+ " ------------");
		
	}

}
