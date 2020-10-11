 package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
	

	List<Empresa> findByIdcategoriaempresa(int idCategoria);
	
	List<Empresa> findByIdsubcategoriaempresa(int idSubCategoria);
	
    List<Empresa> findByIdcategoriaempresaOrderByPopularidadAsc(int idCategoria);

    
    @Query(value="SELECT idempresa,idsubcategoriaempresa, nombre_subcategoria ,nombre_empresa,  \r\n" + 
    		"							 direccion_empresa,ruc_empresa,telefono_empresa,celular_empresa,descripcion_empresa  \r\n" + 
    		"							 ,urlfoto_empresa,nombredueno_empresa,popularidad\r\n" + 
    		"			                ,cuenta_delivery,costo_delivery,detalle_delivery,tiempo_aproximado_entrega\r\n" + 
    		"			                ,iddistrito,icono_empresa,horario_inicio,horario_fin,tarjeta,detalle_tarjeta,estrella_empresa \r\n" + 
    		"			                ,maps_coordenada_x ,maps_coordenada_y ,detalle_ubicacion,disponible\r\n" + 
    		"														,idcategoriaempresa\r\n" + 
    		"							,nombre_categoria\r\n" + 
    		"							,idcuentaempresa,cuentaactiva,marketplace,socio\r\n" + 
    		"							,precio_menu,monto_descuento_menu\r\n" + 
    		"							,idusuariogeneral,apellido,nombre,correo,celular,foto\r\n" + 
    		" 							FROM empresa_bi "+
    		"							WHERE idcategoriaempresa = ?1 AND costo_delivery <= ?2 "+
    		"							",nativeQuery=true)
    List<Empresa> listfindByIdcategoriaAndCosto_delivery(int idCategoria,float preciodelivery);

}
