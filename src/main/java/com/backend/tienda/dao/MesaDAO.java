package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Mesa;

public interface MesaDAO {
	
	void añadirMesa (Mesa mesa);
	boolean eliminarMesa(int idMesa);
	boolean actualizaMesa(int idMesa);
	List<Mesa> listaMesa();
}
