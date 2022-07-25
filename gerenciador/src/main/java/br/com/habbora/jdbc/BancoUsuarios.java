package br.com.habbora.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.habbora.modelo.Usuario;

public class BancoUsuarios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Usuario> banco = new ArrayList<Usuario>();
	private Integer chaveId = 0;

	public void add(Usuario usuario) {
		usuario.setChaveId(chaveId++);
		banco.add(usuario);
	}

	public Usuario read(Integer chaveId) {
		for(Usuario usuario: banco) {
			if(usuario.getChaveId().equals(chaveId))
				return usuario;
		}
		return null;
	}
	
	public Usuario read(String nickname) {
		for(Usuario usuario: banco) {
			if(usuario.getNickname().equals(nickname))
				return usuario;
		}
		return null;
	}
	
	public void delete(Integer chaveId) {
		for(Usuario usuario : banco) {
			if(usuario.getChaveId().equals(chaveId)) {
				banco.remove(usuario);
				return;
			}
		}
	}
	
	@Override
	public String toString() {
		String saida = "";
		for(Usuario usuario : banco) {
			saida += String.format("ID: %d, ", usuario.getChaveId());
			saida += String.format("Nome: %s;", usuario.getNickname());
			saida += String.format("\n");
		}
		return saida;
	}

	public List<Usuario> getBanco() {
		System.out.println(this.banco);
		return this.banco;
	}

	public int getSize() {
		return banco.size();
	}

	public Usuario isValid(String nome, String senha) {
		for(Usuario usuario: banco) {
			if(usuario.isValid(nome,senha)) {
				return usuario;
			}
		}
		return null;
	}
}
