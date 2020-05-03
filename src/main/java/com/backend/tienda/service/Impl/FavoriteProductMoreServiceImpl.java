package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.FavoriteProductMoreDAO;
import com.backend.tienda.entity.FavoriteProductMore;
import com.backend.tienda.service.FavoriteProductMoreService;

@Service
public class FavoriteProductMoreServiceImpl implements FavoriteProductMoreService {
	
	@Autowired
	FavoriteProductMoreDAO favoriteProductMoreDAO;

	@Override
	public List<FavoriteProductMore> listaFavoriteProduct(int idUsuario) {
		return favoriteProductMoreDAO.listaFavoriteProduct(idUsuario);
	}

}
