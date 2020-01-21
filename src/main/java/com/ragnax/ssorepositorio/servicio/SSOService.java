package com.ragnax.ssorepositorio.servicio;

import java.util.List;

import com.ragnax.domain.sso.entidad.*;
import com.ragnax.ssorepositorio.exception.LogicaImplException;

public interface SSOService {
	
	Rol crearRol(Rol objRol) throws LogicaImplException;
	
	Rol buscarRolxNombre(Rol objRol) throws LogicaImplException;
	
	List<Rol> listarTodoRol() throws LogicaImplException;
	
	Aplicacion crearAplicacion(Aplicacion objAplicacion) throws LogicaImplException;
	
	Aplicacion buscarAplicacion(Aplicacion objAplicacion) throws LogicaImplException;
	
	Aplicacion buscarAplicacionxUriRuta(Aplicacion objAplicacion) throws LogicaImplException;
	
	List<Aplicacion> listarTodoAplicacion() throws LogicaImplException;
	
	Maquina crearMaquina(Maquina objMaquina) throws LogicaImplException;
	
	Maquina buscarMaquinaxDireccionIpMaquina(Maquina objMaquina) throws LogicaImplException;
	
	List<Maquina> listarTodoMaquina() throws LogicaImplException;
	
	Genero crearGenero(Genero objGenero) throws LogicaImplException;
	
	Genero buscarGeneroxNombre(Genero objGenero) throws LogicaImplException;
	
	List<Genero> listarTodoGenero() throws LogicaImplException;
	
	TipoAccionPerfil crearTipoAccionPerfil(TipoAccionPerfil objTipoAccionPerfil) throws LogicaImplException;
	
	TipoAccionPerfil buscarTipoAccionPerfil(TipoAccionPerfil objTipoAccionPerfil) throws LogicaImplException;
	
	List<TipoAccionPerfil> listarTodoTipoAccionPerfil()  throws LogicaImplException;
	
	Empresa crearEmpresa(Empresa objEmpresa) throws LogicaImplException;
	
	Empresa buscarEmpresa(Empresa objEmpresa) throws LogicaImplException;
	
	Empresa buscarEmpresaxDominio(Empresa objEmpresa) throws LogicaImplException;
	
	List<Empresa> listarEmpresaxIdPais(Empresa objEmpresa) throws LogicaImplException;
	
	List<Empresa> listarTodoEmpresa() throws LogicaImplException;
	
	ConfiguracionEmpresaUsuario crearConfiguracionEmpresaUsuario(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario) throws LogicaImplException;
	
	ConfiguracionEmpresaUsuario buscarConfiguracionEmpresaUsuarioxEmpresa(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario) throws LogicaImplException;
	
	List<ConfiguracionEmpresaUsuario> listarTodoConfiguracionEmpresaUsuario() throws LogicaImplException;
	
	Member crearMember(Member objMember) throws LogicaImplException;
	
	Member buscarMember(Member objMember) throws LogicaImplException;
	
	List<Member> listarTodoMember() throws LogicaImplException;
	
	Perfil crearPerfil(ConfiguracionEmpresaUsuario configuracionEmpresaUsuario, Perfil objPerfil) throws LogicaImplException;
	
	Perfil buscarPerfil(Perfil objPerfil) throws LogicaImplException;
	
	Perfil buscarPerfilxUsername(Perfil objPerfil) throws LogicaImplException;
	
	List<Perfil> buscarPerfilxUsernameLike(Perfil objPerfil) throws LogicaImplException;
	
	Perfil buscarPerfilxUsernamexPasswordContrasenha(Perfil objPerfil) throws LogicaImplException;
	
	Perfil buscarPerfilxEmail(Perfil objPerfil) throws LogicaImplException;
	
	List<Perfil> listarTodoPerfil() throws LogicaImplException;
	
	List<Perfil> listarPerfilLikeUsernamePerfil(Perfil objPerfil) throws LogicaImplException;
	
	FotoPerfil crearFotoPerfil(FotoPerfil objFotoPerfil) throws LogicaImplException;

	Usuario generarCodigoUsuario(Usuario objUsuario) throws LogicaImplException;
	
