package br.com.contatos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.contatos.model.Usuario;
import br.com.contatos.model.JdbcUsuarioDao;

@Controller
public class LoginController {

	private JdbcUsuarioDao dao;
	
	@Autowired
	public LoginController(JdbcUsuarioDao dao){
		this.dao = dao;
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "formularioLogin";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if(dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "forward:novoContato";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
}
