package com.group.cast.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.group.cast.bean.FeriasBean;
import com.group.cast.model.Equipe;
import com.group.cast.model.Ferias;
import com.group.cast.model.Funcionario;
import com.group.cast.model.User;

@Repository
@Transactional
public class GeneralDAOImpl implements GeneralDAO{
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	/*LISTA EQUIPES*/
	@Override
	public List<Equipe> getAllEquipe() {
		// TODO Auto-generated method stub
		//System.out.println("getUsers");
		
		List<Equipe> lstEquipe =  entitymanager.createQuery("Select u from Equipe u where u.nuStatus = 1", Equipe.class)
				.getResultList();
				
		return lstEquipe;
	}
	
	/*LISTA FUNCIONARIOS*/
	@Override
	public List<Funcionario> getAllFuncionario() {
		// TODO Auto-generated method stub
		//System.out.println("getUsers");
		
		List<Funcionario> lstFuncionario =  entitymanager.createQuery("Select u from Funcionario u where u.nuStatus = 1", Funcionario.class)
				.getResultList();
				
		return lstFuncionario;
	}
	
	
	
	
	public List<Funcionario> getFuncionarioByEquipe(Integer nuIdEquipe){
		List<Funcionario> lstFuncionario =  entitymanager.createQuery("Select u from Funcionario u  where u.nuIdEquipe = :nuIdEquipe and u.nuStatus =1", Funcionario.class)
				.setParameter("nuIdEquipe", nuIdEquipe)
				.getResultList();
				
		return lstFuncionario;
	}
	
	public List<Ferias> getFeriasByEquipe(Integer nuIdEquipe){
		List<Ferias> lstFerias =  entitymanager.createQuery("Select u from Ferias u  where u.nuIdEquipe = :nuIdEquipe and u.nuStatus=1", Ferias.class)
				.setParameter("nuIdEquipe", nuIdEquipe)
				.getResultList();
				
		return lstFerias;
	}
	
	public void cadastrarFerias(FeriasBean objFerias) {
		//System.out.println("cadastrarFerias");
		entitymanager.createNativeQuery("INSERT INTO Ferias (NU_ID_FUNCIONARIO, NU_ID_EQUIPE, DT_INICIO, DT_FIN, NU_STATUS) "
				+ " VALUES ( :nuIdFuncionario , :nuIdEquipe, :dtInicio, :dtFin, 1)")
				.setParameter("nuIdFuncionario", objFerias.getObjFuncionario().getNuIdFuncionario())		
				.setParameter("nuIdEquipe", objFerias.getObjFuncionario().getNuIdEquipe())
				.setParameter("dtInicio", objFerias.getObjPeriodo().getDtInicio())
				.setParameter("dtFin", objFerias.getObjPeriodo().getDtFin())
				.executeUpdate();
				
	}
	

	public void cadastrarEquipe(Equipe objEquipe) {
		//System.out.println("cadastrarEquipe");
		entitymanager.createNativeQuery("INSERT INTO Equipe (VC_NAME, NU_STATUS) "
				+ " VALUES ( :vcName ,  1)")
				.setParameter("vcName", objEquipe.getVcName())		
				.executeUpdate();
	}
	

}
