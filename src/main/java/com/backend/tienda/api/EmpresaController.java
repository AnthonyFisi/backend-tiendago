package com.backend.tienda.api;

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

@RestController
@RequestMapping(EmpresaController.EMPRESA_CONTROLLER)
public class EmpresaController {
	/*nuevoo*/
	
	public final static String EMPRESA_CONTROLLER="/EmpresaController";
	
	
	public final static String FIND_EMPRESA_IDSUBCATEGORIA="/ListafindBy/{idSubCategoria}";
	
	public final static String FIND_EMPRESA_BY_IDCATEGORIA_UBICACION="/ListafindByLocation/{idCategoria}/{Ubicacion}";
	
	public final static String FIND_EMPRESA_BY_IDCATEGORIA_SORT="/ListaSortfindBy/{idCategoria}";
	
	public final static String FIND_EMPRESA_BY_IDSUBCATEGORIA_UBICACION="/ListafindByLocationSubCategoria/{idSubCategoria}/{Ubicacion}";
	
	public final static String FIND_LISTA="/lista";
	
	public final static String FIND_LISTA_ENTERPRISE="/listaEnterprise/{idCategoria}";
	
	public final static String REGISTRAR_EMPRESA="/registrar";

	
	public final static String FIND_BY_EMPRESA="/findByEmpresa/{idEmpresa}";
	
	public final static String UPDATE_DISPONIBILIDAD_EMPRESA="/updateDisponibilidad/{idEmpresa}/{disponibilidad}";

	
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
	public ResponseEntity<EmpresaGson> listaEmpresaFindByIdCategoriaAndUbicacion(@PathVariable("idCategoria") int idCategoria,@PathVariable("Ubicacion")String Ubicacion){
		
		EmpresaGson empresaGson =null;
		List<Empresa> lista=null;
		
		
		try {
			lista=empresaService.listaEmpresaFindByIdCategoriaAndUbicacion(idCategoria, Ubicacion);
			empresaGson=new EmpresaGson();
			empresaGson.setListaEmpresa(lista);
		}catch(Exception e) 
		{
			return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
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
		
		
		try {
			lista=empresaService.listaEmpresaFindByIdSubCategoriaAndUbicacion(idSubCategoria, Ubicacion);
			empresaGson=new EmpresaGson();
			empresaGson.setListaEmpresa(lista);
		}catch(Exception e) 
		{
			return new ResponseEntity<EmpresaGson>(empresaGson,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
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
	
	

}
