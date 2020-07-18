package com.backend.tienda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.Producto;
import com.backend.tienda.entity.ProductoJOINregistroPedidoJOINpedido;
import com.backend.tienda.gson.ProductoJOINregistroPedidoJOINpedidoGson;
import com.backend.tienda.service.ProductoJOINregistroPedidoJOINpedidoService;

@RestController
@RequestMapping(ProductoJOINregistroPedidoJOINpedidoController.PRODUCTO_REGISTROPEDIDO_PEDIDO_CONTROLLER)
public class ProductoJOINregistroPedidoJOINpedidoController {
	
	public final static String PRODUCTO_REGISTROPEDIDO_PEDIDO_CONTROLLER="/ProductoJOINregistroPedidoJOINpedidoController";
	
	public final static String LISTA_BY_PEDIDO="/listaByEmpresa/{idusuario}/{idempresa}";

	public final static String LISTA_TOTAL="/listaTotal/{idusuario}";
	
	public final static String LISTA_TOTAL_BY_USUARIO="/listaTotalByUsuario/{idusuario}";

	public final static String LISTA_TOTAL_BY_USUARIO_2="/listaProductosAfterSell/{idPedido}";


	
	@Autowired
	ProductoJOINregistroPedidoJOINpedidoService productoJOINregistroPedidoJOINpedidoService;
	
	
	@RequestMapping(value=LISTA_BY_PEDIDO,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson> lista(@PathVariable("idusuario")int idusuario,@PathVariable("idempresa")int idempresa){
		
		ProductoJOINregistroPedidoJOINpedidoGson gson=null;
		List<ProductoJOINregistroPedidoJOINpedido> lista=null;
		
		try {
			
			lista=productoJOINregistroPedidoJOINpedidoService.listaTotalByEmpresa(idusuario, idempresa);
			gson= new ProductoJOINregistroPedidoJOINpedidoGson();
			gson.setListaProductoJOINregistroPedidoJOINpedido(lista);
		}catch(Exception e) {
			return new ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson>(gson,HttpStatus.INTERNAL_SERVER_ERROR);

			
		}
		
		return new ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson>(gson,HttpStatus.OK);
	
	}


	
	@RequestMapping(value=LISTA_TOTAL,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson> lista(@PathVariable("idusuario")int idusuario){
		
		ProductoJOINregistroPedidoJOINpedidoGson gson=null;
		List<ProductoJOINregistroPedidoJOINpedido> lista=null;
		
		try {
			
			lista=productoJOINregistroPedidoJOINpedidoService.listaCarritoTotal(idusuario);
			gson= new ProductoJOINregistroPedidoJOINpedidoGson();
			gson.setListaProductoJOINregistroPedidoJOINpedido(lista);
		}catch(Exception e) {
			return new ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson>(gson,HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return new ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson>(gson,HttpStatus.OK);
	
	}
	
	
	@RequestMapping(value=LISTA_TOTAL_BY_USUARIO,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson> listaTotalByUsuario(@PathVariable("idusuario")int idusuario){
		
		ProductoJOINregistroPedidoJOINpedidoGson gson=null;
		List<ProductoJOINregistroPedidoJOINpedido> lista=null;
		
		try {
			
			lista=productoJOINregistroPedidoJOINpedidoService.listaCarritoByIdUsuario(idusuario);
			gson= new ProductoJOINregistroPedidoJOINpedidoGson();
			gson.setListaProductoJOINregistroPedidoJOINpedido(lista);
		}catch(Exception e) {
			return new ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson>(gson,HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return new ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson>(gson,HttpStatus.OK);
	
	}
	
	@RequestMapping(value=LISTA_TOTAL_BY_USUARIO_2,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson> listaTotalByUsuarioProof(@PathVariable("idPedido")int idPedido){
		
		ProductoJOINregistroPedidoJOINpedidoGson gson=null;
		List<ProductoJOINregistroPedidoJOINpedido> lista=null;
		
		try {
			
			lista=productoJOINregistroPedidoJOINpedidoService.listaProductoVenta(idPedido);
			gson= new ProductoJOINregistroPedidoJOINpedidoGson();
			gson.setListaProductoJOINregistroPedidoJOINpedido(lista);
		}catch(Exception e) {
			return new ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson>(gson,HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		return new ResponseEntity<ProductoJOINregistroPedidoJOINpedidoGson>(gson,HttpStatus.OK);
	
	}

}
