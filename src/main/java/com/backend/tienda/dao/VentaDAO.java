package com.backend.tienda.dao;

import java.util.List;

import com.backend.tienda.entity.Venta;

public interface VentaDAO {
	
	int añadirVenta(Venta venta);
	List<Venta> listaVentas();


}
