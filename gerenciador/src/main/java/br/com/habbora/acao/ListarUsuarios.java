package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.dao.UsuariosDao;

public class ListarUsuarios implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		UsuariosDao usuarios = new UsuariosDao();
		request.setAttribute("usuarios", usuarios.getBanco());
		
		return "forward:ListarUsuarios.jsp";
	}

}
