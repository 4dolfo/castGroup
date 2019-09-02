package com.group.cast.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.group.cast.bean.FeriasBean;
import com.group.cast.dao.GeneralDAO;
import com.group.cast.dao.UserDAO;
import com.group.cast.dao.UserDAOImpl;
import com.group.cast.model.Equipe;
import com.group.cast.model.Ferias;
import com.group.cast.model.Funcionario;
import com.group.cast.model.User;

@Component
@Transactional(rollbackFor=Exception.class)
public class AppServiceImpl implements AppService {
	

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private GeneralDAO generalDAO;
	
	/*
	public void setUserIDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	*/
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public User getUser(String vcEmail, String vcPassword) {
		// TODO Auto-generated method stub
		
		return userDAO.getUser(vcEmail, vcPassword);
	}

	/*LISTA TODOS EQUIPES*/
	@Override
	public List<Equipe> getAllEquipe() {
		// TODO Auto-generated method stub
		return generalDAO.getAllEquipe();
	}
	
	/*LISTA TODOS FUNCIONARIOS*/
	@Override
	public List<Funcionario> getAllFuncionario() {
		// TODO Auto-generated method stub
		return generalDAO.getAllFuncionario();
	}
	

	@Override
	public List<Funcionario> getFuncionarioByEquipe(Integer nuIdEquipe){
		return generalDAO.getFuncionarioByEquipe(nuIdEquipe);
		
	}
	
	@Override
	public List<Ferias> getFeriasByEquipe(Integer nuIdEquipe){
		return generalDAO.getFeriasByEquipe(nuIdEquipe);
		
	}
	@Override
	public void cadastrarFerias(FeriasBean objFerias) {
		generalDAO.cadastrarFerias(objFerias);
	}
	
	@Override
	public void cadastrarEquipe(Equipe objEquipe) {
		generalDAO.cadastrarEquipe(objEquipe);
	}
	
	
}