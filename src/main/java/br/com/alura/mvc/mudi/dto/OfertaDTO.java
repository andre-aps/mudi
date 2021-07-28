package br.com.alura.mvc.mudi.dto;

import lombok.Data;

@Data
public class OfertaDTO {

	private Long pedidoId;
	private String valor;
	private String dataEntrega;
	private String comentario;
	
}
