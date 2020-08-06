package com.backend.tienda.util;

import java.util.List;

public class CalculatePriceRestaurante {
	
	
	public static float calculatePrice(float ventaTotal,List<Integer> listaPorcentajes) {
		
		return ventaTotal*listaPorcentajes.get(2);
		
	}

}
