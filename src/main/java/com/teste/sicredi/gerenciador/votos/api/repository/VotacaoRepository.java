package com.teste.sicredi.gerenciador.votos.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.sicredi.gerenciador.votos.api.model.Votacao;


public interface VotacaoRepository extends JpaRepository<Votacao, Long>{
	
	Optional<Votacao> findVotacaoByPautaId(Long idPauta);

}
