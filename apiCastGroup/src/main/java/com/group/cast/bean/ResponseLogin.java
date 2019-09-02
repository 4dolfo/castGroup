package com.group.cast.bean;

public class ResponseLogin extends Response{
	private Usuario usuario;
	public ResponseLogin(Usuario usuario, Integer nuError, String vcError) {
		super(nuError, vcError);
		this.usuario=usuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
