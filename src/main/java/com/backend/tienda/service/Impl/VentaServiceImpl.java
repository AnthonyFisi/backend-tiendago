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
	public Venta updateVentaEstado(int idVenta,int idEstado_empresa,String tiempo_espera,String tiempototal_espera) {
		
	Venta venta=null;
	
		try 
		{
			venta=ventaRepository.findById(idVenta).get();
			venta.setIdestado_empresa(idEstado_empresa);
			venta.setTiempo_espera(tiempo_espera);
			venta.setTiempototal_espera(tiempototal_espera);
			venta=ventaRepository.save(venta);
		
		}catch(Exception e)
		{
			return venta;
		}
		
		return venta;
	}

	@Override
	public Venta updateVentaEstado(int idVenta, int idEstado_empresa) {
		Venta venta=null;
		
		try 
		{
			venta=ventaRepository.findById(idVenta).get();
			venta.setIdestado_empresa(idEstado_empresa);
			venta=ventaRepository.save(venta);
		
		}catch(Exception e)
		{
			return venta;
		}
		
		return venta;
		}

	@Override
	public Venta updateVentaTiempoEspera(int idVenta, int tiempo) {
		Venta venta=null;
		int time=0;
		long tiempototal=0;
		
		try {
			venta=ventaRepository.findById(idVenta).get();
			
			time=Integer.valueOf(venta.getTiempo_espera())+ tiempo;
			tiempototal=tiempo*60000;
			tiempototal=tiempototal+new Long(venta.getTiempototal_espera());
			venta.setTiempo_espera(String.valueOf(time));
			venta.setTiempototal_espera(String.valueOf(tiempototal));
			venta=ventaRepository.save(venta);
		}catch(Exception e) {
			return venta;

		}
		
		return venta;

	}

	@Override
	public Venta updateVentaPrecioTotal(int idVenta, float costoTotal) {
	Venta venta=null;
	float costo=0;
		
		try {
			venta=ventaRepository.findById(idVenta).get();
			costo=venta.getVenta_costototal()+costoTotal;
			venta.setVenta_costototal(costo);
			venta=ventaRepository.save(venta);
		}catch(Exception e) {
			return venta;

		}
		
		return venta;
	}

	@Override
	public Venta updateVentaCancelarPedido(int idVenta,String comentario_cancelar) {
Venta venta=null;
		
		try {
			venta=ventaRepository.findById(idVenta).get();
			venta.setCancelar(true);
			venta.setComentario_cancelar(comentario_cancelar);
			venta=ventaRepository.save(venta);
		}catch(Exception e) {
			return venta;

		}
		
		return venta;
	}

	@Override
	public Venta getVenta(int idVenta) {
			Venta venta=null;
		
		try {
			venta=ventaRepository.findById(idVenta).get();
		}catch(Exception e) {
			return venta;

		}
		
		return venta;
		
	}

	@Override
	public Venta updateDeliveryEstado(int idVenta, int idEstado_delivery,int idRepartidor) {
			Venta venta=null;
		
		try {
			venta=ventaRepository.findById(idVenta).get();
			venta.setIdestado_delivery(idEstado_delivery);
			venta.setIdrepartidor(idRepartidor);
			venta=ventaRepository.save(venta);
		}catch(Exception e) {
			return venta;

		}
		
		return venta;
	}

	@Override
	public Venta updateDisponibilidad(int idVenta) {
Venta venta=null;
		
		try {
			venta=ventaRepository.findById(idVenta).get();
			venta.setOrden_disponible(false);
			venta=ventaRepository.save(venta);
		}catch(Exception e) {
			return venta;

		}
		
		return venta;
	}

	@Override
	public Venta updateVentaEstadoGeneral(int idventa,int idestado_general) {
Venta venta=null;
		
		try {
			venta=ventaRepository.findById(idventa).get();
			venta.setIdestado_general(idestado_general);
			venta=ventaRepository.save(venta);
		}catch(Exception e) {
			return venta;

		}
		
		return venta;
	}

	

}
