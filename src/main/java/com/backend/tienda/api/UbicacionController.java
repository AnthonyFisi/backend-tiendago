package com.backend.tienda.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Ubicacion;
import com.backend.tienda.entity.Usuario;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.entity.VentaAndroid;
import com.backend.tienda.gson.UbicacionGson;
import com.backend.tienda.repository.UsuarioRepository;
import com.backend.tienda.service.UbicacionService;

@RestController
@RequestMapping(UbicacionController.UBICACION_CONTROLLER)

public class UbicacionController {
	
	public final static String UBICACION_CONTROLLER="/UbicacionController";
	
	public final static String LISTA_BY_IDUSUARIO="/listaTotalByUsuario/{idusuario}";
	
	public final static String OBJETO_BY_IDUBICACION="/ObjetoByUbicacion/{idubicacion}";
	
	public final static String REGISTRAR="/registrar/{idOldUbicacion}";

	public final static String REGISTRAR_FIRST_TIME="/registrarFirstTime";
	
	public final static String ACTUALIZAR_ESTADO="/updateEstadoUbicacion/{idOldUbicacion}/{idNewUbicacion}";
	
	public final static String ELIMINAR_UBICACION="/deleteUbicacion/{idUbicacion}";
	
	
	@Autowired
	UbicacionService ubicacionService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value=LISTA_BY_IDUSUARIO,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UbicacionGson>  listaUbicacionByIdUsuario(@PathVariable("idusuario")int idusuario){
		
		List<Ubicacion> listaUbicacion=null;
		UbicacionGson ubicacionGson=null;
		
		try {
			
			listaUbicacion=ubicacionService.findByidusuario(idusuario);
			ubicacionGson=new UbicacionGson();
			ubicacionGson.setListaUbicacion(listaUbicacion);
			
		}catch(Exception e) {
			return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.OK);
	}
	
	

	@RequestMapping(value=REGISTRAR_FIRST_TIME,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ubicacion>  registrarFirstTimeUbicacion(@RequestBody Ubicacion ubicacion){
		
		Ubicacion ubicacio=null;
		Usuario usuario=null;
		
		try {
			
			
			usuario=usuarioRepository.findByIdusuariogeneral(ubicacion.getIdusuario());
			ubicacion.setIdusuario(usuario.getIdusuario());
			ubicacio=ubicacionService.saveUbicacionFirstTime(ubicacion);
			
		}catch(Exception e) {
			return new  ResponseEntity<Ubicacion>(ubicacio,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<Ubicacion>(ubicacio,HttpStatus.OK);
	}
	
	@RequestMapping(value=REGISTRAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ubicacion>  registrarUbicacion(@RequestBody Ubicacion ubicacion,@PathVariable("idOldUbicacion") int idOldUbicacion){
		
		Ubicacion ubicacio=null;
		Usuario usuario=null;

		
		usuario=usuarioRepository.findByIdusuariogeneral(ubicacion.getIdusuario());

		
		try {
			ubicacion.setIdusuario(usuario.getIdusuario());
			ubicacio=ubicacionService.saveUbicacion(ubicacion,idOldUbicacion);
			
		}catch(Exception e) {
			return new  ResponseEntity<Ubicacion>(ubicacio,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<Ubicacion>(ubicacio,HttpStatus.OK);
	}
	
	@RequestMapping(value=OBJETO_BY_IDUBICACION,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UbicacionGson>  searchByIdUbicacion(@PathVariable("idubicacion")int idubicacion){
		
		Ubicacion ubicacion=null;
		UbicacionGson ubicacionGson=null;
		
		try {
			ubicacion=ubicacionService.findByidubicacion(idubicacion);
			List<Ubicacion> lista=new ArrayList<>();
			lista.add(ubicacion);
			ubicacionGson=new UbicacionGson();
			ubicacionGson.setListaUbicacion(lista);
			
			
		}catch(Exception e) {
			return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.OK);
	}


	
	@RequestMapping(value=ACTUALIZAR_ESTADO,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UbicacionGson>  searchByIdUbicacion(@PathVariable("idOldUbicacion")int idOldUbicacion,
			@PathVariable("idNewUbicacion")int idNewUbicacion){
		
		Ubicacion ubicacion=null;
		UbicacionGson ubicacionGson=null;
		boolean respuestaOld=false;
		boolean respuestaNew=false;
		
		respuestaOld=ubicacionService.updateEstadoUbicacion(idOldUbicacion,false);
		

		
		if(respuestaOld) {
			
			respuestaNew=ubicacionService.updateEstadoUbicacion(idNewUbicacion,true);
			
		}
		
		if(respuestaNew) {
			
		try {
				ubicacion=ubicacionService.findByidubicacion(idNewUbicacion);
				List<Ubicacion> lista=new ArrayList<>();
				lista.add(ubicacion);
				ubicacionGson=new UbicacionGson();
				ubicacionGson.setListaUbicacion(lista);
				
				
			}catch(Exception e) {
				return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
	//return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.INTERNAL_SERVER_ERROR);


		return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value=ELIMINAR_UBICACION,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UbicacionGson>  deleteUbicacion(@PathVariable("idUbicacion")int idUbicacion){
		
		boolean respuesta=false;
		
		UbicacionGson ubicacionGson=null;
		Ubicacion ubicacion=null;
		
		respuesta=ubicacionService.deleteUbicacion(idUbicacion);
		if(respuesta) {
	
			ubicacion=new Ubicacion();
			List<Ubicacion> lista=new ArrayList<>();
			lista.add(ubicacion);
			ubicacionGson=new UbicacionGson();
			ubicacionGson.setListaUbicacion(lista);
			
		}else {
			return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
		return new  ResponseEntity<UbicacionGson>(ubicacionGson,HttpStatus.OK);
	}


	
	
}
