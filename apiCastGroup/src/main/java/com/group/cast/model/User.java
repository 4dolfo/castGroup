package com.group.cast.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="USER")

public class User implements Serializable {
	@Id
	@Column(name="NU_ID_USER")
	private Integer nuIdUser;
	@Column(name="VC_NAME")
	private String vcName;
	@Column(name="VC_EMAIL")
	private String vcEmail;
	@Column(name="VC_PASSWORD")
	private String vcPassword;
	@Column(name="NU_STATUS")
	private Integer nuStatus;
	@Column(name="DT_REGISTER")
	private String dtRegister;
	public Integer getNuIdUser() {
		return nuIdUser;
	}
	public void setNuIdUser(Integer nuIdUser) {
		this.nuIdUser = nuIdUser;
	}
	public String getVcName() {
		return vcName;
	}
	public void setVcName(String vcName) {
		this.vcName = vcName;
	}
	public String getVcEmail() {
		return vcEmail;
	}
	public void setVcEmail(String vcEmail) {
		this.vcEmail = vcEmail;
	}
	public String getVcPassword() {
		return vcPassword;
	}
	public void setVcPassword(String vcPassword) {
		this.vcPassword = vcPassword;
	}
	public String getDtRegister() {
		return dtRegister;
	}
	public void setDtRegister(String dtRegister) {
		this.dtRegister = dtRegister;
	}
	
}
