package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.MesaDAO;
import com.backend.tienda.entity.Mesa;
import com.backend.tienda.service.MesaService;

@Service

public class MesaServiceImpl implements MesaService {

	@Autowired
	MesaDAO mesaDAO;
	
	@Override
	public void añadirMesa(Mesa mesa) {
		mesaDAO.añadirMesa(mesa);
		
	}

	@Override
	public boolean eliminarMesa(int idMesa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizaMesa(int idMesa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Mesa> listaMesa() {
		return mesaDAO.listaMesa();
	}

}
