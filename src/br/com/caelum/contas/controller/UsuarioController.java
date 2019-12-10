package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("/usuario/form")
	public String formulario() {
		return "usuario/formulario";
	}
	
	@RequestMapping("/usuario/efetuaLogin")
	public String adiciona(Usuario usuario, HttpSession session) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if (usuarioDAO.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "usuario/login";
		}
		
		return "redirect:/usuario/form";
	}		
	
	@RequestMapping("/usuario/efetuaLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/usuario/form";
	}	
	
}
