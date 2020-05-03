package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.FavoriteProductDAO;
import com.backend.tienda.entity.FavoriteProduct;
import com.backend.tienda.service.FavoriteProductService;

@Service
public class FavoriteProductServiceImpl  implements FavoriteProductService{
	
	@Autowired
	FavoriteProductDAO favoriteProductDAO;
	
	@Override
	public int registrarFavoriteProduct(FavoriteProduct favoriteProduct) {
		return favoriteProductDAO.registrarFavoriteProduct(favoriteProduct);
	}

	@Override
	public FavoriteProduct findFavoriteProduct(int idUsuario, int idProducto) {
		return favoriteProductDAO.findFavoriteProduct(idUsuario, idProducto);
	}

	@Override
	public int updateStateFavoriteProduct(int idFavoriteProduct,boolean activo) {
		return favoriteProductDAO.updateStateFavoriteProduct(idFavoriteProduct,activo);
	}
	

}
