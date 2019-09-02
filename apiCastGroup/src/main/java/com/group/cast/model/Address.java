package com.group.cast.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address  implements Serializable {
	@Id
	@Column(name="NU_ID_ADDRESS")
	private Integer nuIdAddress;
	@Column(name="NU_ID_FUNCIONARIO")
	private Integer nuIdFuncionario;
	@Column(name="VC_RUA")
	private String vcRua;
	@Column(name="VC_NUMERO")
	private String vcNumero;
	@Column(name="VC_COMPLEMENTO")
	private String vcComplemento;
	@Column(name="VC_BAIRRO")
	private String vcBairro;
	@Column(name="VC_CIDADE")
	private String vcCidade;
	@Column(name="VC_ESTADO")
	private String vcEstado;
	@Column(name="NU_STATUS")
	private Integer nuStatus;
	@Column(name="DT_REGISTER")
	private String dtRegister;
	public Integer getNuIdAddress() {
		return nuIdAddress;
	}
	public void setNuIdAddress(Integer nuIdAddress) {
		this.nuIdAddress = nuIdAddress;
	}
	public Integer getNuIdFuncionario() {
		return nuIdFuncionario;
	}
	public void setNuIdFuncionario(Integer nuIdFuncionario) {
		this.nuIdFuncionario = nuIdFuncionario;
	}
	public String getVcRua() {
		return vcRua;
	}
	public void setVcRua(String vcRua) {
		this.vcRua = vcRua;
	}
	public String getVcNumero() {
		return vcNumero;
	}
	public void setVcNumero(String vcNumero) {
		this.vcNumero = vcNumero;
	}
	public String getVcComplemento() {
		return vcComplemento;
	}
	public void setVcComplemento(String vcComplemento) {
		this.vcComplemento = vcComplemento;
	}
	public String getVcBairro() {
		return vcBairro;
	}
	public void setVcBairro(String vcBairro) {
		this.vcBairro = vcBairro;
	}
	public String getVcCidade() {
		return vcCidade;
	}
	public void setVcCidade(String vcCidade) {
		this.vcCidade = vcCidade;
	}
	public String getVcEstado() {
		return vcEstado;
	}
	public void setVcEstado(String vcEstado) {
		this.vcEstado = vcEstado;
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
