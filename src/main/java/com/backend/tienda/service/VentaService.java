package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Venta;

public interface VentaService {
	
	Venta registrarVenta(Venta venta);
	
	List<Venta> listaVentaTotal();

}
