package com.backend.tienda.repositorys;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.tienda.entity.Roles;
import com.backend.tienda.models.ERole;
import com.backend.tienda.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByNombre(ERole nombre);
}