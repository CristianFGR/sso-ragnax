package com.ragnax.ssorepositorio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

import com.ragnax.domain.response.error.RagnaxError;
import com.ragnax.domain.sso.entidad.*;
import com.ragnax.ssorepositorio.exception.LogicaImplException;
import com.ragnax.ssorepositorio.servicio.SSOService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;

@RestController
@RequestMapping
//@RefreshScope
public class SSOController {
	
	/**TODO Para usar el commons por el momento es necesario hacer esta Wea**/
	@Autowired
	SSOService ssoService;
	
	@GetMapping(value = "/pruebaSSO", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rol>  buscarTipoMoneda()  throws LogicaImplException{

		return new ResponseEntity<>(new Rol("pruebaRol"), HttpStatus.OK);

	}
	/***************************************************/
	/*************** Rol  ******************************/
	/***************************************************/
	@ApiOperation(value = "buscarRolxNombre", response = Rol.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Rol.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarRolxNombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rol>  buscarRolxNombre(@ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Rol objRol, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarRolxNombre(objRol), HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "buscarAplicacionxUriRuta", response = Aplicacion.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Aplicacion.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAplicacionxUriRuta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aplicacion>  buscarAplicacionxUriRuta(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Aplicacion objAplicacion, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarAplicacionxUriRuta(objAplicacion),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarMaquinaxDireccionIpMaquina", response = Maquina.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Maquina.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarMaquinaxDireccionIpMaquina}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Maquina>  buscarMaquinaxDireccionIpMaquina(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Maquina objMaquina, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarMaquinaxDireccionIpMaquina(
				objMaquina), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarEmpresa", response = Empresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Empresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa>  buscarEmpresa(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Empresa objEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarEmpresa(
				objEmpresa), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarEmpresaxDominio", response = Empresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Empresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarEmpresaxDominio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa>  buscarEmpresaxDominio(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Empresa objEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarEmpresaxDominio(
				objEmpresa), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarPerfilxUsername", response = Perfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Perfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarPerfilxUsername}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil>  buscarPerfilxUsername(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Perfil objPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarPerfilxUsername(objPerfil),HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarPerfilxUsernamexPasswordContrasenha", response = Perfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Perfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarPerfilxUsernamexPasswordContrasenha}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil>  buscarPerfilxUsernamexPasswordContrasenha(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Perfil objPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		

		return new ResponseEntity<>(ssoService.buscarPerfilxUsernamexPasswordContrasenha(
				objPerfil), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarPerfilxEmail", response = Perfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Perfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarPerfilxEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil>  buscarPerfilxEmail(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Perfil objPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarPerfilxEmail(objPerfil), HttpStatus.OK);
	}
	
//	Seguridad buscarPerfilxOnlyUsernamePerfilModel(Perfil objPerfil) throws LogicaImplException;
//	
//	Seguridad buscarPerfilxOnlyNombreUsuarioPerfilModel(Perfil objPerfil) throws LogicaImplException;
	
	@ApiOperation(value = "buscarGeneroxNombre", response = Genero.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Genero.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarGeneroxNombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genero>  buscarGeneroxNombre(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Genero objGenero, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarGeneroxNombre(objGenero), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarTipoAccionPerfil", response = TipoAccionPerfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoAccionPerfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarTipoAccionPerfil}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAccionPerfil>  buscarTipoAccionPerfil(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoAccionPerfil objTipoAccionPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarTipoAccionPerfil(objTipoAccionPerfil), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarTipoAccionPerfil", response = TipoAccionPerfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoAccionPerfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarTipoAccionPerfil}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoAccionPerfil>> listarTipoAccionPerfil(  @ApiParam(value = "objeto de entrada", required = true) 
		@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.listarTodoTipoAccionPerfil(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAplicacionRolxAplicacionxRol", response = AplicacionRol.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AplicacionRol.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAplicacionRolxAplicacionxRol}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AplicacionRol>  buscarAplicacionRolxAplicacionxRol(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AplicacionRol objAplicacionRol, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarAplicacionRolxAplicacionxRol(
				objAplicacionRol),  HttpStatus.OK);
	}
	
	@ApiOperation(value = "crearMember", response = Member.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Member.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearMember}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Member>  crearMember(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Member objMember, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.crearMember(objMember), HttpStatus.OK);
	}
	
