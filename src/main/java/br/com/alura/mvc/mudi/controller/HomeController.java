package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.enums.StatusPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.util.UsuarioUtil;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping
	public ModelAndView home() {
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(UsuarioUtil.getNomeUsuario());
		
		return new ModelAndView("home")
				.addObject("pedidos", pedidos);
	}
	
	@GetMapping("/{status}")
	public ModelAndView byStatus(@PathVariable("status") String status) {
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		return new ModelAndView("home")
				.addObject("pedidos", pedidos)
				.addObject(status);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
