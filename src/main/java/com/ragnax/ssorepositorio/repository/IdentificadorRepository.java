package com.ragnax.ssorepositorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;

public interface IdentificadorRepository extends JpaRepository<Identificador, Integer> {
	
	Identificador findByValueIdentificadorAndNombreIdentificadorAndCodigoPaisPortal(String valueIdentificador, String nombreIdentificador, String codigoPaisPortal);
	
	List<Identificador> findByIdMember(Member idMember);
	
}
