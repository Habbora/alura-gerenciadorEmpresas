package br.com.habbora.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.habbora.dao.SessaoDao;
import br.com.habbora.modelo.Sessao;

@WebFilter("/*")
public class LoginFilter extends HttpFilter implements Filter {
	
	private static final long serialVersionUID = 1L;

	public LoginFilter() {
        super();
        
    }
    
	public void destroy() {
		
	}
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Banco de dados;
		// UsuariosDao usuarios = new UsuariosDao();
		SessaoDao sessoes = new SessaoDao();
		
		String uri = request.getRequestURI();
		
		HttpSession httpSession = request.getSession();
		String httpSessionId = httpSession.getId();
		
		Sessao sessao = sessoes.read(httpSessionId);
		if(sessao != null) {
			request.setAttribute("usuarioNome", sessao.getUsuario().getNome());
			request.setAttribute("usuarioNivel", Integer.valueOf(5));
			chain.doFilter(request, response);
		} else if(uri.contains("LoginUsuario") || uri.contains("AdicionarUsuario")) {
			LoginServlet loginServlet = new LoginServlet();
			loginServlet.service(request, response);
		}else {
			response.sendRedirect("LoginUsuario");
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
