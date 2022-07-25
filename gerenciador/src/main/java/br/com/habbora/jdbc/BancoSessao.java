package br.com.habbora.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.habbora.modelo.Sessao;

public class BancoSessao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Sessao> banco = new ArrayList<Sessao>();
	private Integer chaveId = 0;

	public void add(Sessao obj) {
		obj.setChaveId(chaveId++);
		banco.add(obj);
	}

	public Sessao read(Integer chaveId) {
		for(Sessao obj: banco) {
			if(obj.getChaveId().equals(chaveId))
				return obj;
		}
		return null;
	}
	
	public Sessao read(String sessao) {
		for(Sessao obj: banco) {
			if(obj.getSession().equals(sessao))
				return obj;
		}
		return null;
	}
	
	public void delete(Integer chaveId) {
		for(Sessao obj : banco) {
			if(obj.getChaveId().equals(chaveId)) {
				banco.remove(obj);
				return;
			}
		}
	}

	
}
