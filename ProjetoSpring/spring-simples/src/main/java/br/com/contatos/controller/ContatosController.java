package br.com.contatos.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.contatos.model.Contato;
import br.com.contatos.model.IContatoDao;

@Controller
public class ContatosController {
	
	@Autowired
	@Qualifier(value="jpaContatoDao")
	private IContatoDao dao;
	
	
	@RequestMapping("/novoContato")
	public String exibeFormulario(){
		return "novoContato";
	}
	
	@RequestMapping("/adicionaContato")
	public String adicionaContato(@Valid Contato contato, BindingResult result){
 
		if (result.hasErrors()){
			return "novoContato";
		}
		dao.adiciona(contato);

		return "contatoAdicionado";
	}
	
	@RequestMapping("/listaContatos")
	public String listaContatos(Model model){

		List<Contato> contatos = dao.getLista();
		
		model.addAttribute("contatos", contatos);
		
		return "listaContatos";
	}
	
	@RequestMapping("/removeContato")
	public String removeContatos(Contato contato){
		
		dao.remove(contato);
		
		//return "redirect:listaContatos";
		return "forward:listaContatos";
	}
	
	@RequestMapping("/mostraContato")
	public String mostraContato(long id){
		Contato contato = dao.getContato(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("contato", contato);
		
		return "mostraContato";
	}
	
	@RequestMapping("/alteraContato")
	public String alteraContatos(Contato contato){
		
		dao.altera(contato);
		
		return "redirect:listaContatos";
		//return "forward:listaContatos";
	}
	
	@RequestMapping("/desativaContato")
	public void desativaContato(long id, HttpServletResponse response){
		Contato contato = dao.getContato(id);
		contato.setAtivo(false);
		
		dao.altera(contato);
		
		response.setStatus(200);
	}
}
