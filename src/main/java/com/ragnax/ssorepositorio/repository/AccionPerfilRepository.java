package com.ragnax.ssorepositorio.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;



public interface AccionPerfilRepository extends JpaRepository<AccionPerfil, Integer> {
	
	AccionPerfil findByidPerfilAndIdTipoAccionPerfilAndKeyAccionPerfil(Perfil idPerfil, TipoAccionPerfil idTipoAccionPerfil, String keyAccionPerfil);
	
	List<AccionPerfil> findByUltimaAccionPerfilBetween(Timestamp ultimaAccionPerfilA , Timestamp ultimaAccionPerfilB);
	
	List<AccionPerfil> findByIdPerfilAndIdTipoAccionPerfil(Perfil idPerfil, TipoAccionPerfil idTipoAccionPerfil);
}
