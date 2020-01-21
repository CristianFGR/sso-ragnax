package com.ragnax.ssorepositorio;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ragnax.domain.sso.entidad.*;
import com.ragnax.domain.zapala.modelo.Zapala;
import com.ragnax.domain.zapala.modelo.ZapalaRequest;
import com.ragnax.ssorepositorio.exception.LogicaImplException;
import com.ragnax.ssorepositorio.servicio.SSOService;
import com.ragnax.ssorepositorio.servicio.clientes.ZapalaClienteRest;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class CrearDataSsoRepositorioTests {

	@Autowired
	private SSOService ssoService;
	
//	@Autowired
//	private ZapalaClienteRest zapalaClienteRest;

	@DisplayName("Test Junit 5 + Spring @Autowired Integration")
	@Test
	public void llenarTablasByNegocioComponent() throws LogicaImplException{
		//	/**********************************************************
		crearGeneroNegocio();
		crearRolNegocio();
		crearTipoAccionPerfil();
		crearAplicacionNegocio();
		crearEmpresaNegocio();
		crearMaquinaNegocio();
		crearMaquinaEmpresaNegocio();
		crearConfiguracionEmpresaUsuario();
		crearMemberNegocio();

		crearPerfilNegocio();
		crearAccionPerfilNegocio();
		crearUsuarioNegocio();
		crearAplicacionEmpresaNegocio();
		crearAplicacionRolNegocio();


		crearEmpresaUsuarioNegocio();
		crearEmpresaUsuarioAplicacionEmpresa();

		crearAplicacionServicioNegocio();
		//	***********************************************************/
		crearSeguridadAplicacionServicioNegocio();

	}

	public void crearGeneroNegocio() throws LogicaImplException{
		
//		ZapalaRequest zapalaRequest = new ZapalaRequest(LocalDateTime.now());
		
		List<Genero> listaGenero = null; 

		try{
			listaGenero = ssoService.listarTodoGenero();
		}catch(Exception e){

		}

		if(listaGenero == null) {
			try {
				System.out.println("crearGeneroNegocio");
				Genero generoA = new Genero("masculino", "hombrecito que camina derechito", true);
				Genero generoB = new Genero("femenino", "mujercita que camina derechita", true);
				Genero generoC = new Genero("Transgénero", "Persona cuyo género no coincide con el que te fue socialmente asignado al nacer. Trans: Abreviación de transgénero.", true);
				Genero generoD = new Genero("Hombre Trans", "Persona transgénero que se identifica como hombre.", true);
				Genero generoE = new Genero("Persona Trans", "Persona transgénero que no quiere definirse por ningún género en concreto.", true);
				Genero generoF = new Genero("Mujer Trans", "Persona transgénero que se identifica como mujer.", true);
				Genero generoG = new Genero("FTM, Female to Male o Mujer a Hombre", "otra de las etiquetas para asignar a los hombres transgénero. Su uso no está muy aconsejado y usarlo por otras personas para referirse a ellos puede resultar ofensivo, pero eso no quita que algunas personas se identifiquen y definan con ella.", true);
				Genero generoH = new Genero("MTF Male to Female u Hombre a mujer", "lo mismo que en el anterior caso.", true);
				Genero generoI = new Genero("Transfemenino", "personas transgénero a la que se asignó el género masculino en su nacimiento pero que se identifican más con los signos de la feminidad que con los de la masculinidad.", true);
				Genero generoJ = new Genero("Transmasculino", "personas transgénero a la que se asignó el género femenino en su nacimiento pero que se identifican más con los signos de la masculinidad que con los de la feminidad.", true);
				Genero generoK = new Genero("Transexual", "Término médico para las personas que desean modificar su cuerpo para conseguir una imagen con la que se sientan más cómodas (o aliviar un malestar, la disforia)", true);
				Genero generoL = new Genero("Mujer Transexual", "persona transexual que se identifica como mujer", true);
				Genero generoM = new Genero("Hombre Transexual", "persona transexual que se identifica como hombre", true);
				Genero generoN = new Genero("Persona transexual", "Persona transexual que no quiere definirse por ningún género en concreto", true);
				Genero generoP = new Genero("Andrógino/e", "Persona cuya identidad es una mezcla en distintos grados entre mujer y hombre. También se puede usar como sinónimo ginoandros.", true);
				Genero generoQ = new Genero("Neutrois", "lo opuesto a la androginia, personas que hacen una supresión de las características tradicionalmente asignadas como masculinas o femeninas. Suele abarcar el género neutro, null-gender, gender neutral y a veces se solapa con agénero.", true);
				Genero generoR = new Genero("Personas de sexo no ajustado o non-conforming", "personas que no se quieren identificar con las etiquetas de género binarias. Algunas etiquetas afines son Gender Questioning y Gender Variant.", true);
				Genero generoS = new Genero("Berdache", "término empleado especialmente por las personas pertenecientes a pueblos amerindios de América del Norte. Se utilizaba como equivalente a homosexual. Son personas que se mueven entre los roles masculinos y femeninos para cuestiones de vestimenta, sociabilidad o sexualidad, dependiendo de la elección personal de cada uno.", true);
				Genero generoT = new Genero("No-binario", "personas que no se identifican con el género binario, esto está dentro de los transgéneros, aunque muchos prefieran la palabra no binario para evitar confusiones. Es decir, todos las personas no-binarias son trans, pero no todos las personas trans son no binarias. Genderqueer: sinónimo de género no-binario.", true);
				Genero generoU = new Genero("Agénero", "Persona que no se identifica con ningún género.", true);
				Genero generoV = new Genero("Bigénero", "persona que se identifica con dos géneros, por ejemplo: male/female, male/agender. Puede ser al mismo tiempo o fluctuar entre ambos.", true);
				Genero generoW = new Genero("Género Fluido", "persona cuyo género fluctúa entre varios, puede ser dos o más (por eso no es exactamente lo mismo que bigénero).", true);
				Genero generoX = new Genero("Pangénero", "identidad en la que se ubican todas las identidades, aunque de una manera fija y no variable, no como en el género fluido. ", true);
				Genero generoY = new Genero("Poligénero", "Persona con más de dos identidades de género", true);
				Genero generoZ = new Genero("Intergénero", "Persona intersexual cuya identidad se sitúa en un punto medio entre dos géneros, usualmente los binarios. Esta identidad pertenece únicamente a personas intersexuales, no debe utilizarse por parte del resto.", true);
				Genero generoAA = new Genero("Otro", "No especificado", true);

				int largoMax = 50;

				generoA.setDescripcionGenero((generoA.getDescripcionGenero().length()>=largoMax) ? generoA.getDescripcionGenero().substring(0,largoMax) :generoA.getDescripcionGenero().substring(0,generoA.getDescripcionGenero().length()));
				generoB.setDescripcionGenero((generoB.getDescripcionGenero().length()>=largoMax) ? generoB.getDescripcionGenero().substring(0,largoMax) :generoB.getDescripcionGenero().substring(0,generoB.getDescripcionGenero().length()));
				generoC.setDescripcionGenero((generoC.getDescripcionGenero().length()>=largoMax) ? generoC.getDescripcionGenero().substring(0,largoMax) :generoC.getDescripcionGenero().substring(0,generoC.getDescripcionGenero().length()));
				generoD.setDescripcionGenero((generoD.getDescripcionGenero().length()>=largoMax) ? generoD.getDescripcionGenero().substring(0,largoMax) :generoD.getDescripcionGenero().substring(0,generoD.getDescripcionGenero().length()));
				generoE.setDescripcionGenero((generoE.getDescripcionGenero().length()>=largoMax) ? generoE.getDescripcionGenero().substring(0,largoMax) :generoE.getDescripcionGenero().substring(0,generoE.getDescripcionGenero().length()));
				generoF.setDescripcionGenero((generoF.getDescripcionGenero().length()>=largoMax) ? generoF.getDescripcionGenero().substring(0,largoMax) :generoF.getDescripcionGenero().substring(0,generoF.getDescripcionGenero().length()));
				generoG.setDescripcionGenero((generoG.getDescripcionGenero().length()>=largoMax) ? generoG.getDescripcionGenero().substring(0,largoMax) :generoG.getDescripcionGenero().substring(0,generoG.getDescripcionGenero().length()));
				generoH.setDescripcionGenero((generoH.getDescripcionGenero().length()>=largoMax) ? generoH.getDescripcionGenero().substring(0,largoMax) :generoH.getDescripcionGenero().substring(0,generoH.getDescripcionGenero().length()));
				generoI.setDescripcionGenero((generoI.getDescripcionGenero().length()>=largoMax) ? generoI.getDescripcionGenero().substring(0,largoMax) :generoI.getDescripcionGenero().substring(0,generoI.getDescripcionGenero().length()));
				generoJ.setDescripcionGenero((generoJ.getDescripcionGenero().length()>=largoMax) ? generoJ.getDescripcionGenero().substring(0,largoMax) :generoJ.getDescripcionGenero().substring(0,generoJ.getDescripcionGenero().length()));
				generoK.setDescripcionGenero((generoK.getDescripcionGenero().length()>=largoMax) ? generoK.getDescripcionGenero().substring(0,largoMax) :generoK.getDescripcionGenero().substring(0,generoK.getDescripcionGenero().length()));
				generoL.setDescripcionGenero((generoL.getDescripcionGenero().length()>=largoMax) ? generoL.getDescripcionGenero().substring(0,largoMax) :generoL.getDescripcionGenero().substring(0,generoL.getDescripcionGenero().length()));
				generoM.setDescripcionGenero((generoM.getDescripcionGenero().length()>=largoMax) ? generoM.getDescripcionGenero().substring(0,largoMax) :generoM.getDescripcionGenero().substring(0,generoM.getDescripcionGenero().length()));
				generoN.setDescripcionGenero((generoN.getDescripcionGenero().length()>=largoMax) ? generoN.getDescripcionGenero().substring(0,largoMax) :generoN.getDescripcionGenero().substring(0,generoN.getDescripcionGenero().length()));
				generoP.setDescripcionGenero((generoP.getDescripcionGenero().length()>=largoMax) ? generoP.getDescripcionGenero().substring(0,largoMax) :generoP.getDescripcionGenero().substring(0,generoP.getDescripcionGenero().length()));
				generoQ.setDescripcionGenero((generoQ.getDescripcionGenero().length()>=largoMax) ? generoQ.getDescripcionGenero().substring(0,largoMax) :generoQ.getDescripcionGenero().substring(0,generoQ.getDescripcionGenero().length()));
				generoR.setDescripcionGenero((generoR.getDescripcionGenero().length()>=largoMax) ? generoR.getDescripcionGenero().substring(0,largoMax) :generoR.getDescripcionGenero().substring(0,generoR.getDescripcionGenero().length()));
				generoS.setDescripcionGenero((generoS.getDescripcionGenero().length()>=largoMax) ? generoS.getDescripcionGenero().substring(0,largoMax) :generoS.getDescripcionGenero().substring(0,generoS.getDescripcionGenero().length()));
				generoT.setDescripcionGenero((generoT.getDescripcionGenero().length()>=largoMax) ? generoT.getDescripcionGenero().substring(0,largoMax) :generoT.getDescripcionGenero().substring(0,generoT.getDescripcionGenero().length()));
				generoU.setDescripcionGenero((generoU.getDescripcionGenero().length()>=largoMax) ? generoU.getDescripcionGenero().substring(0,largoMax) :generoU.getDescripcionGenero().substring(0,generoU.getDescripcionGenero().length()));
				generoV.setDescripcionGenero((generoV.getDescripcionGenero().length()>=largoMax) ? generoV.getDescripcionGenero().substring(0,largoMax) :generoV.getDescripcionGenero().substring(0,generoV.getDescripcionGenero().length()));
				generoW.setDescripcionGenero((generoW.getDescripcionGenero().length()>=largoMax) ? generoW.getDescripcionGenero().substring(0,largoMax) :generoW.getDescripcionGenero().substring(0,generoW.getDescripcionGenero().length()));
				generoX.setDescripcionGenero((generoX.getDescripcionGenero().length()>=largoMax) ? generoX.getDescripcionGenero().substring(0,largoMax) :generoX.getDescripcionGenero().substring(0,generoX.getDescripcionGenero().length()));
				generoY.setDescripcionGenero((generoY.getDescripcionGenero().length()>=largoMax) ? generoY.getDescripcionGenero().substring(0,largoMax) :generoY.getDescripcionGenero().substring(0,generoY.getDescripcionGenero().length()));
				generoZ.setDescripcionGenero((generoZ.getDescripcionGenero().length()>=largoMax) ? generoZ.getDescripcionGenero().substring(0,largoMax) :generoZ.getDescripcionGenero().substring(0,generoZ.getDescripcionGenero().length()));
				generoAA.setDescripcionGenero((generoAA.getDescripcionGenero().length()>=largoMax) ? generoAA.getDescripcionGenero().substring(0,largoMax) :generoAA.getDescripcionGenero().substring(0,generoAA.getDescripcionGenero().length()));

				ssoService.crearGenero(generoA);
				ssoService.crearGenero(generoB);
				ssoService.crearGenero(generoC);
				ssoService.crearGenero(generoD);
				ssoService.crearGenero(generoE);
				ssoService.crearGenero(generoF);
				ssoService.crearGenero(generoG);
				ssoService.crearGenero(generoH);
				ssoService.crearGenero(generoI);
				ssoService.crearGenero(generoJ);
				ssoService.crearGenero(generoK);
				ssoService.crearGenero(generoL);
				ssoService.crearGenero(generoM);
				ssoService.crearGenero(generoN);
				ssoService.crearGenero(generoP);
				ssoService.crearGenero(generoQ);
				ssoService.crearGenero(generoR);
				ssoService.crearGenero(generoS);
				ssoService.crearGenero(generoT);
				ssoService.crearGenero(generoU);
				ssoService.crearGenero(generoV);
				ssoService.crearGenero(generoW);
				ssoService.crearGenero(generoX);
				ssoService.crearGenero(generoY);
				ssoService.crearGenero(generoZ);
				ssoService.crearGenero(generoAA);
			}catch(Exception e) {

			}
		}
		
//		Zapala zapala  = zapalaClienteRest.generarTiempoDuracion(zapalaRequest);
		
//		System.out.println(zapala.getCodigoGenerado());

	}

	public void crearRolNegocio() throws LogicaImplException{

		List<Rol> listaRol = null; 

		try{
			listaRol = ssoService.listarTodoRol();
		}catch(Exception e){

		}

		if(listaRol == null) {
			try {
				Rol rolA = new Rol("usuario", "Rol de quienes utilizan la aplicacion");
				Rol rolB = new Rol("ejecutivo", "Rol de ejecutivos que utilizan la aplicacion");
				Rol rolC = new Rol("administrador", "Rol de quienes administran una aplicacion");
				Rol rolD = new Rol("aplicacion", "Rol de aplicaciones que solicitan un servicio");

				ssoService.crearRol(rolA);
				ssoService.crearRol(rolB);
				ssoService.crearRol(rolC);
				ssoService.crearRol(rolD);
			}catch(Exception e) {

			}
		}

	}

	public void crearTipoAccionPerfil() throws LogicaImplException{
		List<TipoAccionPerfil> listaTipoAccionPerfil = null; 

		try{
			listaTipoAccionPerfil = ssoService.listarTodoTipoAccionPerfil();
		}catch(Exception e){

		}

		if(listaTipoAccionPerfil == null) {
			try {
				TipoAccionPerfil tipoAccionPerfilA = new TipoAccionPerfil("iniciar_envio_correo_confirmacion", "iniciar el envio de correo de confirmacion de creacion de usuario-member-perfil");
				TipoAccionPerfil tipoAccionPerfilB = new TipoAccionPerfil("finalizar_envio_correo_confirmacion", "finalizar el envio de correo de confirmacion de creacion de usuario-member-perfil");
				TipoAccionPerfil tipoAccionPerfilC = new TipoAccionPerfil("iniciar_envio_correo_usuario_inactivo", "iniciar el envio de correo de confirmacion de creacion de usuario-member-perfil");
				TipoAccionPerfil tipoAccionPerfilD = new TipoAccionPerfil("finalizar_envio_correo_usuario_inactivo", "finalizar el envio de correo de confirmacion de creacion de usuario-member-perfil");

				ssoService.crearTipoAccionPerfil(tipoAccionPerfilA);
				ssoService.crearTipoAccionPerfil(tipoAccionPerfilB);
				ssoService.crearTipoAccionPerfil(tipoAccionPerfilC);
				ssoService.crearTipoAccionPerfil(tipoAccionPerfilD);
			}catch(Exception e) {

			}
		}
	}

	//seguridad"
	//"webmail"
	//"uchile"
	public void crearAplicacionNegocio() throws LogicaImplException{

		List<Aplicacion> listaAplicacion = null; 

		try{
			listaAplicacion = ssoService.listarTodoAplicacion();
		}catch(Exception e){

		}

		if(listaAplicacion == null) {
			try {
				//		Date fechaInicial = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-10-31 12:56:11");
				//		Date fechaFinal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-12-05 11:09:37");
				//		
				//		String strFormatoFechaYYYY_MM_ddTHH_MM_SSZ =  "yyyy-MM-dd'T'HH:mm:ss'Z'";
				//		SimpleDateFormat formatoFecha_YYYY_MM_DDTHHmmss = new SimpleDateFormat(strFormatoFechaYYYY_MM_ddTHH_MM_SSZ);

				//		System.out.println(fechaInicial);
				//		System.out.println(fechaFinal);

				//Las aplicacion son el nombre de los aplicaciones/componentes web que tienen acceso a los distintos webservice del medio
				Aplicacion aplicacionA=new Aplicacion("seguridad", "/seguridad", "8081", "seguridad", "aplicacion de registro usuario y seguridad");
				Aplicacion aplicacionB=new Aplicacion("webmail", "/webmail", "8081", "webmail", "aplicacion de envio de correo");
				Aplicacion aplicacionC=new Aplicacion("uchile", "/uchile", "8081", "uchile", "aplicacion de administracion y de la universidad de chile");

				ssoService.crearAplicacion(aplicacionA);
				ssoService.crearAplicacion(aplicacionB);
				ssoService.crearAplicacion(aplicacionC);
			}catch(Exception e) {

			}
		}
	}

	//"Tesoro del cielo"
	//"Universidad de Chile"
	//"Parking"
	public void crearEmpresaNegocio() throws LogicaImplException{
		List<Empresa> listaEmpresa = null; 

		try{
			listaEmpresa = ssoService.listarTodoEmpresa();
		}catch(Exception e){

		}

		if(listaEmpresa == null) {
			try {
				Empresa empresaA=new Empresa();
				empresaA.setRolUnicoIdentificadorEmpresa("1-9");
				empresaA.setNombreEmpresa("Tesoro del cielo"); //nombre fantasia
				empresaA.setNombreEmpresaLowerCase(empresaA.getNombreEmpresa().toLowerCase());
				empresaA.setDominioEmpresa("tesoro".toLowerCase());
				empresaA.setRazonSocialEmpresa("Sociedad Tesoro del cielo limitada"); //nombre legal empresa
				empresaA.setRazonSocialEmpresaLowerCase(empresaA.getRazonSocialEmpresa().toLowerCase());
				empresaA.setGiroEmpresa("Muchas Cosas"); // accion que hace empresa
				empresaA.setDireccionOrigen("Lord Cochrane 309 depto 902");  // ubicacion legal empresa
				empresaA.setCodigoPaisPortal("cl");
				empresaA.setIdRegion(1);
				empresaA.setIdComuna(1);
				empresaA.setCiudadOrigen("Santiago");
				empresaA.setEstadoEmpresa(true); 

				Empresa empresaB =new Empresa();
				empresaB.setRolUnicoIdentificadorEmpresa("2-7");
				empresaB.setNombreEmpresa("Universidad de Chile"); //nombre fantasia
				empresaB.setNombreEmpresaLowerCase(empresaB.getNombreEmpresa().toLowerCase());
				empresaB.setDominioEmpresa("uchile".toLowerCase());
				empresaB.setRazonSocialEmpresa("Universidad de Chile"); //nombre legal empresa
				empresaB.setRazonSocialEmpresaLowerCase(empresaB.getRazonSocialEmpresa().toLowerCase());
				empresaB.setGiroEmpresa("Muchas Cosas"); // accion que hace empresa
				empresaB.setDireccionOrigen("Alameda");  // ubicacion legal empresa
				empresaB.setCodigoPaisPortal("cl");
				empresaB.setIdRegion(1);
				empresaB.setIdComuna(1);
				empresaB.setCiudadOrigen("Santiago");
				empresaB.setEstadoEmpresa(true);

				Empresa empresaC =new Empresa();
				empresaC.setRolUnicoIdentificadorEmpresa("3-5");
				empresaC.setNombreEmpresa("Parking"); //nombre fantasia
				empresaC.setNombreEmpresaLowerCase(empresaB.getNombreEmpresa().toLowerCase());
				empresaC.setDominioEmpresa("parking".toLowerCase());
				empresaC.setRazonSocialEmpresa("Parking Security"); //nombre legal empresa
				empresaC.setRazonSocialEmpresaLowerCase(empresaB.getRazonSocialEmpresa().toLowerCase());
				empresaC.setGiroEmpresa("Muchas Cosas"); // accion que hace empresa
				empresaC.setDireccionOrigen("Andres Bello");  // ubicacion legal empresa
				empresaC.setCodigoPaisPortal("cl");
				empresaC.setIdRegion(1);
				empresaC.setIdComuna(1);
				empresaC.setCiudadOrigen("Santiago");
				empresaC.setEstadoEmpresa(true);

				ssoService.crearEmpresa(empresaA);
				ssoService.crearEmpresa(empresaB);
				ssoService.crearEmpresa(empresaC);
			}catch(Exception e) {

			}
		}
	}

	public void crearMaquinaNegocio() throws LogicaImplException{
		List<Maquina> listaMaquina = null; 

		try{
			listaMaquina = ssoService.listarTodoMaquina();
		}catch(Exception e){

		}

		if(listaMaquina == null) {
			try {
				Maquina maquina=new Maquina();
				maquina.setDireccionIpMaquina("127.0.0.1");
				maquina.setNombreIpMaquina("127.0.0.1");

				ssoService.crearMaquina(maquina);
			}catch(Exception e) {

			}
		}
	}

	public void crearMaquinaEmpresaNegocio() throws LogicaImplException {

		List<Maquina> listaMaquina = null; 

		try{
			listaMaquina = ssoService.listarTodoMaquina();
		}catch(Exception e){

		}

		if(listaMaquina == null) {
			try {
				MaquinaEmpresa maquinaEmpresaA=new MaquinaEmpresa(new Maquina(1), new Empresa(1));
				MaquinaEmpresa maquinaEmpresaB=new MaquinaEmpresa(new Maquina(1), new Empresa(2));
				MaquinaEmpresa maquinaEmpresaC=new MaquinaEmpresa(new Maquina(1), new Empresa(3));

				ssoService.crearMaquinaEmpresa(maquinaEmpresaA);
				ssoService.crearMaquinaEmpresa(maquinaEmpresaB);
				ssoService.crearMaquinaEmpresa(maquinaEmpresaC);
			}catch(Exception e) {

			}
		}
	}

	public void crearConfiguracionEmpresaUsuario() throws LogicaImplException {

		List<ConfiguracionEmpresaUsuario> listaConfiguracionEmpresaUsuario = null; 

		try{
			listaConfiguracionEmpresaUsuario = ssoService.listarTodoConfiguracionEmpresaUsuario();
		}catch(Exception e){

		}

		if(listaConfiguracionEmpresaUsuario == null) {
			try {
				ConfiguracionEmpresaUsuario configuracionEmpresaUsuarioA = new ConfiguracionEmpresaUsuario();
				configuracionEmpresaUsuarioA.setPasswordEmpresaUsuarioContrasenhaFormat("MD5");
				configuracionEmpresaUsuarioA.setPasswordEmpresaUsuarioContrasenhaSalto(false);
				configuracionEmpresaUsuarioA.setIdEmpresa(new Empresa(1));

				ConfiguracionEmpresaUsuario configuracionEmpresaUsuarioB = new ConfiguracionEmpresaUsuario();
				configuracionEmpresaUsuarioB.setPasswordEmpresaUsuarioContrasenhaFormat("MD5");
				configuracionEmpresaUsuarioB.setPasswordEmpresaUsuarioContrasenhaSalto(false);
				configuracionEmpresaUsuarioB.setIdEmpresa(new Empresa(2));

				ConfiguracionEmpresaUsuario configuracionEmpresaUsuarioC = new ConfiguracionEmpresaUsuario();
				configuracionEmpresaUsuarioC.setPasswordEmpresaUsuarioContrasenhaFormat("MD5");
				configuracionEmpresaUsuarioC.setPasswordEmpresaUsuarioContrasenhaSalto(false);
				configuracionEmpresaUsuarioC.setIdEmpresa(new Empresa(3));

				ssoService.crearConfiguracionEmpresaUsuario(configuracionEmpresaUsuarioA);
				ssoService.crearConfiguracionEmpresaUsuario(configuracionEmpresaUsuarioB);
				ssoService.crearConfiguracionEmpresaUsuario(configuracionEmpresaUsuarioC);
			}catch(Exception e) {

			}
		}
	}

	public void crearMemberNegocio() throws LogicaImplException {

		List<Member> listaMember = null; 

		try{
			listaMember = ssoService.listarTodoMember();
		}catch(Exception e){

		}

		if(listaMember == null) {
			try {

				List<Genero> listaGenero = ssoService.listarTodoGenero();

				Member memberA=new Member();
				//Fecha Nacimiento AAAA-mm-dd

				memberA.setNombreMember("GlobalTesoro");
				memberA.setApellidoPaternoMember("Global");
				memberA.setApellidoMaternoMember("Global");
				memberA.setTelefonoContactoMember("56988776699");
				memberA.setFechaNacimientoMember("2000-01-01");
				memberA.setIdGenero(listaGenero.get(0));
				memberA.setFirmaMember("empresa");
				//		memberA.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));

				Member memberB=new Member();

				memberB.setNombreMember("Shaka");
				memberB.setApellidoPaternoMember("Virgo");
				memberB.setApellidoMaternoMember("VirgoMat");
				memberB.setTelefonoContactoMember("56988776699");
				memberB.setFechaNacimientoMember("2000-01-01");
				memberB.setIdGenero(listaGenero.get(0));
				memberB.setFirmaMember("soy el administrador");
				//		memberB.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));

				Member memberC =new Member();

				memberC.setNombreMember("Flor");
				memberC.setApellidoPaternoMember("de Lotto");
				memberC.setApellidoMaternoMember("Lotto del Orto");
				memberC.setTelefonoContactoMember("56988776699");
				memberC.setFechaNacimientoMember("2000-01-01");
				memberC.setIdGenero(listaGenero.get(0));
				memberC.setFirmaMember("soy una flor");
				//		memberC.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));

				Member memberD =new Member();

				memberD.setNombreMember("Flor");
				memberD.setApellidoPaternoMember("deL Orto");
				memberD.setApellidoMaternoMember("La flot");
				memberD.setTelefonoContactoMember("56988776699");
				memberD.setFechaNacimientoMember("2000-01-01");
				memberD.setIdGenero(listaGenero.get(0));
				memberD.setFirmaMember("soy una flor");
				//		memberD.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));
				//A

				Member memberE =new Member();

				memberE.setNombreMember("GlobalUchile");
				memberE.setApellidoPaternoMember("Global");
				memberE.setApellidoMaternoMember("Global");
				memberE.setTelefonoContactoMember("56988776699");
				memberE.setFechaNacimientoMember("2000-01-01");
				memberE.setIdGenero(listaGenero.get(0));
				memberE.setFirmaMember("empresa");
				//		memberE.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));

				Member memberF =new Member();

				memberF.setNombreMember("Canon");
				memberF.setApellidoPaternoMember("Geminis");
				memberF.setApellidoMaternoMember("Saga");
				memberF.setTelefonoContactoMember("56988776699");
				memberF.setFechaNacimientoMember("2000-01-01");
				memberF.setIdGenero(listaGenero.get(0));
				memberF.setFirmaMember("soy el administrador");
				//		memberF.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));

				Member memberG =new Member();

				memberG.setNombreMember("usuario");
				memberG.setApellidoPaternoMember("local");
				memberG.setApellidoMaternoMember("localmat");
				memberG.setTelefonoContactoMember("56988776699");
				memberG.setFechaNacimientoMember("2000-01-01");
				memberG.setIdGenero(listaGenero.get(0));
				memberG.setFirmaMember("he aqui");
				//		memberG.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));
				//B

				Member memberH =new Member();

				memberH.setNombreMember("Travel");
				memberH.setApellidoPaternoMember("Security");
				memberH.setApellidoMaternoMember("MatSecurity");
				memberH.setTelefonoContactoMember("56988776699");
				memberH.setFechaNacimientoMember("2000-01-01");
				memberH.setIdGenero(listaGenero.get(0));
				memberH.setFirmaMember("empresa");
				//		memberH.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));

				Member memberI =new Member();

				memberI.setNombreMember("Administrador");
				memberI.setApellidoPaternoMember("Travel");
				memberI.setApellidoMaternoMember("no travel");
				memberI.setTelefonoContactoMember("56988776699");
				memberI.setFechaNacimientoMember("2000-01-01");
				memberI.setIdGenero(listaGenero.get(0));
				memberI.setFirmaMember("soy el administrador");
				//		memberI.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));

				Member memberJ =new Member();

				memberJ.setNombreMember("Hetero");
				memberJ.setApellidoPaternoMember("Curiosa");
				memberJ.setApellidoMaternoMember("Croata");
				memberJ.setTelefonoContactoMember("56988776699");
				memberJ.setFechaNacimientoMember("2000-01-01");
				memberJ.setIdGenero(listaGenero.get(0));
				memberJ.setFirmaMember("soy hetero curioso");
				//		memberJ.setCreacionMember(DateMapper.DateUtilToDateSantiago(new Date()));
				//C
				//		for(Genero gMod:listaGenero){
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberA.getIdGenero().getNombreGenero())){
				//				memberA.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberB.getGeneroMember())){
				//				memberB.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberC.getGeneroMember())){
				//				memberC.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberD.getGeneroMember())){
				//				memberD.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberE.getGeneroMember())){
				//				memberE.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberF.getGeneroMember())){
				//				memberF.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberF.getGeneroMember())){
				//				memberF.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberG.getGeneroMember())){
				//				memberG.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberH.getGeneroMember())){
				//				memberH.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberI.getGeneroMember())){
				//				memberI.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//			if(gMod.getNombreGenero().toLowerCase().equalsIgnoreCase(memberJ.getGeneroMember())){
				//				memberJ.setIdGeneroMember(gMod.getIdGenero());
				//			}
				//		}


				ssoService.crearMember(memberA);
				ssoService.crearMember(memberB);
				ssoService.crearMember(memberC);
				ssoService.crearMember(memberD);
				ssoService.crearMember(memberE);
				ssoService.crearMember(memberF);
				ssoService.crearMember(memberG);
				ssoService.crearMember(memberH);
				ssoService.crearMember(memberI);
				ssoService.crearMember(memberJ);

				//		memberA.setRutMember();
				//		memberB.setRutMember("20.000.000-5");
				//		memberC.setRutMember("30.000.000-2");
				//		memberD.setRutMember("30.000.000-2");
				//		memberE.setRutMember("2-7");
				//		memberF.setRutMember("40.000.000-K");
				//		memberG.setRutMember("50.000.000-7");
				//		memberH.setRutMember("3-5");
				//		memberI.setRutMember("60.000.000-4");
				//		memberJ.setRutMember("70.000.000-1");
				Identificador identificadorA=new Identificador("RUT", "1-9", "cl", memberA);
				Identificador identificadorB=new Identificador("RUT", "20.000.000-5", "cl",  memberB);
				Identificador identificadorC=new Identificador("RUT", "30.000.000-2", "cl",  memberC);
				Identificador identificadorD=new Identificador("RUT", "21000000-3", "cl",  memberD);
				Identificador identificadorE=new Identificador("RUT", "2-7", "cl",  memberE);//5
				Identificador identificadorF=new Identificador("RUT", "40.000.000-K", "cl",  memberF);
				Identificador identificadorG=new Identificador("RUT", "50.000.000-7", "cl",  memberG);
				Identificador identificadorH=new Identificador("RUT", "3-5", "cl",  memberH);
				Identificador identificadorI=new Identificador("RUT", "60.000.000-4", "cl",  memberI);
				Identificador identificadorJ=new Identificador("RUT", "70.000.000-1", "cl",  memberJ);

				ssoService.crearIdentificador(identificadorA);
				ssoService.crearIdentificador(identificadorB);
				ssoService.crearIdentificador(identificadorC);
				ssoService.crearIdentificador(identificadorD);
				ssoService.crearIdentificador(identificadorE);
				ssoService.crearIdentificador(identificadorF);
				ssoService.crearIdentificador(identificadorG);
				ssoService.crearIdentificador(identificadorH);
				ssoService.crearIdentificador(identificadorI);
				ssoService.crearIdentificador(identificadorJ);

			}catch(Exception e) {

			}
		}
	}

	public void crearPerfilNegocio() throws LogicaImplException {

		List<Perfil> listaPerfil = null; 

		try{
			listaPerfil = ssoService.listarTodoPerfil();
		}catch(Exception e){

		}

		if(listaPerfil == null) {
			try {
				Perfil perfilA=new Perfil();
				Perfil perfilB=new Perfil();
				Perfil perfilC=new Perfil();
				Perfil perfilD=new Perfil();
				Perfil perfilE=new Perfil();
				Perfil perfilF=new Perfil();
				Perfil perfilG=new Perfil();
				Perfil perfilH=new Perfil();
				Perfil perfilI=new Perfil();
				Perfil perfilJ=new Perfil();

				ConfiguracionEmpresaUsuario configuracionEmpresaUsuarioA = new ConfiguracionEmpresaUsuario(new Empresa(1), true);
				ConfiguracionEmpresaUsuario configuracionEmpresaUsuarioB = new ConfiguracionEmpresaUsuario(new Empresa(2), true);
				ConfiguracionEmpresaUsuario configuracionEmpresaUsuarioC = new ConfiguracionEmpresaUsuario(new Empresa(3), true);

				try{
					configuracionEmpresaUsuarioA = ssoService.buscarConfiguracionEmpresaUsuarioxEmpresa(configuracionEmpresaUsuarioA);
					configuracionEmpresaUsuarioB = ssoService.buscarConfiguracionEmpresaUsuarioxEmpresa(configuracionEmpresaUsuarioB);
					configuracionEmpresaUsuarioC = ssoService.buscarConfiguracionEmpresaUsuarioxEmpresa(configuracionEmpresaUsuarioC);
				}catch(Exception e){

				}

				perfilA.setUsernamePerfil("plataformatesoro");
				perfilA.setNombrePerfilLowerCase("PlataformaTesoro");
				perfilA.setEmailPerfil("global@tesoro.cl"); 
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioA.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passA = MD5.getMD5("123456");
				//		}
				perfilA.setPasswordContrasenhaNormal("123456");
				//		perfilA.setPasswordContrasenha(passA);
				perfilA.setPasswordPregunta("usuario");
				perfilA.setPasswordRespuesta("empresa");
				//		
				//		perfilA.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilA.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilA.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				//		perfilA.setEstadoUsuarioPerfil(true);
				perfilA.setAnonimo(1);

				perfilB.setUsernamePerfil("administradortesoro");
				perfilB.setNombrePerfilLowerCase("AdministradorTesoro");
				perfilB.setEmailPerfil("administador_shaka_virgo@tesoro.cl");
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioA.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passB = MD5.getMD5("123456");
				//		}
				perfilB.setPasswordContrasenhaNormal("123456");
				//		perfilB.setPasswordContrasenha(passB);
				perfilB.setPasswordPregunta("usuario");
				perfilB.setPasswordRespuesta("empresa");
				//		perfilB.setEstadoUsuarioPerfil(true);
				//		perfilB.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilB.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilB.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilB.setAnonimo(1);

				perfilC.setUsernamePerfil("usuariounotesoro");
				perfilC.setNombrePerfilLowerCase("EsclavoUnoTesoro");
				perfilC.setEmailPerfil("fdelotto@tesoro.cl");
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioA.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passC = MD5.getMD5("123456");
				//		}
				perfilC.setPasswordContrasenhaNormal("123456");
				//		perfilC.setPasswordContrasenha(passC);
				perfilC.setPasswordPregunta("usuario");
				perfilC.setPasswordRespuesta("empresa");
				//		perfilC.setEstadoUsuarioPerfil(true);
				//		perfilC.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilC.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilC.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilC.setAnonimo(1);

				perfilD.setUsernamePerfil("usuariodostesoro");
				perfilD.setNombrePerfilLowerCase("EsclavoDosTesoro");
				perfilD.setEmailPerfil("usuariodostesoro@tesoro.cl");
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioA.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passD = MD5.getMD5("123456");
				//		}
				perfilD.setPasswordContrasenhaNormal("123456");
				//		perfilD.setPasswordContrasenha(passD);
				perfilD.setPasswordPregunta("usuario");
				perfilD.setPasswordRespuesta("empresa");
				//		perfilD.setEstadoUsuarioPerfil(true);
				//		perfilD.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilD.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilD.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilD.setAnonimo(1);


				perfilE.setUsernamePerfil("plataformaUchile");
				perfilE.setNombrePerfilLowerCase("PlataformaUchile");
				perfilE.setEmailPerfil("global@uchile.cl"); 
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioB.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passE = MD5.getMD5("7890qw");
				//		}
				perfilE.setPasswordContrasenhaNormal("7890qw");
				//		perfilE.setPasswordContrasenha(passE);
				perfilE.setPasswordPregunta("usuario");
				perfilE.setPasswordRespuesta("empresa");
				//		perfilE.setEstadoUsuarioPerfil(true);
				//		perfilE.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilE.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilE.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilE.setAnonimo(1);

				perfilF.setUsernamePerfil("administradorUchile");
				perfilF.setNombrePerfilLowerCase("AdministradorUchile");
				perfilF.setEmailPerfil("administrador_canon_geminis@uchile.cl"); 
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioB.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passF = MD5.getMD5("7890qw");
				//		}
				perfilF.setPasswordContrasenhaNormal("7890qw");
				//		perfilF.setPasswordContrasenha(passF);
				perfilF.setPasswordPregunta("usuario");
				perfilF.setPasswordRespuesta("empresa");
				//		perfilF.setEstadoUsuarioPerfil(true);
				//		perfilF.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilF.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilF.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilF.setAnonimo(1);

				perfilG.setUsernamePerfil("usuariounouchile");
				perfilG.setNombrePerfilLowerCase("EsclavoUnoUchile");
				perfilG.setEmailPerfil("elocal@uchile.cl"); 
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioB.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passG = MD5.getMD5("7890qw");
				//		}
				perfilG.setPasswordContrasenhaNormal("7890qw");
				//		perfilG.setPasswordContrasenha(passG);
				perfilG.setPasswordPregunta("usuario");
				perfilG.setPasswordRespuesta("empresa");
				//		perfilG.setEstadoUsuarioPerfil(true);
				//		perfilG.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilG.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilG.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilG.setAnonimo(1);

				perfilH.setUsernamePerfil("plataformaparking");
				perfilH.setNombrePerfilLowerCase("PlataformaParking");
				perfilH.setEmailPerfil("global@empresa.cl"); 
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioC.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passH = MD5.getMD5("ertyuiop");
				//		}
				perfilH.setPasswordContrasenhaNormal("ertyuiop");
				//		perfilH.setPasswordContrasenha(passH);
				perfilH.setPasswordPregunta("usuario");
				perfilH.setPasswordRespuesta("empresa");
				//		perfilH.setEstadoUsuarioPerfil(true);
				//		perfilH.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilH.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilH.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilH.setAnonimo(1);

				perfilI.setUsernamePerfil("administradorparking");
				perfilI.setNombrePerfilLowerCase("AdministradorParking");
				perfilI.setEmailPerfil("administrador_travel_security@empresa.cl"); 
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioC.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passI = MD5.getMD5("ertyuiop");
				//		}
				perfilI.setPasswordContrasenhaNormal("ertyuiop");
				//		perfilI.setPasswordContrasenha(passI);
				perfilI.setPasswordPregunta("usuario");
				perfilI.setPasswordRespuesta("empresa");
				//		perfilI.setEstadoUsuarioPerfil(true);
				//		perfilI.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilI.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilI.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilI.setAnonimo(1);

				perfilJ.setUsernamePerfil("usuarioparking");
				perfilJ.setNombrePerfilLowerCase("EsclavoParking");
				perfilJ.setEmailPerfil("hcurioso@empresa.cl");
				//Solo en Web se puede formatear 
				//		if(configuracionEmpresaUsuarioC.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
				//			passJ = MD5.getMD5("ertyuiop");
				//		}
				perfilJ.setPasswordContrasenhaNormal("ertyuiop");
				//		perfilJ.setPasswordContrasenha(passJ);
				perfilJ.setPasswordPregunta("usuario");
				perfilJ.setPasswordRespuesta("empresa");
				//		perfilJ.setEstadoUsuarioPerfil(true);
				//		perfilJ.setPasswordUltimaActualizacion(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilJ.setEstadoPerfilLastBloqueado(DateMapper.DateUtilToDateSantiago(new Date()));
				//		perfilJ.setUltimaConexionPerfil(DateMapper.DateUtilToDateSantiago(new Date())); //ultimo momento en el cual el usuario hizo log-In en el servicio
				perfilJ.setAnonimo(1);

				ssoService.crearPerfil(configuracionEmpresaUsuarioA, perfilA);
				ssoService.crearPerfil(configuracionEmpresaUsuarioA, perfilB);
				ssoService.crearPerfil(configuracionEmpresaUsuarioA, perfilC);
				ssoService.crearPerfil(configuracionEmpresaUsuarioA, perfilD);
				ssoService.crearPerfil(configuracionEmpresaUsuarioB, perfilE);
				ssoService.crearPerfil(configuracionEmpresaUsuarioB, perfilF);
				ssoService.crearPerfil(configuracionEmpresaUsuarioB, perfilG);
				ssoService.crearPerfil(configuracionEmpresaUsuarioC, perfilH);
				ssoService.crearPerfil(configuracionEmpresaUsuarioC, perfilI);
				ssoService.crearPerfil(configuracionEmpresaUsuarioC, perfilJ);
			}catch(Exception e) {

			}
		}
	}

	public void crearAccionPerfilNegocio() throws LogicaImplException{
		//		AccionPerfil accionesPerfil=new AccionPerfil();
		//
		//		accionesPerfil.setUltimaAccionPerfil(DateMapper.DateUtilToDateSantiago(new Date()));
		//		accionesPerfil.setIdPerfil(1);
		//		accionesPerfil.setIdTipoAccionPerfil(1);
		//		accionesPerfil.setKeyAccionPerfil("kasmkasmaskmsa");
		//
		//		factorySeguridadNegocio.getAccionPerfilNegocio().crearAccionPerfil(accionesPerfil);
	}

	public void crearUsuarioNegocio() throws LogicaImplException{
		List<Usuario> listaUsuario = null; 

		try{
			listaUsuario = ssoService.listarTodoUsuario();
		}catch(Exception e){

		}

		if(listaUsuario == null) {
			try {
				Usuario usuarioA=new Usuario(new Member(1), new Perfil(1));
				Usuario usuarioB=new Usuario(new Member(2), new Perfil(2));
				Usuario usuarioC=new Usuario(new Member(3), new Perfil(3));
				Usuario usuarioD=new Usuario(new Member(4), new Perfil(4));
				Usuario usuarioE=new Usuario(new Member(5), new Perfil(5));
				Usuario usuarioF=new Usuario(new Member(6), new Perfil(6));
				Usuario usuarioG=new Usuario(new Member(7), new Perfil(7));
				Usuario usuarioH=new Usuario(new Member(8), new Perfil(8));
				Usuario usuarioI=new Usuario(new Member(9), new Perfil(9));
				Usuario usuarioJ=new Usuario(new Member(10), new Perfil(10));
				//		//"Tesoro del cielo"
				//		usuarioA.setIdMember(1);
				//		usuarioA.setIdPerfil(1);
				//
				//		usuarioB.setIdMember(2);
				//		usuarioB.setIdPerfil(2);
				//
				//		usuarioC.setIdMember(3);
				//		usuarioC.setIdPerfil(3);
				//
				//		usuarioD.setIdMember(4);
				//		usuarioD.setIdPerfil(4);
				//		//"Tesoro del cielo"
				//		//"Universidad de Chile"
				//		usuarioE.setIdMember(5);
				//		usuarioE.setIdPerfil(5);
				//
				//		usuarioF.setIdMember(6);
				//		usuarioF.setIdPerfil(6);
				//
				//		usuarioG.setIdMember(7);
				//		usuarioG.setIdPerfil(7);
				//		//"Universidad de Chile"
				//
				//		//"Parking"
				//		usuarioH.setIdMember(8);
				//		usuarioH.setIdPerfil(8);
				//
				//		usuarioI.setIdMember(9);
				//		usuarioI.setIdPerfil(9);
				//
				//		usuarioJ.setIdMember(10);
				//		usuarioJ.setIdPerfil(10);
				//"Parking"

				ssoService.generarCodigoUsuario(usuarioA);
				ssoService.generarCodigoUsuario(usuarioB);
				ssoService.generarCodigoUsuario(usuarioC);
				ssoService.generarCodigoUsuario(usuarioD);
				ssoService.generarCodigoUsuario(usuarioE);
				ssoService.generarCodigoUsuario(usuarioF);
				ssoService.generarCodigoUsuario(usuarioG);
				ssoService.generarCodigoUsuario(usuarioH);
				ssoService.generarCodigoUsuario(usuarioI);
				ssoService.generarCodigoUsuario(usuarioJ);

				ssoService.crearUsuario(usuarioA);
				ssoService.crearUsuario(usuarioB);
				ssoService.crearUsuario(usuarioC);
				ssoService.crearUsuario(usuarioD);
				ssoService.crearUsuario(usuarioE);
				ssoService.crearUsuario(usuarioF);
				ssoService.crearUsuario(usuarioG);
				ssoService.crearUsuario(usuarioH);
				ssoService.crearUsuario(usuarioI);
				ssoService.crearUsuario(usuarioJ);
			}catch(Exception e) {

			}
		}
	}

	public void crearAplicacionRolNegocio() throws LogicaImplException{
		List<AplicacionRol> listaAplicacionRol = null; 

		try{
			listaAplicacionRol = ssoService.listarTodoAplicacionRol();
		}catch(Exception e){

		}

		if(listaAplicacionRol == null) {
			try {
				//seguridad" -> aplicacion, administracion, usuario
				Aplicacion aplicacionA = ssoService.buscarAplicacion(new Aplicacion(1));
				Aplicacion aplicacionB = ssoService.buscarAplicacion(new Aplicacion(2));
				Aplicacion aplicacionC = ssoService.buscarAplicacion(new Aplicacion(3));

				Rol rolA = ssoService.buscarRolxNombre(new Rol("usuario"));
				Rol rolB = ssoService.buscarRolxNombre(new Rol("ejecutivo"));
				Rol rolC = ssoService.buscarRolxNombre(new Rol("administrador"));
				Rol rolD = ssoService.buscarRolxNombre(new Rol("aplicacion"));

				AplicacionRol aplicacionRolAA=new  AplicacionRol(aplicacionA, rolA);
				AplicacionRol aplicacionRolAB=new  AplicacionRol(aplicacionA, rolB);
				AplicacionRol aplicacionRolAC=new  AplicacionRol(aplicacionA, rolC);
				AplicacionRol aplicacionRolAD=new  AplicacionRol(aplicacionA, rolD);
				//seguridad"

				//"webmail" -> aplicacion, administracion, usuario 
				AplicacionRol aplicacionRolBC=new  AplicacionRol(aplicacionB, rolA);
				AplicacionRol aplicacionRolBA=new  AplicacionRol(aplicacionB, rolB);
				AplicacionRol aplicacionRolBB=new  AplicacionRol(aplicacionB, rolC);
				AplicacionRol aplicacionRolBD=new  AplicacionRol(aplicacionB, rolD);
				//"webmail"

				//"uchile" -> aplicacion, administracion, usuario
				AplicacionRol aplicacionRolCC=new  AplicacionRol(aplicacionC, rolA);
				AplicacionRol aplicacionRolCA=new  AplicacionRol(aplicacionC, rolB);
				AplicacionRol aplicacionRolCB=new  AplicacionRol(aplicacionC, rolC);
				AplicacionRol aplicacionRolCD=new  AplicacionRol(aplicacionC, rolD);
				//"uchile"

				ssoService.crearAplicacionRol(aplicacionRolAA);
				ssoService.crearAplicacionRol(aplicacionRolAB);
				ssoService.crearAplicacionRol(aplicacionRolAC);
				ssoService.crearAplicacionRol(aplicacionRolAD);

				ssoService.crearAplicacionRol(aplicacionRolBA);
				ssoService.crearAplicacionRol(aplicacionRolBB);
				ssoService.crearAplicacionRol(aplicacionRolBC);
				ssoService.crearAplicacionRol(aplicacionRolBD);

				ssoService.crearAplicacionRol(aplicacionRolCA);
				ssoService.crearAplicacionRol(aplicacionRolCB);
				ssoService.crearAplicacionRol(aplicacionRolCC);
				ssoService.crearAplicacionRol(aplicacionRolCD);
			}catch(Exception e) {

			}
		}
	}

	public void crearAplicacionEmpresaNegocio() throws LogicaImplException{

		List<AplicacionEmpresa> listaAplicacionEmpresa = null; 

		try{
			listaAplicacionEmpresa = ssoService.listarTodoAplicacionEmpresa();
		}catch(Exception e){

		}

		if(listaAplicacionEmpresa == null) {
			try {
				//"Tesoro del cielo"
				List<AplicacionEmpresa>  metAplicacionEmpresa = new ArrayList<AplicacionEmpresa>();

				List<Aplicacion> listaAplicacion = ssoService.listarTodoAplicacion();

				List<Empresa> listaEmpresa = ssoService.listarTodoEmpresa();

				for(Aplicacion appMod: listaAplicacion){
					for(Empresa empMod: listaEmpresa){
						AplicacionEmpresa aplicacionEmpresa = new AplicacionEmpresa();

						aplicacionEmpresa = new AplicacionEmpresa(appMod ,empMod);

						ssoService.crearAplicacionEmpresa(aplicacionEmpresa);

						metAplicacionEmpresa.add(aplicacionEmpresa);
					}
				}
				System.out.println(metAplicacionEmpresa);
			}catch(Exception e) {

			}
		}
	}

	public void crearEmpresaUsuarioNegocio() throws LogicaImplException{
		//"Tesoro del cielo"
		List<EmpresaUsuario> listaEmpresaUsuario = null; 

		try{
			listaEmpresaUsuario = ssoService.listarTodoEmpresaUsuario();
		}catch(Exception e){

		}

		if(listaEmpresaUsuario == null) {
			try {
				List<EmpresaUsuario>  metListaEmpresaUsuario = new ArrayList<EmpresaUsuario>();

				List<Rol> listaRol = ssoService.listarTodoRol();

				List<Usuario> listaUsuario = ssoService.listarTodoUsuario();

				List<Empresa> listaEmpresa = ssoService.listarTodoEmpresa();

				Perfil perfilDominio = new Perfil();

				EmpresaUsuario empresaUsuario = new EmpresaUsuario();
				//		los 10 usuario dividido en 3 empresas pueden estar en las 3 aplicaciones
				for(Empresa empMod: listaEmpresa){
					metListaEmpresaUsuario = new ArrayList<EmpresaUsuario>();
					perfilDominio.setUsernamePerfil(empMod.getDominioEmpresa());

					//			List<Perfil> listaPerfil = ssoService.listarPerfilxLikeUsernamePerfil(perfilDominio);
					List<Perfil> listaPerfil = ssoService.listarPerfilLikeUsernamePerfil(perfilDominio);

					for(Perfil perMod: listaPerfil){
						for(Rol rolMod: listaRol){
							String aaa = (rolMod.getNombreRolLowerCase().equals("aplicacion")) ? "plataforma" : rolMod.getNombreRolLowerCase();
							if(perMod.getUsernamePerfil().contains(aaa)){
								//Buscar la Aplicacion Empresa

								for(Usuario usuMod: listaUsuario){
									if(usuMod.getIdPerfil().getIdPerfil()==perMod.getIdPerfil()){

										empresaUsuario = new EmpresaUsuario();

										empresaUsuario = new EmpresaUsuario(empMod,usuMod, rolMod);

										ssoService.crearEmpresaUsuario(empresaUsuario);

										metListaEmpresaUsuario.add(empresaUsuario);

										break;
									}
								}
							}
						}
					}
					System.out.println(empMod.getNombreEmpresa());
					if(metListaEmpresaUsuario!=null){
						System.out.println("UsuarioEmpresa:"+metListaEmpresaUsuario.size());
					}
				}

				System.out.println(metListaEmpresaUsuario);
			}catch(Exception e) {

			}
		}
	}


	public void crearEmpresaUsuarioAplicacionEmpresa() throws LogicaImplException{
		List<EmpresaUsuarioAplicacionEmpresa> listaEmpresaUsuarioAplicacionEmpresa = null; 

		try{
			listaEmpresaUsuarioAplicacionEmpresa = ssoService.listarTodoEmpresaUsuarioAplicacionEmpresa();
		}catch(Exception e){

		}

		if(listaEmpresaUsuarioAplicacionEmpresa == null) {
			try {
				System.out.println("crearEmpresaUsuarioAplicacionEmpresa");/*
		select * from dbadmseguridad.empresa e 
		inner join dbadmseguridad.aplicacion_empresa ae on ae.fk_id_empresa = e.id_empresa
		where e.dominio_empresa like '%uchile%';

		select * from dbadmseguridad.empresa e 
		inner join dbadmseguridad.empresa_usuario eu on e.id_empresa = eu.fk_id_empresa
		where e.dominio_empresa like '%uchile%';

		select * from dbadmseguridad.empresa_usuario eu 
		inner join dbadmseguridad.empresa_usuario_aplicacion_empresa euae on eu.id_empresa_usuario = euae.fk_id_empresa_usuario
		where eu.id_empresa_usuario = 5;
				 */
				/*
		select * from dbadmseguridad.empresa e 
		inner join dbadmseguridad.empresa_usuario eu on e.id_empresa = eu.fk_id_empresa
		inner join dbadmseguridad.empresa_usuario_aplicacion_empresa euae on eu.id_empresa_usuario = euae.fk_id_empresa_usuario
		inner join dbadmseguridad.aplicacion_empresa ae on ae.id_aplicacion_empresa = euae.fk_id_aplicacion_empresa
		inner join dbadmseguridad.aplicacion a on a.id_aplicacion = ae.fk_id_aplicacion
		inner join dbadmseguridad.usuario_unit u on eu.fk_id_usuario = u.id_usuario
		inner join dbadmseguridad.perfil_usuariounit p on u.fk_id_perfil = p.id_perfil
		inner join dbadmseguridad.member_usuariounit m on u.fk_id_member = m.id_member
		where ae.id_aplicacion_empresa in (
		select aeD.id_aplicacion_empresa from dbadmseguridad.empresa eD 
		inner join dbadmseguridad.aplicacion_empresa aeD on aeD.fk_id_empresa = eD.id_empresa
		where eD.dominio_empresa like '%uchile%'
		)
				 */

				List<EmpresaUsuarioAplicacionEmpresa>  metListaEmpresaUsuarioAplicacionEmpresa = new ArrayList<EmpresaUsuarioAplicacionEmpresa>();

				List<EmpresaUsuario>  metListaEmpresaUsuario = new ArrayList<EmpresaUsuario>();

				List<Empresa> listaEmpresa = ssoService.listarTodoEmpresa();

				List<Usuario> listaUsuario = ssoService.listarTodoUsuario();

				for(Empresa empMod: listaEmpresa){

					metListaEmpresaUsuarioAplicacionEmpresa = new ArrayList<EmpresaUsuarioAplicacionEmpresa>();

					metListaEmpresaUsuario = new ArrayList<EmpresaUsuario>();
					//Traer UsuarioEmpresa x EMpresa 
					List<EmpresaUsuario> listaEmpresaUsuario = ssoService.listarEmpresaUsuarioxEmpresa(new EmpresaUsuario(empMod));

					//Traer AplicacionEmpresa x Empresa
					List<AplicacionEmpresa> listaAplicacionEmpresa = ssoService.listarAplicacionEmpresaxEmpresa(new AplicacionEmpresa(empMod));

					for(Usuario usuMod: listaUsuario){
						for(EmpresaUsuario empusuMod: listaEmpresaUsuario){
							if(usuMod.getIdUsuario() == empusuMod.getIdUsuario().getIdUsuario()){
								metListaEmpresaUsuario.add(empusuMod);
								break;
							}
						}
					}

					for(EmpresaUsuario empUsuMod: metListaEmpresaUsuario){
						for(AplicacionEmpresa appEmpMod: listaAplicacionEmpresa){
							EmpresaUsuarioAplicacionEmpresa eUAEMod=new EmpresaUsuarioAplicacionEmpresa();

							eUAEMod.setIdEmpresaUsuario(empUsuMod);

							eUAEMod.setIdAplicacionEmpresa(appEmpMod);

							eUAEMod.setEstadoEmpresaUsuarioAplicacionEmpresa(true);

							eUAEMod =ssoService.crearEmpresaUsuarioAplicacionEmpresa(eUAEMod);

							metListaEmpresaUsuarioAplicacionEmpresa.add(eUAEMod);
						}
					}

					System.out.println(empMod.getNombreEmpresa());
					if(metListaEmpresaUsuarioAplicacionEmpresa!=null){
						System.out.println("listaEUAE:"+metListaEmpresaUsuarioAplicacionEmpresa.size());
					}
				}
			}catch(Exception e) {

			}
		}
	}

	/***********************************************************************************************/
	//Por APlicacion-Rol Declarado dependiendo del empresaUsuarioRol asignado al metodo

	//seguridad"
	//"webmail"
	//"uchile"
	//Por Aplicacion ,  los metodos/servicios que posee 
	public void crearAplicacionServicioNegocio() throws LogicaImplException{
		List<AplicacionServicio> listaAplicacionServicio = null; 

		try{
			listaAplicacionServicio = ssoService.listarTodoAplicacionServicio();
		}catch(Exception e){

		}

		if(listaAplicacionServicio == null) {
			try {
				Aplicacion aplicacionA = ssoService.buscarAplicacion(new Aplicacion(1));
				/****			Aplicacion aplicacionB = ssoService.buscarAplicacion(new Aplicacion(2));*****/
				Aplicacion aplicacionC = ssoService.buscarAplicacion(new Aplicacion(3));

				//		Seguridad
				AplicacionServicio aplicacionServicioA=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "validarExistenciaRut","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioB=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "validarExistenciaCorreoElectronico","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioC=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "validarExistenciaUsernameLogin","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioD=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "validarExistenciaNombrePerfil","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioE=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "crearNuevoUsuarioSeguridad","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioF=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "actualizarNuevoUsuarioSeguridad","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioG=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "listarUsuarioSeguridadxEmpresaxRolxFechaCreacion","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioH=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "obtenerUsuarioSeguridadByIdUsuarioByEmailPerfil","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioI=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "listarAccionPerfilxUsuario","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioJ=new AplicacionServicio(aplicacionA, "manashiki-seguridad-wsrest", "backofficeSeguridad", "recuperarContrasenhaUsuarioSeguridad","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				ssoService.crearAplicacionServicio(aplicacionServicioA);

				ssoService.crearAplicacionServicio(aplicacionServicioB);

				ssoService.crearAplicacionServicio(aplicacionServicioC);

				ssoService.crearAplicacionServicio(aplicacionServicioD);

				ssoService.crearAplicacionServicio(aplicacionServicioE);

				ssoService.crearAplicacionServicio(aplicacionServicioF);

				ssoService.crearAplicacionServicio(aplicacionServicioG);

				ssoService.crearAplicacionServicio(aplicacionServicioH);

				ssoService.crearAplicacionServicio(aplicacionServicioI);

				ssoService.crearAplicacionServicio(aplicacionServicioJ);

				/******************************************************************/
				/******************************************************************/

				AplicacionServicio aplicacionServicioAA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarProgramaUniversidad","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioBA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarProgramaUniversidadConEstado","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioDA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarProgramaUniversidadPostulacion","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioCA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarProgramaUniversidadPostulacionConEstado","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioEA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarTipoCertificados","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioFA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarTipoCertificadoConEstado","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioGA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarFinalidadCertificado","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)

				AplicacionServicio aplicacionServicioHA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarFinalidadCertificadoConEstado","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioIA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "crearSolicitudCertificado","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioJA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarSolicitudCertificado","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioKA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarSolicitudCertificadoxEntreFechas","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioLA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarTipoSolicitud","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioMA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarTipoSolicitudConEstado","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioNA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "crearArchivoSolicitud","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioOA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "actualizarArchivoSolicitud","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioPA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "crearSolicitudAcademica","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioQA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarSolicitudAcademicas","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioRA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarSolicitudAcademicaxEntreFechas","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioSA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "buscarArchivoSolicitud","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioTA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarRegion","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioUA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarComunasxRegion","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioVA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "crearSolicitudPostulacion","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioWA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarSolicitudPostulacion","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioXA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "listarSolicitudPostulacionxEntreFechas","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				AplicacionServicio aplicacionServicioYA=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "uchileArte", "crearNegocioSolicitud","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				//		AplicacionServicio aplicacionServicioAB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "listarSemestreTemporada","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)
				//		
				//		AplicacionServicio aplicacionServicioBB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "crearSemestreTemporada","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)
				//
				//		AplicacionServicio aplicacionServicioCB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "actualizarSemestreTemporada","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)
				//		
				//		AplicacionServicio aplicacionServicioDB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "buscarSemestreTemporada","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)
				//		
				//		AplicacionServicio aplicacionServicioEB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "crearAlumno","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)
				//		
				//		AplicacionServicio aplicacionServicioFB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "actualizarAlumno","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)
				//		
				//		AplicacionServicio aplicacionServicioGB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "obtenerAlumnoxUsuario","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio)
				//		
				//		AplicacionServicio aplicacionServicioHB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "listarAlumnoNoAsociadoToUsuario","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioIB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "listarAlumnoNoAsociadoToSeguridad","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioJB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "crearProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioKB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "actualizarProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioLB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "buscarProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioMB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "listarProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioNB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "crearAlumnoProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioOB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "actualizarAlumnoProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioPB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "buscarAlumnoProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioQB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "listarAlumnoProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioRB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "crearAsignaturaProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioSB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "actualizarAsignaturaProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioTB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "buscarAsignaturaProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioUB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "listarAsignaturaProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioVB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "crearAsignaturaTomadaProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioWB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "actualizarAsignaturaTomadaProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioXB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "buscarAsignaturaTomadaProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);
				//		
				//		AplicacionServicio aplicacionServicioYB=new AplicacionServicio(aplicacionC, "manashiki-uchilearte-wsrest", "intranetUchileArteController", "listarAsignaturaTomadaProgramaActivoSemestre","", "POST"); //(idAplicacion, uriRutaAplicacionServicio, metodoHttp, estadoAplicacionServicio);

				//
				ssoService.crearAplicacionServicio(aplicacionServicioAA);

				ssoService.crearAplicacionServicio(aplicacionServicioBA);

				ssoService.crearAplicacionServicio(aplicacionServicioCA);

				ssoService.crearAplicacionServicio(aplicacionServicioDA);

				ssoService.crearAplicacionServicio(aplicacionServicioEA);

				ssoService.crearAplicacionServicio(aplicacionServicioFA);

				ssoService.crearAplicacionServicio(aplicacionServicioGA);

				ssoService.crearAplicacionServicio(aplicacionServicioHA);

				ssoService.crearAplicacionServicio(aplicacionServicioIA);

				ssoService.crearAplicacionServicio(aplicacionServicioJA);

				ssoService.crearAplicacionServicio(aplicacionServicioKA);

				ssoService.crearAplicacionServicio(aplicacionServicioLA);

				ssoService.crearAplicacionServicio(aplicacionServicioMA);

				ssoService.crearAplicacionServicio(aplicacionServicioNA);

				ssoService.crearAplicacionServicio(aplicacionServicioOA);

				ssoService.crearAplicacionServicio(aplicacionServicioPA);

				ssoService.crearAplicacionServicio(aplicacionServicioQA);

				ssoService.crearAplicacionServicio(aplicacionServicioRA);

				ssoService.crearAplicacionServicio(aplicacionServicioSA);

				ssoService.crearAplicacionServicio(aplicacionServicioTA);

				ssoService.crearAplicacionServicio(aplicacionServicioUA);

				ssoService.crearAplicacionServicio(aplicacionServicioVA);

				ssoService.crearAplicacionServicio(aplicacionServicioWA);

				ssoService.crearAplicacionServicio(aplicacionServicioXA);

				ssoService.crearAplicacionServicio(aplicacionServicioYA);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioAB);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioBB);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioCB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioDB);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioEB);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioFB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioGB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioHB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioIB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioJB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioKB);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioLB);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioMB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioNB);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioOB);
				//
				//		ssoService.crearAplicacionServicio(aplicacionServicioPB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioQB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioRB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioSB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioTB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioUB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioVB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioVB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioWB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioXB);
				//		
				//		ssoService.crearAplicacionServicio(aplicacionServicioYB);
			}catch(Exception e) {

			}
		}
	}




	//	Por Aplicacion ,  los usuario que tienen acceso que posee
	public void crearSeguridadAplicacionServicioNegocio() throws LogicaImplException{
		List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso = null; 

		try{
			listaSeguridadAplicacionAcceso = ssoService.listarTodoSeguridadAplicacionAcceso();
		}catch(Exception e){

		}

		if(listaSeguridadAplicacionAcceso == null) {
			try {
				System.out.println("crearSeguridadAplicacionServicioNegocio");

				List<Empresa> listaEmpresa = ssoService.listarTodoEmpresa();

				List<EmpresaUsuario> listaEmpresaUsuario = new ArrayList<EmpresaUsuario>();

				List<AplicacionServicio> listaAplicacionServicio = ssoService.listarTodoAplicacionServicio();

				List<EmpresaUsuarioAplicacionEmpresa> listaEmpresaUsuarioAplicacionEmpresa = new ArrayList<EmpresaUsuarioAplicacionEmpresa>(); 

				List<SeguridadAplicacionAcceso> listaSeguridadAccesoAplicacionServicio = new ArrayList<SeguridadAplicacionAcceso>();

				for(Empresa empMod: listaEmpresa){
					System.out.println("Empresa: "+empMod.getNombreEmpresa());
					listaSeguridadAccesoAplicacionServicio = new ArrayList<SeguridadAplicacionAcceso>();

					listaEmpresaUsuarioAplicacionEmpresa = new ArrayList<EmpresaUsuarioAplicacionEmpresa>();

					listaEmpresaUsuario = new ArrayList<EmpresaUsuario>();
					//Traer UsuarioEmpresa x EMpresa 
					listaEmpresaUsuario = ssoService.listarEmpresaUsuarioxEmpresa(new EmpresaUsuario(empMod));

					for(EmpresaUsuario empUsuMod: listaEmpresaUsuario){


						if(empUsuMod.getIdEmpresaUsuario().intValue()==5){
							System.out.println("aqui");
						}

						if(empMod.getIdEmpresa().intValue() == empUsuMod.getIdEmpresa().getIdEmpresa().intValue()){

							System.out.println("Empresa Usuario: "+empUsuMod.getIdEmpresaUsuario());

							listaEmpresaUsuarioAplicacionEmpresa = ssoService.listarEmpresaUsuarioAplicacionEmpresaxEU(new EmpresaUsuarioAplicacionEmpresa(empUsuMod));

							for(EmpresaUsuarioAplicacionEmpresa euaeMod: listaEmpresaUsuarioAplicacionEmpresa){
								for(AplicacionServicio appSerMod: listaAplicacionServicio){

									System.out.println("EUAE: "+euaeMod.getIdEmpresaUsuarioAplicacionEmpresa()+" - ApliServ"+appSerMod.getIdAplicacionServicio());

									SeguridadAplicacionAcceso seguridadAplicacionAcceso = new SeguridadAplicacionAcceso(euaeMod, appSerMod);

									ssoService.crearSeguridadAplicacionAcceso(seguridadAplicacionAcceso);

									listaSeguridadAccesoAplicacionServicio.add(seguridadAplicacionAcceso);
								}
							}
						}
					}

					System.out.println(empMod.getNombreEmpresa());
					if(listaSeguridadAccesoAplicacionServicio!=null){
						System.out.println("listaEUAE:"+listaSeguridadAccesoAplicacionServicio.size());
					}

				}



			}catch(Exception e) {

			}
		}
	}
}