package com.backend.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Cuenta_Usuario;

@Repository
public interface Cuenta_UsuarioRepository extends JpaRepository<Cuenta_Usuario,Integer> {

}
