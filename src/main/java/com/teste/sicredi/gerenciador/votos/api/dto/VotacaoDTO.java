package com.teste.sicredi.gerenciador.votos.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class VotacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 932534759423252085L;
	
	private Long id;
	private PautaDTO pauta;
	private Long duracaoMinutos;
	
}
