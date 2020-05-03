package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.FavoriteProductMore;

public interface FavoriteProductMoreDAO {
	
	List<FavoriteProductMore> listaFavoriteProduct(int idUsuario);

}
