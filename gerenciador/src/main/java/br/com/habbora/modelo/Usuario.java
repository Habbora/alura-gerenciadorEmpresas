package br.com.habbora.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Integer chaveId = 0;
	String sessao = "";
	String nome = "";
	String nickname = "";
	String senha = "";
	
	public Usuario(String nome, String nickname, String senha) {
		this.nome = nome;
		this.nickname = nickname;
		this.senha = senha;
	}
	
	public Integer getChaveId() {
		return chaveId;
	}
	
	public void setChaveId(Integer chaveId) {
		this.chaveId = chaveId;
	}
	
	public String getSessao() {
		return sessao;
	}
	
	public void setSessao(String sessao) {
		this.sessao = sessao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Boolean isValid(String nickname, String senha) {
		if(nickname == null || senha == null) return false;
		if(this.nickname.equals(nickname) && this.senha.equals(senha))
			return true;
		return false;
	}
	
	public Boolean isValid(Usuario usuario) {
		if(this.nickname.equals(usuario.getNickname()) && this.senha.equals(usuario.getSenha()))
			return true;
		return false;
	}
	
	public Boolean isValid(String sessao) {
		if(sessao == null) sessao = "";
		if(this.sessao.equals(sessao))
			return true;
		return false;
	}

}
