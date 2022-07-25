package br.com.habbora.dao;

import br.com.habbora.jdbc.BancoSessao;
import br.com.habbora.modelo.Empresa;
import br.com.habbora.modelo.Sessao;

public class SessaoDao {
	
	private static BancoSessao banco = new BancoSessao();
	
	public SessaoDao() {
		
	}

	public void add(Sessao obj) {
		banco.add(obj);
	}

	public Sessao read(Integer id) {
		return banco.read(id);
	}
	
	public Sessao read(String sessao) {
		if(sessao == null) return null;
		return banco.read(sessao);
	}

	public void update(Empresa oldEmpresa, Empresa newEmpresa) {

	}

	public void delete(Integer chaveId) {
		banco.delete(chaveId);
	}

}
