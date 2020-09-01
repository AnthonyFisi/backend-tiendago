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

import com.backend.tienda.entity.Empresa;
import com.backend.tienda.gson.EmpresaGson;
import com.backend.tienda.service.EmpresaService;
import com.backend.tienda.util.HaversineDistanceDelivery;

@RestController
@RequestMapping(EmpresaController.EMPRESA_CONTROLLER)
public class EmpresaController {
	/*nuevoo*/

	public final static String EMPRESA_CONTROLLER="/EmpresaController";


	public final static String FIND_EMPRESA_IDSUBCATEGORIA="/ListafindBySubcategoria/{idSubCategoria}";

	public final static String FIND_EMPRESA_BY_IDCATEGORIA_UBICACION="/ListafindByLocation/{idCategoria}/{Ubicacion}";

	public final static String FIND_EMPRESA_BY_IDCATEGORIA_SORT="/ListaSortfindBy/{idCategoria}";

	public final static String FIND_EMPRESA_BY_IDSUBCATEGORIA_UBICACION="/ListafindByLocationSubCategoria/{idSubCategoria}/{Ubicacion}";

	public final static String FIND_LISTA="/lista";

	public final static String FIND_LISTA_ENTERPRISE="/listaEnterprise/{idCategoria}";

	public final static String REGISTRAR_EMPRESA="/registrar";


	public final static String FIND_BY_EMPRESA="/findByEmpresa/{idEmpresa}";

	public final static String UPDATE_DISPONIBILIDAD_EMPRESA="/updateDisponibilidad/{idEmpresa}/{disponibilidad}";


	public final static String UPDATE_NUMERO_TELEFONO="/updateTelefono/{idEmpresa}/{numTelefono}";

	public final static String UPDATE_NUMERO_CELULAR="/updateCelular/{idEmpresa}/{numCelular}";

	public final static String UPDATE_HORARIO_INICIO_FIN="/updateHorario/{idEmpresa}/{horarioInicio}/{horarioFin}";

	public final static String UPDATE_TIEMPO_APROXIMADO="/updateTiempo/{idEmpresa}/{tiempo}";

	public final static String UPDATE_DESCRIPCION="/updateDescripcion";




	@Autowired
	EmpresaService empresaService;



