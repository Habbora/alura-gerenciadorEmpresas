package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	
	public String execute(HttpServletRequest request, HttpServletResponse response);

}
