package com.backend.tienda.api;

import java.util.List;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Ubicacion;
import com.backend.tienda.service.UbicacionService;

@RestController
@RequestMapping("/Ubicacion")
public class UbicacionController {
	
	@Autowired
	UbicacionService ubicacionService;
	
	
	@RequestMapping(value = "/listaUbicacion/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Ubicacion>> listaUbicacionByidUsuario(@PathVariable("idUsuario")int idUsuario){
	
		List<Ubicacion> alu;
		try {
			alu= ubicacionService.listaUbicacion(idUsuario);
			return new ResponseEntity<List<Ubicacion>>(alu, HttpStatus.OK);

		}catch(Exception e) {
			alu= null;
			return new ResponseEntity<List<Ubicacion>>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	@RequestMapping(value = "/findUbicacion/{idUbicacion}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ubicacion> listaUbicacionByidUbicacion(@PathVariable("idUbicacion")int idUbicacion){
	
		Ubicacion alu;
		try {
			alu= ubicacionService.findByIdUbicacion(idUbicacion);
			return new ResponseEntity<Ubicacion>(alu, HttpStatus.OK);

		}catch(Exception e) {
			alu= null;
			return new ResponseEntity<Ubicacion>(alu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/registrarUbicacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrarUbicacionUsuario(@RequestBody Ubicacion ubicacion){
	
		Integer respuesta1=ubicacionService.actualizarEstadoUbicacionDesactivo(ubicacion.getIdusuario());
		System.out.println("repuesta "+ respuesta1);
		
		
		Integer respuesta=0;
		try {
			respuesta= ubicacionService.registrarUbicacion(ubicacion);
			return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);

		}catch(Exception e) {
		
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping(value = "/encontrarUbicacion/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ubicacion> findByIdUbicacion(@PathVariable("idUsuario")int idUsuario){
	
		Ubicacion ubicacion=null;
		try {
			ubicacion= ubicacionService.findByIdUsuarioAndIdUbicacion(idUsuario);
			return new ResponseEntity<Ubicacion>(ubicacion, HttpStatus.OK);

		}catch(Exception e) {
		
			return new ResponseEntity<Ubicacion>(ubicacion, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping(value = "/actualizarUbicacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizarUbicacion(@RequestBody Ubicacion ubicacion){
	
		Integer respuesta1=ubicacionService.actualizarEstadoUbicacionDesactivo(ubicacion.getIdusuario());
		
		Integer respuesta=0;
		try {
			respuesta= ubicacionService.actualizarEstadoUbicacionActivo(ubicacion.getIdubicacion());
			return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);

		}catch(Exception e) {
		
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping(value = "/eliminarUbicacion/{idUbicacion}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminarUbicacion(@PathVariable("idUbicacion") int idUbicacion){
	
		Integer respuesta=0;
		
		try {
			respuesta= ubicacionService.eliminarUbicacion(idUbicacion);
			return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);

		}catch(Exception e) {
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	
	}
	
	

}
