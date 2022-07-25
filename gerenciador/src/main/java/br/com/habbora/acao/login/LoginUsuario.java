package br.com.habbora.acao.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.habbora.acao.Acao;
import br.com.habbora.dao.SessaoDao;
import br.com.habbora.dao.UsuariosDao;
import br.com.habbora.modelo.Sessao;
import br.com.habbora.modelo.Usuario;

public class LoginUsuario implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		SessaoDao sessoes = new SessaoDao();
		UsuariosDao usuarios = new UsuariosDao();
		
		String parNome = request.getParameter("nome");
		String parSenha = request.getParameter("senha");

		HttpSession httpSession = request.getSession();
		String httpSessionId = httpSession.getId();
		
		if(parNome == null || parSenha == null) {
			return "forward:LoginUsuario.jsp";
		}
		
		Usuario usuario = usuarios.isValid(parNome, parSenha);
		if(usuario != null)
			sessoes.add(new Sessao(httpSessionId, usuario));
			
		return "redirect:ListarEmpresas";
	}
}
