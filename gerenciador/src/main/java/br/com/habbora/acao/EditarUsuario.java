package br.com.habbora.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.habbora.dao.UsuariosDao;
import br.com.habbora.modelo.Usuario;

public class EditarUsuario implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String parNome = request.getParameter("nome");
		String parNickname = request.getParameter("nickname");
		String parSenha = request.getParameter("senha");
		String parSenha2 = request.getParameter("senha2");
		String parId = request.getParameter("id");
		
		UsuariosDao usuarios = new UsuariosDao();
		Usuario usuario = usuarios.read(Integer.valueOf(parId));
		
		if(parNome != null && parNickname != null) {
			if(!parNome.isBlank() && !parNickname.isBlank()) {
				if(parSenha.equals(parSenha2)) {
					usuario.setNome(parNome);
					usuario.setNickname(parNickname);
					usuario.setSenha(parSenha);
					usuarios.update();
					System.out.println(parNome);
					System.out.println(usuario.getNome());
					return "redirect:ListarUsuarios";
				}
			}
		}
		
		request.setAttribute("usuario", usuario);
		request.setAttribute("acao", "EditarUsuario");
		return "forward:FormUsuario.jsp";
	}
}
