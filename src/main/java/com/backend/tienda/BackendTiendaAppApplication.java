package com.backend.tienda;

import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.tienda.firebase.Delivery;

@SpringBootApplication
public class BackendTiendaAppApplication {
	
	


	public static void main(String[] args) {
		int m=876;

		for(int i=0;i<22;i++) {
			
			/*String ROM = "Java Programming";
			ROM = "\"" + ROM + "\"";*/
			/*System.out.println("INSERT INTO categoria_producto_empresa (idempresa,nombre,descripcion) VALUES (  \"" + i + "\",'Productos 1','Ninguna');" );
			System.out.println("INSERT INTO categoria_producto_empresa (idempresa,nombre,descripcion) VALUES (  \"" + i + "\",'Productos 2','Ninguna');" );
			System.out.println("INSERT INTO categoria_producto_empresa (idempresa,nombre,descripcion) VALUES (  \"" + i + "\",'Productos 3','Ninguna');" );
			System.out.println("INSERT INTO categoria_producto_empresa (idempresa,nombre,descripcion) VALUES (  \"" + i + "\",'Productos 4','Ninguna');" );
			System.out.println("INSERT INTO categoria_producto_empresa (idempresa,nombre,descripcion) VALUES (  \"" + i + "\",'Productos 5','Ninguna');" );*/
			
			
		/*	System.out.println("UPDATE producto SET idcategoriaproducto = ? WHERE idempresa=\"" + i + "\" AND idcategoriaproducto=1;");
			System.out.println("UPDATE producto SET idcategoriaproducto = ? WHERE idempresa=\"" + i + "\" AND idcategoriaproducto=2;");
			System.out.println("UPDATE producto SET idcategoriaproducto = ? WHERE idempresa=\"" + i + "\" AND idcategoriaproducto=3;");
			System.out.println("UPDATE producto SET idcategoriaproducto = ? WHERE idempresa=\"" + i + "\" AND idcategoriaproducto=4;");
			System.out.println("UPDATE producto SET idcategoriaproducto = ? WHERE idempresa=\"" + i + "\" AND idcategoriaproducto=5;");
*/
			System.out.println("idproducto BETWEEN \"" + m  +"\" AND + \""+ (m+9) +"\";");
			
			m=m+9;

			//idproducto BETWEEN 859 AND 868;
			
		}

		SpringApplication.run(BackendTiendaAppApplication.class, args);
	
			
		
	}

}
