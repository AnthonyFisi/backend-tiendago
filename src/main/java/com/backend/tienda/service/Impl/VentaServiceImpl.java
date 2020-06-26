package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Venta;
import com.backend.tienda.repository.VentaRepository;
import com.backend.tienda.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{
	
	@Autowired
	VentaRepository ventaRepository;

	@Override
	public Venta registrarVenta(Venta venta) {
		Venta respuesta=null;
		try {
			respuesta=ventaRepository.save(venta);
			
		}catch(Exception e) {
			return respuesta;
		}
		return respuesta;
	}

	@Override
	public List<Venta> listaVentaTotal() {
		return ventaRepository.findAll();
	}

	@Override
	public Venta updateVentaEstado(int idVenta,int idEstado_Venta,String tiempo_espera) {
		
	Venta venta=null;
	
		try 
		{
			venta=ventaRepository.findById(idVenta).get();
			venta.setIdestado_venta(idEstado_Venta);
			venta.setTiempo_espera(tiempo_espera);
			venta=ventaRepository.save(venta);
		
		}catch(Exception e)
		{
			return venta;
		}
		
		return venta;
	}

}
