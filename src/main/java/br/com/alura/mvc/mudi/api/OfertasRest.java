package br.com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.dto.OfertaDTO;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping(path = "/api/ofertas")
public class OfertasRest {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(@RequestBody OfertaDTO ofertaDTO) {
		Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(ofertaDTO.getPedidoId());
		
		if(!pedidoEncontrado.isPresent())
			return null;
	
		Pedido pedido = pedidoEncontrado.get();
		
		Oferta oferta = Oferta.toModel(ofertaDTO);
		oferta.setPedido(pedido);
		
		pedido.getOfertas().add(oferta);
		
		pedidoRepository.save(pedido);
		
		return oferta;
	}
	
}
