package com.backend.tienda.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Empresa;
import com.backend.tienda.entity.Empresa_favorito_usuario;
import com.backend.tienda.gson.EmpresaGson;
import com.backend.tienda.gson.Empresa_favoritaGson;
import com.backend.tienda.service.EmpresaService;
import com.backend.tienda.service.Empresa_favorito_usuarioService;

@RestController
@RequestMapping(Empresa_favorito_usuarioController.EMPRESA_FAVORITO_USUARIO_CONTROLLER)
public class Empresa_favorito_usuarioController {


	public final static String EMPRESA_FAVORITO_USUARIO_CONTROLLER="/EmpresaFavoritoUsuarioController";

	public final static String REGISTRAR="/registrar";
	
	public final static String ELIMINAR="/eliminar/{idempresa}/{idusuario}";


	public final static String LISTA_FAVORITOS="/lista/{idusuario}";

	
	@Autowired
	Empresa_favorito_usuarioService empresa_favorito_usuarioService;
	
	@Autowired
	EmpresaService empresaService;

	@PostMapping(REGISTRAR)
	public ResponseEntity<?> registrarFavorito(@RequestBody Empresa_favorito_usuario favorito){

		Empresa_favorito_usuario empresa_favorito=null;

		empresa_favorito=empresa_favorito_usuarioService.guardarFavorito(favorito);

		if(empresa_favorito!=null) {
			return ResponseEntity.ok(empresa_favorito);
		}

		return ResponseEntity.notFound().build();

	}

	
	@PostMapping(ELIMINAR)
	public ResponseEntity<?> eliminarFavorito(@PathVariable("idempresa")int idempresa,@PathVariable("idusuario") int idusuario){

		Empresa_favorito_usuario empresa_favorito=null;

		empresa_favorito=empresa_favorito_usuarioService.eliminarFavorito(idempresa, idusuario);

		if(empresa_favorito!=null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(new Empresa_favorito_usuario());


	}
	
	

	@GetMapping(LISTA_FAVORITOS)
	public ResponseEntity<?> listaFavorito(@PathVariable("idusuario") int idusuario){
		
		List<Empresa> listaEmpresaFavorita=null;

		List<Empresa_favorito_usuario> lista_empresa=null;
		
		
		List<Integer> listaIds=new ArrayList<>();

		EmpresaGson empresaGson=null;

		
		lista_empresa=empresa_favorito_usuarioService.listaEmpresas(idusuario);

		for(Empresa_favorito_usuario favorito:lista_empresa) {
			System.out.println(favorito.getIdempresa());
			listaIds.add(favorito.getIdempresa());
		}
		
		listaEmpresaFavorita=empresaService.listaEmpresaFavorito(listaIds);
		
		if(listaEmpresaFavorita.size()>0) {
			empresaGson=new EmpresaGson();
			empresaGson.setListaEmpresa(listaEmpresaFavorita);
		
			return ResponseEntity.ok(listaEmpresaFavorita);
		}
		
	
		return ResponseEntity.notFound().build();


	}
	
	
	

}
