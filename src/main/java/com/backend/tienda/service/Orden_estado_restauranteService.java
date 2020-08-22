package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Orden_estado_empresa;
import com.backend.tienda.entity.Orden_estado_empresaPK;

public interface Orden_estado_restauranteService {
	
	Orden_estado_empresa registrarEstado(Orden_estado_empresa ordenEstado);
	
	List<Orden_estado_empresa> listaEstadosOrden(int idVenta);
	
	Orden_estado_empresa OrdenDate(int idVenta,int idEstado_Venta);
	
	List<Orden_estado_empresa> listaEstados(List<Orden_estado_empresaPK> pk);
	
}
