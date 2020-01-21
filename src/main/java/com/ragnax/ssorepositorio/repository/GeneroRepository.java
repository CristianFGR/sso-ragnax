package com.ragnax.ssorepositorio.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.domain.sso.entidad.*;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
	
	@Query("select g from Genero g where g.nombreGenero = :nombreGenero")
	Page<Genero> findByNombreGenero(String nombreGenero, Pageable page);
	
}
