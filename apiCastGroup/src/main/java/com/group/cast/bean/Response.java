package com.group.cast.bean;

public class Response {
	private Integer nuError;
	private String vcError;
	
	public Response(){
		this.nuError=0;
		this.vcError="";
	}
	public Response(Integer nuError, String vcError) {
		this.nuError=nuError;
		this.vcError=vcError;
	}
	public Integer getNuError() {
		return nuError;
	}
	public void setNuError(Integer nuError) {
		this.nuError = nuError;
	}
	public String getVcError() {
		return vcError;
	}
	public void setVcError(String vcError) {
		this.vcError = vcError;
	}
}
