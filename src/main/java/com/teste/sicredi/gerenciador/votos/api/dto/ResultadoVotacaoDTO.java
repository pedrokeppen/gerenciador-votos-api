package com.teste.sicredi.gerenciador.votos.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoVotacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 932534759423252085L;
	
	private Long idVotacao;
	private String statusVotacao;
	private Long idPauta;
	private String tituloPauta;
	private Integer qtdSim;
	private Integer qtdNao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataFim;
	
}
