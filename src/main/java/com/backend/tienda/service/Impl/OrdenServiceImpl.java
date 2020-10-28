package com.backend.tienda.service.Impl;

import java.util.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.Orden;
import com.backend.tienda.repository.OrdenRepository;
import com.backend.tienda.service.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService{

	@Autowired
	OrdenRepository ordenRepository;
	
	@Override
	public List<Orden> ordenDisponible(int idusuario) {

          
  		Timestamp time=new Timestamp(System.currentTimeMillis());
  		Timestamp timeStampDate = null;
         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
          // you can change format of date
         Date date;
		try {
			date = formatter.parse(time.toString());
	         timeStampDate = new Timestamp(date.getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		return ordenRepository.findByIdusuarioAndVentafechaGreaterThanEqual(idusuario,timeStampDate);
	}

}
