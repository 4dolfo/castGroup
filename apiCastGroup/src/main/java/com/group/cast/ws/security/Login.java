package com.group.cast.ws.security;

public class Login {

	private String  vcUsuario;
	private String vcPassword;
	private String vcAbreviatura;
	private String vcVersion;
	private String vcSiglaAplicacion;
	private Integer nuSSO;
	
	public Login(){
		
	}
	public Login(String vcUsuario, String vcPassword) {
		this.vcUsuario=vcUsuario;
		this.vcPassword=vcPassword;
	}
	public String getVcUsuario() {
		return vcUsuario;
	}
	public void setVcUsuario(String vcUsuario) {
		this.vcUsuario = vcUsuario;
	}
	public String getVcPassword() {
		return vcPassword;
	}
	public void setVcPassword(String vcPassword) {
		this.vcPassword = vcPassword;
	}
	public String getVcAbreviatura() {
		return vcAbreviatura;
	}
	public void setVcAbreviatura(String vcAbreviatura) {
		this.vcAbreviatura = vcAbreviatura;
	}
	public String getVcVersion() {
		return vcVersion;
	}
	public void setVcVersion(String vcVersion) {
		this.vcVersion = vcVersion;
	}
	public String getVcSiglaAplicacion() {
		return vcSiglaAplicacion;
	}
	public void setVcSiglaAplicacion(String vcSiglaAplicacion) {
		this.vcSiglaAplicacion = vcSiglaAplicacion;
	}
	public Integer getNuSSO() {
		return nuSSO;
	}
	public void setNuSSO(Integer nuSSO) {
		this.nuSSO = nuSSO;
	}
	
	
}

