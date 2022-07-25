package br.com.habbora.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.habbora.modelo.Empresa;

public class BancoEmpresas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Empresa> banco = new ArrayList<Empresa>();
	private Integer chaveId = 0;

	public void add(Empresa empresa) {
		empresa.setChaveId(chaveId++);
		banco.add(empresa);
	}

	public Empresa read(Integer chaveId) {
		for(Empresa empresa: banco) {
			if(empresa.getChaveId().equals(chaveId))
				return empresa;
		}
		return null;
	}
	
	public void delete(Integer chaveId) {
		for(Empresa empresa : banco) {
			if(empresa.getChaveId().equals(chaveId)) {
				banco.remove(empresa);
				return;
			}
		}
	}
	
	@Override
	public String toString() {
		String saida = "";
		for(Empresa empresa : banco) {
			saida += String.format("ID: %d, ", empresa.getChaveId());
			saida += String.format("Nome: %s;", empresa.getNome());
			saida += String.format("\n");
		}
		return saida;
	}

	public void clear() {
		banco.clear();
		
	}

	public List<Empresa> getEmpresas() {
		System.out.println(this.banco);
		return this.banco;
	}
}
