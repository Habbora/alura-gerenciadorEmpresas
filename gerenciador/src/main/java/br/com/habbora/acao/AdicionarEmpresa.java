package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.dao.EmpresasDao;
import br.com.habbora.modelo.Empresa;

public class AdicionarEmpresa implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String parNome = request.getParameter("nome");
		
		EmpresasDao empresas = new EmpresasDao();
		
		if(parNome != null) {
			empresas.add(new Empresa(parNome));
			return "redirect:ListarEmpresas";
		} else {
			request.setAttribute("acao", "AdicionarEmpresa");
			return "forward:FormEmpresa.jsp";
		}
		
		
		
	}
}
