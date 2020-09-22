package com.backend.tienda;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.tienda.firebase.Delivery;

@SpringBootApplication
public class BackendTiendaAppApplication {
	
	


	public static void main(String[] args) {
		
		Timestamp time=new Timestamp(System.currentTimeMillis());


		String fecha2=
		    	LocalDate                       // Represents an entire day, without time-of-day and without time zone.
		    	.now(                           // Capture the current date.
		    	    ZoneId.of( "America/Lima" )   // Returns a `ZoneId` object.
		    	).plusDays(1).toString();
		
		Timestamp date2=Timestamp.valueOf(fecha2+" 19:56:00.000");
		
		long diference=date2.getTime()-time.getTime();
		
		//int minutos=(int) (diference/60000);
		
		System.out.println(diference+" milisegundos");
		
	
		SpringApplication.run(BackendTiendaAppApplication.class, args);
	
			
		
	}

}
