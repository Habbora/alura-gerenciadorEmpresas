package br.com.habbora.modelo;

import java.io.Serializable;

public class Sessao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Integer chaveId = 0;
	String session;
	Usuario usuario;
	
	public Sessao(String session, Usuario usuario) {
		this.session = session;
		this.usuario = usuario;
	}
	
	public Integer getChaveId() {
		return chaveId;
	}
	
	public void setChaveId(Integer chaveId) {
		this.chaveId = chaveId;
	}
	
	public String getSession() {
		return session;
	}
	
	public void setSession(String session) {
		this.session = session;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
