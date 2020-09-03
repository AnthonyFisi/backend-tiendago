package com.backend.tienda.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Empresa_bi2;
import com.backend.tienda.repository.Empresa_bi2Repository;
import com.backend.tienda.service.Empresa_bi2Service;

@Service
public class Empresa_bi2ServiceImpl implements Empresa_bi2Service{
	
	@Autowired
	Empresa_bi2Repository empresa_bi2Repository;

	@Override
	public Empresa_bi2 findByIdUsuario(int idusuario) {
		return empresa_bi2Repository.findById(idusuario).get();
	}

	
	

}
