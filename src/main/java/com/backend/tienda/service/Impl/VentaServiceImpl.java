package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.dao.VentaDAO;
import com.backend.tienda.entity.Venta;
import com.backend.tienda.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	VentaDAO ventaDAO;
	
	@Override
	public int añadirVenta(Venta venta) {
		return ventaDAO.añadirVenta(venta);
		
	}

	@Override
	public List<Venta> listaVentas() {
		return ventaDAO.listaVentas();
	}

}
