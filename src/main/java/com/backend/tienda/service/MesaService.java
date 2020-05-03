package com.backend.tienda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Mesa;

public interface MesaService {
	
	void añadirMesa (Mesa mesa);
	boolean eliminarMesa(int idMesa);
	boolean actualizaMesa(int idMesa);
	List<Mesa> listaMesa();

}
