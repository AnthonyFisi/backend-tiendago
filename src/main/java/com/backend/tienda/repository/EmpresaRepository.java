 package com.backend.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Empresa;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
	
	@Query(value="SELECT e.idempresa,e.idsubcategoriaempresa,e.nombre_empresa," + 
			"				 e.direccion_empresa,e.ruc_empresa,e.telefono_empresa,e.celular_empresa,e.descripcion_empresa" + 
			"				 ,e.urlfoto_empresa,e.nombredueno_empresa,e.idcuentaempresa,e.porcentaje_popularidad" +
			"                ,e.cuenta_delivery,e.costo_delivery,e.detalle_delivery,e.tiempo_aproximado_entrega"+
			"                ,e.iddistrito,e.horario_atencion "+
			"				  FROM empresa AS e INNER JOIN cuentaempresa AS c ON e.idcuentaempresa = c.idcuentaempresa " + 
			"				                          JOIN subcategoriaempresa AS sce ON sce.idsubcategoriaempresa = e.idsubcategoriaempresa" + 
			"				 							JOIN categoriaempresa AS ce ON ce.idcategoriaempresa = sce.idcategoriaempresa " + 
			"				 WHERE ce.idcategoriaempresa= ?1   AND c.cuentaactiva = true AND  " + 
			"					plainto_tsquery( ?2 ) @@ to_tsvector(coalesce(direccion_empresa,'')) " , nativeQuery=true)
	List<Empresa> listaEmpresaFindByIdCategoriaAnddireccion(int idCategoria, String direccion);
	
	@Query(value = "SELECT e.idempresa,e.idsubcategoriaempresa,e.nombre_empresa," + 
			"				 e.direccion_empresa,e.ruc_empresa,e.telefono_empresa,e.celular_empresa,e.descripcion_empresa" + 
			"				 ,e.urlfoto_empresa,e.nombredueno_empresa,e.idcuentaempresa,e.porcentaje_popularidad" + 
			"                ,e.cuenta_delivery,e.costo_delivery,e.detalle_delivery,e.tiempo_aproximado_entrega"+
			"                ,e.iddistrito,e.horario_atencion "+
			"				  FROM empresa AS e INNER JOIN cuentaempresa AS c ON e.idcuentaempresa = c.idcuentaempresa " + 
			"				                          JOIN subcategoriaempresa AS sce ON sce.idsubcategoriaempresa = e.idsubcategoriaempresa" + 
			"				 							JOIN categoriaempresa AS ce ON ce.idcategoriaempresa = sce.idcategoriaempresa " + 
			"				 WHERE ce.idcategoriaempresa = ?1   AND c.cuentaactiva =  true  ORDER BY e.porcentaje_popularidad DESC LIMIT 10 ;", nativeQuery = true)
	public  List<Empresa> listaEmpresaSortByBusquedaRating(int idCategoria);
	
	@Query(value="SELECT e.idempresa,e.idsubcategoriaempresa,e.nombre_empresa," + 
				"				e.direccion_empresa,e.ruc_empresa,e.telefono_empresa,e.celular_empresa,e.descripcion_empresa" + 
				"				,e.urlfoto_empresa,e.nombredueno_empresa,e.idcuentaempresa,e.porcentaje_popularidad" + 
				"                ,e.cuenta_delivery,e.costo_delivery,e.detalle_delivery,e.tiempo_aproximado_entrega"+
				"                ,e.iddistrito,e.horario_atencion "+
				"				FROM empresa AS e INNER JOIN cuentaempresa AS c ON e.idcuentaempresa = c.idcuentaempresa " + 
				"				 WHERE e.idsubcategoriaempresa = ?1 AND c.cuentaactiva = true  AND" + 
				"				 plainto_tsquery( ?2  ) @@ to_tsvector(coalesce(direccion_empresa,'')) ",nativeQuery=true)
	List<Empresa> listaEmpresaFindByIdSubCategoriaAnddireccion(int idSubCategoria, String direccion);
	
	
	@Query(value="SELECT e.idempresa,e.idsubcategoriaempresa,e.nombre_empresa,"
				+ "e.direccion_empresa,e.ruc_empresa,e.telefono_empresa,e.celular_empresa,e.descripcion_empresa"
				+ ",e.urlfoto_empresa,e.nombredueno_empresa,e.idcuentaempresa,e.porcentaje_popularidad"
				+"                ,e.cuenta_delivery,e.costo_delivery,e.detalle_delivery,e.tiempo_aproximado_entrega"
				+"                ,e.iddistrito,e.horario_atencion "
				+ " FROM empresa AS e INNER JOIN cuentaempresa AS c ON e.idcuentaempresa = c.idcuentaempresa "
				+ " WHERE e.idsubcategoriaempresa = ?1  AND c.cuentaactiva = true  ",nativeQuery=true)
	List<Empresa> listaEmpresaFindByIdSubCategoria(int idSubCategoria);

	
	


}
