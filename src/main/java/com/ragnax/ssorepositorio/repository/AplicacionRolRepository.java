package com.ragnax.ssorepositorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;


public interface AplicacionRolRepository extends JpaRepository<AplicacionRol, Integer> {
	
	AplicacionRol findByIdAplicacionAndIdRol(Aplicacion idAplicacion, Rol idRol);
	
	List<AplicacionRol> findByIdAplicacion(Aplicacion idAplicacion);
	
	List<AplicacionRol> findByIdRol(Rol idRol);
	
}
