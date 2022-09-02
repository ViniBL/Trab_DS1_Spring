package br.ufscar.dc.dsw.controller;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Pacote_adquirido;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.IPacote_adquiridoService;
import br.ufscar.dc.dsw.service.spec.IPacoteService;

@Controller
@RequestMapping("/compras")
public class Pacote_adquiridoController {
	
	@Autowired
	private IPacote_adquiridoService service;
	
	@Autowired
	private IPacoteService pacoteService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pacote_adquirido compra) {
		compra.setUsuario(this.getUsuario());
		return "compra/cadastro";
	}
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
					
		model.addAttribute("compras",service.buscarTodosPorUsuario(this.getUsuario()));
		
		return "compra/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Pacote_adquirido compra, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "compra/cadastro";
		}
		
		service.salvar(compra);
		attr.addFlashAttribute("sucess", "Compra inserida com sucesso.");
		return "redirect:/compras/listar";
	}
	
	@ModelAttribute("pacotes")
	public List<Pacote> listaPacotes() {
		return pacoteService.buscarTodos();
	}
}
