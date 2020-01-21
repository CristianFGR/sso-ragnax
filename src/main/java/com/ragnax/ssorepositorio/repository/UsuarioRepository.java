package com.ragnax.ssorepositorio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.domain.sso.entidad.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.codigoUsuarioUnit = :codigoUsuarioUnit")
	Page<Usuario> findByCodigoUsuarioUnit(String codigoUsuarioUnit, Pageable page);
	
	Usuario findByIdMemberAndIdPerfil( Member idMember, Perfil idPerfil);
	
	List<Usuario> findByCodigoUsuarioUnitIn(List<String> listaCodigoUsuarioUnit);
	
	List<Usuario> findByIdMember(Member idMember);
	
	List<Usuario> findByIdPerfil(Perfil idPerfil);
	
}
