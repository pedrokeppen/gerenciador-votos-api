package com.teste.sicredi.gerenciador.votos.api.service;

import com.teste.sicredi.gerenciador.votos.api.dto.ResultadoVotacaoDTO;
import com.teste.sicredi.gerenciador.votos.api.dto.VotacaoDTO;
import com.teste.sicredi.gerenciador.votos.api.dto.VotoDTO;
import com.teste.sicredi.gerenciador.votos.api.model.Votacao;
import com.teste.sicredi.gerenciador.votos.api.model.Voto;

public interface VotacaoService {

	Votacao abrir(VotacaoDTO dto);
	
	boolean isVotacaoValidaAberta(Votacao votacao);
	
	Votacao findById(Long idVotacao);
	
	Voto votar(VotoDTO dto);
	
	ResultadoVotacaoDTO exibirResultadoVotacao(Long idVotacao);
	
}
