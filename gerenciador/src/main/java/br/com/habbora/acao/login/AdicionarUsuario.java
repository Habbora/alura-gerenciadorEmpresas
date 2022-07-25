package br.com.habbora.acao.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.acao.Acao;
import br.com.habbora.dao.UsuariosDao;
import br.com.habbora.modelo.Usuario;

public class AdicionarUsuario implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		UsuariosDao usuariosDao = new UsuariosDao();

		String parNome = request.getParameter("nome");
		String parNickname = request.getParameter("nickname");
		String parSenha = request.getParameter("senha");
		String parSenha2 = request.getParameter("senha2");

		if (parNome != null && parNickname != null && parSenha != null && parSenha2 != null) {

			if (!parNome.isBlank() && !parNickname.isBlank() && !parSenha.isBlank()) {

				if (parSenha.equals(parSenha2)) {

					if (usuariosDao.read(parNickname) == null) {

						usuariosDao.add(new Usuario(parNome, parNickname, parSenha));
						return "redirect:LoginUsuario";
					} else {
						request.setAttribute("msg", "<br> Usuário já existe! <br><br>");
					}
				} else {
					request.setAttribute("msg", "<br> Senhas diferentes! <br><br>");
				}
			} else {
				request.setAttribute("msg", "<br> Faltando informação! <br><br>");
			}
		} else {

		}
		request.setAttribute("acao", "AdicionarUsuario");
		return "forward:FormUsuario.jsp";
	}
}
