package br.com.habbora.dao;

import java.util.List;

import br.com.habbora.jdbc.BancoUsuarios;
import br.com.habbora.jdbc.FileDataObject;
import br.com.habbora.modelo.Usuario;

public class UsuariosDao {
	
	String dir = "usuario.jdb";

	private FileDataObject fileDataObject = new FileDataObject(dir);
	private static BancoUsuarios bancoUsuarios;
	
	public UsuariosDao() {
		if(bancoUsuarios == null) {
			//System.out.println("Banco de dados sendo carregado!");
			bancoUsuarios = (BancoUsuarios) fileDataObject.load();
			if(bancoUsuarios == null) {
				bancoUsuarios = new BancoUsuarios();
				fileDataObject.save(bancoUsuarios);
			}
		} else {
			//System.out.println("Banco de dados já iniciado!");
		}
		
		if(bancoUsuarios.getSize() == 0) {
			Usuario admin = new Usuario("Administrador", "admin", "12345678");
			this.add(admin);
		}
	}

	public void add(Usuario usuario) {
		bancoUsuarios.add(usuario);
		fileDataObject.save(bancoUsuarios);
	}

	public Usuario read(Integer id) {
		return bancoUsuarios.read(id);
	}
	
	public Usuario read(String nickname) {
		return bancoUsuarios.read(nickname);
	}

	public void delete(Integer chaveId) {
		bancoUsuarios.delete(chaveId);
		fileDataObject.save(bancoUsuarios);
	}
	
	@Override
	public String toString() {
		return bancoUsuarios.toString();
	}

	public void clear() {
		fileDataObject.delete();
		bancoUsuarios = new BancoUsuarios();
		Usuario admin = new Usuario("Administrador", "admin", "12345678");
		this.add(admin);
	}
	
	public void toBeDestroyed() {
		bancoUsuarios = null;
	}

	public List<Usuario> getBanco() {
		return bancoUsuarios.getBanco();
	}
	
	public Integer getSize() {
		return bancoUsuarios.getSize();
	}

	public Usuario isValid(String nome, String senha) {
		return bancoUsuarios.isValid(nome,senha);
	}

	public void update() {
		fileDataObject.save(bancoUsuarios);
	}

}
