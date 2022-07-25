package br.com.habbora.modelo;

import java.io.Serializable;

public class Empresa implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	Integer chaveId = null;
	Boolean	status = false;
	String	nome = "";
	
	public Empresa(String nome) {
		this.nome = nome;
		this.status = true;
	}
	
	public Empresa(Integer chaveId, Empresa empresa) {
		this.chaveId = chaveId;
		this.nome = empresa.getNome();
		this.status = true;
	}
	
	public String getNome() {
		return this.nome;
	}

	@Override
	public String toString() {
		return String.format("%s", nome);
	}

	public Integer getChaveId() {
		return this.chaveId;
	}
	
	public void setChaveId(Integer chaveId) {
		if(this.chaveId == null)
			this.chaveId = chaveId;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
