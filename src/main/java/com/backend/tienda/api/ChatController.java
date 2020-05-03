package com.backend.tienda.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import com.backend.tienda.entity.Usuario;
import com.backend.tienda.service.UsuarioService;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Controller
public class ChatController {
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	UsuarioService service;

	
	String nombre = null;
	
/*

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {

		@SuppressWarnings("unused")
		Usuario usuario= service.mostrarByUsuario(2);

		  TimerTask timerTask = new TimerTask() {
	            @Override
	            public void run() {
	                try {
	            		Usuario usuario= service.mostrarByUsuario(2);
	                    //System.out.println("REGISTER FAKE "+usuario1.getUsuario_apellido());

	                	//session.getBasicRemote().sendText("Push");
	                	chatMessage.setSender(usuario.getUsuario_apellido());

	            
	                    System.out.println("REGISTER"+usuario.getUsuario_apellido());
	               
	                } catch (Exception ex) {
	                    //Logger.getLogger(PushSocket.class.getName()).log(Level.SEVERE, null, ex);
	                	System.out.println("GG MANO");
	                }
	            }
	        };
	        Timer timer = new Timer(true);
	        timer.scheduleAtFixedRate(timerTask, 0, 3 * 1000);
    		headerAccessor.getSessionAttributes().put("username", "holaaaaaaaaaaaaaaaaaa");

		
		return chatMessage;
	}*/
	/*
    @Scheduled(fixedRate = 2000)
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    	ChatMessage chatMessage=new ChatMessage();
		Usuario usuario= service.mostrarByUsuario(2);

    	chatMessage.setContent(usuario.getUsuario_apellido());
        System.out.println(usuario.getUsuario_apellido());

		  TimerTask timerTask = new TimerTask() {
	            @Override
	            public void run() {
	                try {
	            		Usuario usuario= service.mostrarByUsuario(2);

	                	//session.getBasicRemote().sendText("Push");
	                	chatMessage.setContent(usuario.getUsuario_apellido());
	                    System.out.println(usuario.getUsuario_apellido());
	               
	                } catch (Exception ex) {
	                    //Logger.getLogger(PushSocket.class.getName()).log(Level.SEVERE, null, ex);
	                	System.out.println("GG MANO");
	                }
	            }
	        };
	        Timer timer = new Timer(true);
	        timer.scheduleAtFixedRate(timerTask, 0, 3 * 1000);
    	
	        //System.out.println("paso *****************************************");
	        
	        return chatMessage;

        
	}
    */
    
 	
	
/*
    @Autowired
    private SimpMessagingTemplate template;

    //@Scheduled(fixedRate = 2000)
	@MessageMapping("/chat.register/")
    public void greeting(@Payload ChatMessage chatMessage) {
      //  Thread.sleep(1000); // simulated delay
		Usuario usuario= service.mostrarByUsuario(2);

        System.out.println("scheduled");
        //ChatMessage chatMessage= new ChatMessage();
        chatMessage.setContent(usuario.getUsuario_apellido());
        
        this.template.convertAndSend("/topic/public",chatMessage);
    }

	
	
	
	@Scheduled(fixedRate=2000)
	public void scheduleTaskWithFixedRate() {
		
		Usuario usuario= service.mostrarByUsuario(2);
		System.out.println(usuario.getUsuario_apellido());
		
	    //logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
	}*/

}