	Usuario crearUsuario(Usuario objUsuario) throws LogicaImplException;
	/****Buscar Exclusivamente siempre por codigoUsuario *******/
	Usuario buscarUsuarioxCodigo(Usuario objUsuario) throws LogicaImplException ;
	
	List<Usuario> listarTodoUsuario() throws LogicaImplException;
	
	AplicacionEmpresa crearAplicacionEmpresa(AplicacionEmpresa objAplicacionEmpresa) throws LogicaImplException;
	
	AplicacionEmpresa buscarAplicacionEmpresaxAplicacionxEmpresa(AplicacionEmpresa objAplicacionEmpresa) throws LogicaImplException;
	
	List<AplicacionEmpresa> listarAplicacionEmpresaxEmpresa(AplicacionEmpresa objAplicacionEmpresa) throws LogicaImplException;
	
	List<AplicacionEmpresa> listarTodoAplicacionEmpresa() throws LogicaImplException;
	
	AplicacionRol crearAplicacionRol(AplicacionRol objAplicacionRol) throws LogicaImplException;
	
	AplicacionRol buscarAplicacionRolxAplicacionxRol(AplicacionRol objAplicacionRol) throws LogicaImplException;
	
	List<AplicacionRol> listarTodoAplicacionRol() throws LogicaImplException;
	
	Identificador crearIdentificador(Identificador objIdentificador) throws LogicaImplException;
	
	Identificador buscarIdentificadorxValuexPais(Identificador objIdentificador) throws LogicaImplException;
	
	AccionPerfil crearAccionPerfil(AccionPerfil objAccionPerfil) throws LogicaImplException;
	
	AccionPerfil buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(AccionPerfil objAccionPerfil) throws LogicaImplException;
	
	MaquinaEmpresa crearMaquinaEmpresa(MaquinaEmpresa objMaquinaEmpresa) throws LogicaImplException;
	
	List<MaquinaEmpresa> listarMaquinaEmpresaxEmpresa(MaquinaEmpresa objMaquinaEmpresa) throws LogicaImplException;
	
	EmpresaUsuario crearEmpresaUsuario(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException;
	
	EmpresaUsuario buscarEmpresaUsuario(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException;
	
	EmpresaUsuario buscarEmpresaUsuarioxEmpresaxUsuarioxRol(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException;
	
	List<EmpresaUsuario> listarEmpresaUsuarioxEmpresa(EmpresaUsuario objEmpresaUsuario)  throws LogicaImplException;
	
	List<EmpresaUsuario> listarEmpresaUsuarioxEmpresaxRol(EmpresaUsuario objEmpresaUsuario)  throws LogicaImplException;
	
	List<EmpresaUsuario> listarTodoEmpresaUsuario() throws LogicaImplException;
	
	AplicacionServicio crearAplicacionServicio(AplicacionServicio objAplicacionServicio)  throws LogicaImplException;
	
	AplicacionServicio buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(AplicacionServicio objAplicacionServicio) throws LogicaImplException;
	
	List<AplicacionServicio> listarAplicacionServicioxAplicacion(AplicacionServicio objAplicacionServicio) throws LogicaImplException;
	
	List<AplicacionServicio> listarTodoAplicacionServicio() throws LogicaImplException;
	
	EmpresaUsuarioAplicacionEmpresa crearEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException;
	
	EmpresaUsuarioAplicacionEmpresa buscarEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException;
	
	EmpresaUsuarioAplicacionEmpresa buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException;
	
	List<EmpresaUsuarioAplicacionEmpresa> listarEmpresaUsuarioAplicacionEmpresaxEU(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException;
	
	List<EmpresaUsuarioAplicacionEmpresa> listarTodoEmpresaUsuarioAplicacionEmpresa() throws LogicaImplException;
	
	SeguridadAplicacionAcceso crearSeguridadAplicacionAcceso(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws LogicaImplException;
	
	SeguridadAplicacionAcceso buscarSeguridadAplicacionAcceso(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws LogicaImplException;
	
	List<SeguridadAplicacionAcceso> listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws LogicaImplException;
	
	List<SeguridadAplicacionAcceso> listarTodoSeguridadAplicacionAcceso() throws LogicaImplException;
}
