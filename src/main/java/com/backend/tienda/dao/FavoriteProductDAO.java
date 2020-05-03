package com.backend.tienda.dao;

import com.backend.tienda.entity.FavoriteProduct;

public interface FavoriteProductDAO {
	
	int registrarFavoriteProduct(FavoriteProduct favoriteProduct);
	FavoriteProduct findFavoriteProduct(int idUsuario , int idProducto);
	int updateStateFavoriteProduct(int idFavoriteProduct,boolean activo);
	
}
