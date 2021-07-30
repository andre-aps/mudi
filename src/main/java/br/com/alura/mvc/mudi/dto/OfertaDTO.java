package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class OfertaDTO {

	private Long pedidoId;
	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	private String valor;
	@NotNull
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}")
	private String dataEntrega;
	private String comentario;
	
}
