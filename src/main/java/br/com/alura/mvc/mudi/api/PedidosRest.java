package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.enums.StatusPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping(path = "/api/pedidos")
public class PedidoRest {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping(path = "/aguardando")
	public List<Pedido> listarPedidosAguardando() {
		
		return pedidoRepository
				.findByStatus(StatusPedido.AGUARDANDO, PageRequest.of(0, 10, Sort.Direction.DESC, "id"));
	}
	
}
