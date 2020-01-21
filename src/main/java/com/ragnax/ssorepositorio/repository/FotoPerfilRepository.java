package com.ragnax.ssorepositorio.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.domain.sso.entidad.*;

public interface FotoPerfilRepository extends JpaRepository<FotoPerfil, Integer> {
	
	//Traer Todas las Fotos de Perfil
	List<FotoPerfil> findByidPerfilAndUploadFotoPerfilBefore(Perfil idPerfil,Timestamp uploadFotoPerfil);
	
}
