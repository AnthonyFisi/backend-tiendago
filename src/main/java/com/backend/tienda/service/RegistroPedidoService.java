package com.backend.tienda.service;

import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.entity.RegistroPedidoPK;

public interface RegistroPedidoService {
	
	RegistroPedido registrar(RegistroPedido registroPedido);
	
	RegistroPedido findByid_pedidoAndid_producto(int idpedido,int idproducto);
	
	RegistroPedido updateRegistroPedidoCantidadAndPrecio(int registro_cantidad,float registro_costo,String comentario,RegistroPedidoPK pk);
	
	RegistroPedido findByid(RegistroPedidoPK pk);
	
	RegistroPedido updateDisminuirCantidadAndPrecio(int registro_cantidad,float registro_costo,RegistroPedidoPK pk);
	
	int eliminarProductoRegistro(RegistroPedidoPK pk);

}
