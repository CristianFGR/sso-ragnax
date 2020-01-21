//package com.ragnax.ssorepositorio.entidad;
//
//import java.io.Serializable;
//
//import javax.persistence.*;
//
///**
// *  implementation class for @Entity: MaquinaEmpresa
// * en la base de Datos representa las empresas que pueden acceder a los servicios de la empresa Tesoro del Cielo.
// */
//@Entity
//@Table (name="maquina_empresa")
//
//public class MaquinaEmpresa implements Serializable{
// 
//	private static final long serialVersionUID = -40956965837493271L;
//
//	@Id
//	@OrderBy
//	@Column(name="id_maquina_empresa")
//	private Integer idMaquinaEmpresa;
//	
//	@ManyToOne
//	@JoinColumn(name="fk_id_empresa")
//	private Empresa idEmpresa;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="fk_id_maquina")
//	private Maquina idMaquina;
//	
//	public MaquinaEmpresa() {
//		super();
//	}
//	
//	public MaquinaEmpresa(Maquina idMaquina, Empresa idEmpresa) {
//		super();
//		this.idEmpresa = idEmpresa;
//		this.idMaquina = idMaquina;
//	}
//
//	public Integer getIdMaquinaEmpresa() {
//		return idMaquinaEmpresa;
//	}
//
//	public void setIdMaquinaEmpresa(Integer idMaquinaEmpresa) {
//		this.idMaquinaEmpresa = idMaquinaEmpresa;
//	}
//
//	public Empresa getIdEmpresa() {
//		return idEmpresa;
//	}
//
//	public void setIdEmpresa(Empresa idEmpresa) {
//		this.idEmpresa = idEmpresa;
//	}
//
//	public Maquina getIdMaquina() {
//		return idMaquina;
//	}
//
//	public void setIdMaquina(Maquina idMaquina) {
//		this.idMaquina = idMaquina;
//	}
//	
//}
