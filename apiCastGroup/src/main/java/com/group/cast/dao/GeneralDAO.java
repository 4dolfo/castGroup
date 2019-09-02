package com.group.cast.dao;

import java.util.List;

import com.group.cast.bean.FeriasBean;
import com.group.cast.model.Equipe;
import com.group.cast.model.Ferias;
import com.group.cast.model.Funcionario;
import com.group.cast.model.User;

public interface GeneralDAO {
	public List<Equipe> getAllEquipe();
	public List<Funcionario> getAllFuncionario();
	public List<Funcionario> getFuncionarioByEquipe(Integer nuIdEquipe);
	
	public List<Ferias> getFeriasByEquipe(Integer nuIdEquipe);
	
	public void cadastrarFerias(FeriasBean objFerias);
	
	public void cadastrarEquipe(Equipe objEquipe);
	
	
	
}
