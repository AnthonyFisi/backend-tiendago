package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.PublicidadDAO;
import com.backend.tienda.entity.Publicidad;
import com.backend.tienda.service.PublicidadService;

@Service
public class PublicidadServiceImpl implements PublicidadService{
	
	@Autowired
	PublicidadDAO publicidadDAO;

	@Override
	public List<Publicidad> listaPublicidad() {
		return publicidadDAO.listaPublicidad();
	}

}
