package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.alura.mvc.mudi.dto.OfertaDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor;
	private LocalDate dataEntrega;
	private String comentario;
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	
	public Oferta(OfertaDTO ofertaDTO) {
		this.comentario = ofertaDTO.getComentario();
		this.dataEntrega = LocalDate.parse(ofertaDTO.getDataEntrega(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.valor = new BigDecimal(ofertaDTO.getValor());
	}
	
	public static Oferta toModel(OfertaDTO ofertaDTO) {
		return new Oferta(ofertaDTO);
	}

}
