package com.ragnax.ssorepositorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;

public interface SeguridadSessionPlataformaRepository extends JpaRepository<SeguridadSessionPlataforma, Integer> {
	
	
}
