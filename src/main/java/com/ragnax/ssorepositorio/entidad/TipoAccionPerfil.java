//package com.ragnax.ssorepositorio.entidad;
//
//import java.io.Serializable;
//import java.lang.String;
//
//import javax.persistence.*;
//
///**
// *  implementation class for @Entity: TipoAccionPerfil
// * en la base de Datos representa el detalle de las acciones que realiza una persona en el servicio de SSO
// */
//@Entity
//@Table (name="tipo_accion_perfil")
//
//public class TipoAccionPerfil implements Serializable{
// 
//	private static final long serialVersionUID = -1078273053362235328L;
//
//	@Id
//	@OrderBy
//	@Column(name="id_tipo_accion_perfil")
//	private Integer idTipoAccionPerfil;
//	
//	@Column(name="nombre_tipo_accion_perfil")
//	private String nombreTipoAccionPerfil;
//	
//	@Column(name="descripcion_tipo_accion_perfil")
//	private String descripcionTipoAccionPerfil;
//	
////	@OneToMany(mappedBy="idTipoAccionPerfil")
////	private List<AccionPerfil> acciones_perfiles_perfiles;
//
//	
//	public TipoAccionPerfil() {
//		super();
//	}
//
//	public TipoAccionPerfil(String nombreTipoAccionPerfil, String descripcionTipoAccionPerfil) {
//		super();
//		this.nombreTipoAccionPerfil = nombreTipoAccionPerfil;
//		this.descripcionTipoAccionPerfil = descripcionTipoAccionPerfil;
//	}
//
//	public Integer getIdTipoAccionPerfil() {
//		return idTipoAccionPerfil;
//	}
//
//
//	public void setIdTipoAccionPerfil(Integer idTipoAccionPerfil) {
//		this.idTipoAccionPerfil = idTipoAccionPerfil;
//	}
//
//
//	public String getNombreTipoAccionPerfil() {
//		return nombreTipoAccionPerfil;
//	}
//
//
//	public void setNombreTipoAccionPerfil(String nombreTipoAccionPerfil) {
//		this.nombreTipoAccionPerfil = nombreTipoAccionPerfil;
//	}
//
//
//	public String getDescripcionTipoAccionPerfil() {
//		return descripcionTipoAccionPerfil;
//	}
//
//
//	public void setDescripcionTipoAccionPerfil(String descripcionTipoAccionPerfil) {
//		this.descripcionTipoAccionPerfil = descripcionTipoAccionPerfil;
//	}
//
//
////	public List<AccionPerfil> getAcciones_perfiles_perfiles() {
////		return acciones_perfiles_perfiles;
////	}
////
////
////	public void setAcciones_perfiles_perfiles(List<AccionPerfil> acciones_perfiles_perfiles) {
////		this.acciones_perfiles_perfiles = acciones_perfiles_perfiles;
////	}
//	
//}
