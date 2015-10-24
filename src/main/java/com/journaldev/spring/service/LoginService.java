package com.journaldev.spring.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

import com.journaldev.hibernate.data.Login;

@Component
public class LoginService {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*@Transactional
	public boolean checkLogin(Login login){
	    Session session = sessionFactory.getCurrentSession();
	    
	    session.List<Login> login = Login.findAll();
	    
	    if(login.size() > 0){
	        return 
	    }
	}*/
	
	//@SuppressWarnings("unchecked")
    public Login checkLogin(Login usuario){
        List<Login> login = new ArrayList<Login>();
        
        usuario = (Login) getSessionFactory().getCurrentSession()
        .createQuery("from Login where usuario=?")
        .setParameter(0, usuario).list();
        
        
        if (login.size() > 0) {
            return login.get(0);
        } else{
            return null;
        }
    	
    	
    	/*Session session = sessionFactory.getCurrentSession();
    	if(session.equals(usuario)){
    	}*/
            
    }

}
