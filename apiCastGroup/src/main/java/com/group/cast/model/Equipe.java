package com.group.cast.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPE")
public class Equipe  implements Serializable {
	@Id
	@Column(name="NU_ID_EQUIPE")
	private Integer nuIdEquipe;
	@Column(name="VC_NAME")
	private String vcName;
	@Column(name="NU_STATUS")
	private Integer nuStatus;
	@Column(name="DT_REGISTER")
	private String dtRegister;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Funcionario> lstFuncionario;
	
	
	public Integer getNuIdEquipe() {
		return nuIdEquipe;
	}
	public void setNuIdEquipe(Integer nuIdEquipe) {
		this.nuIdEquipe = nuIdEquipe;
	}
	public String getVcName() {
		return vcName;
	}
	public void setVcName(String vcName) {
		this.vcName = vcName;
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