	@ApiOperation(value = "crearIdentificador", response = Identificador.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Identificador.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearIdentificador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Identificador>  crearIdentificador(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Identificador objIdentificador, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.crearIdentificador(
				objIdentificador), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarIdentificadorxValuexPais", response = Identificador.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Identificador.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarIdentificadorxValuexPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Identificador>  buscarIdentificadorxValuexPais(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Identificador objIdentificador, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarIdentificadorxValuexPais(
				objIdentificador), HttpStatus.OK);
	}
	
	@ApiOperation(value = "crearAccionPerfil", response = AccionPerfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AccionPerfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearAccionPerfil}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccionPerfil>  crearAccionPerfil(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AccionPerfil objAccionPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.crearAccionPerfil(objAccionPerfil), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAccionPerfilxPerfilxTipoAccionxKeyAccion", response = AccionPerfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AccionPerfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAccionPerfilxPerfilxTipoAccionxKeyAccion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccionPerfil>  buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AccionPerfil objAccionPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(
				objAccionPerfil), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarMaquinaEmpresaxEmpresa", response = MaquinaEmpresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = MaquinaEmpresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarMaquinaEmpresaxEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaquinaEmpresa>> listarMaquinaEmpresaxEmpresa(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid MaquinaEmpresa objMaquinaEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.listarMaquinaEmpresaxEmpresa(
				objMaquinaEmpresa), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAplicacionEmpresaxAplicacionxEmpresa", response = AplicacionEmpresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AplicacionEmpresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAplicacionEmpresaxAplicacionxEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AplicacionEmpresa>  buscarAplicacionEmpresaxAplicacionxEmpresa(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AplicacionEmpresa objAplicacionEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarAplicacionEmpresaxAplicacionxEmpresa(objAplicacionEmpresa), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarConfiguracionEmpresaUsuarioxEmpresa", response = ConfiguracionEmpresaUsuario.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ConfiguracionEmpresaUsuario.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarConfiguracionEmpresaUsuarioxEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConfiguracionEmpresaUsuario>  buscarConfiguracionEmpresaUsuarioxEmpresa(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarConfiguracionEmpresaUsuarioxEmpresa(
				objConfiguracionEmpresaUsuario), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarUsuarioxCodigo", response = Usuario.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Usuario.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarUsuarioxCodigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario>  buscarUsuarioxCodigo(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Usuario objUsuario, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarUsuarioxCodigo(objUsuario), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarEmpresaUsuarioxEmpresaxUsuarioxRol", response = EmpresaUsuario.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EmpresaUsuario.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarEmpresaUsuarioxEmpresaxUsuarioxRol}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaUsuario>  buscarEmpresaUsuarioxEmpresaxUsuarioxRol(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid EmpresaUsuario objEmpresaUsuario, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarEmpresaUsuarioxEmpresaxUsuarioxRol(
				objEmpresaUsuario), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarEmpresaUsuarioxEmpresaxRol", response = EmpresaUsuario.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EmpresaUsuario.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarEmpresaUsuarioxEmpresaxRol}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpresaUsuario>>  listarEmpresaUsuarioxEmpresaxRol(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid EmpresaUsuario objEmpresaUsuario, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.listarEmpresaUsuarioxEmpresaxRol(
				objEmpresaUsuario),  HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp", response = AplicacionServicio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AplicacionServicio.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AplicacionServicio>  buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AplicacionServicio objAplicacionServicio, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(
				objAplicacionServicio), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarAplicacionServicioxAplicacion", response = AplicacionServicio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AplicacionServicio.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarAplicacionServicioxAplicacion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AplicacionServicio>>  listarAplicacionServicioxAplicacion(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AplicacionServicio objAplicacionServicio, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.listarAplicacionServicioxAplicacion(
				objAplicacionServicio), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarEmpresaUsuarioAplicacionEmpresaxEUxAE", response = EmpresaUsuarioAplicacionEmpresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EmpresaUsuarioAplicacionEmpresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarEmpresaUsuarioAplicacionEmpresaxEUxAE}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaUsuarioAplicacionEmpresa>  buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid EmpresaUsuarioAplicacionEmpresa objEmpresaUsuarioAplicacionEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(
				objEmpresaUsuarioAplicacionEmpresa), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio", response = SeguridadAplicacionAcceso.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = SeguridadAplicacionAcceso.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SeguridadAplicacionAcceso>>  listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid SeguridadAplicacionAcceso objSeguridadAplicacionAcceso, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(ssoService.listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(
				objSeguridadAplicacionAcceso), HttpStatus.OK);
	}

}
