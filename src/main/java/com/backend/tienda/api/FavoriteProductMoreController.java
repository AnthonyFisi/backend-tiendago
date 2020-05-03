package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.backend.tienda.entity.FavoriteProductMore;
import com.backend.tienda.service.FavoriteProductMoreService;

@RestController
@RequestMapping("/favoriteProductMore")
public class FavoriteProductMoreController {
	
	@Autowired
	FavoriteProductMoreService favoriteProductMoreService;
	
	@RequestMapping(value = "/mostrarFavoriteProduct/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FavoriteProductMore>> mostrarFavorite(@PathVariable("idUsuario") int idUsuario){
	
		
		List<FavoriteProductMore> listaFavoriteProduct=null;
		try {
			listaFavoriteProduct=favoriteProductMoreService.listaFavoriteProduct(idUsuario);
			
			return new ResponseEntity<List<FavoriteProductMore>>(listaFavoriteProduct, HttpStatus.OK);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		
			return new ResponseEntity<List<FavoriteProductMore>>(listaFavoriteProduct, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
