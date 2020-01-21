package com.ragnax.ssorepositorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;

public interface MaquinaEmpresaRepository extends JpaRepository<MaquinaEmpresa, Integer> {
	
	MaquinaEmpresa findByIdMaquinaAndIdEmpresa(Maquina idMaquina, Empresa idEmpresa);
	
	List<MaquinaEmpresa> findByIdEmpresa(Empresa idEmpresa);
	
}
