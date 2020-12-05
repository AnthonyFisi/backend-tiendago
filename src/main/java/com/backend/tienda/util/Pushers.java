package com.backend.tienda.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pusher.rest.Pusher;

@Component
public class Pushers {
	
	@Value("${backend.tienda.app.pusherappid}")
	private String appId;
	
	@Value("${backend.tienda.app.pusherkey}")
	private String key;
	
	@Value("${backend.tienda.app.pushersecret}")
	private String secret;
	
	
	public Pusher instance() {
		Pusher pusherobject = new Pusher(appId, key, secret);
		pusherobject.setCluster("us2");
		return pusherobject;
	}
		

}
