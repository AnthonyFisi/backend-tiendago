package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.EmpresaOficial;
import com.backend.tienda.entity.Orden_estado_delivery;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.Ubicacion;
import com.backend.tienda.gson.HistorialDetailGson;
import com.backend.tienda.service.EmpresaOficialService;
import com.backend.tienda.service.Orden_estado_deliveryService;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;
import com.backend.tienda.service.UbicacionService;

@RestController
@RequestMapping(HistorialDetailController.HISTORIAL_DETAIL_CONTROLLER)
public class HistorialDetailController {


	public final static String HISTORIAL_DETAIL_CONTROLLER="/HistorialDetailController";
	
	public final static String PEDIDO="/lista/{idempresa}/{idpedido}/{idventa}/{idubicacion}";
	
	@Autowired
	ProductoJOINregistroPedidoJOINpedidoService productoJOINregistroPedidoJOINpedidoService;
	
	@Autowired
	Orden_estado_deliveryService orden_estado_deliveryService;
	
	@Autowired
	UbicacionService ubicacionService;
	
	@Autowired
	EmpresaOficialService empresaOficialService;
	
	@GetMapping(PEDIDO)
	@PreAuthorize("hasRole('ROLE_MOTORIZADO')")
	public ResponseEntity<?> detailOrdenHistorial(@PathVariable("idempresa")int idempresa,
			@PathVariable("idpedido")int idpedido,
			@PathVariable("idventa")int idventa,
			@PathVariable("idubicacion")int idubicacion){
	
		 List<ProductoJOINregistroPedidoJOINpedido> listaProducto=null;
		
		 List<Orden_estado_delivery> listaEstados=null;
		 
		 EmpresaOficial empresaOficial=null;
		 
		 HistorialDetailGson gson=null;
		 
		 Ubicacion ubicacion=null;
				 
		 listaProducto=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(idpedido);
		 
		 listaEstados=orden_estado_deliveryService.listaEstadosByIdVenta(idventa);
		
		 empresaOficial=empresaOficialService.findByIdempresa(idempresa);
		 
		 ubicacion=ubicacionService.findByidubicacion(idubicacion);
		
		 gson=new HistorialDetailGson();
		
		 gson.setListaEstados(listaEstados);
		 
		 gson.setListaProducto(listaProducto);
		 
		 gson.setUbicacionEmpresa(empresaOficial.getDireccion_empresa());
		 
		 gson.setUbicacionUsuario(ubicacion.getUbicacion_nombre());
		 
		return ResponseEntity.ok(gson);
	}
	
	
}
