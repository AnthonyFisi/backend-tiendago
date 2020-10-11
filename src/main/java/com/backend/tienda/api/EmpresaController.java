package com.backend.tienda.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Empresa;
import com.backend.tienda.entity.EmpresaOficial;
import com.backend.tienda.gson.EmpresaGson;
import com.backend.tienda.repository.EmpresaOficialRepository;
import com.backend.tienda.repository.EmpresaRepository;
import com.backend.tienda.service.EmpresaService;
import com.backend.tienda.util.HaversineDistanceDelivery;

@RestController
@RequestMapping(EmpresaController.EMPRESA_CONTROLLER)
public class EmpresaController {

	public final static String EMPRESA_CONTROLLER="/EmpresaController";

	public final static String LISTA="/lista";

	public final static String FIND_EMPRESA_BY_UBICACION_CERCA="/ListaCerca/{Ubicacion}";

	
	public final static String FIND_EMPRESA_BY_IDCATEGORIA_UBICACION="/ListafindByLocation/{idCategoria}/{Ubicacion}";
		
	//REEMPLAZAMPS ->ELIMINADOS 
	public final static String FIND_EMPRESA_BY_IDCATEGORIA_SORT="/ListaSortfindBy/{idCategoria}";
	
	public final static String FIND_EMPRESA_BY_IDCATEGORIA_UBICACION_COMPLEMENTARIA="/ListaCategoriaComplemento/{idCategoria}/{Ubicacion}";

	

	public final static String FIND_EMPRESA_BY_IDSUBCATEGORIA_UBICACION="/ListafindByLocationSubCategoria/{idSubCategoria}/{Ubicacion}";
	
	//REEMPLAZAMPS ->ELIMINADOS 
	public final static String FIND_EMPRESA_IDSUBCATEGORIA="/ListafindBySubcategoria/{idSubCategoria}";
	
	public final static String FIND_EMPRESA_BY_IDSUBCATEGORIA_UBICACION_COMPLEMENTARIA="/ListaSubcategoriaComplemento/{idSubCategoria}/{Ubicacion}";


	public final static String REGISTRAR_EMPRESA="/registrar";

	public final static String FIND_BY_EMPRESA="/findByEmpresa/{idEmpresa}";

	public final static String UPDATE_DISPONIBILIDAD_EMPRESA="/updateDisponibilidad/{idEmpresa}/{disponibilidad}";

	public final static String UPDATE_NUMERO_TELEFONO="/updateTelefono/{idEmpresa}/{numTelefono}";

	public final static String UPDATE_NUMERO_CELULAR="/updateCelular/{idEmpresa}/{numCelular}";

	public final static String UPDATE_HORARIO_INICIO_FIN="/updateHorario/{idEmpresa}/{horarioInicio}/{horarioFin}";

	public final static String UPDATE_TIEMPO_APROXIMADO="/updateTiempo/{idEmpresa}/{tiempo}";

	public final static String UPDATE_DESCRIPCION="/updateDescripcion";

	public final static String FILTRO_BY_IDCATEGORIA_DISTANCIA_PRECIODELIVERY="/filtro/{idcategoriaempresa}/{distancia}/{preciodelivery}/{ubicacion}";


	@Autowired
	EmpresaService empresaService;

	@Autowired
	EmpresaRepository empresaOficialRepository;
	
	@GetMapping(FILTRO_BY_IDCATEGORIA_DISTANCIA_PRECIODELIVERY)
	public ResponseEntity<List<Empresa>> filtroEmpresa(
			@PathVariable("idcategoriaempresa")int idcategoriaempresa,
			@PathVariable("distancia")int distancia,
			@PathVariable("preciodelivery")float preciodelivery,
			@PathVariable("ubicacion")String ubicacion){

		int distance=10000; 
		
		float price_delivery=100;
				
		if(distancia>0) {
			distance=distancia;
		}
		if(preciodelivery>0) {
			price_delivery=preciodelivery;
		}

		List<Empresa> lista=empresaService.listaEmpresaFiltro(idcategoriaempresa, price_delivery);
		
		lista=HaversineDistanceDelivery.calculateDistance(lista,ubicacion,distance);
		
		return ResponseEntity.ok(lista);

	}
	
	
	@GetMapping(LISTA)
	public ResponseEntity<?> todo(){
		List<Empresa> lista=empresaOficialRepository.findAll();
	
		
		return ResponseEntity.ok(lista);
		
	}

