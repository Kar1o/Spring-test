package com.journaldev.hibernate.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Login")
public class Login {
	
	@Id
	@Column(name="idLogin")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idLogin;
	@Column(name="usuario")
	private String usuario;
	@Column(name="senha")
	private double senha;
	
	public long getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(long idLogin) {
		this.idLogin = idLogin;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public double getSenha() {
		return senha;
	}
	public void setSenha(double senha) {
		this.senha = senha;
	}
	
	
}
