package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import com.backend.tienda.entity.EmpresaOficial;
import com.backend.tienda.service.EmpresaOficialService;

@RestController
@RequestMapping(EmpresaOficialController.EMPRESA_OFICIAL_CONTROLLER)
public class EmpresaOficialController {
	
	public final static String EMPRESA_OFICIAL_CONTROLLER="/EmpresaOficialController";

	public final static String UPDATE_DESCUENTO_MENU="/updateDescuento/{idempresa}/{descuento}";
	

	public final static String UPDATE_DISPONIBILIDAD_EMPRESA="/updateDisponibilidad/{idEmpresa}/{disponibilidad}";

	public final static String UPDATE_NUMERO_TELEFONO="/updateTelefono/{idEmpresa}/{numTelefono}";

	public final static String UPDATE_NUMERO_CELULAR="/updateCelular/{idEmpresa}/{numCelular}";

	public final static String UPDATE_HORARIO_INICIO_FIN="/updateHorario/{idEmpresa}/{horarioInicio}/{horarioFin}";

	public final static String UPDATE_TIEMPO_APROXIMADO="/updateTiempo/{idEmpresa}/{tiempo}";

	public final static String UPDATE_DESCRIPCION="/updateDescripcion";
	
	@Autowired
	EmpresaOficialService empresaOficialService;
	
	@PostMapping(UPDATE_DESCUENTO_MENU)
	public ResponseEntity<?> updateDescuentoMenu(@PathVariable("idempresa") int idempresa,@PathVariable("descuento") float descuento){
		
		EmpresaOficial empresa=empresaOficialService.updateValorDescuento(idempresa, descuento);
		
		if(empresa==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(empresa);
		
	}
	
	
	@PostMapping(UPDATE_DISPONIBILIDAD_EMPRESA)
    public ResponseEntity<EmpresaOficial> updateDisponibilidadEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("disponibilidad") boolean disponibilidad){

        EmpresaOficial rpta=null;
        
        rpta=empresaOficialService.updateDisponibilidad(idEmpresa, disponibilidad);

        if(rpta==null) {
        	
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(rpta);

    }
	
	@PostMapping(UPDATE_NUMERO_TELEFONO)
	public ResponseEntity<EmpresaOficial> updateTelefonoEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("numTelefono")String numTelefono){

	        EmpresaOficial rpta=null;
	        
	        rpta=empresaOficialService.updateTelefono(idEmpresa, numTelefono);
	        if(rpta==null) {
	        	
	            return ResponseEntity.badRequest().build();
	        }
	        return ResponseEntity.ok(rpta);

	    }

	@RequestMapping(value=UPDATE_NUMERO_CELULAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpresaOficial> updateCelularEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("numCelular")String numCelular){

        EmpresaOficial rpta=null;

        try {
            rpta=empresaOficialService.updateCelular(idEmpresa, numCelular);

        }catch(Exception e) 
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<EmpresaOficial>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<EmpresaOficial>(rpta,HttpStatus.OK);

    }

    @RequestMapping(value=UPDATE_HORARIO_INICIO_FIN, method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpresaOficial> updateHorarioEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("horarioInicio")int horarioInicio,@PathVariable("horarioFin")int horarioFin){

        EmpresaOficial rpta=null;

        try {
            rpta=empresaOficialService.updateHorarioAtencion(idEmpresa, horarioInicio, horarioFin);

        }catch(Exception e) 
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<EmpresaOficial>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<EmpresaOficial>(rpta,HttpStatus.OK);

    }


    @RequestMapping(value=UPDATE_TIEMPO_APROXIMADO,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpresaOficial> updateTiempoEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("tiempo")String tiempo){

        EmpresaOficial rpta=null;

        try {
            rpta=empresaOficialService.updateTiempoEntrega(idEmpresa, tiempo);

        }catch(Exception e) 
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<EmpresaOficial>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<EmpresaOficial>(rpta,HttpStatus.OK);

    }



    @RequestMapping(value=UPDATE_DESCRIPCION,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpresaOficial> updateDescripcionEmpresa(@RequestBody EmpresaOficial empresa){

        EmpresaOficial rpta=null;

        try {
            rpta=empresaOficialService.updateDescripcion(empresa);

        }catch(Exception e) 
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<EmpresaOficial>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<EmpresaOficial>(rpta,HttpStatus.OK);

    }

}
