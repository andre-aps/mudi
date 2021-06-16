package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping(path = "/home")
	public ModelAndView home() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("pedidos", pedidos);
		
		return modelAndView;
	}
}
