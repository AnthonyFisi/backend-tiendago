package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Horario;
import com.backend.tienda.gson.HorarioGson;
import com.backend.tienda.service.HorarioService;

@RestController
@RequestMapping(HorarioController.NOMBRE_HORARIO_CONTROLLER)
public class HorarioController {

	
	public static final String  NOMBRE_HORARIO_CONTROLLER="/horarioController";
	
	public static final String  LISTA_HORARIOS="/lista";


	@Autowired
	HorarioService horarioService;
	
	
	@RequestMapping(value=LISTA_HORARIOS,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HorarioGson> listaHorario(){
		
		HorarioGson horarioGson=null;
		List<Horario> lista=null;
		
		
		try {
			lista= horarioService.listahorario();
			
			horarioGson=new HorarioGson();
			
			horarioGson.setListaHorario(lista);
			
		}catch(Exception e) {
			
			return new ResponseEntity<HorarioGson>(horarioGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<HorarioGson>(horarioGson,HttpStatus.OK);

		
	}
}
