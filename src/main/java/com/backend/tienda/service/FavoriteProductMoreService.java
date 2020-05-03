package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.FavoriteProductMore;


public interface FavoriteProductMoreService {
	
	List<FavoriteProductMore> listaFavoriteProduct(int idUsuario);


}
