package com.group.cast.ws.security;

public class Usuario {
	private Integer nuIdUsuario; // Codigo del usuario
	private String vcUsuario;
	private Integer nuIdSesion;
	private String vcNombre;//
	private Integer nuIdPerfil;
	private String vcPerfil;
	private Integer nuIdAplicativo;
	private String vcSiglaAplicativo;
	private Integer nuIdOficina; //
	private String vcOficina; //
	private String vcCodDepartamento;
	private String vcJWT; //
	private String vcCodTipoPersona;
	private String vcCodTipoDocumento;
	private String vcNroDocumento;
	
	public void Usuario() {
		
	}

	public Integer getNuIdUsuario() {
		return nuIdUsuario;
	}

	public void setNuIdUsuario(Integer nuIdUsuario) {
		this.nuIdUsuario = nuIdUsuario;
	}

	public String getVcUsuario() {
		return vcUsuario;
	}

	public void setVcUsuario(String vcUsuario) {
		this.vcUsuario = vcUsuario;
	}

	public Integer getNuIdSesion() {
		return nuIdSesion;
	}

	public void setNuIdSesion(Integer nuIdSesion) {
		this.nuIdSesion = nuIdSesion;
	}

	public String getVcNombre() {
		return vcNombre;
	}

	public void setVcNombre(String vcNombre) {
		this.vcNombre = vcNombre;
	}

	public Integer getNuIdPerfil() {
		return nuIdPerfil;
	}

	public void setNuIdPerfil(Integer nuIdPerfil) {
		this.nuIdPerfil = nuIdPerfil;
	}

	public String getVcPerfil() {
		return vcPerfil;
	}

	public void setVcPerfil(String vcPerfil) {
		this.vcPerfil = vcPerfil;
	}

	public Integer getNuIdAplicativo() {
		return nuIdAplicativo;
	}

	public void setNuIdAplicativo(Integer nuIdAplicativo) {
		this.nuIdAplicativo = nuIdAplicativo;
	}

	public Integer getNuIdOficina() {
		return nuIdOficina;
	}

	public void setNuIdOficina(Integer nuIdOficina) {
		this.nuIdOficina = nuIdOficina;
	}

	public String getVcOficina() {
		return vcOficina;
	}

	public void setVcOficina(String vcOficina) {
		this.vcOficina = vcOficina;
	}

	public String getVcSiglaAplicativo() {
		return vcSiglaAplicativo;
	}

	public void setVcSiglaAplicativo(String vcSiglaAplicativo) {
		this.vcSiglaAplicativo = vcSiglaAplicativo;
	}

	public String getVcCodTipoPersona() {
		return vcCodTipoPersona;
	}

	public void setVcCodTipoPersona(String vcCodTipoPersona) {
		this.vcCodTipoPersona = vcCodTipoPersona;
	}

	public String getVcJWT() {
		return vcJWT;
	}

	public void setVcJWT(String vcJWT) {
		this.vcJWT = vcJWT;
	}

	public String getVcCodTipoDocumento() {
		return vcCodTipoDocumento;
	}

	public void setVcCodTipoDocumento(String vcCodTipoDocumento) {
		this.vcCodTipoDocumento = vcCodTipoDocumento;
	}

	public String getVcNroDocumento() {
		return vcNroDocumento;
	}

	public void setVcNroDocumento(String vcNroDocumento) {
		this.vcNroDocumento = vcNroDocumento;
	}

	public String getVcCodDepartamento() {
		return vcCodDepartamento;
	}

	public void setVcCodDepartamento(String vcCodDepartamento) {
		this.vcCodDepartamento = vcCodDepartamento;
	}
	
	
}
