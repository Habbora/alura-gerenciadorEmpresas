package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.dao.EmpresasDao;

public class ListarEmpresas implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		EmpresasDao empresas = new EmpresasDao();
		request.setAttribute("empresas", empresas.getEmpresas());
		
		return "forward:ListarEmpresas.jsp";
	}

}
