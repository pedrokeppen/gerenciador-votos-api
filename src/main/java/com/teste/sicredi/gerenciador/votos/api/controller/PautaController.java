package com.teste.sicredi.gerenciador.votos.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.sicredi.gerenciador.votos.api.dto.PautaDTO;
import com.teste.sicredi.gerenciador.votos.api.model.Pauta;
import com.teste.sicredi.gerenciador.votos.api.service.PautaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/pauta")
@AllArgsConstructor
public class PautaController {

	private PautaService service;
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<Pauta> cadastrar(@RequestBody PautaDTO dto) throws IOException {
		
		Pauta pauta = this.service.salvar(dto);
		
		return ResponseEntity.ok(pauta);
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Pauta>> listarTodas() throws IOException {
		
		List<Pauta> pautas = this.service.listarTodas();
		
		return ResponseEntity.ok(pautas);
	}
}