	@RequestMapping(value=FIND_EMPRESA_IDSUBCATEGORIA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaCategoriaEmpresa(@PathVariable("idSubCategoria") int idSubCategoria){

		EmpresaGson empresaGson =null;
		List<Empresa> lista=null;


		try {
			lista=empresaService.listaEmpresaFindByIdSubCategoria(idSubCategoria);
			empresaGson=new EmpresaGson();
			empresaGson.setListaEmpresa(lista);
		}catch(Exception e) 
		{
			return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.OK);

	}

	@RequestMapping(value=FIND_EMPRESA_BY_IDCATEGORIA_UBICACION,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaEmpresaFindByIdCategoriaAndUbicacion(@PathVariable("idCategoria") int idCategoria
			,@PathVariable("Ubicacion")String Ubicacion){

		List<Empresa> listaEmpresaCerca=new ArrayList<>();

		EmpresaGson empresaGson =null;

		List<Empresa> lista=null;

		lista=empresaService.listaEmpresaIdCategoria(idCategoria);

		listaEmpresaCerca=HaversineDistanceDelivery.calculateDistance(lista,Ubicacion);


		empresaGson=new EmpresaGson();

		empresaGson.setListaEmpresa(listaEmpresaCerca);


		return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.OK);

	}


	@RequestMapping(value=FIND_EMPRESA_BY_IDCATEGORIA_SORT,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaEmpresaSortByBusquedaRating(@PathVariable("idCategoria") int idCategoria){

		EmpresaGson empresaGson =null;
		List<Empresa> lista=null;


		try {
			lista=empresaService.listaEmpresaSortByBusquedaRating(idCategoria);
			empresaGson=new EmpresaGson();
			empresaGson.setListaEmpresa(lista);
		}catch(Exception e) 
		{
			
			return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.OK);

	}



	@RequestMapping(value=FIND_EMPRESA_BY_IDSUBCATEGORIA_UBICACION,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaEmpresaFindByIdSubCategoriaAndUbicacion(@PathVariable("idSubCategoria") int idSubCategoria,@PathVariable("Ubicacion")String Ubicacion){

		EmpresaGson empresaGson =null;
		
		List<Empresa> lista=null;
		
		List<Empresa> listaEmpresaCerca=new ArrayList<>();

		lista=empresaService.listaEmpresaFindByIdSubCategoria(idSubCategoria);

		listaEmpresaCerca=HaversineDistanceDelivery.calculateDistance(lista,Ubicacion);

		empresaGson=new EmpresaGson();

		empresaGson.setListaEmpresa(listaEmpresaCerca);



		return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.OK);

	}

	@RequestMapping(value=REGISTRAR_EMPRESA,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> regitrarEmpresa(@RequestBody Empresa empresa){

		Empresa rpta=null;

		try {
			rpta=empresaService.InsertEmpresa(empresa);

		}catch(Exception e) 
		{
			return new ResponseEntity<Empresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Empresa>(rpta,HttpStatus.OK);

	}

	@RequestMapping(value=FIND_BY_EMPRESA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> findByIdEmpresa(@PathVariable("idEmpresa") int idEmpresa){

		Empresa rpta=null;

		try {
			rpta=empresaService.findByIdEmpresaTotal(idEmpresa);

		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<Empresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Empresa>(rpta,HttpStatus.OK);

	}


	@RequestMapping(value=UPDATE_DISPONIBILIDAD_EMPRESA,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> updateDisponibilidadEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("disponibilidad") boolean disponibilidad){

		Empresa rpta=null;

		try {
			rpta=empresaService.updateDisponibilidad(idEmpresa, disponibilidad);

		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<Empresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Empresa>(rpta,HttpStatus.OK);

	}


	@RequestMapping(value=UPDATE_NUMERO_TELEFONO,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> updateTelefonoEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("numTelefono")String numTelefono){

		Empresa rpta=null;

		try {
			rpta=empresaService.updateTelefono(idEmpresa, numTelefono);

		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<Empresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Empresa>(rpta,HttpStatus.OK);

	}

	@RequestMapping(value=UPDATE_NUMERO_CELULAR,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> updateCelularEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("numCelular")String numCelular){

		Empresa rpta=null;

		try {
			rpta=empresaService.updateCelular(idEmpresa, numCelular);

		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<Empresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Empresa>(rpta,HttpStatus.OK);

	}

	@RequestMapping(value=UPDATE_HORARIO_INICIO_FIN, method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> updateHorarioEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("horarioInicio")int horarioInicio,@PathVariable("horarioFin")int horarioFin){

		Empresa rpta=null;

		try {
			rpta=empresaService.updateHorarioAtencion(idEmpresa, horarioInicio, horarioFin);

		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<Empresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Empresa>(rpta,HttpStatus.OK);

	}


	@RequestMapping(value=UPDATE_TIEMPO_APROXIMADO,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> updateTiempoEmpresa(@PathVariable("idEmpresa") int idEmpresa,@PathVariable("tiempo")String tiempo){

		Empresa rpta=null;

		try {
			rpta=empresaService.updateTiempoEntrega(idEmpresa, tiempo);

		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<Empresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Empresa>(rpta,HttpStatus.OK);

	}



	@RequestMapping(value=UPDATE_DESCRIPCION,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa> updateDescripcionEmpresa(@RequestBody Empresa empresa){

		Empresa rpta=null;

		try {
			rpta=empresaService.updateDescripcion(empresa);

		}catch(Exception e) 
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<Empresa>(rpta,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Empresa>(rpta,HttpStatus.OK);

	}


}
