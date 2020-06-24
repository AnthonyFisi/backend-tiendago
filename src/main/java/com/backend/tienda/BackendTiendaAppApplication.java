package com.backend.tienda;

import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendTiendaAppApplication {
	
	


	public static void main(String[] args) {	
		SpringApplication.run(BackendTiendaAppApplication.class, args);
		Timestamp fecha_entrega=new Timestamp(System.currentTimeMillis());
		System.out.println(fecha_entrega+ " ------------");
		
	}

}
