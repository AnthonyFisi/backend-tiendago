package com.backend.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Usuario_general;
import com.backend.tienda.firebase.Delivery;
import com.backend.tienda.firebase.DeliveryService;
import com.backend.tienda.repositorys.UserRepository;
import com.pusher.rest.Pusher;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DeliveryService deliveryService;
	
	Pusher pusher = new Pusher("960667", "18c8170377c406cfcf3a", "55be7e2ee64af1927a79");

	
	@GetMapping("/all/{idusuario}")
	public String allAccess(@PathVariable("idusuario") int idusuario) {
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
        System.out.println("Inicio "+idusuario+" :"+dateFormat.format(date));
        
        String cantidad="60000";
        
        long tiempoEspera=new Long(cantidad);
		
		long tiempo=(long) (tiempoEspera*0.8);

		
		  Timer timer;
		    timer = new Timer();
		    TimerTask task = new TimerTask() {

		        @Override
		        public void run()
		        {
		        	DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    		Date date2 = new Date();
		        	List<Delivery> lista=null;

					try {
						lista = deliveryService.listaDeliveryAble(true);
			            System.out.println(lista.size()+"/"+idusuario);
			           
			            System.out.println("Fin "+idusuario+" :"+dateFormat2.format(date2));
			            
			            pusher.setCluster("us2");

			            String li=lista.size()+"/"+idusuario;
						
						pusher.trigger("canal-orden-delivery", "my-event",li );


					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		        	
		           
		           
		        }
		        };

		    timer.schedule(task,tiempo);
		
		
		/*
		int id=9;
		Usuario_general general=userRepository.findById(id).get();
		System.out.println(general.getContrasena()+ "/ "+general.getCorreo() );*/
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_EMPRESA_ASOCIADA')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('ROLE_MOTORIZADO')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}