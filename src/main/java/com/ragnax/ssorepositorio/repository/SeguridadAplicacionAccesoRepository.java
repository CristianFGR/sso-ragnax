package com.ragnax.ssorepositorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;
public interface SeguridadAplicacionAccesoRepository extends JpaRepository<SeguridadAplicacionAcceso, Integer> {
	
	SeguridadAplicacionAcceso findByIdEmpresaUsuarioAplicacionEmpresaAndIdAplicacionServicio(
			EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			AplicacionServicio idAplicacionServicio);
	
	List<SeguridadAplicacionAcceso> findByIdEmpresaUsuarioAplicacionEmpresaAndIdAplicacionServicioInAndEstadoSeguridadAplicacionAcceso(
			EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			List<AplicacionServicio> listaAplicacionServicio,
			Boolean estadoSeguridadAplicacionAcceso);
	
	
	List<SeguridadAplicacionAcceso> findByIdEmpresaUsuarioAplicacionEmpresaAndEstadoSeguridadAplicacionAcceso(
			EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			Boolean estadoSeguridadAplicacionAcceso);
}
