package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.dao.EmpresasDao;
import br.com.habbora.modelo.Empresa;

public class EditarEmpresa implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String parAcao = request.getParameter("acao");
		String parNome = request.getParameter("nome");
		String parId = request.getParameter("id");
		
		EmpresasDao empresas = new EmpresasDao();
		
		if(parAcao != null && parNome != null) {
			Empresa empresa = empresas.read(Integer.valueOf(parId));
			empresa.setNome(parNome);
			return "redirect:ListarEmpresas";
		} else {
			Empresa empresa = empresas.read(Integer.valueOf(parId));
			request.setAttribute("empresa", empresa);
			request.setAttribute("acao", "EditarEmpresa");
			return "forward:FormEmpresa.jsp";
		}
	}
}
