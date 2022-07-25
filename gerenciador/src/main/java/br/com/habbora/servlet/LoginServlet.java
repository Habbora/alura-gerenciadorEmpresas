package br.com.habbora.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.acao.Acao;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String acao = "";
		String uri = request.getRequestURI();
		String[] multUri = uri.split("/");
		
		Class<?> classe;
		try {
			classe = Class.forName("br.com.habbora.acao.login." + multUri[2]);
			@SuppressWarnings("deprecation")
			Acao cAcao = (Acao) classe.newInstance();
			acao = cAcao.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("LoginUsuario");
		}
		
		String[] multiAcao = acao.split(":");
		if(multiAcao[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + multiAcao[1]);
			rd.forward(request, response);
		} else if(multiAcao[0].equals("redirect")) {
			response.sendRedirect(multiAcao[1]);
		} else {
			
		}
	}
}
