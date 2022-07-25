package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.dao.UsuariosDao;

public class ApagarUsuario implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String parId = request.getParameter("id");
		
		UsuariosDao usuariosDao = new UsuariosDao();
		usuariosDao.delete(Integer.valueOf(parId));
		
		return "redirect:ListarUsuarios";
	}
}
