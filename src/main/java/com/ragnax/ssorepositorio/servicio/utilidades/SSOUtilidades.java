package com.ragnax.ssorepositorio.servicio.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.ragnax.domain.sso.entidad.*;

public class SSOUtilidades {
	
	public static List<String> crearListaCadenaCodigoPassword(Perfil objPerfil){
		
		List<String> listaCadena = new ArrayList<String>();
		
		String passPerfil = objPerfil.getPasswordContrasenhaNormal().trim();

		listaCadena.add(passPerfil);
		
		return listaCadena; 
	}
	
	public static List<String> crearListaCadenaCodigoUsuario(Usuario objUsuario){
		
		List<String> listaCadena = new ArrayList<String>();
		
		String codigoUsuario = objUsuario.getIdMember().getIdMember()+""+ objUsuario.getIdPerfil().getIdPerfil();

		codigoUsuario = codigoUsuario.trim();
		codigoUsuario = codigoUsuario.replace("\\s", "").replace(" ", "");
		codigoUsuario = codigoUsuario.toLowerCase();
		
		listaCadena.add(codigoUsuario);
		
		return listaCadena; 
	}
	
} 
