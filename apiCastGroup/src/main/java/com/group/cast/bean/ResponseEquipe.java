package com.group.cast.bean;

import java.util.List;

import com.group.cast.model.Equipe;

public class ResponseEquipe extends Response{
	private List<Equipe> lstEquipe;
	public ResponseEquipe(List<Equipe> lstEquipe, Integer nuError, String vcError) {
		super(nuError, vcError);
		this.lstEquipe=lstEquipe;
	}
	public List<Equipe> getLstEquipe() {
		return lstEquipe;
	}
	public void setLstEquipe(List<Equipe> lstEquipe) {
		this.lstEquipe = lstEquipe;
	}
	
}
