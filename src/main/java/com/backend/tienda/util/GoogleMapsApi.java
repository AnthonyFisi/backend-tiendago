package com.backend.tienda.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.type.LatLng;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GoogleMapsApi extends HttpConnection {
    
	private static final String BASE_URI_STRING = "https://maps.googleapis.com/maps/api/directions/json";
    
    private static final String GET_REQUEST = "GET";
    
    @Value("${backend.tienda.app.google-maps-key}")
    private  String API_KEY_GOOGLE_MAPS;

    public String getLocation (List<Double> point1, List<Double> point2) throws Exception {
        // Get JSON builder
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        // Set initial parameters
        Map<String, String> parameters = new HashMap<>();

        // Get location
        parameters.put("origin", point1.get(0).toString() + "," + point1.get(1).toString());
        parameters.put("destination", point2.get(0).toString() + "," + point2.get(1).toString());
       // parameters.put("sensor","false");
       // parameters.put("mode","driving");
        parameters.put("key", API_KEY_GOOGLE_MAPS);
        String json = getRequest(GET_REQUEST, BASE_URI_STRING, parameters);

        return json;
        // LocationResource resource = gson.fromJson(json, LocationResource.class);
        // return mapResourceToDomain(resource);
    }
    
  
    
}