package com.group.cast.bean;

import java.util.List;

import com.group.cast.model.Equipe;

public class ResponseFerias extends Response{
	private FeriasBean objFerias;
	
	public ResponseFerias( FeriasBean objFerias, Integer nuError, String vcError) {
		super(nuError, vcError);
		this.objFerias=objFerias;
	}

	public FeriasBean getObjFerias() {
		return objFerias;
	}

	public void setObjFerias(FeriasBean objFerias) {
		this.objFerias = objFerias;
	}

}
