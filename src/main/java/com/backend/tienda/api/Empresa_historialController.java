package com.backend.tienda.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Empresa_historial;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.entity.Repartidor_Bi;
import com.backend.tienda.gson.Empresa_historialGson;
import com.backend.tienda.models.Empresa_historialDetail;
import com.backend.tienda.service.Empresa_historialService;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;
import com.backend.tienda.service.Repartidor_BiService;

@RestController
@RequestMapping(Empresa_historialController.EMPRESA_HISTORIAL_CONTROLLER)
public class Empresa_historialController {
	
	public final static String EMPRESA_HISTORIAL_CONTROLLER="/EmpresaHistorialController";

	public static final String LISTA_BY_IDEMPRESA_HISTORIAL="/listaPedidosHistorial/{idEmpresa}";
	
	public static final String EMPRESA_HISTORIAL_DETAIL="/Detail/{idEmpresa}/{idPedido}/{idRepartidor}";

	
	@Autowired
	Empresa_historialService empresa_historialService;
	
	@Autowired
	ProductoJOINregistroPedidoJOINpedidoService productoJOINregistroPedidoJOINpedidoService;
	
	@Autowired
	Repartidor_BiService repartidor_biService;
	
	@GetMapping(LISTA_BY_IDEMPRESA_HISTORIAL)
	public ResponseEntity<Empresa_historialGson>  listaPedidosHistorial(@PathVariable("idEmpresa") int idEmpresa){


		Empresa_historialGson empresahistorialGson= null;

		List<Empresa_historial> listaEmpresaHistorial=null;

		listaEmpresaHistorial=empresa_historialService.findByEstado(4, idEmpresa);

		if(listaEmpresaHistorial.size()<=0) {

			return new ResponseEntity<Empresa_historialGson>( empresahistorialGson,HttpStatus.NOT_FOUND);

		}

		empresahistorialGson= new Empresa_historialGson();
		empresahistorialGson.setListaEmpresaHistorial(listaEmpresaHistorial);



		return new ResponseEntity<Empresa_historialGson>( empresahistorialGson,HttpStatus.OK);
	}

	
	@GetMapping(EMPRESA_HISTORIAL_DETAIL)
	public ResponseEntity<Empresa_historialDetail>  PedidoHistorialDetail(@PathVariable("idEmpresa") int idEmpresa,
			@PathVariable("idPedido") int idPedido,
			@PathVariable("idRepartidor") int idRepartidor){


		Empresa_historialDetail empresahistorialDetail= null;

		List<ProductoJOINregistroPedidoJOINpedido> listaProductos=null;

		Repartidor_Bi repartidor_bi=null;
		
		listaProductos=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(idPedido);
		
		if(listaProductos.size()<=0) {
			return  ResponseEntity.badRequest().build();
		}
		
		empresahistorialDetail =new Empresa_historialDetail();
		
		empresahistorialDetail.setListaProductos(listaProductos);	
		
		repartidor_bi=repartidor_biService.findByIdRepartidor(idRepartidor);
		
		if(repartidor_bi==null) {
			return  ResponseEntity.badRequest().build();
		}

		empresahistorialDetail.setRepartidor_bi(repartidor_bi);


		return  ResponseEntity.ok(empresahistorialDetail);
	}


}
