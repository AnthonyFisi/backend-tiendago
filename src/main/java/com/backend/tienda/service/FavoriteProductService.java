package com.backend.tienda.service;

import com.backend.tienda.entity.FavoriteProduct;

public interface FavoriteProductService {
	
	int registrarFavoriteProduct(FavoriteProduct favoriteProduct);
	FavoriteProduct findFavoriteProduct(int idUsuario , int idProducto);
	int updateStateFavoriteProduct(int idFavoriteProduct,boolean activo);



}
