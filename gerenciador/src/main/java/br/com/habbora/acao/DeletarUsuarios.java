package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.dao.UsuariosDao;

public class DeletarUsuarios implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		UsuariosDao usuariosDao = new UsuariosDao();
		usuariosDao.clear();
		
		return "redirect:LogoutUsuario";
	}
}
