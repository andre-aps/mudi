package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.alura.mvc.mudi.dto.PedidoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataEntrega;
	private String urlProduto;
	private String urlImagem;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	public Pedido(PedidoDTO pedidoDTO) {
		this.nomeProduto = pedidoDTO.getNomeProduto();
		this.urlProduto = pedidoDTO.getUrlProduto();
		this.urlImagem = pedidoDTO.getUrlImagem();
		this.descricao = pedidoDTO.getDescricao();
		this.status = StatusPedido.AGUARDANDO;
	}
	
	public static Pedido toModel(PedidoDTO pedidoDTO) {
		return new Pedido(pedidoDTO);
	}

}
