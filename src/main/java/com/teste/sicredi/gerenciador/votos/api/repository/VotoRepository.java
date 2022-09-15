package com.teste.sicredi.gerenciador.votos.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.sicredi.gerenciador.votos.api.model.Voto;


public interface VotoRepository extends JpaRepository<Voto, Long>{
	
	Optional<Voto> findByCpf(String cpf);

}
