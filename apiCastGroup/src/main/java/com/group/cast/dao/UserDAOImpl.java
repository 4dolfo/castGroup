package com.group.cast.dao;

import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.group.cast.model.User;
import com.group.cast.security.Constants;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	
	@PersistenceContext
	private EntityManager entitymanager;
	
	
	@Override
	public List<User> findAll(){
		// TODO Auto-generated method stub
		return entitymanager.createQuery("from User", User.class).getResultList();
	}

	@Override
	public User getUser(String vcEmail, String vcPassword) {
		// TODO Auto-generated method stub
		//System.out.println("getUsers");
		
		List<User> lstUser =  entitymanager.createQuery("Select u from User u where u.vcEmail = :vcEmail and u.nuStatus = 1", User.class)
				.setParameter("vcEmail", vcEmail)
				.getResultList();
		
		User user = null;
		//System.out.println("L="+lstUser.size());
		if(lstUser.size()!=0) {

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			if (passwordEncoder.matches(vcPassword, lstUser.get(0).getVcPassword())) {
				user=lstUser.get(0);
				
			}

		}
		
		
		return user;
	}
	
	
	/*
	@Override
	public Personel findById(Long id) {
	
		return entitymanager.find(Personel.class, id);
	}

	@Override
	public List<Personel> findByFirstName(String firstname) {
		
		return entitymanager.createQuery("from Personel where first_name = :first_name", Personel.class)
				.setParameter("first_name", firstname).getResultList();
	}

	@Override
	public void create(Personel personel) {
		entitymanager.persist(personel);

	}

	@Override
	public Personel update(Personel personel) {
		
		return entitymanager.merge(personel);
	}

	@Override
	public void delete(Long id) {
		entitymanager.remove(entitymanager.getReference(Personel.class, id));
	}
	
	*/
}