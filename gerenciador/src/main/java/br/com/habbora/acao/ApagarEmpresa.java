package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.dao.EmpresasDao;

public class ApagarEmpresa implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String parId = request.getParameter("id");
		
		EmpresasDao empresas = new EmpresasDao();
		empresas.delete(Integer.valueOf(parId));
		
		return "redirect:ListarEmpresas";
	}
}
