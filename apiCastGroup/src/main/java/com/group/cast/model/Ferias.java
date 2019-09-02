package com.group.cast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FERIAS")
public class Ferias {
	@Id
	@Column(name="NU_ID_FERIAS")
	private Integer nuIdFerias;
	@Column(name="NU_ID_FUNCIONARIO")
	private Integer nuIdFuncionario;
	@Column(name="NU_ID_EQUIPE")
	private Integer nuIdEquipe;
	@Column(name="DT_INICIO")
	private String dtInicio;
	@Column(name="DT_FIN")
	private String dtFin;
	@Column(name="NU_STATUS")
	private Integer nuStatus;
	@Column(name="DT_REGISTER")
	private String dtRegister;
	
	public Integer getNuIdFerias() {
		return nuIdFerias;
	}
	public void setNuIdFerias(Integer nuIdFerias) {
		this.nuIdFerias = nuIdFerias;
	}
	public Integer getNuIdFuncionario() {
		return nuIdFuncionario;
	}
	public void setNuIdFuncionario(Integer nuIdFuncionario) {
		this.nuIdFuncionario = nuIdFuncionario;
	}
	public Integer getNuIdEquipe() {
		return nuIdEquipe;
	}
	public void setNuIdEquipe(Integer nuIdEquipe) {
		this.nuIdEquipe = nuIdEquipe;
	}
	public String getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}
	public String getDtFin() {
		return dtFin;
	}
	public void setDtFin(String dtFin) {
		this.dtFin = dtFin;
	}
	public Integer getNuStatus() {
		return nuStatus;
	}
	public void setNuStatus(Integer nuStatus) {
		this.nuStatus = nuStatus;
	}
	public String getDtRegister() {
		return dtRegister;
	}
	public void setDtRegister(String dtRegister) {
		this.dtRegister = dtRegister;
	}
	
	
}
