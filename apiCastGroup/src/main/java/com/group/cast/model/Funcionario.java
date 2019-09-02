package com.group.cast.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="FUNCIONARIO")
public class Funcionario implements Serializable{
	@Id
	@Column(name="NU_ID_FUNCIONARIO")
	private Integer nuIdFuncionario;
	@Column(name="NU_ID_EQUIPE")
	private Integer nuIdEquipe;
	
	@Column(name="VC_NAME")
	private String vcName;
	@Column(name="DT_NASCIMIENTO")
	private String dtNascimiento;
	@Column(name="DT_CONTRATO")
	private String dtContrato;
	@Column(name="VC_URL_FOTO")
	private String vcUrlFoto;
	@Column(name="NU_STATUS")
	private Integer nuStatus;
	@Column(name="DT_REGISTER")
	private String dtRegister;
	
	

	
	public Integer getNuIdFuncionario() {
		return nuIdFuncionario;
	}
	public void setNuIdFuncionario(Integer nuIdFuncionario) {
		this.nuIdFuncionario = nuIdFuncionario;
	}
	public String getVcName() {
		return vcName;
	}
	public void setVcName(String vcName) {
		this.vcName = vcName;
	}
	public String getDtNascimiento() {
		return dtNascimiento;
	}
	public void setDtNascimiento(String dtNascimiento) {
		this.dtNascimiento = dtNascimiento;
	}
	public String getDtContrato() {
		return dtContrato;
	}
	public void setDtContrato(String dtContrato) {
		this.dtContrato = dtContrato;
	}
	public String getVcUrlFoto() {
		return vcUrlFoto;
	}
	public void setVcUrlFoto(String vcUrlFoto) {
		this.vcUrlFoto = vcUrlFoto;
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
	public Integer getNuIdEquipe() {
		return nuIdEquipe;
	}
	public void setNuIdEquipe(Integer nuIdEquipe) {
		this.nuIdEquipe = nuIdEquipe;
	}
}
