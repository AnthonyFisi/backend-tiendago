package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.FavoriteProduct;
import com.backend.tienda.service.FavoriteProductService;

@RestController
@RequestMapping("/favoriteProduct")
public class FavoriteProductController {
	
	@Autowired
	FavoriteProductService favoriteProductService;
	
	
	
	@RequestMapping(value = "/registrarFavorite", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> favoriteProductRegister(@RequestBody FavoriteProduct favoriteProduct){
		int respuesta=0;
		try {
			respuesta= favoriteProductService.registrarFavoriteProduct(favoriteProduct);
			return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);

		}catch(Exception e) {
			
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/updateFavoriteProduct/{idFavoriteProduct}/{activo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> UpdatefavoriteProduct(@PathVariable int idFavoriteProduct,@PathVariable boolean activo){
	
		int respuesta=0;
		try {
			respuesta= favoriteProductService.updateStateFavoriteProduct(idFavoriteProduct,activo);
			return new ResponseEntity<Integer>(respuesta, HttpStatus.OK);

		}catch(Exception e) {
			
			return new ResponseEntity<Integer>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@RequestMapping(value = "/findFavoriteByIds/{idUsuario}/{idProducto}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FavoriteProduct> findFavoriteProduct(@PathVariable("idUsuario") int idUsuario,
			@PathVariable("idProducto") int idProducto){
	
		FavoriteProduct favoriteProduct=null;
		try {
			favoriteProduct=favoriteProductService.findFavoriteProduct(idUsuario, idProducto);
			return new ResponseEntity<FavoriteProduct>(favoriteProduct, HttpStatus.OK);

		}catch(Exception e) {
			
			return new ResponseEntity<FavoriteProduct>(favoriteProduct, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	
	
	
}
