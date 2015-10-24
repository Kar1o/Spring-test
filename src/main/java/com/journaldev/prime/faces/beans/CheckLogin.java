package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
//import java.util.ArrayList;
//import java.util.List;



import com.journaldev.hibernate.data.Login;
import com.journaldev.spring.service.LoginService;
import org.hibernate.SessionFactory;


@ManagedBean
@SessionScoped
public class CheckLogin {
    
    @ManagedProperty("#{LoginService}")
    private LoginService loginService;
    
    private Login login = new Login();
    
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    
    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public LoginService getLoginService(){
        return loginService;
    }
    
    public void setLoginService(LoginService loginService){
        this.loginService = loginService;
    }
    
    public Login getLogin(){
        return login;
    }
    
    public void setLogin(Login login){
        this.login = login;
    }
    
    /*@SuppressWarnings("unchecked")
    public Login CheckLogin(List usuario){
        List<Login> login = new ArrayList<Login>();
        
        usuario = getSessionFactory().getCurrentSession()
        .createQuery("from Login where usuario=?")
        .setParameter(0, usuario).list();
        
        
        if (login.size() > 0) {
            return login.get(0);
        } else{
            return null;
        }
            
    }*/
    
    public String check(){
    	
    	if(loginService.checkLogin(login) != null){
    	FacesMessage message = new FacesMessage("Successful login, welcome " + this.login.getUsuario());
    	FacesContext.getCurrentInstance().addMessage(null, message);
    	}
    	else{
    		FacesMessage message = new FacesMessage("Authentication failed");
    		FacesContext.getCurrentInstance().addMessage(null, message);
    	}
    	return "";
    	
    	
    }

    
}
