package com.backend.tienda.service;

import java.util.List;

import com.backend.tienda.entity.Envio_empresa;

public interface Envio_empresaService {
	
	List<Envio_empresa> findByIdempresa(int idempresa);
	
	List<Envio_empresa> listaAll();
	
	List<Envio_empresa> listafindByIdtipoenvio(int id);


}
