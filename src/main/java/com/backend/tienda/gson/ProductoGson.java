package com.backend.tienda.gson;

import java.io.Serializable;
import java.util.List;

import com.backend.tienda.entity.Producto;

public class ProductoGson  implements Serializable{
	
	List<Producto> listaProducto;

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaProducto == null) ? 0 : listaProducto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoGson other = (ProductoGson) obj;
		if (listaProducto == null) {
			if (other.listaProducto != null)
				return false;
		} else if (!listaProducto.equals(other.listaProducto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductoGson [listaProducto=" + listaProducto + "]";
	}
	
	
	

}
