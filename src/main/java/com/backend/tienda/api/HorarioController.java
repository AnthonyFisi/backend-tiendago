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
import com.backend.tienda.service.HorarioService;

@RestController
@RequestMapping("/Horario")
public class HorarioController {

	@Autowired
	HorarioService horarioService;

	@RequestMapping(value = "/lista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Horario>> obtenerListaHorario(){
		List<Horario> listHorario;
		try {
			listHorario=horarioService.listaHorarios();
			return new ResponseEntity<List<Horario>>(listHorario, HttpStatus.OK);

		}catch(Exception e) {
			listHorario= null;
			return new ResponseEntity<List<Horario>>(listHorario, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
}
