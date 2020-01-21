package com.ragnax.ssorepositorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;

public interface EmpresaUsuarioRepository extends JpaRepository<EmpresaUsuario, Integer> {
	
	EmpresaUsuario findByIdEmpresaAndIdUsuarioAndIdRol(Empresa idEmpresa, Usuario idUsuario, Rol idRol);
	List<EmpresaUsuario> findByEstadoEmpresaUsuario(Boolean estadoEmpresaUsuario);
	List<EmpresaUsuario> findByIdEmpresa(Empresa idEmpresa);
	List<EmpresaUsuario> findByIdUsuario(Usuario idUsuario);
	List<EmpresaUsuario> findByIdEmpresaAndIdRol(Empresa idEmpresa, Rol idRol);
	
	
}
