package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.habbora.dao.SessaoDao;
import br.com.habbora.modelo.Sessao;

public class LogoutUsuario implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Logout Usuario!");
		
		SessaoDao sessoes = new SessaoDao();

		HttpSession httpSession = request.getSession();
		String httpSessionId = httpSession.getId();
		
		Sessao sessao = sessoes.read(httpSessionId);
		sessoes.delete(sessao.getChaveId());
			
		return "redirect:ListarEmpresas";
	}
}
