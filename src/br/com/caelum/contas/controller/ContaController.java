package br.com.caelum.contas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/conta/form")
	public String formulario() {
		return "conta/formulario";
	}
	
//	@RequestMapping("/conta/adicionaConta")
//	public String adiciona(Conta conta) {
//		ContaDAO contaDAO = new ContaDAO();
//		contaDAO.adiciona(conta);
//		
//		return "conta/conta-adicionada";
//	}
	
	@RequestMapping("/conta/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) {
		if (result.hasErrors()) {
			return "conta/formulario";	
		}
		
		
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.adiciona(conta);
		
		return "conta/conta-adicionada";
	}	
	
//	@RequestMapping("/conta/listaContas")
//	public ModelAndView lista() {
//		ContaDAO contaDAO = new ContaDAO();
//		List<Conta> listContas = contaDAO.lista();
//		
//		ModelAndView mv = new ModelAndView("conta/lista");
//		mv.addObject("listContas", listContas);
//		
//		return mv;
//	}
	
	@RequestMapping("/conta/listaContas")
	public String lista(Model m) {
		ContaDAO contaDAO = new ContaDAO();
		List<Conta> listContas = contaDAO.lista();
		
		m.addAttribute("listContas", listContas);
		
		return "/conta/lista";
	}
	
//	@RequestMapping("/conta/removeConta")
//	public ModelAndView remove(Conta conta) {
//		ContaDAO contaDAO = new ContaDAO();
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
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.remove(conta);
		
		return "redirect:/conta/listaContas";
	}
	
	@RequestMapping("/conta/mostraConta")
	public String mostra(Long id, Model model) {
		ContaDAO contaDAO = new ContaDAO();
		model.addAttribute("conta", contaDAO.buscaPorId(id));
		
		return "/conta/conta";
	}
	
	@RequestMapping("/conta/alteraConta")
	public String altera(Conta conta) {
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.altera(conta);
		
		return "redirect:/conta/listaContas";
	}	
	
}
