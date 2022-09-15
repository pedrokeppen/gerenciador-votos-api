package com.teste.sicredi.gerenciador.votos.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.sicredi.gerenciador.votos.api.dto.VotacaoDTO;
import com.teste.sicredi.gerenciador.votos.api.dto.VotoDTO;
import com.teste.sicredi.gerenciador.votos.api.model.Votacao;
import com.teste.sicredi.gerenciador.votos.api.model.Voto;
import com.teste.sicredi.gerenciador.votos.api.service.VotacaoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/votacao")
@AllArgsConstructor
public class VotacaoController {
	
	private VotacaoService service;
	
	@PostMapping(value = "/abrir-votacao")
	public ResponseEntity<Votacao> abrirVotacao(@RequestBody VotacaoDTO dto){
		
		Votacao votacao = this.service.abrir(dto);
		
		return ResponseEntity.ok(votacao);
	}
	
	@PostMapping(value = "/votar")
	public ResponseEntity<Voto> votar(@RequestBody VotoDTO dto){
		
		Voto voto = this.service.votar(dto);
		
		return ResponseEntity.ok(voto);
	}
	
	@GetMapping(value = "/exibir-resultado/{id}")
	public ResponseEntity<Votacao> listarTodas(@PathVariable("id") Long idVotacao){
		
		
		//IMPLEMENTAR AINDA O CALCULO DO RESULTADO DOS VOTOS	
		Votacao votacao = this.service.findById(idVotacao);
		
		return ResponseEntity.ok(votacao);
	}
	
	
}
