package com.teste.sicredi.gerenciador.votos.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.sicredi.gerenciador.votos.api.model.Voto;


public interface VotoRepository extends JpaRepository<Voto, Long>{
	
	Optional<Voto> findByCpf(String cpf);
	
	@Query(nativeQuery = true, value = "SELECT count(d.id_voto) FROM tb_voto d WHERE d.id_votacao = ?1 AND d.voto = ?2")   
	int countVotosByType(Long idVotacao, String tipo);

}
