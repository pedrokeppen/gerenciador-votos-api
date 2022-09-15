package com.teste.sicredi.gerenciador.votos.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.teste.sicredi.gerenciador.votos.api.dto.PautaDTO;
import com.teste.sicredi.gerenciador.votos.api.exceptiohandler.exceptions.InternalServerErrorException;
import com.teste.sicredi.gerenciador.votos.api.exceptiohandler.exceptions.NotFoundException;
import com.teste.sicredi.gerenciador.votos.api.model.Pauta;
import com.teste.sicredi.gerenciador.votos.api.repository.PautaRepository;
import com.teste.sicredi.gerenciador.votos.api.service.PautaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PautaServiceImpl implements PautaService{

	private final PautaRepository repository;
	
	@Override
	public Pauta salvar(PautaDTO dto) {
		
		try {
			Pauta pauta = Pauta.builder()
					.titulo(dto.getTitulo())
					.descricao(dto.getDescricao())
					.build();
		
			return this.repository.save(pauta);

		} catch (Exception e) {
			throw new InternalServerErrorException("Não foi possível salvar a Pauta!");
		}
	}

	@Override
	public List<Pauta> listarTodas() {
		List<Pauta> pautas = this.repository.findAll();
		
		if(CollectionUtils.isEmpty(pautas)) {
			throw new NotFoundException("Nenhuma Pauta encontrada!");
		}
		
		return pautas;
		
	}

	@Override
	public Pauta findById(Long idPauta) {
		Optional<Pauta> pauta = this.repository.findById(idPauta);
		
		if(!pauta.isPresent()) {
			throw new NotFoundException("Pauta não encontrada!");
		}
		
		return pauta.get();
	}
	
	

}
