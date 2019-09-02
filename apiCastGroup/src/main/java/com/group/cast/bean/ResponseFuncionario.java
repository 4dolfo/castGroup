package com.group.cast.bean;

import java.util.List;

import com.group.cast.model.Funcionario;


public class ResponseFuncionario extends Response{
	private List<Funcionario> lstFuncionario;
	public ResponseFuncionario(List<Funcionario> lstFuncionario, Integer nuError, String vcError) {
		super(nuError, vcError);
		this.lstFuncionario=lstFuncionario;
	}
	public List<Funcionario> getLstFuncionario() {
		return lstFuncionario;
	}
	public void setLstFuncionario(List<Funcionario> lstFuncionario) {
		this.lstFuncionario = lstFuncionario;
	}
	
	
}
