package com.ragnax.ssorepositorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;

public interface EmpresaUsuarioAplicacionEmpresaRepository extends JpaRepository<EmpresaUsuarioAplicacionEmpresa, Integer> {
	
	EmpresaUsuarioAplicacionEmpresa findByIdEmpresaUsuarioAndIdAplicacionEmpresa(EmpresaUsuario idEmpresaUsuario, AplicacionEmpresa IdAplicacionEmpresa);
	
	List<EmpresaUsuarioAplicacionEmpresa> findByEstadoEmpresaUsuarioAplicacionEmpresa(Boolean estadoEmpresaUsuarioAplicacionEmpresa);
	
	List<EmpresaUsuarioAplicacionEmpresa> findByIdEmpresaUsuario(EmpresaUsuario idEmpresaUsuario);
	
	List<EmpresaUsuarioAplicacionEmpresa> findByIdAplicacionEmpresa(AplicacionEmpresa IdAplicacionEmpresa);
}
