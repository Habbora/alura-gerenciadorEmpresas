package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "forward:home.jsp";
	}

}
