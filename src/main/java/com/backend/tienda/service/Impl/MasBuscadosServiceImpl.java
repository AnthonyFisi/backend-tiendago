package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.MasBuscadosDAO;
import com.backend.tienda.entity.MasBuscados;
import com.backend.tienda.service.MasBuscadosService;

@Service
public class MasBuscadosServiceImpl implements MasBuscadosService {

	@Autowired
	MasBuscadosDAO masBuscadosDAO;
	
	@Override
	public List<MasBuscados> listaMasBuscadosCategoria(int idCategoria) {
		
		return masBuscadosDAO.listaMasBuscadosCategoria(idCategoria);
	}

}
