package com.backend.tienda.service.Impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.tienda.entity.RegistroPedido;
import com.backend.tienda.entity.RegistroPedidoPK;
import com.backend.tienda.repository.RegistroPedidoRepository;
import com.backend.tienda.service.RegistroPedidoService;

@Service
public class RegistroPedidoImpl  implements RegistroPedidoService{
	
	@Autowired 
	RegistroPedidoRepository registroPedidoRepository;

	@Override
	public RegistroPedido registrar(RegistroPedido registroPedido) {
		
		
		return registroPedidoRepository.save(registroPedido);
	
	}

	@Override
	public RegistroPedido findByid_pedidoAndid_producto(int idpedido, int idproducto) {
		return registroPedidoRepository.findByid_pedidoAndid_producto(idpedido, idproducto);
	}

	@Override
	public RegistroPedido updateRegistroPedidoCantidadAndPrecio(int registro_cantidad, float registro_costo,String comentario,RegistroPedidoPK pk) {
		
		int total=0;
		RegistroPedido registroPedido=registroPedidoRepository.findById(pk).get();
		total=registroPedido.getRegistropedido_cantidadtotal()+registro_cantidad;
		
	
		
		registroPedido.setComentario(registroPedido.getComentario()+" | Comentario "+String.valueOf(total)+" : "+comentario);

		
		registroPedido.setRegistropedido_cantidadtotal(total);
		registroPedido.setRegistropedido_preciototal(registroPedido.getRegistropedido_preciototal()+registro_costo);
		
		//registroPedidoRepository.updateRegistroPedidoCantidadAndPrecio(registro_cantidad, registro_costo, idpedido,idproducto);
		
		return registroPedidoRepository.save(registroPedido);
	}

	@Override
	public RegistroPedido findByid(RegistroPedidoPK pk) {
		return registroPedidoRepository.findByid(pk);
	}

	@Override
	public RegistroPedido updateDisminuirCantidadAndPrecio(int registro_cantidad, float registro_costo,
			RegistroPedidoPK pk) {

		String updateComentario="";
		RegistroPedido registroPedido=registroPedidoRepository.findById(pk).get();
		/*
		String[] parts = registroPedido.getComentario().split("\\|"); 
		List<String> lista=Arrays.asList(parts);
		lista.remove(registroPedido.getRegistropedido_cantidadtotal()-1);
		
		for(String cadena:lista) {
			updateComentario=updateComentario+cadena;
		}
		registroPedido.setComentario(updateComentario);
		
		*/

		
		registroPedido.setRegistropedido_cantidadtotal(registroPedido.getRegistropedido_cantidadtotal()-registro_cantidad);
		registroPedido.setRegistropedido_preciototal(registroPedido.getRegistropedido_preciototal()-registro_costo);
		
		//registroPedidoRepository.updateRegistroPedidoCantidadAndPrecio(registro_cantidad, registro_costo, idpedido,idproducto);
		
		return registroPedidoRepository.save(registroPedido);
	}

	@Override
	public int eliminarProductoRegistro(RegistroPedidoPK pk) {
		// TODO Auto-generated method stub
		
		registroPedidoRepository.deleteById(pk);
		
		RegistroPedido registroPedido=null;
		
		try {
			registroPedido=registroPedidoRepository.findById(pk).get();
			
			return 1;

		}catch(Exception e) {
			
			return 0;

		}
		
	}

	@Override
	public RegistroPedido eliminarCarrito(int idpedido) {
		RegistroPedido registroPedido=null;
		
		try {
			registroPedidoRepository.eliminarCarrito(idpedido);
			registroPedido=new RegistroPedido();
		}catch(Exception e) {
			return registroPedido;
		}
		
		return registroPedido;
	}


	

}
