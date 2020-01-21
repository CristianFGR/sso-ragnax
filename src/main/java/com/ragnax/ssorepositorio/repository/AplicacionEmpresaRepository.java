package com.ragnax.ssorepositorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;


public interface AplicacionEmpresaRepository extends JpaRepository<AplicacionEmpresa, Integer> {
	
	AplicacionEmpresa findByIdAplicacionAndIdEmpresa(Aplicacion idAplicacion, Empresa idEmpresa);
	List<AplicacionEmpresa> findByIdAplicacionAndEstadoAplicacionEmpresa(Aplicacion idAplicacion, Boolean estadoAplicacionEmpresa);
	List<AplicacionEmpresa> findByIdEmpresa(Empresa idEmpresa);
	List<AplicacionEmpresa> findByEstadoAplicacionEmpresa(Boolean estadoAplicacionEmpresa);
}
