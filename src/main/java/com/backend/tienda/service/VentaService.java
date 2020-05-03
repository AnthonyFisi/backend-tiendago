package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Venta;

public interface VentaService {

	int añadirVenta(Venta venta);
	List<Venta> listaVentas();
}