	//ESTA ES LA RELACION DE EMPRESA CERCANAS DE UNA CATEGORIA EN ESPECIFIO (EJEM:RESTAURANTE) EN UN RADIO DE 3000 METROS
	@RequestMapping(value=FIND_EMPRESA_BY_IDCATEGORIA_UBICACION,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaEmpresaFindByIdCategoriaAndUbicacion(@PathVariable("idCategoria") int idCategoria
			,@PathVariable("Ubicacion")String Ubicacion){
		
		double distancia=3000;

		
		List<Empresa> listaEmpresaCerca=new ArrayList<>();

		EmpresaGson empresaGson =null;

		List<Empresa> lista=null;

		lista=empresaService.listaEmpresaIdCategoria(idCategoria);
		

		listaEmpresaCerca=HaversineDistanceDelivery.calculateDistance(lista,Ubicacion,distancia);


		empresaGson=new EmpresaGson();

		empresaGson.setListaEmpresa(listaEmpresaCerca);


		return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.OK);

	}
	
	//ESTA ES LA RELACION DE EMPRESA QUE ESTAN A 3000 METROS DEL PUNTO DEL USUARIO Y MENORES a 5000 METROS Y SE FILTRA POR UNA CATEGORIA EN ESPECIAL

	@RequestMapping(value=FIND_EMPRESA_BY_IDCATEGORIA_UBICACION_COMPLEMENTARIA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaEmpresaFindByIdCategoriaAndUbicacionComplementaria(@PathVariable("idCategoria") int idCategoria
			,@PathVariable("Ubicacion")String Ubicacion){

		System.out.println(Ubicacion+"BOMBRE DE LA UBICACION");
		
		
		List<Empresa> listaEmpresaCerca=new ArrayList<>();

		EmpresaGson empresaGson =null;

		List<Empresa> lista=null;

		lista=empresaService.listaEmpresaIdCategoria(idCategoria);
		
		System.out.println(lista.size()+"tamano");


		listaEmpresaCerca=HaversineDistanceDelivery.calculateDistanceComplementario(lista,Ubicacion);


		empresaGson=new EmpresaGson();

		empresaGson.setListaEmpresa(listaEmpresaCerca);


		return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.OK);

	}
	


	//ESTA ES LA RELACION DE EMPRESA QUE SON MAS PROXIMAS NO DISTINGUE CATEGORIAS 1000 METROS DE RADIO

	@RequestMapping(value=FIND_EMPRESA_BY_UBICACION_CERCA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaEmpresaCerca(@PathVariable("Ubicacion")String Ubicacion){

		System.out.println(Ubicacion+"BOMBRE DE LA UBICACION");
		
		double distancia=2000;
		
		List<Empresa> listaEmpresaCerca=new ArrayList<>();

		EmpresaGson empresaGson =null;

		List<Empresa> lista=null;

		lista=empresaService.listaAllEmpresa();
		
		System.out.println(lista.size()+"tamano");


		listaEmpresaCerca=HaversineDistanceDelivery.calculateDistance(lista,Ubicacion,distancia);


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



	@RequestMapping(value=FIND_EMPRESA_BY_IDSUBCATEGORIA_UBICACION,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaEmpresaFindByIdSubCategoriaAndUbicacion(@PathVariable("idSubCategoria") int idSubCategoria,@PathVariable("Ubicacion")String Ubicacion){

		double distancia=3000;
		
		EmpresaGson empresaGson =null;
		
		List<Empresa> lista=null;
		
		List<Empresa> listaEmpresaCerca=new ArrayList<>();

		lista=empresaService.listaEmpresaFindByIdSubCategoria(idSubCategoria);

		listaEmpresaCerca=HaversineDistanceDelivery.calculateDistance(lista,Ubicacion,distancia);

		empresaGson=new EmpresaGson();

		empresaGson.setListaEmpresa(listaEmpresaCerca);



		return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.OK);

	}
	

	@RequestMapping(value=FIND_EMPRESA_BY_IDSUBCATEGORIA_UBICACION_COMPLEMENTARIA,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaGson> listaEmpresaFindByIdSubCategoriaAndUbicacionComplementario(@PathVariable("idSubCategoria") int idSubCategoria,@PathVariable("Ubicacion")String Ubicacion){

		
		EmpresaGson empresaGson =null;
		
		List<Empresa> lista=null;
		
		List<Empresa> listaEmpresaCerca=new ArrayList<>();

		lista=empresaService.listaEmpresaFindByIdSubCategoria(idSubCategoria);

		listaEmpresaCerca=HaversineDistanceDelivery.calculateDistanceComplementario(lista,Ubicacion);

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
