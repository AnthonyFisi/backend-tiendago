package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Categoria_producto_empresa;
import com.backend.tienda.gson.CategoriaEmpresaGson;
import com.backend.tienda.gson.Categoria_producto_empresaGson;
import com.backend.tienda.service.Categoria_producto_empresaService;

@RestController
@RequestMapping(Categoria_producto_empresaController.CATEGORIA_PRODUCTO_EMPRESA_CONTROLLER)
public class Categoria_producto_empresaController {
	
	
	public static final String  CATEGORIA_PRODUCTO_EMPRESA_CONTROLLER="/categoriaProductoEmpresa";
	
	public static final String  LISTA_CATEGORIA="/ListaCategoria/{idempresa}";
	
	
	@Autowired
	Categoria_producto_empresaService categoria_producto_empresaService;
	
	@GetMapping(LISTA_CATEGORIA)
	public ResponseEntity<?> listaCategoriaProductoEmpresa(@PathVariable("idempresa") int idempresa){
		
		Categoria_producto_empresaGson gson=new Categoria_producto_empresaGson(); 
		
		List<Categoria_producto_empresa> lista=categoria_producto_empresaService.listaCategoria(idempresa);
		gson.setListaCategoriaEmpresa(lista);
		
		return new  ResponseEntity<>(gson,HttpStatus.OK);
		
	}

}
