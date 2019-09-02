package com.group.cast.bean;

public class Funcionario {
	
	private Integer nuMatricula;
	private String vcNome;
	private String dtNascemento;
	private Endereco objEndereco;
	private String dtContratacao;
	private String vcFoto;
	private Equipe objEquipe;
	
	public Integer getNuMatricula() {
		return nuMatricula;
	}
	public void setNuMatricula(Integer nuMatricula) {
		this.nuMatricula = nuMatricula;
	}
	public String getVcNome() {
		return vcNome;
	}
	public void setVcNome(String vcNome) {
		this.vcNome = vcNome;
	}
	public String getDtNascemento() {
		return dtNascemento;
	}
	public void setDtNascemento(String dtNascemento) {
		this.dtNascemento = dtNascemento;
	}
	public Endereco getObjEndereco() {
		return objEndereco;
	}
	public void setObjEndereco(Endereco objEndereco) {
		this.objEndereco = objEndereco;
	}
	public String getDtContratacao() {
		return dtContratacao;
	}
	public void setDtContratacao(String dtContratacao) {
		this.dtContratacao = dtContratacao;
	}
	public String getVcFoto() {
		return vcFoto;
	}
	public void setVcFoto(String vcFoto) {
		this.vcFoto = vcFoto;
	}
	public Equipe getObjEquipe() {
		return objEquipe;
	}
	public void setObjEquipe(Equipe objEquipe) {
		this.objEquipe = objEquipe;
	}
	
}
