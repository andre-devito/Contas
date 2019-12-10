package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	private ContaDAO contaDAO;
	
	@Autowired
	public ContaController(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}

	@RequestMapping("/conta/form")
	public String formulario() {
		return "conta/formulario";
	}
	
//	@RequestMapping("/conta/adicionaConta")
//	public String adiciona(Conta conta) {
//		contaDAO.adiciona(conta);
//		
//		return "conta/conta-adicionada";
//	}
	
	@RequestMapping("/conta/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
		if (result.hasErrors()) {
			return "conta/formulario";	
		}
		
		contaDAO.adiciona(conta);
		
		return "conta/conta-adicionada";
	}	
	
//	@RequestMapping("/conta/listaContas")
//	public ModelAndView lista() {
//		List<Conta> listContas = contaDAO.lista();
//		
//		ModelAndView mv = new ModelAndView("conta/lista");
//		mv.addObject("listContas", listContas);
//		
//		return mv;
//	}
	
	@RequestMapping("/conta/listaContas")
	public String lista(Model m) {
		List<Conta> listContas = contaDAO.lista();
		
		m.addAttribute("listContas", listContas);
		
		return "/conta/lista";
	}
	
//	@RequestMapping("/conta/removeConta")
//	public ModelAndView remove(Conta conta) {
//		contaDAO.remove(conta);
//		
//		List<Conta> listContas = contaDAO.lista();
//		ModelAndView mv = new ModelAndView("conta/lista");
//		mv.addObject("listContas", listContas);
//		
//		return mv;
//	}
	
	@RequestMapping("/conta/removeConta")
	public String remove(Conta conta) {
		contaDAO.remove(conta);
		
		return "redirect:/conta/listaContas";
	}
	
	@RequestMapping("/conta/mostraConta")
	public String mostra(Long id, Model model) {
		model.addAttribute("conta", contaDAO.buscaPorId(id));
		
		return "/conta/conta";
	}
	
	@RequestMapping("/conta/alteraConta")
	public String altera(Conta conta) {
		contaDAO.altera(conta);
		
		return "redirect:/conta/listaContas";
	}
	
	@RequestMapping("/conta/pagaConta")
	public void paga(Conta conta, HttpServletResponse response) {
		contaDAO.paga(conta.getId());
		
		response.setStatus(200);
	}
	
}
