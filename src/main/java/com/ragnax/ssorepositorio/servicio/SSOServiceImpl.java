package com.ragnax.ssorepositorio.servicio;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ragnax.domain.sso.entidad.*;
import com.ragnax.domain.zapala.modelo.ZapalaRequest;
import com.ragnax.ssorepositorio.exception.LogicaImplException;
import com.ragnax.ssorepositorio.repository.FactorySeguridadDAO;
import com.ragnax.ssorepositorio.servicio.utilidades.ChapalaImpl;
import com.ragnax.ssorepositorio.servicio.utilidades.SSOUtilidades;

/**TODO Para usar el commons por el momento es necesario hacer esta Wea**/
@Service("ssoService")
//@ComponentScan(basePackageClasses = { FactoryApiProperties.class})
public class SSOServiceImpl implements SSOService {
	/*****Segun se necesite se van creando llamadas al repositorio para devolver entities.*****/
	@Autowired
	private FactorySeguridadDAO factorySeguridadDAO;
	
//	@Autowired
//	private ZapalaClienteRest ChapalaImpl;
	
//	@Autowired
//	private FactoryApiProperties factoryApiProperties;
	
	/******* Rol Rol Rol *****************/
	/******* Rol Rol Rol *****************/
	/******* Rol Rol Rol *****************/
	public Rol crearRol(Rol objRol) throws LogicaImplException {
		
		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreRolLowerCase").descending());

			Page<Rol> pageNombreLowerRol  = factorySeguridadDAO.getRolRepository().findByNombreRolLowerCase(objRol.getNombreRol().toLowerCase(), pageByNombreDesc);

			if(pageNombreLowerRol.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idRol").descending());

				Page<Rol> pageIdRol = factorySeguridadDAO.getRolRepository().findAll(pageByidDesc);

				Integer idRol = (!pageIdRol.isEmpty()) ? (Integer) pageIdRol.getContent().get(0).getIdRol() + 1 : 1; 

				objRol.setIdRol(idRol);
				
				objRol.setNombreRolLowerCase(objRol.getNombreRol().toLowerCase());
				
				objRol.setEstadoRol(true);
				
				factorySeguridadDAO.getRolRepository().save(objRol);

				return buscarRolxNombre(objRol);
			
			}else {
				throw new LogicaImplException("No se puede crear Rol, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
//	public SeguridadAplicaciones buscarRol(Rol objRol) throws LogicaImplException {
//
//		SeguridadAplicaciones seguridadAplicaciones = new SeguridadAplicaciones();
//
//		try {
//			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
//			
//
//			Optional<Rol> optRolDesc  = factorySeguridadDAO.getRolRepository().findById(objRol.getIdRol());
//
//			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
//				//... solo actualizar estado****/
//			if(optRolDesc.isPresent()){
//
//				seguridadAplicaciones.setRol(optRolDesc.get());
//			}
//			else {
//				throw new LogicaImplException("No existe Rol con nombre:" +objRol.getNombreRol());
//			}
//
//		} catch (Exception e) {
//			throw new LogicaImplException(e.getMessage());
//		}
//		return seguridadAplicaciones;
//	}
	
	public Rol buscarRolxNombre(Rol objRol) throws LogicaImplException {

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.*****/
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreRolLowerCase").descending());

			Page<Rol> pageNombreDesc  = factorySeguridadDAO.getRolRepository().findByNombreRol(
					objRol.getNombreRol().toLowerCase(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(!pageNombreDesc.isEmpty()){

				return pageNombreDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Rol con nombre:" +objRol.getNombreRol());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public List<Rol> listarTodoRol() throws LogicaImplException {
		try {
			List<Rol> listaRol = factorySeguridadDAO.getRolRepository().findAll();

			if(listaRol!=null && !listaRol.isEmpty()){
				return listaRol;
			}else {
				throw new LogicaImplException("No existe lista de Rol");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	/*******************************************/
	/***** Aplicacion Aplicacion Aplicacion ****/
	/*******************************************/
	public Aplicacion crearAplicacion(Aplicacion objAplicacion) throws LogicaImplException {
		
		try {
			Timestamp tsInicial = new Timestamp(new Date().getTime());
			
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreAplicacionLowerCase").descending());

			Page<Aplicacion> pageNombreLowerAplicacion  = factorySeguridadDAO.getAplicacionRepository().findByNombreAplicacionLowerCase(objAplicacion.getNombreAplicacion().toLowerCase(), pageByNombreDesc);
			
			Pageable pageByUriDesc = PageRequest.of(0, 1, Sort.by("uriRuta").descending());

			Page<Aplicacion> pageUriRutaDesc  = factorySeguridadDAO.getAplicacionRepository().findByUriRuta(
					objAplicacion.getUriRuta(), pageByUriDesc);
			
			if(pageNombreLowerAplicacion.isEmpty() && pageUriRutaDesc.isEmpty()){
				
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAplicacion").descending());

				Page<Aplicacion> pageIdAplicacion = factorySeguridadDAO.getAplicacionRepository().findAll(pageByidDesc);

				Integer idAplicacion = (!pageIdAplicacion.isEmpty()) ? (Integer) pageIdAplicacion.getContent().get(0).getIdAplicacion()+1 : 1; 

				objAplicacion.setIdAplicacion(idAplicacion);
				
				objAplicacion.setNombreAplicacionLowerCase(objAplicacion.getNombreAplicacion().toLowerCase());
				
				objAplicacion.setFechaCreacionAplicacion(tsInicial);
				
				factorySeguridadDAO.getAplicacionRepository().save(objAplicacion);

				return buscarAplicacionxUriRuta(objAplicacion);

			}else {
				throw new LogicaImplException("No se puede crear Aplicacion, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public Aplicacion buscarAplicacion(Aplicacion objAplicacion) throws LogicaImplException {
		
		try {

			Optional<Aplicacion> optAplicacionDesc  = factorySeguridadDAO.getAplicacionRepository().findById(objAplicacion.getIdAplicacion());

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(optAplicacionDesc.isPresent()){

				return optAplicacionDesc.get();
			}
			else {
				throw new LogicaImplException("No existe Aplicacion con nombre:" +objAplicacion.getNombreAplicacion());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	
	public Aplicacion buscarAplicacionxUriRuta(Aplicacion objAplicacion) throws LogicaImplException {

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.*****/
			Pageable pageByUriDesc = PageRequest.of(0, 1, Sort.by("uriRuta").descending());

			Page<Aplicacion> pageUriRutaDesc  = factorySeguridadDAO.getAplicacionRepository().findByUriRuta(
					objAplicacion.getUriRuta(), pageByUriDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(!pageUriRutaDesc.isEmpty()){

				return pageUriRutaDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Aplicacion con uri ruta:" +objAplicacion.getUriRuta());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public List<Aplicacion> listarTodoAplicacion() throws LogicaImplException {

		try {
			List<Aplicacion> listaAplicacion = factorySeguridadDAO.getAplicacionRepository().findAll();

			if(listaAplicacion!=null && !listaAplicacion.isEmpty()){
				return listaAplicacion;
			}else {
				throw new LogicaImplException("No existe lista de Aplicacion");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	/*******************************************/
	/***** Maquina Maquina Maquina *************/
	/*******************************************/
	public Maquina crearMaquina(Maquina objMaquina) throws LogicaImplException {

		

		try {

			Pageable pageByDireccionDesc = PageRequest.of(0, 1, Sort.by("direccionIpMaquina").descending());

			Page<Maquina> pageDireccionMaquina  = factorySeguridadDAO.getMaquinaRepository().findByDireccionIpMaquina(objMaquina.getDireccionIpMaquina(), pageByDireccionDesc);

			if(pageDireccionMaquina.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idMaquina").descending());

				Page<Maquina> pageIdMaquina = factorySeguridadDAO.getMaquinaRepository().findAll(pageByidDesc);

				Integer idMaquina = (!pageIdMaquina.isEmpty()) ? (Integer) pageIdMaquina.getContent().get(0).getIdMaquina()+1 : 1; 

				objMaquina.setIdMaquina(idMaquina);

				factorySeguridadDAO.getMaquinaRepository().save(objMaquina);

				return buscarMaquinaxDireccionIpMaquina(objMaquina);

			} else {
				throw new LogicaImplException("No se puede crear Maquina, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public Maquina buscarMaquinaxDireccionIpMaquina(Maquina objMaquina) throws LogicaImplException {

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.*****/
			Pageable pageByDireccionDesc = PageRequest.of(0, 1, Sort.by("direccionIpMaquina").descending());

			Page<Maquina> pageDireccionDesc  = factorySeguridadDAO.getMaquinaRepository().findByDireccionIpMaquina(
					objMaquina.getDireccionIpMaquina(), pageByDireccionDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(!pageDireccionDesc.isEmpty()){

				return pageDireccionDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objMaquina.getDireccionIpMaquina());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	@Override
	public List<Maquina> listarTodoMaquina() throws LogicaImplException {
		
		try {
			List<Maquina> listaMaquina = factorySeguridadDAO.getMaquinaRepository().findAll();

			if(listaMaquina!=null && !listaMaquina.isEmpty()){
				return listaMaquina;
			}else {
				throw new LogicaImplException("No existe lista de Maquina");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	/********************************************************/
	/********** Genero Genero Genero ************************/
	/********************************************************/
	public Genero crearGenero(Genero objGenero) throws LogicaImplException {

		

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreGenero").descending());

			Page<Genero> pageNombreLowerGenero  = factorySeguridadDAO.getGeneroRepository().
					findByNombreGenero(objGenero.getNombreGenero(), pageByNombreDesc);

			if(pageNombreLowerGenero.isEmpty()){
				
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idGenero").descending());

				Page<Genero> pageIdGenero = factorySeguridadDAO.getGeneroRepository().findAll(pageByidDesc);

				Integer idGenero = (!pageIdGenero.isEmpty()) ? (Integer) pageIdGenero.getContent().get(0).getIdGenero()+1 : 1; 

				objGenero.setIdGenero(idGenero);
				
				objGenero.setEstadoGenero(true);

				factorySeguridadDAO.getGeneroRepository().save(objGenero);

				return buscarGeneroxNombre(objGenero);

			}else {
				throw new LogicaImplException("No se puede crear Genero, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
//	public SeguridadAplicaciones buscarGenero(Genero objGenero) throws LogicaImplException {
//		SeguridadAplicaciones seguridadAplicaciones = new SeguridadAplicaciones();
//		
//		try {
//
//			Optional<Genero> optGeneroDesc  = factorySeguridadDAO.getGeneroRepository().findById(objGenero.getIdGenero());
//
//			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
//				//... solo actualizar estado****/
//			if(optGeneroDesc.isPresent()){
//
//				seguridadAplicaciones.setGenero(optGeneroDesc.get());
//			}
//			else {
//				throw new LogicaImplException("No existe Genero con nombre:" +objGenero.getNombreGenero());
//			}
//
//		} catch (Exception e) {
//			throw new LogicaImplException(e.getMessage());
//		}
//		return seguridadAplicaciones;
//	}
	
	public Genero buscarGeneroxNombre(Genero objGenero) throws LogicaImplException {
		

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.*****/
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreGenero").descending());

			Page<Genero> pageNombreDesc  = factorySeguridadDAO.getGeneroRepository().
					findByNombreGenero(objGenero.getNombreGenero(), pageByNombreDesc);
			
			if(!pageNombreDesc.isEmpty()){
				return pageNombreDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Genero con nombre:" +objGenero.getNombreGenero());
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public List<Genero> listarTodoGenero() throws LogicaImplException {
		

		try {
			List<Genero> listaGenero = factorySeguridadDAO.getGeneroRepository().findAll();

			if(listaGenero!=null && !listaGenero.isEmpty()){
				return listaGenero;
			}else {
				throw new LogicaImplException("No existe lista de Genero");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	/********************************************************/
	/********** TipoAccionPerfil TipoAccionPerfil************/
	/********************************************************/
	public TipoAccionPerfil crearTipoAccionPerfil(TipoAccionPerfil objTipoAccionPerfil) throws LogicaImplException {
		
		

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoAccionPerfil").descending());

			Page<TipoAccionPerfil> pageNombreLowerTipoAccionPerfil  = factorySeguridadDAO.getTipoAccionPerfilRepository().findByNombreTipoAccionPerfil(objTipoAccionPerfil.getNombreTipoAccionPerfil(), pageByNombreDesc);

			if(pageNombreLowerTipoAccionPerfil.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoAccionPerfil").descending());

				Page<TipoAccionPerfil> pageIdTipoAccionPerfil = factorySeguridadDAO.getTipoAccionPerfilRepository().findAll(pageByidDesc);

				Integer idTipoAccionPerfil = (!pageIdTipoAccionPerfil.isEmpty()) ? (Integer) pageIdTipoAccionPerfil.getContent().get(0).getIdTipoAccionPerfil()+1 : 1; 

				objTipoAccionPerfil.setIdTipoAccionPerfil(idTipoAccionPerfil);
				
				factorySeguridadDAO.getTipoAccionPerfilRepository().save(objTipoAccionPerfil);

				return buscarTipoAccionPerfil(objTipoAccionPerfil);

			}else {
				throw new LogicaImplException("No se puede crear TipoAccionPerfil, parametros ya existen en identificador valido");
			}
 
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public TipoAccionPerfil buscarTipoAccionPerfil(TipoAccionPerfil objTipoAccionPerfil) throws LogicaImplException {
		

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Optional<TipoAccionPerfil> optPerEmpresa = factorySeguridadDAO.getTipoAccionPerfilRepository().findById(objTipoAccionPerfil.getIdTipoAccionPerfil());
			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(optPerEmpresa!=null && optPerEmpresa.isPresent()){

				return optPerEmpresa.get();

			}else {
				throw new LogicaImplException("No existe TipoAccionPerfil con identificador:" +objTipoAccionPerfil.getIdTipoAccionPerfil());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}

	public List<TipoAccionPerfil> listarTodoTipoAccionPerfil() throws LogicaImplException {
		

		try {
			List<TipoAccionPerfil> listaTipoAccionPerfil = factorySeguridadDAO.getTipoAccionPerfilRepository().findAll();

			if(listaTipoAccionPerfil!=null && !listaTipoAccionPerfil.isEmpty()){
				return listaTipoAccionPerfil;
			}else {
				throw new LogicaImplException("No existe lista de TipoAccionPerfil");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	/********************************************************/
	/********** Empresa Empresa Empresa *********************/
	/********************************************************/
	
	public Empresa crearEmpresa(Empresa objEmpresa) throws LogicaImplException {

		

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreEmpresa").descending());

			Page<Empresa> pageNombreDesc  = factorySeguridadDAO.getEmpresaRepository().findByNombreEmpresaLowerCase(
					objEmpresa.getNombreEmpresa().toLowerCase(), pageByNombreDesc);

			Pageable pageByDominioDesc = PageRequest.of(0, 1, Sort.by("dominioEmpresa").descending());

			Page<Empresa> pageDominioDesc  = factorySeguridadDAO.getEmpresaRepository().findByDominioEmpresa(
					objEmpresa.getDominioEmpresa(), pageByDominioDesc);

			Pageable pageByRazonSocialDesc = PageRequest.of(0, 1, Sort.by("razonSocialEmpresa").descending());

			Page<Empresa> pageRazonSocialDesc  = factorySeguridadDAO.getEmpresaRepository().findByRazonSocialEmpresaLowerCase(
					objEmpresa.getRazonSocialEmpresa().toLowerCase(), pageByRazonSocialDesc);


			if(pageNombreDesc.isEmpty() && pageDominioDesc.isEmpty() && pageRazonSocialDesc.isEmpty()) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idEmpresa").descending());

				Page<Empresa> pageIdEmpresa = factorySeguridadDAO.getEmpresaRepository().findAll(pageByidDesc);

				Integer idEmpresa = (!pageIdEmpresa.isEmpty()) ? (Integer) pageIdEmpresa.getContent().get(0).getIdEmpresa() +1 : 1; 

				objEmpresa.setIdEmpresa(idEmpresa);

				objEmpresa.setNombreEmpresaLowerCase(objEmpresa.getNombreEmpresa().toLowerCase());

				objEmpresa.setRazonSocialEmpresaLowerCase(objEmpresa.getRazonSocialEmpresa().toLowerCase());

				objEmpresa.setEstadoEmpresa(true);

				factorySeguridadDAO.getEmpresaRepository().save(objEmpresa);

				return buscarEmpresa(objEmpresa);

			}else {
				throw new LogicaImplException("No se puede crear Empresa, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public Empresa buscarEmpresa(Empresa objEmpresa) throws LogicaImplException {
		

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Optional<Empresa> optPerEmpresa = factorySeguridadDAO.getEmpresaRepository().findById(objEmpresa.getIdEmpresa());

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(optPerEmpresa!=null && optPerEmpresa.isPresent()){

				return optPerEmpresa.get();

			}else {
				throw new LogicaImplException("No existe Empresa con identificador:" +objEmpresa.getIdEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public Empresa buscarEmpresaxNombre(Empresa objEmpresa) throws LogicaImplException {
		

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreEmpresa").descending());

			Page<Empresa> pageNombreDesc  = factorySeguridadDAO.getEmpresaRepository().findByNombreEmpresaLowerCase(
					objEmpresa.getNombreEmpresa().toLowerCase(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(!pageNombreDesc.isEmpty()){

				return pageNombreDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objEmpresa.getNombreEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public Empresa buscarEmpresaxDominio(Empresa objEmpresa) throws LogicaImplException {
		

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Pageable pageByDominioDesc = PageRequest.of(0, 1, Sort.by("dominioEmpresa").descending());

			Page<Empresa> pageDominioDesc  = factorySeguridadDAO.getEmpresaRepository().findByDominioEmpresa(
					objEmpresa.getDominioEmpresa(), pageByDominioDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(!pageDominioDesc.isEmpty()){

				return pageDominioDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objEmpresa.getDominioEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public Empresa buscarEmpresaxRazonSocial(Empresa objEmpresa) throws LogicaImplException {
		

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Pageable pageByRazonSocialDesc = PageRequest.of(0, 1, Sort.by("razonSocialEmpresa").descending());

			Page<Empresa> pageRazonSocialDesc  = factorySeguridadDAO.getEmpresaRepository().findByRazonSocialEmpresaLowerCase(
					objEmpresa.getRazonSocialEmpresa().toLowerCase(), pageByRazonSocialDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				... solo actualizar estado****/
			if(!pageRazonSocialDesc.isEmpty()){

				return pageRazonSocialDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objEmpresa.getNombreEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
		public List<Empresa> listarEmpresaxIdPais(Empresa objEmpresa) throws LogicaImplException {
			

			try {
				List<Empresa> listaEmpresa = factorySeguridadDAO.getEmpresaRepository().findByCodigoPaisPortal(objEmpresa.getCodigoPaisPortal());

				if(listaEmpresa!=null && !listaEmpresa.isEmpty()){
					return listaEmpresa;
				}else {
					throw new LogicaImplException("No existe lista de Empresa");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

		}
		
		public List<Empresa> listarTodoEmpresa() throws LogicaImplException {
			

			try {
				List<Empresa> listaEmpresa = factorySeguridadDAO.getEmpresaRepository().findAll();

				if(listaEmpresa!=null && !listaEmpresa.isEmpty()){
					return listaEmpresa;
				}else {
					throw new LogicaImplException("No existe lista de Empresa");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

		}
		
		/*****************************************************************/
		/********ConfiguracionEmpresaUsuario ConfiguracionEmpresaUsuario**/
		/*****************************************************************/
		public ConfiguracionEmpresaUsuario crearConfiguracionEmpresaUsuario(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario) throws LogicaImplException {

			try {

				Pageable pageByEmpresaDesc = PageRequest.of(0, 1, Sort.by("idEmpresa").descending());

				Page<ConfiguracionEmpresaUsuario> pageIdEmpresaDesc = factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().findByIdEmpresa(
						objConfiguracionEmpresaUsuario.getIdEmpresa(), pageByEmpresaDesc);

				if(pageIdEmpresaDesc.isEmpty()) {

					Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idConfiguracionEmpresaUsuario").descending());

					Page<ConfiguracionEmpresaUsuario> pageIdConfiguracion = factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().findAll(pageByidDesc);

					Integer idConfiguracion = (!pageIdConfiguracion.isEmpty()) ? (Integer) pageIdConfiguracion.getContent().get(0).getIdConfiguracionEmpresaUsuario() +1 : 1; 

					objConfiguracionEmpresaUsuario.setIdConfiguracionEmpresaUsuario(idConfiguracion);

					objConfiguracionEmpresaUsuario.setIdEmpresa(buscarEmpresa(objConfiguracionEmpresaUsuario.getIdEmpresa()));

					objConfiguracionEmpresaUsuario.setEstadoConfiguracionEmpresaUsuario(true);

					factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().save(objConfiguracionEmpresaUsuario);

					return buscarConfiguracionEmpresaUsuarioxEmpresa(objConfiguracionEmpresaUsuario);

				}else {
					throw new LogicaImplException("No se puede crear ConfiguracionEmpresaUsuario, empresa ya existe");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}
		}
		
		public ConfiguracionEmpresaUsuario buscarConfiguracionEmpresaUsuarioxEmpresa(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario) throws LogicaImplException {

			try {

				objConfiguracionEmpresaUsuario = factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().findByIdEmpresaAndEstadoConfiguracionEmpresaUsuario(
						buscarEmpresa(objConfiguracionEmpresaUsuario.getIdEmpresa()), objConfiguracionEmpresaUsuario.getEstadoConfiguracionEmpresaUsuario());

				if(objConfiguracionEmpresaUsuario!=null) {
					return objConfiguracionEmpresaUsuario;
				}else {
					throw new LogicaImplException("No se puede crear ConfiguracionEmpresaUsuario, no existe");
				}

			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

		}
		
		public List<ConfiguracionEmpresaUsuario> listarTodoConfiguracionEmpresaUsuario() throws LogicaImplException {

			try {
				List<ConfiguracionEmpresaUsuario> listaConfiguracionEmpresaUsuario = factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().findAll();

				if(listaConfiguracionEmpresaUsuario!=null && !listaConfiguracionEmpresaUsuario.isEmpty()){
					return listaConfiguracionEmpresaUsuario;
				}else {
					throw new LogicaImplException("No existe lista de Empresa");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}
		}
		
		/***************************************/
		/********Member Member Member **********/
		/***************************************/
		public Member crearMember(Member objMember) throws LogicaImplException {

			try {
				Timestamp tsInicial = new Timestamp(new Date().getTime());

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idMember").descending());

				Page<Member> pageIdMember = factorySeguridadDAO.getMemberRepository().findAll(pageByidDesc);

				Integer idMember = (!pageIdMember.isEmpty()) ? (Integer) pageIdMember.getContent().get(0).getIdMember() +1 : 1; 

				objMember.setIdMember(idMember);

				objMember.setIdGenero(buscarGeneroxNombre(objMember.getIdGenero()));

				objMember.setCreacionMember(tsInicial);

				factorySeguridadDAO.getMemberRepository().save(objMember);

				return buscarMember(objMember);

			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}
		}
		
		public Member buscarMember(Member objMember) throws LogicaImplException {
			
			try {
				/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
				Optional<Member> optPerMember = factorySeguridadDAO.getMemberRepository().findById(objMember.getIdMember());

				/***Si existe reemplazar por el nuevo*/
				if(optPerMember!=null && optPerMember.isPresent()){

					return optPerMember.get();

				}else {
					throw new LogicaImplException("No existe Member con identificador:" +objMember.getIdMember());
				}

			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}
		}
		
		public List<Member> listarTodoMember() throws LogicaImplException {

			try {
				List<Member> listaMember = factorySeguridadDAO.getMemberRepository().findAll();

				if(listaMember!=null && !listaMember.isEmpty()){
					return listaMember;
				}else {
					throw new LogicaImplException("No existe lista de Member");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

		}
		
		/***************************************/
		/********Perfil Perfil Perfil **********/
		/***************************************/
	
		public Perfil crearPerfil(ConfiguracionEmpresaUsuario configuracionEmpresaUsuario, Perfil objPerfil) throws LogicaImplException {

			

			String password = "";
			try {
				/**Obtener Configuracion de Empresa**/

				
				configuracionEmpresaUsuario = buscarConfiguracionEmpresaUsuarioxEmpresa(configuracionEmpresaUsuario);
				
				if(configuracionEmpresaUsuario.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
					password = ChapalaImpl.generarMD5(new ZapalaRequest(
							SSOUtilidades.crearListaCadenaCodigoPassword(objPerfil))).getCodigoGenerado(); 
				}
				
				Timestamp tsInicial = new Timestamp(new Date().getTime());

				Pageable pageByUsernameDesc = PageRequest.of(0, 1, Sort.by("usernamePerfil").descending());

				Page<Perfil> pageUsernameDesc  = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfil(
						objPerfil.getUsernamePerfil(), pageByUsernameDesc);

				Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombrePerfilLowerCase").descending());

				Page<Perfil> pageNombreDesc  = factorySeguridadDAO.getPerfilRepository().findByNombrePerfilLowerCase(
						objPerfil.getNombrePerfilLowerCase(), pageByNombreDesc);

				Pageable pageByEmailDesc = PageRequest.of(0, 1, Sort.by("emailPerfil").descending());

				Page<Perfil> pageEmailDesc  = factorySeguridadDAO.getPerfilRepository().findByEmailPerfil(
						objPerfil.getEmailPerfil().toLowerCase(), pageByEmailDesc);

				
				if(pageUsernameDesc.isEmpty() && pageNombreDesc.isEmpty() && pageEmailDesc.isEmpty()) {

					Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idPerfil").descending());

					Page<Perfil> pageIdPerfil = factorySeguridadDAO.getPerfilRepository().findAll(pageByidDesc);
					
					Integer idPerfil = (!pageIdPerfil.isEmpty()) ? (Integer) pageIdPerfil.getContent().get(0).getIdPerfil() +1 : 1; 

					objPerfil.setIdPerfil(idPerfil);
					objPerfil.setPasswordContrasenha((!"".equals(password)? password : objPerfil.getPasswordContrasenha()) );
					
					objPerfil.setUltimaAccionUsuario(tsInicial);
					objPerfil.setUltimaConexionPerfil(tsInicial);
					objPerfil.setPasswordUltimaActualizacion(tsInicial);
					objPerfil.setEstadoPerfilLastBloqueado(tsInicial);
					objPerfil.setEstadoUsuarioPerfil(true);

					factorySeguridadDAO.getPerfilRepository().save(objPerfil);

					return  buscarPerfilxUsername(objPerfil);

				}else {
					throw new LogicaImplException("No se puede crear Perfil, parametros ya existen en identificador valido");
				}


			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

		}
	
	
	public Perfil buscarPerfil(Perfil objPerfil) throws LogicaImplException {
		
		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Optional<Perfil> optPerPerfil = factorySeguridadDAO.getPerfilRepository().findById(objPerfil.getIdPerfil());

			/***Si existe reemplazar por el nuevo*/
			if(optPerPerfil!=null && optPerPerfil.isPresent()){

				return optPerPerfil.get();

			}else {
				throw new LogicaImplException("No existe Perfil con identificador:" +objPerfil.getIdPerfil());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public Perfil buscarPerfilxUsernamexPasswordContrasenha(Perfil objPerfil) throws LogicaImplException {

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Pageable pageByUsernameDesc = PageRequest.of(0, 1, Sort.by("usernamePerfil").descending());

			Page<Perfil> pageUsernameDesc  = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfil(
					objPerfil.getUsernamePerfil(), pageByUsernameDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
			... solo actualizar estado****/

			Perfil perPerfil  = (!pageUsernameDesc.isEmpty()) ? factorySeguridadDAO.getPerfilRepository().
					findByUsernamePerfilAndPasswordContrasenha(objPerfil.getUsernamePerfil(),  objPerfil.getPasswordContrasenha()) : null;

					if(perPerfil!=null) {
						return pageUsernameDesc.getContent().get(0);
					}
					else {
						throw new LogicaImplException("No existe Empresa con dominio:" +objPerfil.getUsernamePerfil());
					}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public Perfil buscarPerfilxUsername(Perfil objPerfil) throws LogicaImplException {

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Pageable pageByUsernameDesc = PageRequest.of(0, 1, Sort.by("usernamePerfil").descending());

			Page<Perfil> pageUsernameDesc  = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfil(
					objPerfil.getUsernamePerfil(), pageByUsernameDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
			... solo actualizar estado****/
			if(!pageUsernameDesc.isEmpty()){
				return pageUsernameDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objPerfil.getUsernamePerfil());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public List<Perfil> buscarPerfilxUsernameLike(Perfil objPerfil) throws LogicaImplException {

		try {

			List<Perfil> listaPerfil  = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfilLike(objPerfil.getUsernamePerfil());

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
			... solo actualizar estado****/
			if(listaPerfil!=null && !listaPerfil.isEmpty()){
				return listaPerfil;
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objPerfil.getUsernamePerfil());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}


	public Perfil buscarPerfilxEmail(Perfil objPerfil) throws LogicaImplException {

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Pageable pageByEmailDesc = PageRequest.of(0, 1, Sort.by("emailPerfil").descending());

			Page<Perfil> pageEmailDesc  = factorySeguridadDAO.getPerfilRepository().findByEmailPerfil(
					objPerfil.getUsernamePerfil(), pageByEmailDesc);
			
			if(!pageEmailDesc.isEmpty()){
				return pageEmailDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objPerfil.getUsernamePerfil());
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}


//	public Perfil buscarPerfilxOnlyUsernamePerfilModel(Perfil objPerfil) throws LogicaImplException {
//		
//		return null;
//	}
//
//
//	public Perfil buscarPerfilxOnlyNombreUsuarioPerfilModel(Perfil objPerfil) throws LogicaImplException {
//		
//		return null;
//	}

	
	public List<Perfil> listarTodoPerfil() throws LogicaImplException {

		try {
			List<Perfil> listaPerfil = factorySeguridadDAO.getPerfilRepository().findAll();

			if(listaPerfil!=null && !listaPerfil.isEmpty()){
				return listaPerfil;
			}else {
				throw new LogicaImplException("No existe lista de Perfil");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public List<Perfil> listarPerfilLikeUsernamePerfil(Perfil objPerfil) throws LogicaImplException {

		try {
			Pageable pageByUsernamePerfilDesc = PageRequest.of(0, 1, Sort.by("usernamePerfil").descending());
			
			Page<Perfil>  pageListaPerfil = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfilLike(objPerfil.getUsernamePerfil(), pageByUsernamePerfilDesc);

			if(!pageListaPerfil.getContent().isEmpty()){
				return pageListaPerfil.getContent();
			}else {
				throw new LogicaImplException("No existe lista de Perfil");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	/********************************************/
	/********Usuario Usuario Usuario ************/
	/********************************************/
	
	public Usuario generarCodigoUsuario(Usuario objUsuario) throws LogicaImplException{

		try {

			buscarMember(objUsuario.getIdMember());

			buscarPerfil(objUsuario.getIdPerfil());

			String codigoViaje = ChapalaImpl.generarCodigoByNumero(new ZapalaRequest(
					SSOUtilidades.crearListaCadenaCodigoUsuario(objUsuario))).getCodigoGenerado();  

			/**Buscar si el codigo existe*/
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("codigoUsuarioUnit").descending());

			Page<Usuario> pageCodigoDesc  = factorySeguridadDAO.getUsuarioRepository().findByCodigoUsuarioUnit(
					objUsuario.getCodigoUsuarioUnit(), pageByNombreDesc);

			if(pageCodigoDesc.isEmpty()) {

				objUsuario.setCodigoUsuarioUnit(codigoViaje);

				return objUsuario;

			}else {
				throw new LogicaImplException("No se puede crear codigo de viaje, datos de validacion erroneos");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public Usuario crearUsuario(Usuario objUsuario) throws LogicaImplException {
		


		try {
			
			if(ChapalaImpl.generarCodigoByNumero(new ZapalaRequest(
					SSOUtilidades.crearListaCadenaCodigoUsuario(objUsuario))).getCodigoGenerado().
					equals(objUsuario.getCodigoUsuarioUnit())) {
				
				Usuario metUsuario = factorySeguridadDAO.getUsuarioRepository().findByIdMemberAndIdPerfil(objUsuario.getIdMember() , objUsuario.getIdPerfil());

				if(metUsuario==null) {

					Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idUsuario").descending());

					Page<Usuario> pageIdUsuario = factorySeguridadDAO.getUsuarioRepository().findAll(pageByidDesc);

					Integer idUsuario = (!pageIdUsuario.isEmpty()) ? (Integer) pageIdUsuario.getContent().get(0).getIdUsuario() +1 : 1; 

					objUsuario.setIdUsuario(idUsuario);
					
					objUsuario.setIdMember(buscarMember(objUsuario.getIdMember()));
					
					objUsuario.setIdPerfil(buscarPerfil(objUsuario.getIdPerfil()));

					factorySeguridadDAO.getUsuarioRepository().save(objUsuario);

					return buscarUsuarioxCodigo(objUsuario);

				}else {
					throw new LogicaImplException("No se puede crear Usuario, parametros ya existen en identificador valido");
				}

			}else {
				throw new LogicaImplException("No se puede crear Usuario, codigo de usuario no corresponde");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public Usuario buscarUsuarioxCodigo(Usuario objUsuario) throws LogicaImplException {

		try {
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("codigoUsuarioUnit").descending());

			Page<Usuario> pageCodigoDesc  = factorySeguridadDAO.getUsuarioRepository().findByCodigoUsuarioUnit(
					objUsuario.getCodigoUsuarioUnit(), pageByNombreDesc);
			
			if(!pageCodigoDesc.isEmpty()){
				return pageCodigoDesc.getContent().get(0);
			}
			else {
				throw new LogicaImplException("No existe Usuario con codigo:" +objUsuario.getCodigoUsuarioUnit());
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
	}
	
	public List<Usuario> listarTodoUsuario() throws LogicaImplException {

		try {
			List<Usuario> listaUsuario = factorySeguridadDAO.getUsuarioRepository().findAll();

			if(listaUsuario!=null && !listaUsuario.isEmpty()){
				return listaUsuario;
			}else {
				throw new LogicaImplException("No existe lista de Usuario");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	/****************************************************/
	/********AplicacionRol AplicacionRol AplicacionRol***/
	/****************************************************/
	public AplicacionRol crearAplicacionRol(AplicacionRol objAplicacionRol) throws LogicaImplException {

		try {
			
			AplicacionRol metAplicacionRol = factorySeguridadDAO.getAplicacionRolRepository().findByIdAplicacionAndIdRol(buscarAplicacionxUriRuta(objAplicacionRol.getIdAplicacion()), buscarRolxNombre(objAplicacionRol.getIdRol()));

			if(metAplicacionRol==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAplicacionRol").descending());

				Page<AplicacionRol> pageIdAplicacionRol = factorySeguridadDAO.getAplicacionRolRepository().findAll(pageByidDesc);

				Integer idAplicacionRol = (!pageIdAplicacionRol.isEmpty()) ? (Integer) pageIdAplicacionRol.getContent().get(0).getIdAplicacionRol() +1 : 1; 

				objAplicacionRol.setIdAplicacionRol(idAplicacionRol);

				objAplicacionRol.setEstadoAplicacionRol(true);

				factorySeguridadDAO.getAplicacionRolRepository().save(objAplicacionRol);

				return buscarAplicacionRolxAplicacionxRol(objAplicacionRol);

			}else {
				throw new LogicaImplException("No se puede crear AplicacionRol, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	

	public AplicacionRol buscarAplicacionRolxAplicacionxRol(AplicacionRol objAplicacionRol)
			throws LogicaImplException {

		try {
			objAplicacionRol = factorySeguridadDAO.getAplicacionRolRepository().findByIdAplicacionAndIdRol(objAplicacionRol.getIdAplicacion(), objAplicacionRol.getIdRol());

			if(objAplicacionRol.getEstadoAplicacionRol()) {
				return objAplicacionRol;
			}else {
				throw new LogicaImplException("No se puede crear AplicacionRol, parametros no existen en un identificador valido");
			}
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	@Override
	public List<AplicacionRol> listarTodoAplicacionRol() throws LogicaImplException {
		
		try {
			List<AplicacionRol> listaAplicacionRol = factorySeguridadDAO.getAplicacionRolRepository().findAll();

			if(listaAplicacionRol!=null && !listaAplicacionRol.isEmpty()){
				return listaAplicacionRol;
			}else {
				throw new LogicaImplException("No existe lista de AplicacionRol");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	/****************************************************/
	/********Identificador Identificador Identificador***/
	/****************************************************/
	
	public Identificador crearIdentificador(Identificador objIdentificador) throws LogicaImplException {

		try {

			Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idIdentificador").descending());

			Page<Identificador> pageIdIdentificador = factorySeguridadDAO.getIdentificadorRepository().findAll(pageByidDesc);

			Integer idIdentificador = (!pageIdIdentificador.isEmpty()) ? (Integer) pageIdIdentificador.getContent().get(0).getIdIdentificador() +1 : 1;

			objIdentificador.setIdIdentificador(idIdentificador);

			objIdentificador.setIdMember(buscarMember(objIdentificador.getIdMember()));

			factorySeguridadDAO.getIdentificadorRepository().save(objIdentificador);

			return buscarIdentificadorxValuexPais(objIdentificador);

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}


	public Identificador buscarIdentificadorxValuexPais(Identificador objIdentificador) throws LogicaImplException {

		try {
			objIdentificador = factorySeguridadDAO.getIdentificadorRepository().findByValueIdentificadorAndNombreIdentificadorAndCodigoPaisPortal
					(objIdentificador.getValueIdentificador(), objIdentificador.getNombreIdentificador(), objIdentificador.getCodigoPaisPortal());

			if(objIdentificador!=null && objIdentificador.getIdIdentificador()>0) {
				/**Enviar Formateado el RUT*/
//				objIdentificador.setValueIdentificador(sssoUtilidadImpl.generarPatronRUT(objIdentificador.getValueIdentificador()));
				
				return objIdentificador;
			}
			else {
				throw new LogicaImplException("No existe Identificador con value:" +objIdentificador.getValueIdentificador()+"- y nombre:"+objIdentificador.getNombreIdentificador());
			}
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	/****************************************************/
	/********AccionPerfil AccionPerfil AccionPerfil *****/
	/****************************************************/
	public FotoPerfil crearFotoPerfil(FotoPerfil objFotoPerfil) throws LogicaImplException {
		
		return null;
	}
	
	/****************************************************/
	/********AccionPerfil AccionPerfil AccionPerfil *****/
	/****************************************************/
	
	public AccionPerfil crearAccionPerfil(AccionPerfil objAccionPerfil)  throws LogicaImplException {

		try {
			Timestamp tsInicial = new Timestamp(new Date().getTime());
			
			buscarPerfilxUsername(objAccionPerfil.getIdPerfil());

			buscarTipoAccionPerfil(objAccionPerfil.getIdTipoAccionPerfil());

			Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAccionPerfil").descending());

			Page<AccionPerfil> pageIdAccionPerfil = factorySeguridadDAO.getAccionPerfilRepository().findAll(pageByidDesc);

			Integer idAccionPerfil = (!pageIdAccionPerfil.isEmpty()) ? (Integer) pageIdAccionPerfil.getContent().get(0).getIdAccionPerfil() +1 : 1;

			objAccionPerfil.setIdAccionPerfil(idAccionPerfil);

			objAccionPerfil.setIdTipoAccionPerfil(buscarTipoAccionPerfil(objAccionPerfil.getIdTipoAccionPerfil()));

			objAccionPerfil.setIdPerfil(buscarPerfilxUsername(objAccionPerfil.getIdPerfil()));
			
			objAccionPerfil.setUltimaAccionPerfil(tsInicial);
			
			factorySeguridadDAO.getAccionPerfilRepository().save(objAccionPerfil);

			return buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(objAccionPerfil);

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}


	}
	
	public AccionPerfil buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(AccionPerfil objAccionPerfil)
			throws LogicaImplException {

		try {
			objAccionPerfil = factorySeguridadDAO.getAccionPerfilRepository().findByidPerfilAndIdTipoAccionPerfilAndKeyAccionPerfil
					(objAccionPerfil.getIdPerfil(), objAccionPerfil.getIdTipoAccionPerfil(), objAccionPerfil.getKeyAccionPerfil());

			if(objAccionPerfil.getIdAccionPerfil()>0) {
				return objAccionPerfil;
			}
			else {
				throw new LogicaImplException("No existe AccionPerfil con tipo accion:" +objAccionPerfil.getIdTipoAccionPerfil()+"- y key:"+objAccionPerfil.getKeyAccionPerfil());
			}
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	/*******************************************************/
	/********MaquinaEmpresa MaquinaEmpresa MaquinaEmpresa***/
	/*******************************************************/
	public MaquinaEmpresa crearMaquinaEmpresa(MaquinaEmpresa objMaquinaEmpresa) throws LogicaImplException {

		try {

			buscarEmpresa(objMaquinaEmpresa.getIdEmpresa());

			MaquinaEmpresa metMaquinaEmpresa = factorySeguridadDAO.getMaquinaEmpresaRepository().findByIdMaquinaAndIdEmpresa(objMaquinaEmpresa.getIdMaquina(), objMaquinaEmpresa.getIdEmpresa());

			if(metMaquinaEmpresa==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idMaquinaEmpresa").descending());

				Page<MaquinaEmpresa> pageIdMaquinaEmpresa = factorySeguridadDAO.getMaquinaEmpresaRepository().findAll(pageByidDesc);

				Integer idMaquinaEmpresa = (!pageIdMaquinaEmpresa.isEmpty()) ? (Integer) pageIdMaquinaEmpresa.getContent().get(0).getIdMaquinaEmpresa() +1 : 1;

				objMaquinaEmpresa.setIdMaquinaEmpresa(idMaquinaEmpresa);

				objMaquinaEmpresa.setIdEmpresa(buscarEmpresa(objMaquinaEmpresa.getIdEmpresa()));

				objMaquinaEmpresa.setIdMaquina(objMaquinaEmpresa.getIdMaquina());

				factorySeguridadDAO.getMaquinaEmpresaRepository().save(objMaquinaEmpresa);

				return objMaquinaEmpresa;
			}else {
				throw new LogicaImplException("No existe MaquinaEmpresa con maquina:" +objMaquinaEmpresa.getIdMaquina()+"- y empresa:"+objMaquinaEmpresa.getIdEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}

	public List<MaquinaEmpresa> listarMaquinaEmpresaxEmpresa(MaquinaEmpresa objMaquinaEmpresa)
			throws LogicaImplException {
		try {

			buscarEmpresa(objMaquinaEmpresa.getIdEmpresa());

			List<MaquinaEmpresa> listaMaquinaEmpresa = factorySeguridadDAO.getMaquinaEmpresaRepository().findByIdEmpresa(objMaquinaEmpresa.getIdEmpresa());

			if(listaMaquinaEmpresa!=null && !listaMaquinaEmpresa.isEmpty()) {
				return listaMaquinaEmpresa;
			}else {
				throw new LogicaImplException("No existe lista MaquinaEmpresa con empresa:" +objMaquinaEmpresa.getIdEmpresa());
			}
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}

	/*****************************************************************/
	/********AplicacionEmpresa AplicacionEmpresa AplicacionEmpresa ***/
	/*****************************************************************/
	public AplicacionEmpresa crearAplicacionEmpresa(AplicacionEmpresa objAplicacionEmpresa)
			throws LogicaImplException {

		

		try {
			buscarEmpresaxNombre(objAplicacionEmpresa.getIdEmpresa());

			buscarAplicacionxUriRuta(objAplicacionEmpresa.getIdAplicacion());
			
			AplicacionEmpresa metAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().findByIdAplicacionAndIdEmpresa(objAplicacionEmpresa.getIdAplicacion(), objAplicacionEmpresa.getIdEmpresa());
			
			if(metAplicacionEmpresa==null) {
				
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAplicacionEmpresa").descending());

				Page<AplicacionEmpresa> pageIdAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().findAll(pageByidDesc);

				Integer idAplicacionEmpresa = (!pageIdAplicacionEmpresa.isEmpty()) ? (Integer) pageIdAplicacionEmpresa.getContent().get(0).getIdAplicacionEmpresa() +1 : 1;

				objAplicacionEmpresa.setIdAplicacionEmpresa(idAplicacionEmpresa);

				objAplicacionEmpresa.setEstadoAplicacionEmpresa(true);

				factorySeguridadDAO.getAplicacionEmpresaRepository().save(objAplicacionEmpresa);

				return buscarAplicacionEmpresaxAplicacionxEmpresa(objAplicacionEmpresa);

			}else {
				throw new LogicaImplException("No se puede crear AplicacionEmpresa, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public AplicacionEmpresa buscarAplicacionEmpresaxAplicacionxEmpresa(AplicacionEmpresa objAplicacionEmpresa) throws LogicaImplException {

		try {
			objAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().findByIdAplicacionAndIdEmpresa(
					objAplicacionEmpresa.getIdAplicacion(), objAplicacionEmpresa.getIdEmpresa());

			if(objAplicacionEmpresa != null && objAplicacionEmpresa.getIdAplicacionEmpresa() != null) {
				return objAplicacionEmpresa;
			}else {
				throw new LogicaImplException("No se puede crear AplicacionEmpresa, parametros no existen en identificador valido");
			}
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public List<AplicacionEmpresa> listarAplicacionEmpresaxEmpresa(AplicacionEmpresa objAplicacionEmpresa)
			throws LogicaImplException {

		try {

			List<AplicacionEmpresa> listaAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().
					findByIdEmpresa(objAplicacionEmpresa.getIdEmpresa());

			if(listaAplicacionEmpresa!=null && !listaAplicacionEmpresa.isEmpty()) {
				return listaAplicacionEmpresa;
			}else {
				throw new LogicaImplException("No se puede crear lista de AplicacionEmpresa, parametros no existen en identificador valido");
			}
			/*****Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.****/

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public List<AplicacionEmpresa> listarTodoAplicacionEmpresa() throws LogicaImplException {
		
		try {
			List<AplicacionEmpresa> listaAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().findAll();

			if(listaAplicacionEmpresa!=null && !listaAplicacionEmpresa.isEmpty()){
				return listaAplicacionEmpresa;
			}else {
				throw new LogicaImplException("No existe lista de AplicacionEmpresa");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	
	
	/*****************************************************************/
	/********EmpresaUsuario EmpresaUsuario EmpresaUsuario ************/
	/*****************************************************************/
	
	public EmpresaUsuario crearEmpresaUsuario(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException {

		try {
			
			EmpresaUsuario metEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findByIdEmpresaAndIdUsuarioAndIdRol(
					buscarEmpresaxNombre(objEmpresaUsuario.getIdEmpresa()), buscarUsuarioxCodigo(objEmpresaUsuario.getIdUsuario()), buscarRolxNombre(objEmpresaUsuario.getIdRol()));

			if(metEmpresaUsuario==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idEmpresaUsuario").descending());

				Page<EmpresaUsuario> pageIdEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findAll(pageByidDesc);

				Integer idEmpresaUsuario = (!pageIdEmpresaUsuario.isEmpty()) ? (Integer) pageIdEmpresaUsuario.getContent().get(0).getIdEmpresaUsuario() +1 : 1;

				objEmpresaUsuario.setIdEmpresaUsuario(idEmpresaUsuario);

				objEmpresaUsuario.setEstadoEmpresaUsuario(true);

				factorySeguridadDAO.getEmpresaUsuarioRepository().save(objEmpresaUsuario);

				return buscarEmpresaUsuarioxEmpresaxUsuarioxRol(objEmpresaUsuario);

			}else {
				throw new LogicaImplException("No se puede crear Perfil, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public EmpresaUsuario buscarEmpresaUsuario(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException {
		
		return null;
	}
	
	/**Id, Id, Id****/
	public EmpresaUsuario buscarEmpresaUsuarioxEmpresaxUsuarioxRol(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException {

		try {

			buscarEmpresaxNombre(objEmpresaUsuario.getIdEmpresa());

			buscarUsuarioxCodigo(objEmpresaUsuario.getIdUsuario());

			buscarRolxNombre(objEmpresaUsuario.getIdRol());

			objEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findByIdEmpresaAndIdUsuarioAndIdRol(
					objEmpresaUsuario.getIdEmpresa(), objEmpresaUsuario.getIdUsuario(), objEmpresaUsuario.getIdRol());

			if(objEmpresaUsuario!=null) {
				return objEmpresaUsuario;
			}else {
				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public List<EmpresaUsuario> listarEmpresaUsuarioxEmpresa(EmpresaUsuario objEmpresaUsuario)  throws LogicaImplException {

		try {

			buscarEmpresa(objEmpresaUsuario.getIdEmpresa());

			List<EmpresaUsuario> listaEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findByIdEmpresa(
					objEmpresaUsuario.getIdEmpresa());

			if(listaEmpresaUsuario!=null && !listaEmpresaUsuario.isEmpty()) {
				return listaEmpresaUsuario;
			}else {
				throw new LogicaImplException("No existe Lista EmpresaUsuario con estos parametros:");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		
	}
	
	public List<EmpresaUsuario> listarEmpresaUsuarioxEmpresaxRol(EmpresaUsuario objEmpresaUsuario)  throws LogicaImplException {

		try {

			buscarEmpresa(objEmpresaUsuario.getIdEmpresa());

			buscarRolxNombre(objEmpresaUsuario.getIdRol());

			List<EmpresaUsuario> listaEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findByIdEmpresaAndIdRol(
					objEmpresaUsuario.getIdEmpresa(),  objEmpresaUsuario.getIdRol());

			if(listaEmpresaUsuario!=null && !listaEmpresaUsuario.isEmpty()) {
				return listaEmpresaUsuario;
			}else {
				throw new LogicaImplException("No existe Lista EmpresaUsuario con empresa:"+objEmpresaUsuario.getIdEmpresa()+" y rol "+objEmpresaUsuario.getIdRol());
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	@Override
	public List<EmpresaUsuario> listarTodoEmpresaUsuario() throws LogicaImplException {
		
		try {
			List<EmpresaUsuario> listaEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findAll();

			if(listaEmpresaUsuario!=null && !listaEmpresaUsuario.isEmpty()){
				return listaEmpresaUsuario;
			}else {
				throw new LogicaImplException("No existe lista de EmpresaUsuario");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	/*****************************************************************/
	/********AplicacionServicio AplicacionServicio AplicacionServicio*/
	/*****************************************************************/
	public AplicacionServicio crearAplicacionServicio(AplicacionServicio objAplicacionServicio)
			throws LogicaImplException {

		try {

			AplicacionServicio metAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().findByIdAplicacionAndUriRutaAplicacionAndUriRutaAplicacionProductoAndUriRutaAplicacionProductoServicioAndMetodoHttp(
					buscarAplicacionxUriRuta(objAplicacionServicio.getIdAplicacion()),
					objAplicacionServicio.getUriRutaAplicacion(), objAplicacionServicio.getUriRutaAplicacionProducto(),
					objAplicacionServicio.getUriRutaAplicacionProductoServicio(), objAplicacionServicio.getMetodoHttp());

			if(metAplicacionServicio == null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAplicacionServicio").descending());

				Page<AplicacionServicio> pageIdAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().findAll(pageByidDesc);

				Integer idAplicacionServicio = (!pageIdAplicacionServicio.isEmpty()) ? (Integer) pageIdAplicacionServicio.getContent().get(0).getIdAplicacionServicio() +1 : 1;

				objAplicacionServicio.setIdAplicacionServicio(idAplicacionServicio);

				objAplicacionServicio.setEstadoAplicacionServicio(true);

				factorySeguridadDAO.getAplicacionServicioRepository().save(objAplicacionServicio);

				return buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(objAplicacionServicio);

			}else {
				throw new LogicaImplException("No se puede crear AplicacionServicio, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public AplicacionServicio buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp( AplicacionServicio objAplicacionServicio) throws LogicaImplException {

		try {

			buscarAplicacionxUriRuta(objAplicacionServicio.getIdAplicacion());

			objAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().
					findByIdAplicacionAndUriRutaAplicacionAndUriRutaAplicacionProductoAndUriRutaAplicacionProductoServicioAndMetodoHttp(
							objAplicacionServicio.getIdAplicacion(), objAplicacionServicio.getUriRutaAplicacion(), 
							objAplicacionServicio.getUriRutaAplicacionProducto(),
							objAplicacionServicio.getUriRutaAplicacionProductoServicio(), objAplicacionServicio.getMetodoHttp());

			if(objAplicacionServicio!=null) {

				return objAplicacionServicio;

			}else {
				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}


	public List<AplicacionServicio> listarAplicacionServicioxAplicacion(AplicacionServicio objAplicacionServicio) throws LogicaImplException {

		try {

			buscarAplicacionxUriRuta(objAplicacionServicio.getIdAplicacion());

			List<AplicacionServicio> listaAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().
					findByIdAplicacion(objAplicacionServicio.getIdAplicacion());

			if(listaAplicacionServicio!=null && !listaAplicacionServicio.isEmpty()) {

				return listaAplicacionServicio;

			}else {

				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");

			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public List<AplicacionServicio> listarTodoAplicacionServicio() throws LogicaImplException {

		try {
			List<AplicacionServicio> listaAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().findAll();

			if(listaAplicacionServicio!=null && !listaAplicacionServicio.isEmpty()){
				return listaAplicacionServicio;
			}else {
				throw new LogicaImplException("No existe lista de Empresa");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}

	
	/****************************************************************************/
	/********EmpresaUsuarioAplicacionEmpresa EmpresaUsuarioAplicacionEmpresa ****/
	/****************************************************************************/
	
	public EmpresaUsuarioAplicacionEmpresa crearEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEUAE)
			throws LogicaImplException {

		try {

			EmpresaUsuarioAplicacionEmpresa metEUAE = factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().
					findByIdEmpresaUsuarioAndIdAplicacionEmpresa(buscarEmpresaUsuarioxEmpresaxUsuarioxRol(objEUAE.getIdEmpresaUsuario()), 
							buscarAplicacionEmpresaxAplicacionxEmpresa(objEUAE.getIdAplicacionEmpresa()));

			if(metEUAE==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idEmpresaUsuarioAplicacionEmpresa").descending());

				Page<EmpresaUsuarioAplicacionEmpresa> pageIdEUAE = factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().findAll(pageByidDesc);

				Integer idEUAE = (!pageIdEUAE.isEmpty()) ? (Integer) pageIdEUAE.getContent().get(0).getIdEmpresaUsuarioAplicacionEmpresa() +1 : 1;

				objEUAE.setIdEmpresaUsuarioAplicacionEmpresa(idEUAE);

				objEUAE.setEstadoEmpresaUsuarioAplicacionEmpresa(true);

				factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().save(objEUAE);

				return buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(objEUAE);

			}else {
				throw new LogicaImplException("No se puede crear EUAE, Aplicacion no existe");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public EmpresaUsuarioAplicacionEmpresa buscarEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEUAE)
			throws LogicaImplException {
		
		return null;
	}
	
	public EmpresaUsuarioAplicacionEmpresa buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException {

		try {

			objEUAE = factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().findByIdEmpresaUsuarioAndIdAplicacionEmpresa(
					buscarEmpresaUsuarioxEmpresaxUsuarioxRol(objEUAE.getIdEmpresaUsuario()), buscarAplicacionEmpresaxAplicacionxEmpresa(objEUAE.getIdAplicacionEmpresa()));

			if(objEUAE != null) {
				return objEUAE;
			}else {
				throw new LogicaImplException("No existe EmpresaUsuarioAplicacionEmpresa con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	
	public List<EmpresaUsuarioAplicacionEmpresa> listarEmpresaUsuarioAplicacionEmpresaxEU(EmpresaUsuarioAplicacionEmpresa objEUAE)
			throws LogicaImplException {
		try {

			List<EmpresaUsuarioAplicacionEmpresa> listaEmpresaUsuarioAplicacionEmpresa = factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().
					findByIdEmpresaUsuario(buscarEmpresaUsuarioxEmpresaxUsuarioxRol(objEUAE.getIdEmpresaUsuario()));

			if(listaEmpresaUsuarioAplicacionEmpresa!=null && !listaEmpresaUsuarioAplicacionEmpresa.isEmpty()) {

				return listaEmpresaUsuarioAplicacionEmpresa;

			}else {
				throw new LogicaImplException("No existe EmpresaUsuarioAplicacionEmpresa con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	public List<EmpresaUsuarioAplicacionEmpresa> listarTodoEmpresaUsuarioAplicacionEmpresa()
			throws LogicaImplException {
		
		try {
			List<EmpresaUsuarioAplicacionEmpresa> listaEmpresaUsuarioAplicacionEmpresa = 
					factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().findAll();

			if(listaEmpresaUsuarioAplicacionEmpresa!=null && !listaEmpresaUsuarioAplicacionEmpresa.isEmpty()){
				return listaEmpresaUsuarioAplicacionEmpresa;
			}else {
				throw new LogicaImplException("No existe lista de Empresa");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}
	
	/****************************************************************************/
	/********EmpresaUsuarioAplicacionEmpresa EmpresaUsuarioAplicacionEmpresa ****/
	/****************************************************************************/
	
	public SeguridadAplicacionAcceso crearSeguridadAplicacionAcceso(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso)
			throws LogicaImplException {

		try {

			SeguridadAplicacionAcceso metSAA = factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().findByIdEmpresaUsuarioAplicacionEmpresaAndIdAplicacionServicio(
					buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(objSeguridadAplicacionAcceso.getIdEmpresaUsuarioAplicacionEmpresa()),
					buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(objSeguridadAplicacionAcceso.getIdAplicacionServicio()));
			
			if(metSAA == null) {
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idSeguridadAplicacionAcceso").descending());

				Page<SeguridadAplicacionAcceso> pageIdSAA = factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().findAll(pageByidDesc);

				Integer idSeguridadAplicacionAcceso = (!pageIdSAA.isEmpty()) ? (Integer) pageIdSAA.getContent().get(0).getIdSeguridadAplicacionAcceso() +1 : 1;

				objSeguridadAplicacionAcceso.setIdSeguridadAplicacionAcceso(idSeguridadAplicacionAcceso);

				objSeguridadAplicacionAcceso.setEstadoSeguridadAplicacionAcceso(true);

				factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().save(objSeguridadAplicacionAcceso);

				return objSeguridadAplicacionAcceso;
			}else {
				throw new LogicaImplException("No se puede crear SeguridadAplicacionAcceso, parametros ya existen");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

	}
	
	public List<SeguridadAplicacionAcceso> listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws LogicaImplException {

		try {

			
			buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(objSeguridadAplicacionAcceso.getIdEmpresaUsuarioAplicacionEmpresa());
				
			buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(objSeguridadAplicacionAcceso.getIdAplicacionServicio());
			
			
			List<AplicacionServicio> listaAplicacionServicio = new ArrayList<AplicacionServicio>();
			listaAplicacionServicio.add(objSeguridadAplicacionAcceso.getIdAplicacionServicio());
			
			List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso = factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().
							findByIdEmpresaUsuarioAplicacionEmpresaAndIdAplicacionServicioInAndEstadoSeguridadAplicacionAcceso
							(objSeguridadAplicacionAcceso.getIdEmpresaUsuarioAplicacionEmpresa(), 
							listaAplicacionServicio, 
							objSeguridadAplicacionAcceso.getEstadoSeguridadAplicacionAcceso());

			if(listaSeguridadAplicacionAcceso!=null && !listaSeguridadAplicacionAcceso.isEmpty()) {
				return listaSeguridadAplicacionAcceso;
			}else {
				throw new LogicaImplException("No existe SeguridadAplicacionAcceso con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}

	public SeguridadAplicacionAcceso buscarSeguridadAplicacionAcceso(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso)
			throws LogicaImplException {
		
		return null;
	}




	@Override
	public List<SeguridadAplicacionAcceso> listarTodoSeguridadAplicacionAcceso() throws LogicaImplException {
		// TODO Auto-generated method stub
		try {
			List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso = 
					factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().findAll();

			if(listaSeguridadAplicacionAcceso!=null && !listaSeguridadAplicacionAcceso.isEmpty()){
				return listaSeguridadAplicacionAcceso;
			}else {
				throw new LogicaImplException("No existe lista de SeguridadAplicacionAcceso");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
	}

	

}
