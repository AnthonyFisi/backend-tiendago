package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Empresa_favorito_usuario;
import com.backend.tienda.service.Empresa_favorito_usuarioService;

@RestController
@RequestMapping(Empresa_favorito_usuarioController.EMPRESA_FAVORITO_USUARIO_CONTROLLER)
public class Empresa_favorito_usuarioController {


	public final static String EMPRESA_FAVORITO_USUARIO_CONTROLLER="/EmpresaFavoritoUsuarioController";

	public final static String REGISTRAR="/registrar";
	
	public final static String ELIMINAR="/eliminar/{idempresa}/{idusuario}";


	@Autowired
	Empresa_favorito_usuarioService empresa_favorito_usuarioService;

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

}
