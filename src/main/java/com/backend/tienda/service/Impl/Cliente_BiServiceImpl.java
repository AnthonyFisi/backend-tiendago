package com.backend.tienda.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Cliente_Bi;
import com.backend.tienda.repository.Cliente_BiRepository;
import com.backend.tienda.service.Cliente_BiService;

@Service
public class Cliente_BiServiceImpl implements Cliente_BiService{
	
	@Autowired
	Cliente_BiRepository cliente_BiRepository;

	@Override
	public Cliente_Bi findCliente(int idusuario) {
		return cliente_BiRepository.findById(idusuario).get();
	}

}
