package com.backend.tienda.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Ubicacion;
import com.backend.tienda.repository.UbicacionRepository;
import com.backend.tienda.service.UbicacionService;

@Service
public class UbicacionServiceImpl implements UbicacionService{

	
	@Autowired
	UbicacionRepository ubicacionRepository;
	
	@Override
	public List<Ubicacion> findByidusuario(int idusuario) {
		
		return ubicacionRepository.findByIdusuarioAndEliminado(idusuario,false);
	}

	@Override
	public Ubicacion findByidubicacion(int idubicacion) {
		
		return ubicacionRepository.findByidubicacion(idubicacion);
	}

	@Override
	public Ubicacion saveUbicacion(Ubicacion ubicacion,int idOldUbicacion) {
		
		Ubicacion respuesta=null;
		Ubicacion firstAnswer=null;
		
		try {
			
			firstAnswer=ubicacionRepository.findById(idOldUbicacion).get();
			firstAnswer.setUbicacion_estado(false);
			ubicacionRepository.save(firstAnswer);
			
			respuesta=ubicacionRepository.save(ubicacion);
			
		}catch(Exception e) {
			return respuesta;
		}
		
		return respuesta;
	}

	@Override
	public Ubicacion findByidusuario1(int idusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEstadoUbicacion(int idUbicacion,boolean estado) {
		
		boolean respuesta=false;
		Ubicacion ubicacion=null;

		
		try {
			
			ubicacion=ubicacionRepository.findById(idUbicacion).get();
			ubicacion.setUbicacion_estado(estado);
			ubicacionRepository.save(ubicacion);
			respuesta=true;
			
		}catch(Exception e) {
			return respuesta;
		}
		
				
		return respuesta;
	}

	@Override
	public boolean deleteUbicacion(int idubicacion) {
		
		boolean respuesta=false;
		Ubicacion ubicacion=null;
		
		try {
			ubicacion=ubicacionRepository.findById(idubicacion).get();
			ubicacion.setEliminado(true);
			ubicacionRepository.save(ubicacion);
			respuesta=true;
			
			
		}catch(Exception e) {
			return respuesta;
		}
		return respuesta;
	}

	@Override
	public List<Ubicacion> findByIdUsuario(int idusuario) {
		return ubicacionRepository.findByIdusuario(idusuario);
	}

	@Override
	public Ubicacion saveUbicacionFirstTime(Ubicacion ubicacion) {
		
		return ubicacionRepository.save(ubicacion);
	}

}
