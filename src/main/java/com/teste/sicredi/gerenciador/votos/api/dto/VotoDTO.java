package com.teste.sicredi.gerenciador.votos.api.dto;

import java.io.Serializable;

import com.teste.sicredi.gerenciador.votos.api.enums.VotoEnum;

import lombok.Data;

@Data
public class VotoDTO implements Serializable { 
	
	private static final long serialVersionUID = 6225577992609881168L;
	private Long id;
	private String cpf;
	private VotoEnum voto;
	private VotacaoDTO votacao;

}
